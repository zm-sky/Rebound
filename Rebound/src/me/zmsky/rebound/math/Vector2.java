package me.zmsky.rebound.math;

public class Vector2 {
	public float x;
	public float y;
	
	/**
	 * Creates a vector with same the same values
	 * as the given vector.
	 * 
	 * @param v The vector to copy values from.
	 */
	public Vector2(Vector2 v){
		x = v.x;
		y = v.y;
	}
	/**
	 * Creates a vector instance.
	 * 
	 * @param x The x value of this vector.
	 * @param y The y value of this vector.
	 */
	public Vector2(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Limits this vector's values to the one given
	 * in the parameter.
	 * 
	 * @param max The max value desired.
	 */
	public void limitMax(float max){
		if(magnitude() > max){
			normalized();
			mult(max);
		}
	}
	
	/**
	 * Limits this vector's values to the one given
	 * in the parameter.
	 * 
	 * @param max The min value desired.
	 */
	public void limitMin(float min){
		if(magnitude() < min){
			normalized();
			mult(min);
		}
	}
	
	/**
	 * Returns a normalized vector of the same values.
	 * @return
	 */
	public Vector2 normalized(){
		Vector2 normalized = new Vector2(x, y);
		normalized.normalize();
		
		return normalized;
	}
	
	/**
	 * Normalizes this vector.
	 */
	public void normalize(){
		float mag = magnitude();
		
		if(mag != 0)
			div(mag);
	}
	
	/**
	 * Adds this vector's values from the given one.
	 * 
	 * @param v The vector to add from.
	 */
	public void add(Vector2 v){
		x+= v.x;
		y+= v.y;
	}
	
	/**
	 * Subtracts this vector's values from the given one.
	 * @param v
	 */
	public void sub(Vector2 v){
		x-= v.x;
		y-= v.y;
	}
	
	/**
	 * Multiplies this vector's values by the parameter.
	 * @param v The number to multiply by.
	 */
	public void mult(float n){
		x*= n;
		y*= n;
	}
	
	/**
	 * Divides this vector's values by the parameter.
	 * @param n The denominator.
	 */
	public void div(float n){
		x/= n;
		y/= n;
	}
	
	/**
	 * Returns the magnitude of this vector.
	 * 
	 * @return The magnitude of this vector.
	 */
	public float magnitude(){
		return (float) Math.sqrt(x*x + y*y);
	}
	
	/////////////////////
	//Static functions//
	///////////////////
	
	/**
	 * Divides this vector's values by the parameter.
	 * 
	 * @param a The vector to divide.
	 * @param n The denominator.
	 * 
	 * @return The divided vector.
	 */
	public static Vector2 div(Vector2 a, float n){
		Vector2 v = new Vector2(a);
		v.div(n);
		return v;
	}
	/**
	 * Adds two vectors together, returning the resulting vector.
	 * 
	 * @param a VectorA to add to.
	 * @param b VectorB to add from.
	 * 
	 * @return A vector with the result.
	 */
	public static Vector2 add(Vector2 a, Vector2 b){
		return new Vector2(a.x + b.x, a.y + b.y);
	}
	/**
	 * Subtracts two vectors together, returning the resulting vector.
	 * 
	 * @param a VectorA to subtract to.
	 * @param b VectorB to subtract from.
	 * 
	 * @return A vector with the result.
	 */
	public static Vector2 sub(Vector2 a, Vector2 b){
		return new Vector2(a.x - b.x, a.y - b.y);
	}
	public String toString(){
		return "VECTOR2 - X: " + x + " ||  Y: " + y;
	}
}
