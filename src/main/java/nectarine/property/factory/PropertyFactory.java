package nectarine.property.factory;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-07.
 */
public interface PropertyFactory {
    <T> T get(Class<T> clazz, String name);
    <T> void bind(Provider<T> provider);
    <T> void bind(String name, Provider<T> provider);
}
