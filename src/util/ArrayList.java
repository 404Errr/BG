//package util;
//
//import java.util.Arrays;
//
//@SuppressWarnings("serial")
//public class ArrayList<E> extends java.util.ArrayList<E> {
//	@Override
//	public void add(int index, E element) {
//		while (index>size()) add(null);
//		super.add(element);
//	}
//}
//
//class Tester {
//	public static void main(String[] args) {
//		java.util.ArrayList<Integer> array = new java.util.ArrayList<>();
//		ArrayList<Integer> myArray = new ArrayList<>();
//
//		array.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
//		myArray.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
//
//		System.out.println(array);
//		System.out.println(myArray);
//
////		array.add(11, 100);//throws out of bounds
//		myArray.add(11, 100);
//		myArray.add(20, 100);
//
//		System.out.println(array);
//		System.out.println(myArray);
//	}
//}