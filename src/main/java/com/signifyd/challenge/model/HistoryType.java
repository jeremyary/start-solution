package com.signifyd.challenge.model;

/***
 * types of historical knowledge we can know about an account
 *
 * @author jary
 * @since Mar/11/2016
 */
public enum HistoryType {

    /*** we don't have any historical information about this account ***/
    NO_HISTORY,

    /*** we have one or more fraudulent events associated to the account ***/
    FRAUD_HISTORY,

    /*** no fraud, but we don't have any historical purchases 90 days or older ***/
    GOOD_HISTORY,

    /*** no fraud, one or more purchases made that's at least 90 days or older ***/
    UNCONFIRMED_HISTORY
}
