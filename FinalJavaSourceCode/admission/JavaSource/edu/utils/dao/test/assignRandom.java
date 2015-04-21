package edu.utils.dao.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**fail
 * @author Phil
 *
 */
public class assignRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int person = 7;
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		List<Integer> c = new ArrayList<Integer>();
		Map<Integer,Integer> ab = new HashMap<Integer, Integer>();
		
		List<Integer> personGroup1 = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			a.add(i);
		}
		 Random rnd = new Random();
		for (int i = 0; i < 100; i++) {
			   int e = rnd.nextInt(person)+1;
//			int e = (int) Math.random() * 10 +1 ;
//			System.out.println(e);
			b.add(e);

		}
		for (int i = 0; i < 100; i++) {
			   int e = rnd.nextInt(person)+1;
//			int e = (int) Math.random() * 10 +1 ;
//			System.out.println(e);
			c.add(e);

		}
		
		/*for (int i = 0; i < 100; i++) {
			
			ab.put(a.get(i), b.get(i));
		}*/
		
/*
		Iterator iter = ab.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next()	;
			Object key = entry.getKey();
					Object val = entry.getValue();
					System.out.println(key+" "+val);
		}
		*/
		for (int i = 0; i < 100; i++) {
			while(b.get(i)== c.get(i)){
				c.set(i, rnd.nextInt(person)+1);
			}
		}
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i)+ "  "+b.get(i)+ "  "+c.get(i));
		}
		
	}
}
