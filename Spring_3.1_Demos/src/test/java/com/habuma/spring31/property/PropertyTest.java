package com.habuma.spring31.property;

import com.habuma.spring31.CompactDisc;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PropertyTest {
    @Test
    public void usePlaceholderConfigurer() {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/habuma/spring31/property/property.xml");
        CompactDisc cd1 = ctx.getBean("disc1", CompactDisc.class);
        assertThat("Rattle and Hum", equalTo(cd1.getTitle()));
        assertThat("U2", equalTo(cd1.getArtist()));
    }

    @Test
    public void useChuckNorris() {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/habuma/spring31/property/property.xml");
        ctx.getEnvironment().getPropertySources().addFirst(new ChuckNorrisPropertySource("chuck"));

        // refresh the context to reload beans after new property source has been registered
        ctx.refresh();

        CompactDisc cd1 = ctx.getBean("disc1", CompactDisc.class);
        assertThat("Roundhouse Kick", equalTo(cd1.getTitle()));
        assertThat("Roundhouse Kick", equalTo(cd1.getArtist()));
    }
}
