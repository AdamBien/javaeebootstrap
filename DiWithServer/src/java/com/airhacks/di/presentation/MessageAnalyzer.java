package com.airhacks.di.presentation;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * @author airhacks.com
 */
@Stateless
public class MessageAnalyzer {

    @Asynchronous
    public Future<Boolean> analyze(String message) {
        boolean retVal = (message.hashCode() % 2 == 0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MessageAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<>(retVal);
    }

}
