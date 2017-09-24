package com.airhacks.di.presentation;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.interceptor.Interceptors;

/**
 * @author airhacks.com
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@DependsOn("FireStarter")
@Startup
@Singleton
@Interceptors(MethodCallLogger.class)
public class HelloService {

    @Resource
    SessionContext sc;

    @PostConstruct
    public void onInit() {
        System.out.println("Starting...Creating HelloService(EJB)");
    }

    public String sayHello() {
        return " hi there !" + new Date() + " " + sc.getCallerPrincipal();
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Destroying EJB");
    }

}
