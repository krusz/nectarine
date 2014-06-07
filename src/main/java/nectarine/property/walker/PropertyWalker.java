package nectarine.property.walker;

import nectarine.property.visitor.PropertyVisitor;

public class PropertyWalker {
    private PropertyVisitor visitor;

    public void setVisitor(PropertyVisitor visitor) {
        this.visitor = visitor;
    }

    public void walk(Class clazz){

    }

    private void checkField(){

    }

}
