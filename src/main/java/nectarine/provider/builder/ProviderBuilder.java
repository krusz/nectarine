package nectarine.provider.builder;

import nectarine.provider.Provider;

import java.util.List;

/**
 * Created by kamil on 2014-06-07.
 */
public interface ProviderBuilder {
    <T> Provider<T> build(List<T> list);
    <T> Provider<T> build(T [] array);
    <T> Provider<T> build(T t);
}
