package algorithms.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

	public int runBinarySearchIteratively(int[] sortedArray, int key, int low, int high) {
		int index = Integer.MAX_VALUE;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (sortedArray[mid] < key) {
				low = mid + 1;
			} else if (sortedArray[mid] > key) {
				high = mid - 1;
			} else if (sortedArray[mid] == key) {
				index = mid;
				break;
			}
		}
		
		return index;
	}
	
	public int runBinarySearchRecursively(int[] sortedArray, int key, int low, int high) {
		int mid = (low + high) / 2;
		if (high < low) {
			return -1;
		}
		
		if (key == sortedArray[mid]) {
			return mid;
		} else if (key < sortedArray[mid]) {
			return runBinarySearchRecursively(sortedArray, key, low, mid-1);
		} else {
			return runBinarySearchRecursively(sortedArray, key, mid + 1, high);
		}
	}
	
	public int runBinarySearchUsingJavaArrays(int[] sortedArray, Integer key) {
        int index = Arrays.binarySearch(sortedArray, key);
        return index;
    }

    public int runBinarySearchUsingJavaCollections(List<Integer> sortedList, Integer key) {
        int index = Collections.binarySearch(sortedList, key);
        return index;
    }
}
