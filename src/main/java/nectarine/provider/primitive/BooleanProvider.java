package nectarine.provider.primitive;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-08.
 */
public class BooleanProvider implements Provider<Boolean> {
    @Override
    public Boolean get() {
        return true;
    }
}
