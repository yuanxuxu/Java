package JavaBasic.effectivejava.ovritostring;

/**
 * While it isn’t as critical as obeying the equals and hashCode contracts
 * (Items 10 and 11),
 * providing a good toString implementation makes your class much more pleasant
 * to use and
 * makes systems using the class easier to debug.
 */
public class OverrideToString {

    int selected;

    int field;

    @Override
    public String toString() {
        return String.format("%s.%s", selected, field);
    }
}
