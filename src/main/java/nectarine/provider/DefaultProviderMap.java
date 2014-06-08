package nectarine.provider;

import nectarine.provider.primitive.*;

import java.util.HashMap;

/**
 * Created by kamil on 2014-06-08.
 */
public class DefaultProviderMap extends HashMap<Class, Provider> {

    public DefaultProviderMap(){
        put(Boolean.class, new BooleanProvider());
        put(Byte.class, new ByteProvider());
        put(Character.class, new CharProvider());
        put(Double.class, new DoubleProvider());
        put(Float.class, new FloatProvider());
        put(Integer.class, new IntProvider());
        put(Long.class, new LongProvider());
        put(Short.class, new ShortProvider());
        put(String.class, new StringProvider());
    }

}
