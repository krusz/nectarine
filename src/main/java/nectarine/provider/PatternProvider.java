package nectarine.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamil on 2014-06-07.
 */
public abstract class PatternProvider<T> implements Provider<T> {

    protected List<String> patterns = new ArrayList<>();

    protected void addPattern(String pattern){
        patterns.add(pattern);
    }

    public boolean providesPropertyForName(String name){
        for(String pattern : patterns){
            if(name.matches(pattern)){
                return true;
            }
        }
        return false;
    }

}
