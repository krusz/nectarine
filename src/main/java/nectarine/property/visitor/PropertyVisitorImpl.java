package nectarine.property.visitor;

import nectarine.property.factory.PropertyFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kamil on 2014-06-07.
 */
public class PropertyVisitorImpl implements PropertyVisitor {

    private Object obj;
    private PropertyFactory propertyFactory;

    public PropertyVisitorImpl(PropertyFactory propertyFactory){
        this.propertyFactory = propertyFactory;
    }

    @Override
    public void setObject(Object obj){
        this.obj = obj;
    }

    @Override
    public void onPropertyVisit(Class clazz, String name, Method setter) {
        try {
            setter.invoke(obj, propertyFactory.get(clazz, name));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
