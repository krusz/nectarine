package nectarine.provider.pattern;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by kamil on 2014-06-07.
 */
public class PatternProviderTest {

    @Test
    public void shouldProvidesForAllNamesWhichMatchesAddedPattern() {
        //given
        PatternProvider<String> provider = new PatternProvider<String>() {
            @Override
            public String get() {
                return null;
            }
        };

        //when
        provider.addPattern("firstname|name|username");

        //then
        assertTrue(provider.providesPropertyForName("firstname"));
        assertTrue(provider.providesPropertyForName("name"));
        assertTrue(provider.providesPropertyForName("username"));
        assertFalse(provider.providesPropertyForName("12345"));
    }

}
