package javabasic.effectivejava.ovrihashcodeifovriequals;

/**
 * Equal objects must have equal hash codes
 * HashMap and HashSet relys on hashCode for equality check
 *
 */
public class OverrideHashCode {
    String areaCode;
    String prefix;
    String lineNum;

    // Typical hashCode method
    @Override
    public int hashCode() {
        int result = areaCode.hashCode();
        result = 31 * result + prefix.hashCode();
        result = 31 * result + lineNum.hashCode();
        return result;
    }
}