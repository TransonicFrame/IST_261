package StampCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class StampCollection {

    // test program for Bloch, 3rd ed. item 26, p. 118 (Don't use raw types)
    // Raw collection type - don't do this!
    // My stamp collection. Contains only stamp instances.
    private static final Collection STAMPS = new HashSet<Stamp>();

    public static void main(String[] args) {
        // Emits "unchecked call" warning
        STAMPS.add(new Coin(0.50)); 
        
        // https://docs.google.com/document/d/1mAeEgQu4H4ADxa03k7YaVDjIP5vJBvjVIjg3DIvoc8E/edit
        for (Iterator i = STAMPS.iterator(); i.hasNext();) {
            Stamp stamp = (Stamp) i.next(); // Throws ClassCastException
            stamp.cancel();
        }
    }
}
