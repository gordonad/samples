package com.habuma.spring31.c;

import com.habuma.spring31.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/habuma/spring31/c/c-namespace.xml")
public class ConstructorNamespaceTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldInjectConstructorArgumentValuesByName() {
        CompactDisc disc = context.getBean("disc1", CompactDisc.class);
        assertThat("Rattle and Hum", equalTo(disc.getTitle()));
        assertThat("U2", equalTo(disc.getArtist()));
    }

    @Test
    public void shouldInjectConstructorArgumentValuesByIndex() {
        CompactDisc disc = context.getBean("disc2", CompactDisc.class);
        assertThat("Slippery When Wet", equalTo(disc.getTitle()));
        assertThat("Bon Jovi", equalTo(disc.getArtist()));

        disc = context.getBean("disc3", CompactDisc.class);
        assertThat("1984", equalTo(disc.getTitle()));
        assertThat("Van Halen", equalTo(disc.getArtist()));
    }

    @Test
    public void shouldInjectSimpleConstructorArgumentValue() {
        CompactDisc disc = context.getBean("disc4", CompactDisc.class);
        assertThat("Hot Tracks", equalTo(disc.getTitle()));
    }

    @Test
    public void shouldInjectConstructorArgumentReferencesByName() {
        CDPlayer player = context.getBean("player1", CDPlayer.class);
        assertThat(player.getOutput(), instanceOf(Headphones.class));
        assertThat("Rattle and Hum", equalTo(player.getDisc().getTitle()));
    }

    @Test
    public void shouldInjectConstructorArgumentReferencesByIndex() {
        CDPlayer player = context.getBean("player2", CDPlayer.class);
        assertThat(player.getOutput(), instanceOf(Speakers.class));
        assertThat("Slippery When Wet", equalTo(player.getDisc().getTitle()));
    }

    @Test
    public void shouldInjectSimpleConstructorReference() {
        Radio radio = context.getBean(Radio.class);
        assertThat(radio.getOutput(), instanceOf(Speakers.class));
    }
}
