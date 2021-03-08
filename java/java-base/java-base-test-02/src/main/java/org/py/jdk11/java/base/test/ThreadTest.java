package org.py.jdk11.java.base.test;

import org.junit.Test;

public class ThreadTest {

    @Test
    public void testThreadInterrupt() {
        Thread.currentThread().interrupt();
    }

}
