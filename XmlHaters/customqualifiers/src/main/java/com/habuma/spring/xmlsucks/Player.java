package com.habuma.spring.xmlsucks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Player {
    private Media media;
    private OutputDevice outputDevice;

    @Autowired
    public Player(OutputDevice outputDevice) {
        this.outputDevice = outputDevice;
    }

    @Autowired
    @OldSchool
    public void setMedia(Media media) {
        this.media = media;
    }

    public void play() {
        outputDevice.emit(media.play());
    }
}
