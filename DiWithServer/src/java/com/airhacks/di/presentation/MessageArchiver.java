package com.airhacks.di.presentation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author airhacks.com
 */
public class MessageArchiver {

    @PersistenceContext
    EntityManager em;

    public void save(String message) {
        em.merge(new Message(message));
    }

}
