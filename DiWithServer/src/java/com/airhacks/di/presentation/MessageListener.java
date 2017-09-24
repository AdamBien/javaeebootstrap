package com.airhacks.di.presentation;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 * @author airhacks.com
 */
public class MessageListener {

    public void onSuccess(@Observes(during = TransactionPhase.AFTER_SUCCESS) String message) {
        System.out.println("+++ " + message);
    }

    public void onFailure(@Observes(during = TransactionPhase.AFTER_FAILURE) String message) {
        System.out.println("--- " + message);
    }

}
