package com.orishkevich.marvelapp.Model;

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
    public final int  dl;
    public MessageEvent(String message, int dl) {
        this.message = message;
        this.dl = dl;
    }
}
