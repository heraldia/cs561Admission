package edu.random;
import java.text.DecimalFormat;
import java.util.Random;


public class Randomx {
	/**	 * return an integer in [0,max)	 * 
	 * 
	 * @param max 
	 * @return int
	 */
	public static int getRandomInt(int max) {
		return new Random().nextInt(max);
		}
	
	/**	 * return an random double 	 * 
	 * 
	 * @param d nonsense 
	 * @return int
	 */
	public static float getRandom(double d) {
		return new Random().nextFloat();
		}
	/**	 * return an integer in [min, max)
	 *  * 	
	 *   * @param min	
	 *    * @param max	
	 *     * @return	int
	 *      */	
	public static int getRandom(int min, int max) {	
		int r = getRandomInt(max - min);		
		return r + min;	
		}
	
	/**	 * return an double number in [d, e)
	 *  * 	
	 *   * @param e	
	 *    * @param d	
	 *     * @return an double number
	 *      */	
	public static double getRandom(double d, double e) {	
		float r = getRandom(e - d);		
		return r + d;	
		}

	
public static void main(String[] args) {
	int c;
//	c=(int)(Math.random()*100);
//	System.out.println(c);
	for (int i = 0; i < 114; i++) {
//		DecimalFormat df = new DecimalFormat("0.0");
//		double d = getRandom(2.0,4.0);
//		String db = df.format(d); 
//	System.out.println(db);
//		System.out.println(getRandom(7,10));
		System.out.println(getRandomInt(2));
	}
}
}
