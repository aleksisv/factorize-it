package fp.utils;

/**
 * Class whose instantiations are polynomials, i.e of the form P(x) = 5x^3 + x^2
 * + 3x + 5 or.
 */
public class Polynomial {

    private long[] coefficients;
    private int degree;

    /**
     * Default constructor.
     */
    public Polynomial() {
        this.coefficients = new long[1];
        this.coefficients[0] = 0;
        this.degree = determineDegree();
    }

    /**
     * Default constructor.
     *
     * @param coeffs The coefficients of the polynomial.
     */
    public Polynomial(long... coeffs) {
        this.coefficients = new long[coeffs.length];
        for (int i = 0; i < coeffs.length; i++) {
            coefficients[coefficients.length - 1 - i] = coeffs[i];
        }

        this.degree = determineDegree();
        this.sanitizePolynomial();
    }

    /**
     * Getter.
     *
     * @return Coefficients of the polynomial.
     */
    public long[] getCoefficients() {
        return coefficients;
    }

    /**
     * Reverses an array.
     *
     * @param arr Array to be reversed.
     * @return Reversed array.
     */
    private long[] reverse(long[] arr) {
        long[] reversed = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - i - 1];
        }
        return reversed;
    }

    /**
     * Adds two polynomials together.
     *
     * @param p Polynomial to be added to this polynomial.
     * @return The sum of two polynomials.
     */
    public Polynomial addPolynomial(Polynomial p) {

        int max = Math.max(this.getCoefficients().length, p.getCoefficients().length);
        long initialArray[] = new long[max];

        for (int i = 0; i < initialArray.length; i++) {
            if (this.coefficients.length <= i) {
                initialArray[i] = p.coefficients[i];
            } else if (p.coefficients.length <= i) {
                initialArray[i] = this.coefficients[i];
            } else {
                initialArray[i] = p.coefficients[i] + this.coefficients[i];
            }
        }

        long[] initialReversed = reverse(initialArray);

        Polynomial newPoly = new Polynomial(initialReversed);
        newPoly.sanitizePolynomial();
        return newPoly;
    }

    /**
     * Scales polynomial by some scalar.
     *
     * @param scale The scaling factor.
     * @return The scaled polynomial.
     */
    public Polynomial scalePolynomial(long scale) {
        long initialArray[] = new long[this.coefficients.length];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[initialArray.length - i - 1] = scale * this.coefficients[i];
        }

        Polynomial newPoly = new Polynomial(initialArray);
        newPoly.sanitizePolynomial();
        return newPoly;
    }

    /**
     * Determines the degree of a polynomial.
     *
     * @return The degree of the polynomial in question.
     */
    private int determineDegree() {
        int degree = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            if (this.coefficients[i] != 0) {
                degree = i;
            }
        }
        return degree;
    }

    /**
     * Sanitizes this polynomial, i.e removes the leading zeroes.
     */
    private void sanitizePolynomial() {
        while (this.coefficients[(int) this.degree] == 0) {
            if (this.degree == 0) {
                return;
            }
            long[] newArray = new long[this.coefficients.length - 1];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = this.coefficients[i];
            }
            this.setCoefficients(newArray);
        }

    }

    /**
     * Multiplies two polynomials.
     *
     * @param p the polynomial to be multiplied by this polynomial.
     * @return The product of the two polynomials.
     */
    public Polynomial multiply(Polynomial p) {
        long initialArray[] = new long[p.coefficients.length + this.coefficients.length];

        long[] thisReversed = reverse(this.coefficients);
        long[] thatReversed = reverse(p.coefficients);

        for (int i = 0; i < thisReversed.length; i++) {
            for (int j = 0; j < thatReversed.length; j++) {
                initialArray[i + j] += (this.coefficients[i] * p.coefficients[j]);

            }
        }

        long[] initialReversed = reverse(initialArray);
        Polynomial n = new Polynomial(initialReversed);
        n.sanitizePolynomial();
        return n;
    }

    /*
    TO DO!
    public Polynomial longDivision(Polynomial p) {
        long initialArray[] = new long[p.coefficients.length];
        Polynomial d = new Polynomial();
        Polynomial r = this.copyThisPoly();
        
        if(this.degree < p.getDegree()) {
            return new Polynomial();
        }
        
        long coefficient = this.getCoefficients()[(int)this.degree]/p.getCoefficients()[(int)p.degree];
        long exponent = this.degree - p.getDegree();
        
        
        

        

        return r;
    }
     */
    /**
     * Shifts polynomial to right by some number of steps.
     *
     * @param steps The number of steps.
     * @return The shifted polynomial.
     */
    public Polynomial shiftRight(int steps) {
        long[] initialArray = new long[this.coefficients.length + steps];

        for (int i = 0; i < this.coefficients.length; i++) {
            initialArray[i] = this.coefficients[this.coefficients.length - 1 - i];
        }

        Polynomial p = new Polynomial(initialArray);
        p.sanitizePolynomial();
        return p;

    }

    /**
     * Uses Polynomial.multiply to calculate powers of the given exponential.
     *
     * @param exponent The exponent used to calculate the power of the
     * polynomial.
     * @return The resulting polynomial.
     */
    public Polynomial exponentiation(long exponent) {
        Polynomial newpoly = new Polynomial(1);
        while (exponent > 0) {
            newpoly = newpoly.multiply(this);
            exponent--;
        }
        return newpoly;
    }

    /**
     * Evaluates the value of this polynomial at some point x.
     *
     * @param x Point where we want to evaluate the value of the polynomial.
     * @return The value of the polynomial at x.
     */
    public long evaluateAtX(long x) {
        long value = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            value += this.coefficients[i] * (Math.pow(x, i));
        }

        return value;
    }

    /**
     * Getter for the degree of the polynomial.
     *
     * @return The degree of the polynomial.
     */
    public long getDegree() {
        return degree;
    }

    /**
     * Makes a copy of the present polynomial.
     *
     * @return A copy of this polynomial.
     */
    public Polynomial copyThisPoly() {
        long[] initialArray = this.getCoefficients();
        long[] reversedArray = new long[this.getCoefficients().length];
        for (int i = 0; i < initialArray.length; i++) {
            reversedArray[i] = initialArray[initialArray.length - i - 1];
        }
        Polynomial newPoly = new Polynomial(reversedArray);
        return newPoly;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = this.coefficients.length - 1; i >= 0; i--) {
            if (i == 0) {
                if (this.coefficients.length != 1) {
                    s.append(" + ");
                }
                s.append(this.coefficients[i]);

            } else if (i == this.coefficients.length - 1) {
                s.append(this.coefficients[i]);
                s.append("x^");
                s.append(i);
            } else {
                s.append(" + ");
                s.append(this.coefficients[i]);
                s.append("x^");
                s.append(i);
            }
        }
        return s.toString();
    }

    public void setCoefficients(long[] coefficients) {
        this.coefficients = coefficients;
    }

}
