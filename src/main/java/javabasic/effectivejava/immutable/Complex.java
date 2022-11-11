package javabasic.effectivejava.immutable;

/**
 * Classes should be immutable unless there’s a very good reason to make them
 * mutable.
 * If a class cannot be made immutable, limit its mutability as much as
 * possible.
 * Declare every field private final unless there’s a good reason to do
 * otherwise.
 *
 * Constructors should create fully initialized objects with all of their
 * invariants established.
 * Don’t provide a public initialization method separate from the constructor or
 * static factory unless there is a compelling reason to do so.
 */
public final class Complex { // final
    private final double re; // final
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;
        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return String.format("(%s + %si)", re, im);
    }
}