package nectarine.provider.primitive;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-08.
 */
public class ShortProvider implements Provider<Short> {
    @Override
    public Short get() {
        return 456;
    }
}
