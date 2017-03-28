package fp.utils;

public class Polynomial {

    private long[] coefficients;
    private long degree;

    public Polynomial() {
        this.coefficients = new long[1];
        this.coefficients[0] = 0;
        this.degree = determineDegree();
    }

    public Polynomial(long... coeffs) {
        this.coefficients = new long[coeffs.length];
        for (int i = 0; i < coeffs.length; i++) {
            coefficients[coefficients.length - 1 - i] = coeffs[i];
        }

        this.degree = determineDegree();
    }

    public Polynomial(long[] coefficients, long degree) {
        this.coefficients = coefficients;
        this.degree = degree;
    }

    public long[] getCoefficients() {
        return coefficients;
    }

    public Polynomial addPolynomial(Polynomial p) {
        
        int max = Math.max(this.getCoefficients().length, p.getCoefficients().length);
        long initialArray[] = new long[max];
        
        long[] thisReversed = new long[this.coefficients.length];
        long[] thatReversed = new long[p.coefficients.length];
        
        for (int i = 0; i < this.coefficients.length; i++) {
            thisReversed[i] = this.coefficients[this.coefficients.length - i - 1];
        }
        
        for (int i = 0; i < p.coefficients.length; i++) {
            thatReversed[i] = p.coefficients[p.coefficients.length - i - 1];
        }
        
        for (int i = 0; i < initialArray.length; i++) {
            if(this.coefficients.length <= i) {
                initialArray[i] = p.coefficients[i];
            } else if (p.coefficients.length <= i) {
                initialArray[i] = this.coefficients[i];
            } else {
                initialArray[i] = p.coefficients[i] + this.coefficients[i];
            }
        }
        
        long[] initialReversed = new long[max];
        for (int i = 0; i < initialArray.length; i++) {
            initialReversed[i] = initialArray[max-i-1];
        }
        
        Polynomial newPoly = new Polynomial(initialReversed);
        return newPoly;
    }

    public Polynomial scalePolynomial(long scale) {
        long initialArray[] = new long[this.coefficients.length];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[initialArray.length - i - 1] = scale * this.coefficients[i];
        }

        Polynomial newPoly = new Polynomial(initialArray);
        return newPoly;
    }

    private long determineDegree() {
        long degree = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            if (this.coefficients[i] != 0) {
                degree = i;
            }
        }
        return degree;
    }

    public long evaluateAtX(long x) {
        long value = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            value += this.coefficients[i] * (Math.pow(x, i));
        }

        return value;
    }

    public long getDegree() {
        return degree;
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

}
