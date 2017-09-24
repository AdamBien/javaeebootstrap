package com.airhacks.di.presentation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.validation.constraints.Size;

/**
 * @author airhacks.com
 */
@Presenter
public class Index {

    @Inject
    HelloService hs;

    private UserCounter uc;

    private GlobalCounter gc;

    @Inject
    EmptyDelegate ed;

    @Inject
    private NakedObject no;

    @Inject
    BigBrother bb;

    @Size(min = 2, max = 10, message = "Don't do that!")
    private String text;

    @Inject
    public Index(GlobalCounter gc) {
        this.gc = gc;
    }

    public Index() {
    }

    @Inject
    public void setUc(UserCounter uc) {
        this.uc = uc;
    }

    @PostConstruct
    public void onInit() {
        System.out.println("Creating index");
    }

    public String getMessage() {
        uc.increase();
        gc.increase();
        no.hello();
        String message = hs.sayHello();
        bb.gatherEverything(message);
        return message;
    }

    public int getUserCounter() {
        return this.ed.getUserCounter();
    }

    public int getGlobalCounter() {
        return this.ed.getGlobalCounter();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object save() {
        this.bb.gatherEverything(this.text);
        return "theend";
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Destroying index");
    }

}
