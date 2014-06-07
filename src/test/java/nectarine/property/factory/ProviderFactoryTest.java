package nectarine.property.factory;

import nectarine.provider.Provider;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kamil on 2014-06-07.
 */
public class ProviderFactoryTest {

    private PropertyFactory factory = new PropertyFactoryImpl();

    @Test
    public void shouldReturnFirstnameByGivenProviderWhenBindToName() {
        //given
        Provider<String> firstnameProvider = new Provider<String>(){

            @Override
            public String get() {
                return "Kamil";
            }
        };

        //when
        factory.bind("firstname", firstnameProvider);

        //then
        assertEquals("Kamil", factory.get(String.class, "firstname"));
    }

    @Test
    public void shouldReturnStringByGivenProviderWhenBindToStringClass() {
        //given
        Provider<String> firstnameProvider = new Provider<String>(){

            @Override
            public String get() {
                return "Kamil";
            }
        };

        //when
        factory.bind(String.class, firstnameProvider);

        //then
        assertEquals("Kamil", factory.get(String.class, "firstname"));
    }

}
