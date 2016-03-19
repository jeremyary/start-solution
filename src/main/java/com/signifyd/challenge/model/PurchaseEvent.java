package com.signifyd.challenge.model;

/***
 * @author jary
 * @since Mar/11/2016
 */
public class PurchaseEvent {

    private final ActivityRecord record;

    public PurchaseEvent(ActivityRecord record) {
        this.record = record;
    }

    public ActivityRecord getRecord() {
        return record;
    }
}