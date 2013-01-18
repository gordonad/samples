package com.habuma.spring31.cache;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/habuma/spring31/cache/caching.xml")
public class DeclarativeCachingTest {
    private static final Logger logger = LoggerFactory.getLogger(DeclarativeCachingTest.class);

    @Ignore("Test is long running, uncomment @Ignore to execute")
    @Test
    public void cacheTest() {
        logger.debug(translator.translate(0));
        logger.debug(translator.translate(9));
        logger.debug(translator.translate(10));
        logger.debug(translator.translate(15));
        logger.debug(translator.translate(16));
        logger.debug(translator.translate(19));
        logger.debug(translator.translate(19));
        logger.debug(translator.translate(36));
        for (int i = 0; i < 100; i++) {
            logger.debug(translator.translate(51));
        }

        logger.debug("The translator was called {} times", translator.getCallCount());
    }

    @Autowired
    private Translator translator;
}
