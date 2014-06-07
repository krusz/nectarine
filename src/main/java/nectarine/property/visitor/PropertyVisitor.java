package nectarine.property.visitor;

import java.lang.reflect.Method;

public interface PropertyVisitor {
    void onPropertyVisit(Class clazz, String name, Method setter);
    void setObject(Object obj);
}
