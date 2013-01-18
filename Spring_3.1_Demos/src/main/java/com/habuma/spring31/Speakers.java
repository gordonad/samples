package com.habuma.spring31;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Speakers implements OutputDevice {
    private static final Logger logger = LoggerFactory.getLogger(Speakers.class);

    @Override
    public void play() {
        logger.debug("Playing through speakers");
    }
}
