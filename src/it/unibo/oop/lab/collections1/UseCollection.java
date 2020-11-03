package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private static final int SIZE = 2000;
	public static final int FIRST_INDX = 0;
	public static final int ELEM = 100000;
	public static final int ELEM_2 = 1000;
	public static final int TO_MS = 1_000_000;

	private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	ArrayList<Integer> arrList = new ArrayList<>();

    	for (int i = 1000; i < SIZE;i++) {
    		arrList.add(i);
    	}
        /*
         * 
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	LinkedList<Integer> linkList = new LinkedList<>();
    	
    	linkList.addAll(arrList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int lastIndex = (arrList.size() - 1);
    	int temp = arrList.get(lastIndex);
    	arrList.set(lastIndex, arrList.get(FIRST_INDX));
    	arrList.set(FIRST_INDX, temp);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	 for(Integer i : arrList) {
	     		System.out.println(i);
	     }
    	 
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	 
    	Collection<Integer> coll = new ArrayList<Integer>();
     	Collection<Integer> coll2 = new LinkedList<Integer>();
     	
     	//
     	long timeInsertion = System.nanoTime();
     	for (int i = 0; i < ELEM; i++) {
     		coll.add(i);
     	}
     	timeInsertion = System.nanoTime() - timeInsertion;
     	System.out.println("ArrayList time to insert n elements in ns:" + timeInsertion
     						+ "in ms: " + (timeInsertion/TO_MS));
     	
     	long timeInsertion2 = System.nanoTime();
     	for (int i = 0; i < ELEM; i++) {
     		coll2.add(i);
     	}
     	timeInsertion2 = System.nanoTime() - timeInsertion2;
     	System.out.println("LinkedList time to insert n elements in ns:" + timeInsertion2 
     						+ "in ms: " + (timeInsertion2/TO_MS));
    	 
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
     	
     	//Codice commentato per via di problemi nella risoluzione
     	/*long timeReadMiddle = System.nanoTime();
    
    	
    	for(int i = 0; i < ELEM_2 ;i++) {
    		for(int j = 0;j < ELEM\2;j++) {	
    		}
    	}
    	
    	System.out.println("ArrayList time to read A[n/2] element in ns:" + timeReadMiddle
    						+ "in ms: " + (timeReadMiddle/TO_MS));
    	
    	long timeRead2 = System.nanoTime();
    	
    	for(int i = 0; i < ELEM_2 ;i++) {
    		for(int j = 0; i < ELEM/2; j++ ) {
    		}
    
    	}
    	timeRead2 = System.nanoTime() - timeRead2;
    	System.out.println("LinkedList time to read A[n/2] element in ns:" + timeRead2 
    						+ "in ms: " + (timeRead2/TO_MS));
    	
    	*/
     	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
     	
     	Map<String, Double> worldPopulation = new HashMap<>();
    	
    	worldPopulation.put("Africa", 11106635000.00);
    	worldPopulation.put("Americas", 972_005_000.00);
    	worldPopulation.put("Antartica", 0.00);
    	worldPopulation.put("Asia", 4_298_723_000.00);
    	worldPopulation.put("Europe", 742_452_000.00);
    	worldPopulation.put("Oceania", 38_304_000.00);
     	
        /*
         * 8) Compute the population of the world
         */
    	
    	float sum = 0l;
    	
    	for(double d : worldPopulation.values()) {
    		sum += d;
    	}
    	
    	System.out.println(sum);
    }
}

