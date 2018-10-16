package algorithm.mcpa;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostPathAnalysis {

	public static void main(String[] args) {
		Integer arr[] = {131, 673, 234, 103, 18, 201, 96, 342, 965, 150, 630, 803, 746, 422, 111, 537, 699, 497, 121, 956, 805, 732, 524, 37, 331};
		
		int rows = 5;
		int columns = 5;
		int length = arr.length;

		List<Integer> firstColumn = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			if (i % rows == 0) {
				firstColumn.add(i);
			}
		}
		
		List<Integer> firstRow = new ArrayList<>();
		for (int i = 0; i < columns; i++) {
			firstRow.add(i);
		}
				
		System.out.println("Original");
		for (int i = 0; i < rows; i++) {
			System.out.println("\n");
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i * rows + j]);
				if (j < columns-1) {
					System.out.print(", ");
				}
			}
		}
		
		System.out.println("\n");
		
		for (int idx = 0; idx < length; idx++) {
			if (idx == 0) {
				continue;
			}
			Integer aboveValue = idx >= rows ? arr[idx-rows] : 0;
			Integer previousValue = arr[idx-1];
			
			if (firstRow.contains(idx)) {
				arr[idx] = arr[idx] + previousValue;
			}
			if (firstColumn.contains(idx)) {
				arr[idx] = arr[idx] + aboveValue;
			}
			if (!firstRow.contains(idx) && !firstColumn.contains(idx)) {
				if ((arr[idx] + previousValue) < (arr[idx] + aboveValue)) {
					arr[idx] = arr[idx] + previousValue;
				} else {
					arr[idx] = arr[idx] + aboveValue;
				}
			}
		}

		System.out.println("Calculated");
		for (int i = 0; i < rows; i++) {
			System.out.println("\n");
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i * rows + j]);
				if (j < columns-1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println("\n");

	}
	
	
	
	
}
