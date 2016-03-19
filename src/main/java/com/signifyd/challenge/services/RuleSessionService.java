package com.signifyd.challenge.services;

import org.apache.commons.csv.CSVRecord;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * @author jary
 * @since Mar/11/2016
 */
public class RuleSessionService {

    protected KieBase kieBase;

    public void init() throws Exception {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        kieBase = kieContainer.getKieBase("fraudKieBase");
    }

    public void processPurchaseHistory(final List<CSVRecord> recordList) {

        KieSession ruleSession = null;

        try {
            ruleSession = kieBase.newKieSession();

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