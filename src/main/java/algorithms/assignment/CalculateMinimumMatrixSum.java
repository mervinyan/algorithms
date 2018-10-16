package algorithms.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Assignment Problem & Calculating the Minimum Matrix Sum
 * 
 * @see <a href=
 *      "https://hackernoon.com/the-assignment-problem-calculating-the-minimum-matrix-sum-python-1bba7d15252d">The
 *      Assignment Problem & Calculating the Minimum Matrix Sum (Python)</a>
 * @author yanm2
 *
 */
public class CalculateMinimumMatrixSum {
	public static void main(String[] args) {
		Integer arr[] = { 100, 130, 115, 55, 150, 75, 35, 110, 85, 50, 120, 120, 70, 150, 25, 90 };

		List<Data> arr2 = new ArrayList<Data>();

		int numberOfRows = 4;
		int numberOfColumns = 4;
		int column = 0;
		int row = 0;

		for (int i = 0; i < arr.length; i++) {
			row = arr2.size() / numberOfRows + 1;
			column = column + 1;
			if (column > numberOfColumns) {
				column = 1;
			}

			Data data = new Data(row, column, i, arr[i], arr[i]);
			arr2.add(data);
		}

		List<Data> newList = arr2.stream().sorted(Comparator.comparing(Data::getOriginal_value)).collect(Collectors.toList());
		newList.stream().forEach(System.out::println);
		
		List<TestColumn> columnAndValue = new ArrayList<>();
		List<Integer> columnsTested = new ArrayList<>();
		
		for (int i = 0; i < newList.size(); i++) {
			TestColumn testData = new TestColumn(newList.get(i).getColumn(), newList.get(i).getOriginal_value());
			
			if (!columnsTested.contains(newList.get(i).getColumn())) {
				columnAndValue.add(testData);
				columnsTested.add(newList.get(i).getColumn());
			}
		}
		
		for (int i = 0; i < newList.size(); i++) {
			for (int j = 0; j < columnAndValue.size(); j++) {
				if (newList.get(i).getColumn() == columnAndValue.get(j).getColumn()) {
					newList.get(i).setModified_value(newList.get(i).getModified_value() - columnAndValue.get(j).getMinimum_value());
				}
			}
		}
		System.out.println("========================================================");
		newList.stream().forEach(System.out::println);
		
		List<TestRow> rowAndValue = new ArrayList<>();
		List<Integer> rowsTested = new ArrayList<>();
		
		for (int i = 0; i < newList.size(); i++) {
			TestRow testData = new TestRow(newList.get(i).getRow(), newList.get(i).getModified_value(), newList.get(i).getModified_value());
			
			if (!rowsTested.contains(newList.get(i).getRow())) {
				rowAndValue.add(testData);
				rowsTested.add(newList.get(i).getRow());
			}
		}
		
		for (int i = 0; i < newList.size(); i++) {
			for (int j = 0; j < rowAndValue.size(); j++) {
				if (newList.get(i).getRow() == rowAndValue.get(j).getRow() && rowAndValue.get(j).getModified_value() > 0) {
					newList.get(i).setModified_value(newList.get(i).getModified_value() - rowAndValue.get(j).getMinimum_value());
				}
			}
		}
		System.out.println("========================================================");
		newList.stream().forEach(System.out::println);
	}

}

class Data implements Comparable<Data> {
	private int row;
	private int column;
	private int index;
	private int original_value;
	private int modified_value;

	public Data() {

	}

	public Data(int row, int column, int index, int original_value, int modified_value) {
		super();
		this.row = row;
		this.column = column;
		this.index = index;
		this.original_value = original_value;
		this.modified_value = modified_value;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getOriginal_value() {
		return original_value;
	}

	public void setOriginal_value(int original_value) {
		this.original_value = original_value;
	}

	public int getModified_value() {
		return modified_value;
	}

	public void setModified_value(int modified_value) {
		this.modified_value = modified_value;
	}

	@Override
	public int compareTo(Data that) {
		return this.index > that.index ? 1 : (this.index == that.index ? 0 : -1);
	}

	@Override
	public String toString() {
		return String.format("{'column': %d,  'index': %d, 'original_value': %d, 'modified_value': %d, 'row': %d}",
				this.column, this.index, this.original_value, this.modified_value, this.row);
	}

}

class TestColumn {
	private int column;
	private int minimum_value;

	public TestColumn() {

	}

	public TestColumn(int column, int minimum_value) {
		super();
		this.column = column;
		this.minimum_value = minimum_value;
	}

	public int getColumn() {
		return column;
	}

	public int getMinimum_value() {
		return minimum_value;
	}

	@Override
	public String toString() {
		return String.format("{'column': %d,  'minimum_value': %d}", this.column, this.minimum_value);
	}

}

class TestRow {
	private int row;
	private int minimum_value;
	private int modified_value;

	public TestRow() {

	}

	public TestRow(int row, int minimum_value, int modified_value) {
		super();
		this.row = row;
		this.minimum_value = minimum_value;
		this.modified_value = modified_value;
	}

	public int getRow() {
		return row;
	}

	public int getMinimum_value() {
		return minimum_value;
	}
	
	public int getModified_value() {
		return modified_value;
	}

	@Override
	public String toString() {
		return String.format("{'row': %d,  'minimum_value': %d, 'modified_value': %d}", this.row, this.minimum_value, this.modified_value);
	}

}