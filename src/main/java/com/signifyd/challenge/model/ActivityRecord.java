package com.signifyd.challenge.model;

import org.apache.commons.csv.CSVRecord;
import org.joda.time.DateTime;

/***
 * stores the email, activityType, and activityTime of a transaction for historical record
 *
 * @author jary
 * @since Mar/11/2016
 */
public class ActivityRecord {

    private final String email;

    private final ActivityType activityType;

    private final DateTime activityTime;

    public ActivityRecord(final CSVRecord record) {
        this.email = record.get(1);
        this.activityType = ActivityType.valueOf(record.get(2));
        this.activityTime = new DateTime(record.get(0));
    }

    public ActivityRecord(String email, ActivityType activityType, DateTime activityTime) {
        this.email = email;
        this.activityType = activityType;
        this.activityTime = activityTime;
    }

    public String getEmail() {
        return email;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public DateTime getActivityTime() {
        return activityTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivityRecord)) return false;

        ActivityRecord that = (ActivityRecord) o;

        if (!email.equals(that.email)) return false;
        if (activityType != that.activityType) return false;
        return activityTime.equals(that.activityTime);

    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + activityType.hashCode();
        result = 31 * result + activityTime.hashCode();
        return result;
    }
}
