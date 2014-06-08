package nectarine.provider.primitive;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-08.
 */
public class ByteProvider implements Provider<Byte> {
    @Override
    public Byte get() {
        return (byte)(Math.random() * 10);
    }
}
