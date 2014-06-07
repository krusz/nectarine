package nectarine.property.visitor;

import nectarine.property.factory.PropertyFactory;
import nectarine.util.User;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by kamil on 2014-06-07.
 */
public class PropertyVisitorTest {

    @Test
    public void shouldFillUserFirstname() {
        //given
        User user = new User();
        PropertyFactory factory = Mockito.mock(PropertyFactory.class);
        PropertyVisitor visitor = new PropertyVisitorImpl(factory);
        visitor.setObject(user);
        Class<String> propertyClass = null;
        String propertyName = null;
        when(factory.get(propertyClass, propertyName)).thenReturn("Kamil");

        //when
        try {
            visitor.onPropertyVisit(propertyClass, propertyName, user.getClass().getDeclaredMethod("setFirstName", String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //then
        assertEquals("Kamil", user.getFirstName());
    }

}
