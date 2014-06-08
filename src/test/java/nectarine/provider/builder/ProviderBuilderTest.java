package nectarine.provider.builder;

import nectarine.provider.Provider;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by kamil on 2014-06-07.
 */
public class ProviderBuilderTest {

    private ProviderBuilder builder = new ProviderBuilderImpl();

    @Test
    public void shouldBuildProviderFromListWithStringsWhichProvidesValueFromTheList() {
        //given
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        //when
        Provider<String> provider = builder.build(list);
        String value1 = provider.get(),
               value2 = provider.get();

        //then
        assertTrue(list.contains(value1));
        assertTrue(list.contains(value2));
    }

    @Test
         public void shouldBuildProviderFromArrayWithStringsWhichProvidesValueFromTheArray() {
        //given
        String [] array = new String [] {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(array);

        //when
        Provider<String> provider = builder.build(array);
        String value1 = provider.get(),
                value2 = provider.get();

        //then
        assertTrue(list.contains(value1));
        assertTrue(list.contains(value2));
    }

    @Test
    public void shouldBuildProviderFromStringWhichProvidesThisString() {
        //given
        String provided = "Provided";

        //when
        Provider<String> provider = builder.build(provided);

        //then
        assertEquals(provided, provider.get());
    }

}
