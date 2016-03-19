package com.signifyd.challenge.services;

import org.apache.commons.csv.CSVRecord;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * Service for accessing & utilizing a rule session to process a set of events.
 * In future use, this could evolve to be the delegate for a singleton stateful CEP session
 * rather than one-time use and dispose stateless
 *
 * @author jary
 * @since Mar/11/2016
 */
public class RuleSessionService {

    protected KieBase kieBase;

    /***
     * link service to rules package container at start-up
     *
     * @throws Exception
     */
    public void init() throws Exception {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // link from kmodule.xml, drools rule container
        kieBase = kieContainer.getKieBase("fraudKieBase");
    }

    /***
     * since we're only interested in running a quick, disposable session, go ahead and take a list of
     * {@link CSVRecord} entries to simulate events & feed them into a session for processing
     *
     * @param recordList list of {@link CSVRecord} entries that simulate consumer historical events
     */
    public void processPurchaseHistory(final List<CSVRecord> recordList) {

        KieSession ruleSession = null;

        try {
            ruleSession = kieBase.newKieSession();

            // feed each event into the session & determine outcome based on state of session
            for (CSVRecord record : recordList) {
                ruleSession.insert(record);
                ruleSession.fireAllRules();
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (ruleSession != null) {
                ruleSession.destroy();
            }
        }
    }
}