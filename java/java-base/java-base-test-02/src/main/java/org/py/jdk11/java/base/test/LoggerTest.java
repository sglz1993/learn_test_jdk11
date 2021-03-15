package org.py.jdk11.java.base.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.py.common.util.LogUtil;

@Slf4j
public class LoggerTest {

    @Test
    public void testLoggerFilter() {
        LogUtil.addLoggerFilter();
        log.info("hello");
        log.error("hello error");
        log.error("hello param:{}", "i am parm");
        try {
            int i = 1/0;
        } catch (Exception e) {
            log.error("", e);
            log.error("lalal", e);
            log.error("lalal:{}", "errormsg",  e);
        }
    }


}
