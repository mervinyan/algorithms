package algorithms.bubblesort;

import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortUnitTest {

	@Test
	public void givenIntegerArray_whenSortedWithBubbleSort_thenGetSortedArray() {
		Integer[] array = {2, 1, 4, 6, 3, 5};
		Integer[] sortedArray = {1, 2, 3, 4, 5, 6};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(array);
		
		assertArrayEquals(sortedArray, array);
	}
	
	@Test
	public void
	  givenIntegerArray_whenSortedWithOptimizedBubbleSort_thenGetSortedArray() {
	      Integer[] array = { 2, 1, 4, 6, 3, 5 };
	      Integer[] sortedArray = { 1, 2, 3, 4, 5, 6 };
	      BubbleSort bubbleSort = new BubbleSort();
	      bubbleSort.optimizedBubbleSort(array);
	  
	      assertArrayEquals(array, sortedArray);
	}
}
