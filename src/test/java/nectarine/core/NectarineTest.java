package nectarine.core;

import nectarine.util.User;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

public class NectarineTest {
    private Nectarine nectarine = new Nectarine();

    @Test
    public void shouldCreateDummyObject() {
        //when
        User user = nectarine.create(User.class);

        //then
        assertNotNull(user);
    }

    @Test
    public void shouldCreateUserWithRandomFirstName() {
        //when
        User user = nectarine.create(User.class);

        //then
        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isNotNull();
    }
}
