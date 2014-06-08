package nectarine.provider.primitive;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-08.
 */
public class CharProvider implements Provider<Character> {
    @Override
    public Character get() {
        return 'a';
    }
}
