package com.example.connext.connext;

import java.util.ArrayList;

/**
 * Created by raahulbiswas on 15-03-04.
 */
public class Event {

    private String eventName;
    private String eventCode;

    public Event(){

    }

    public Event(String eName, String eCode){
        eventName = eName;
        eventCode = eCode;
    }

    public String getEventName(){
        return eventName;
    }

    public String getEventCode(){
        return eventCode;
    }
}
