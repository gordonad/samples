package com.habuma.spring.xmlsucks;

import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;

@Named
public class CompactDisc implements Media {
    @Value("#{systemEnvironment['SONG']}")
    private String title;

    public String play() {
        System.out.println("PLAYING CD:  " + title);
        return title;
    }
}
