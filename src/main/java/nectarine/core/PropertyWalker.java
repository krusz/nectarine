package nectarine.core;

public class PropertyWalker {
    private PropertyVisitor visitor;

    public void setVisitor(PropertyVisitor visitor) {
        this.visitor = visitor;
    }

    public void walk(Class clazz){

    }

    private void checkField(){
        Class clazz;
        clazz.getDeclaredMethod(name, onPropertVisit(class, name))
    }

}
