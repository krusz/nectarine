package nectarine.core;

import nectarine.property.factory.PropertyFactory;
import nectarine.property.factory.PropertyFactoryImpl;
import nectarine.property.visitor.PropertyVisitor;
import nectarine.property.visitor.PropertyVisitorImpl;
import nectarine.property.walker.PropertyWalker;
import nectarine.provider.Provider;
import nectarine.provider.builder.ProviderBuilder;
import nectarine.provider.builder.ProviderBuilderImpl;

import java.util.List;

public class Nectarine {
    private PropertyWalker walker;
    private PropertyVisitor visitor;
    private PropertyFactory factory;
    private ProviderBuilder builder;

    public Nectarine() {
        builder = new ProviderBuilderImpl();
        factory = new PropertyFactoryImpl();
        walker = new PropertyWalker();
        visitor = new PropertyVisitorImpl(factory);
        walker.setVisitor(visitor);
    }

    public <T> T create(Class<T> clazz) {
        try {
            final T obj = clazz.newInstance();
            visitor.setObject(obj);
            walker.walk(clazz);
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> void fill(T object) {

    }

    public <T> Nectarine bind(Class<T> clazz, Provider<T> provider) {
        factory.bind(clazz, provider);
        return this;
    }

    public <T> Nectarine bind(Class<T> clazz, List<T> list){
        return bind(clazz, builder.build(list));
    }

    public <T> Nectarine bind(Class<T> clazz, T [] array){
        return bind(clazz, builder.build(array));
    }

    public <T> Nectarine bind(String name, Provider<T> provider) {
        factory.bind(name, provider);
        return this;
    }

    public <T> Nectarine bind(String name, List<T> list){
        return bind(name, builder.build(list));
    }

    public <T> Nectarine bind(String name, T [] array){
        return bind(name, builder.build(array));
    }

}
