package org.py.jdk11.java.base.test;

import org.junit.Test;

public class ThreadTest {

    /**
     * thread.interrupt(); 只是标记中断，会打算sleep
     */
    @Test
    public void testThreadInterrupt() {
        try {
            Thread thread = new Thread("test") {
                @Override
                public void run() {
                    for (; ; ) {
                        System.out.println("lalalal");
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread.start();
            Thread.sleep(1000L);
            System.out.println("准备打算");
            thread.interrupt();
            System.out.println("打断完成");
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
