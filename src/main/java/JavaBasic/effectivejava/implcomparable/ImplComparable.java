package JavaBasic.effectivejava.implcomparable;

import java.util.Comparator;

public class ImplComparable {
    public static void main(String[] args) {

    }
}

class PhoneNumber implements Comparable<PhoneNumber> {

    private int areaCode;
    private int prefix;
    private int lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    // nice way to get rid of if else
    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);

    // make use of Comparator
    @Override
    public int compareTo(PhoneNumber o) {
        return COMPARATOR.compare(this, o);
    }
}
