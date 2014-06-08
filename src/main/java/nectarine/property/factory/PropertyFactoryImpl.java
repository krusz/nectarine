package nectarine.property.factory;

import nectarine.provider.PatternProvider;
import nectarine.provider.Provider;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kamil on 2014-06-07.
 */
public class PropertyFactoryImpl implements PropertyFactory {

    private Map<Class, Map<String, Provider>> nameProviders = new HashMap<>();
    private Map<Class, Provider> typeProviders = new HashMap<>();
    private Map<Class, List<PatternProvider>> patternProviders = new HashMap<>();

    @Override
    public <T> T get(Class<T> clazz, String name) {
        Provider<T> provider = getProviderByName(clazz, name);
        if(provider != null){
            return provider.get();
        }
        provider = getProviderByType(clazz);
        if(provider != null){
            return provider.get();
        }
        provider = getProviderByPattern(clazz, name);
        if(provider != null){
            return provider.get();
        }
        return null;
    }

    private <T> Provider<T> getProviderByPattern(Class<T> clazz, String name) {
        List<PatternProvider> providersList = patternProviders.get(clazz);
        if(providersList != null){
            for(PatternProvider provider : providersList) {
                if (provider.providesPropertyForName(name)) {
                    return provider;
                }
            }
        }
        return null;
    }

    private <T> Provider<T> getProviderByType(Class<T> clazz) {
        return typeProviders.get(clazz);
    }

    private <T> Provider<T> getProviderByName(Class<T> clazz, String name){
        Map<String, Provider> providersMap = nameProviders.get(clazz);
        if(providersMap != null){
            return providersMap.get(name);
        }
        return null;
    }

    @Override
    public <T> void bind(Provider<T> provider) {
        typeProviders.put(getProviderTypeClass(provider), provider);
    }

    @Override
    public <T> void bind(String name, Provider<T> provider) {
        Class providedClass = getProviderTypeClass(provider);
        Map<String, Provider> providerMap = nameProviders.get(providedClass);
        if(providerMap == null){
            providerMap = new HashMap<>();
            nameProviders.put(providedClass, providerMap);
        }
        providerMap.put(name, provider);
    }

    private Class getProviderTypeClass(Provider provider){
        return (Class)((ParameterizedType)provider.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }
}
