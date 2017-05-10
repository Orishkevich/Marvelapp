package com.orishkevich.marvelapp.model;

/**
 * Created by Инженер-конструктор on 08.05.2017.
 */

public class MessageEvent {
    public String getMessage() {
        return message;
    }

    public int getDl() {
        return dl;
    }

    public final String message;
    public final int dl;

    public boolean getQd() {
        return qD;
    }

    public final boolean qD;
    public MessageEvent(String message, int dl,boolean qD) {
        this.message = message;
        this.dl = dl;
        this.qD=qD;
    }
}
