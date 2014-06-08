package nectarine.provider.primitive;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-08.
 */
public class IntProvider implements Provider<Integer> {
    @Override
    public Integer get() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}
