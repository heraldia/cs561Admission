package edu.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RanAver {

	/**
	 * @param args
	 */

	List<Integer> committeeList_1 = new ArrayList<Integer>();
	List<Integer> committeeList_2 = new ArrayList<Integer>();
	Random rnd = new Random();
	int n = 0;
	int m = 0;
	int offset = 3; // offset should be less than or equal to m/2.
	
	public RanAver(int n, int m, int offset) {
		super();
//		if(n>m){
		this.n = n;
//		}
//		else {
//			this.n = n;
//		}
		this.m = m;
		this.offset = offset;
		this.checkDuplicate(n, m, offset);
	}

	public int getRemainder(int n, int m) {
		return n % m;
	}

	public int getAver(int n, int m) {
		return n / m;
	}


	public List<Integer> getFirstList(int n, int m, int offset) {
		List<Integer> iFirstList = new ArrayList<Integer>();
		for (int i = offset; i > 0; i--) {
			iFirstList.add(m - i + 1);
		}

		for (int i = 0; i < n / m + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				iFirstList.add(j);
			}
		}
		iFirstList = iFirstList.subList(0, n);
		return iFirstList;
	}

	public List<Integer> getSecondList(int n, int m, int offset) {
		List<Integer> iSecondList = new ArrayList<Integer>();
		List<Integer> tIntegerslList = new ArrayList<Integer>();
		
		tIntegerslList = getFirstList(n,m,offset);
 
		for (int i = 0; i < offset; i++) {
			tIntegerslList.set(i, i + 1);
		}
		
		Random rnd = new Random();
		int nOriginal = n ;
		int e = m/2;
		for (int i = 0; i < nOriginal; i++, n--) {
			e = rnd.nextInt(n);
			iSecondList.add(tIntegerslList.get(e));
			tIntegerslList.remove(e);
		}
		return iSecondList;
	}
	
	public void checkDuplicate(int n,int m,int offset) {
		committeeList_1 = getFirstList(n, m, offset);
		committeeList_2 = getSecondList(n, m, offset);
		for (int i = 0; i < committeeList_1.size(); i++) {
			while(committeeList_1.get(i)==committeeList_2.get(i)){
				committeeList_2.set(i,rnd.nextInt(FinalConstant.totalNumberCommittee)+1);
			}
		} 
//		System.out.println(committeeList_1);
//		System.out.println(committeeList_2);
		distribution(committeeList_1);
		distribution(committeeList_2);
	}

	public static void distribution(List<Integer> committeeIntegers_2) {

		List<Integer> icommitteeIntegers_2 = new ArrayList<Integer>();
		icommitteeIntegers_2 = committeeIntegers_2;
		int distrib[] = new int[FinalConstant.totalNumberCommittee];
		for (int i = 0; i < FinalConstant.totalNumberCommittee-1; i++) {
			distrib[i]=0;
		}
		Iterator<Integer> iterator = committeeIntegers_2.iterator();
		while (iterator.hasNext()){
			 distrib[iterator.next()-1]++; 
		}
		for (int i = 0; i < distrib.length; i++) {
			System.out.print(distrib[i]+"  ");
		}
		System.out.println();
	}
	
	public List<Integer> getCommitteeList_1() {
		return committeeList_1;
	}

	public void setCommitteeList_1(List<Integer> committeeList_1) {
		this.committeeList_1 = committeeList_1;
	}

	public List<Integer> getCommitteeList_2() {
		return committeeList_2;
	}

	public void setCommitteeList_2(List<Integer> committeeList_2) {
		this.committeeList_2 = committeeList_2;
	}

	
	public static void main(String[] args) {
		int n = 3;
		int m = 8;
		int offset = 3; // offset should be less than or equal to m/2.

		RanAver ranAver1 = new RanAver(n,m,offset);
		System.out.println(ranAver1.getCommitteeList_1());
		System.out.println(ranAver1.getCommitteeList_2());
		}
}
