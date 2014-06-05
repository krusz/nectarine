package nectarine.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Nectarine {
    private Map<String, Provider> nameBindings;
    private Map<Class, Provider> typeBindings;
    private Map<Class, Map<String, Provider>> providers;


    public Nectarine(){
        typeBindings = new HashMap<>();
        nameBindings = new HashMap<>();
        providers = new HashMap<>();
    }

    public <T> T create(Class<T> clazz){

        PropertyWalker walker = new PropertyWalker();
        walker.setVisitor(new PropertyVisitor() {
            @Override
            public void onPropertyVisit(Class clazz, String name, Method setter) {
                dsadas();
            }
        });
        walker.walk(clazz);


        try {
            T obj = clazz.newInstance();
            Field[] fields = clazz.get;
            for (Field field : fields) {
                field.set(obj, "asdasda");
            }
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public <T> void fill(T object){

    }

    public Nectarine bind(Class type, Provider provider){
        typeBindings.put(type, provider);
        return this;
    }
}
