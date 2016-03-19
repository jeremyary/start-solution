package com.signifyd.challenge.model;

/***
 * transfer object for rules session, once we've created a record, ties record to an active purchase event
 *
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