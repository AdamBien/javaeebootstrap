package com.airhacks.di.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.ScheduleExpression;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @author airhacks.com
 */
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
public class BigBrother {

    private CopyOnWriteArrayList<String> messageQueue;
    @Resource
    TimerService ts;
    private Timer timer;

    @Inject
    MessageAnalyzer ma;

    @Inject
    MessageArchiver archiver;

    @Inject
    Event<String> events;

    @Resource
    SessionContext sc;

    @PostConstruct
    public void initialize() {
        this.messageQueue = new CopyOnWriteArrayList<>();
        ScheduleExpression se = new ScheduleExpression();
        se.minute("*").hour("*").second("*/5");
        this.timer = ts.createCalendarTimer(se);
    }

    //txProxy.begin
    public void gatherEverything(String message) {
        this.archiver.save(message);
        this.messageQueue.add(message);
        this.events.fire(message);

        //this.sc.setRollbackOnly();
    }
    //txProxy.commit

    @Timeout
    public void batchAnalyze() {
        System.out.println("Analyzing at: " + new Date());
        List<Future<Boolean>> results = new ArrayList<>();
        for (String message : messageQueue) {
            results.add(ma.analyze(message));
            this.messageQueue.remove(message);
        }
        for (Future<Boolean> result : results) {
            try {
                System.out.println("### Result is: " + result.get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(BigBrother.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
