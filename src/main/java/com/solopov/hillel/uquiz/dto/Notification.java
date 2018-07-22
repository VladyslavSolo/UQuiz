package com.solopov.hillel.uquiz.dto;

public class Notification {
   private String message;
   private boolean positiveStatus=true;

    public Notification(String message, boolean positiveStatus) {
        this.message = message;
        this.positiveStatus = positiveStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isPositiveStatus() {
        return positiveStatus;
    }

    public void setPositiveStatus(boolean positiveStatus) {
        this.positiveStatus = positiveStatus;
    }
}
