package pl.sternik.dk;

public class Thing implements Cloneable {

    public Thing clone() {
        Thing clone = null;
        try {
            clone = (Thing) super.clone();
            // here make deep copy for mutable objects
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
