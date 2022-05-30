
/**
 * A class that represents a rational number. 
 * 
 * @author Charles Hoot 
 * @version 4.0
 * 
 * Lab 1
 * By: Alyssa Richie
 * Team: Team Two's (Alyssa Richie, Alica Shi, Muhammad Reza, Nico Paganelli)
 * 
*/

public class Rational
{
    private int numerator;
    private int denominator;

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {  
        //default constructor makes a rational number 1
        numerator = 1;
        denominator = 1;
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d)
    {
        //checks if denominator value given is 0.
        // a rational number (fraction) can't have a denominator of 0.
        if(d == 0)
        {
            throw new ZeroDenominatorException("The denominator cannot be zero");
        }
        //sets private data fields to given values
        numerator = n;
        denominator = d;
        //Call the normalize function to reduce to smallest fraction.
        normalize();
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        //getter method --> gets the value for the numerator
        return numerator;
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        return denominator;
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {               
        //Only have to make the numerator negative. Both numerator & denominator would
        //      counteract and make the rational number positive again
        int num = -(numerator);
        //create a new rational number because function returns a rational number
        Rational negRational = new Rational(num, denominator);
        return negRational;
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert()
    { 
        // rational number that is 1/r is the same as flipping the numerator and denominator.
        Rational invertRational = new Rational(denominator, numerator);
        return invertRational;
    }

    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other)
    {       
        //rational number in form (ny+xd)/dy
        // n/d is for the original (this) rational number
        // x/y is for rational "other"
        int x = other.getNumerator();
        int y = other.getDenominator();
        int n = getNumerator();
        int d = getDenominator();
        
        //Formulas for adding two rational numbers 
        int addedNumerator = n * y + x * d;
        int addedDenominator = d * y;
        
        //Create a new rational number object --> must return rational number
        Rational addedRational = new Rational(addedNumerator, addedDenominator);
        
        return addedRational;
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other)
    {               
        //rational number in form (ny-xd)/dy
        // n/d is for the original rational number
        // x/y is for rational other
        int x = other.getNumerator();
        int y = other.getDenominator();
        int n = getNumerator();
        int d = getDenominator();
        //nearly identical formula used for subtracting as adding. But "-" instead of "+"
        int subNumerator = n * y - x * d;
        int subDenominator = d * y;
        
        Rational subRational = new Rational(subNumerator, subDenominator);
        return subRational;
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other)
    {       
        int x = other.getNumerator();
        int y = other.getDenominator();
        int n = getNumerator();
        int d = getDenominator();
        
        //Multiply straight across
        int multNumerator = x * n;
        int multDenominator = y * d;
        
        Rational multRational = new Rational(multNumerator, multDenominator);
        return multRational;
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other)
    {   
        //Dividing is the same as multiplying by it's reciprical.
        Rational divRational = this.multiply(other.invert());
        return divRational;
    }
     
 
 
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     *
     */
    private void normalize()
    {  
        //checks if either the denominator is negative
        //This guarntees only the numerator is negative (if any negatives)
        if(denominator < 0)
        {
           //Multiplying both numerator and denominator causes the negative
           //   sign to be put onto the numerator if negative sign is only at bottom
           denominator = denominator * (-1);
           numerator = numerator * (-1);
        }
        
        //Use absolute values so the function gcd works.
        int gcf = gcd(Math.abs(numerator), Math.abs(denominator));
        
        //sets numerator and denominator
        numerator = numerator / gcf;
        denominator = denominator / gcf;
    }
    
    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }

}
