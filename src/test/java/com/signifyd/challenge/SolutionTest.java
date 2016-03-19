package com.signifyd.challenge;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testRunChallenge() {

        try {
            Solution.main(new String[]{"test"});

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
