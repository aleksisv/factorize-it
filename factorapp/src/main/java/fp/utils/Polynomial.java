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
        this.sanitizePolynomial();
    }

    public Polynomial(long[] coefficients, long degree) {
        this.coefficients = coefficients;
        this.degree = degree;
    }

    public long[] getCoefficients() {
        return coefficients;
    }
    
    private long[] reverse(long[] arr) {
        long[] reversed = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - i - 1];
        }
        return reversed;
    }
    

    public Polynomial addPolynomial(Polynomial p) {
        
        int max = Math.max(this.getCoefficients().length, p.getCoefficients().length);
        long initialArray[] = new long[max];
        
        long[] thisReversed = reverse(this.coefficients);
        long[] thatReversed = reverse(p.coefficients);
        
        for (int i = 0; i < initialArray.length; i++) {
            if(this.coefficients.length <= i) {
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

    public Polynomial scalePolynomial(long scale) {
        long initialArray[] = new long[this.coefficients.length];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[initialArray.length - i - 1] = scale * this.coefficients[i];
        }

        Polynomial newPoly = new Polynomial(initialArray);
        newPoly.sanitizePolynomial();
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
    
    private void sanitizePolynomial() {
        if(this.coefficients[this.coefficients.length - 1] == 0) {
            long[] newArray = new long[this.coefficients.length - 1];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = this.coefficients[i];
            }
            this.setCoefficients(newArray);
        }
        
    }
    
    public Polynomial times(Polynomial p) {
        long initialArray[] = new long[p.coefficients.length + this.coefficients.length];
        
        long[] thisReversed = reverse(this.coefficients);
        long[] thatReversed = reverse(p.coefficients);
        
        for (int i = 0; i < thisReversed.length; i++) {
            for (int j = 0; j < thatReversed.length; j++) {
                initialArray[i+j] += (this.coefficients[i]*p.coefficients[j]);
                
            }
        }
        
        long[] initialReversed = reverse(initialArray);
        Polynomial n = new Polynomial(initialReversed);
        n.sanitizePolynomial();
        return n;
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

    public void setCoefficients(long[] coefficients) {
        this.coefficients = coefficients;
    }
    
    

}
