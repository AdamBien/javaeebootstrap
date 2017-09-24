package com.airhacks.di.presentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author airhacks.com
 */
@ApplicationScoped
public class EmptyDelegate {

    @Inject
    GlobalCounter gc;

    @Inject
    UserCounter uc;

    public int getUserCounter() {
        return uc.getCounter();
    }

    public int getGlobalCounter() {
        return this.gc.getCounter();
    }

}
