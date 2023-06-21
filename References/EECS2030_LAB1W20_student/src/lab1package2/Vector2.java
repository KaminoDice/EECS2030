package lab1package2;

/**
 * A class that represents two dimensional spatial vectors (a direction and a
 * magnitude). Every vector has a real-valued x-component and a y-component. The
 * class provides some basic mathematical operations such as vector addition and
 * subtraction, and scalar multiplicaton.
 * 
 * 
 * 
 */
public final class Vector2 {
    private double x;
    private double y;

    /**
     * Creates the vector <code>(0.0, 0.0)</code> with name equal to the empty
     * string.
     */
    public Vector2() {
        
    }

    /**
     * Creates the vector <code>(x, y)</code>.
     * 
     * @param x
     *            the x-component of the vector
     * @param y
     *            the y-component of the vector
     */
    public Vector2(double x, double y) {
        
    }

    /**
     * Creates a vector with the same components as another vector.
     * 
     * @param other
     *            a vector to copy the components from
     */
    public Vector2(Vector2 other) {
        
    }

    /**
     * Returns the x component of the vector.
     * 
     * @return the x component of the vector.
     */
    public double getX() {
        
    }

    /**
     * Sets the x component of the vector.
     * 
     * @param x
     *            the new value of the x component.
     */
    public void setX(double x) {
       
    }

    /**
     * Returns the y component of the vector.
     * 
     * @return the y component of the vector.
     */
    public double getY() {
        
    }

    /**
     * Sets the y component of the vector.
     * 
     * @param y
     *            the new value of the y component.
     */
    public void setY(double y) {
        
    }

    /**
     * Sets the x and y component of the vector.
     * 
     * @param x
     *            the new value of the x component.
     * @param y
     *            the new value of the y component.
     */
    public void set(double x, double y) {
        
    }

    /**
     * Add a vector to this vector changing the components of this vector.
     * 
     * <p>
     * Mathematically, if this vector is <code>a</code> and the other vector is
     * <code>b</code> then invoking this method is equivalent to computing
     * <code>a + b</code> and assigning the value back to <code>a</code>.
     * 
     * @param other
     *            the vector to add to this vector.
     * @return this <code>Vector2D</code> object
     */
    public Vector2 add(Vector2 other) {
       
    }

    /**
     * Subtract a vector from this vector changing the components of this
     * vector.
     * 
     * <p>
     * Mathematically, if this vector is <code>a</code> and the other vector is
     * <code>b</code> then invoking this method is equivalent to computing
     * <code>a - b</code> and assigning the value back to <code>a</code>.
     * 
     * @param other
     *            the vector to subtract this vector.
     * @return this <code>Vector2D</code> object
     */
    public Vector2 subtract(Vector2 other) {
      
    }

    /**
     * Multiply this vector by a scalar amount changing the components of this
     * vector.
     * 
     * <p>
     * Mathematically, if this vector is <code>a</code> and the scalor is
     * <code>s</code> then invoking this method is equivalent to computing
     * <code>s * a</code> and assigning the value back to <code>a</code>.
     * 
     * @param s
     *            the scalar value to multiply the vector by
     * @return this <code>Vector2D</code> object
     */
    public Vector2 multiply(double s) {
        
    }

    /**
     * Returns the magnitude of this vector.
     * 
     * @return the magnitude of this vector.
     */
    public double mag() {
       
    }

    /**
     * Returns a new <code>Vector2D</code> equal to <code>a + b</code>.
     * 
     * @param a
     *            a vector
     * @param b
     *            another vector
     * @return a new <code>Vector2D</code> equal to <code>a + b</code>
     */
    public static Vector2 add(Vector2 a, Vector2 b) {
    
    }

    /**
     * Returns a new <code>Vector2D</code> equal to <code>a - b</code>.
     * 
     * @param a
     *            a vector
     * @param b
     *            another vector
     * @return a new <code>Vector2D</code> equal to <code>a - b</code>
     */
    public static Vector2 subtract(Vector2 a, Vector2 b) {
      
    }

    /**
     * Returns a new <code>Vector2D</code> equal to <code>s * a</code>.
     * 
     * @param s
     *            a scalar
     * @param a
     *            a vector
     * @return a new <code>Vector2D</code> equal to <code>s * a</code>
     */
    public static Vector2 multiply(double s, Vector2 a) {
       
    }

    /**
     * Returns the vector having magnitude one pointing in the direction
     * <code>theta</code> degrees from the x axis.
     * 
     * <p>
     * The components of the vector are equal to
     * <code>(Math.cos(rad), Math.sin(rad))</code> where <code>rad</code> is
     * <code>theta</code> expressed in radians.
     * 
     * @param theta
     *            the direction that the vector is pointing in measured in
     *            degrees from the x axis
     * @return the unit vector pointing in the given direction
     */
    public static Vector2 dirVector(double theta) {
        
    }

    
    /**
     * Returns a string representation of the vector. The string is the name of
     * the vector, followed by the comma separated components of the vector
     * inside parentheses.
     * 
     * @return a string representation of the vector
     */
    @Override
    public String toString() {
        
    }

    /**
     * Determines if two vectors are almost equal (similar). Two vectors are
     * similar if the magnitude of their vector difference is smaller than the
     * specified tolerance.
     * 
     * @param other
     *            the other vector to compare
     * @param tol
     *            the threshold length of the vector difference
     *            <code>(this - other)</code>
     * @return <code>true</code> if the length of <code>(this - other)</code> is
     *         less than <code>tol</code>, and <code>false</code> otherwise
     */
    public boolean similarTo(Vector2 other, double tol) {
       
    }
}