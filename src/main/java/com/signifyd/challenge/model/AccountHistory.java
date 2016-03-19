package com.signifyd.challenge.model;

import java.util.ArrayList;
import java.util.List;

/***
 * store {@link ActivityRecord} for known email address as they enter system
 *
 * @author jary
 * @since Mar/11/2016
 */
public class AccountHistory {

    private final String accountEmail;

    private final List<ActivityRecord> history;

    public AccountHistory(String accountEmail) {
        this.accountEmail = accountEmail;
        this.history = new ArrayList<>();
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public List<ActivityRecord> getHistory() {
        return history;
    }
}
