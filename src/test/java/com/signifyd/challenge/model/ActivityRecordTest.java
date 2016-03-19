package com.signifyd.challenge.model;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author jary
 * @since Mar 19, 2016
 */
public class ActivityRecordTest {

    @Test
    public void testEquals() {

        DateTime now = new DateTime();
        ActivityRecord a = new ActivityRecord("a@email.com", ActivityType.PURCHASE, now);
        ActivityRecord b = new ActivityRecord("a@email.com", ActivityType.PURCHASE, now);

        Assert.assertTrue(a.equals(b));

        b = new ActivityRecord("b@email.com", ActivityType.PURCHASE, now);
        Assert.assertFalse(a.equals(b));

        b = new ActivityRecord("a@email.com", ActivityType.FRAUD_REPORT, now);
        Assert.assertFalse(a.equals(b));

        b = new ActivityRecord("a@email.com", ActivityType.PURCHASE, now.plusMinutes(1));
        Assert.assertFalse(a.equals(b));
    }
}
