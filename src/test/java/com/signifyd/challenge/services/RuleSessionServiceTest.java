package com.signifyd.challenge.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;

/**
 * @author jary
 * @since Mar 19, 2016
 */
public class RuleSessionServiceTest {

    private RuleSessionService service;

    @Before
    public void init() throws Exception {
        service = new RuleSessionService();
        service.init();
    }
    @Test
    public void testInit() {

        KieBase kieBase = service.kieBase;
        Assert.assertNotNull(kieBase);
        Assert.assertNotNull(kieBase.getKiePackage("rules.fraudDetect"));
    }
}
