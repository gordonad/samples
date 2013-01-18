package com.habuma.spring31.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.PropertySource;

public class ChuckNorrisPropertySource extends PropertySource<Object> {
    private static final Logger logger = LoggerFactory.getLogger(ChuckNorrisPropertySource.class);

    public ChuckNorrisPropertySource(String name) {
        super(name);
    }

    @Override
    public Object getProperty(String name) {
        logger.debug("Chuck says...");
        return "Roundhouse Kick";
    }
}
