package nectarine.provider.primitive;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-08.
 */
public class FloatProvider implements Provider<Float> {
    @Override
    public Float get() {
        return 1.0f;
    }
}
