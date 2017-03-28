
package fp.utils;

public class Polynomial {
    private long[] coefficients;
    private long degree;

    public Polynomial() {
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

    private long determineDegree() {
        long degree = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            if(this.coefficients[i] != 0) {
                degree = i;
            }
        }
        return degree;
    }
    
    public long evaluateAtX(long x) {
        long value = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            value += this.coefficients[i]*(Math.pow(x, i    ));
        }
        
        return value;
    }
    
    

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = this.coefficients.length-1; i >= 0; i--) {
            if(i == 0) {
                s.append(" + ");
                s.append(this.coefficients[i]);
                
            } else if (i == this.coefficients.length-1) {
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
