package nectarine.provider.builder;

import nectarine.provider.Provider;

import java.util.List;

/**
 * Created by kamil on 2014-06-07.
 */
public class ProviderBuilderImpl implements ProviderBuilder {

    @Override
    public <T> Provider<T> build(final List<T> list) {
        return new Provider<T>() {
            @Override
            public T get() {
                int i = (int )(Math.random() * list.size());
                return list.get(i);
            }
        };
    }

    @Override
    public <T> Provider<T> build(final T[] array) {
        return new Provider<T>() {
            @Override
            public T get() {
                int i = (int )(Math.random() * array.length);
                return array[i];
            }
        };
    }

    @Override
    public <T> Provider<T> build(final T t) {
        return new Provider<T>() {
            @Override
            public T get() {
                return t;
            }
        };
    }
}
