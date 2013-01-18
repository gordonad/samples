package com.habuma.spring31.feature;

import com.habuma.spring31.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {
    @Bean
    public CompactDisc album1() {
        return new CompactDisc("Rattle and Hum", "U2");
    }
}
