package nectarine.provider.primitive;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-08.
 */
public class DoubleProvider implements Provider<Double> {
    @Override
    public Double get() {
        return Math.random();
    }
}
