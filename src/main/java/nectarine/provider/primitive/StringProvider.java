package nectarine.provider.primitive;

import nectarine.provider.Provider;

/**
 * Created by kamil on 2014-06-08.
 */
public class StringProvider implements Provider<String> {

    private static final String LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String get() {
        int size = (int) (Math.random() * 10) + 1;
        StringBuilder sb = new StringBuilder(size);
        for( int i = 0; i < size; i++ ) {
            sb.append(LETTERS.charAt((int) (Math.random() * LETTERS.length())));
        }
        return sb.toString();
    }

}
