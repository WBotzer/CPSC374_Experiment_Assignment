import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class BubbleSort {
	// Variables
	static int size = 1000; // size of the array to use

	public static void main(String[] args) {
		int[] array1 = new int[size];
		int[] array2 = new int[size];
		int[] array3 = new int[size];
		int[] array4 = new int[size];

		try {
			start(array1, array2, array3, array4);
		} catch (IOException e) { }


		long startTime = System.nanoTime();
		BubbleSort(array1);
		long endTime = System.nanoTime();
		System.out.println("Total execution time: " + (endTime - startTime));


		startTime = System.nanoTime();
		BubbleSortExit(array2);
		endTime = System.nanoTime();
		System.out.println("Total execution time: " + (endTime - startTime));
		
		startTime = System.nanoTime();
		SelectionSort(array3);
		endTime = System.nanoTime();
		System.out.println("Total execution time: " + (endTime - startTime));
		
		startTime = System.nanoTime();
		InsertionSort(array4);
		endTime = System.nanoTime();
		System.out.println("Total execution time: " + (endTime - startTime));
	}

	public static void start(int[] array1, int[] array2, int[] array3,
			int[] array4) throws IOException {
		// read from file
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader("rand.txt"));
		} finally {
			if (inputStream == null) {
				System.out.println("Not Found");
			}
		}

		int num = 0;
		String line = null;
		for (int i = 0; i < size; i++) {
			line = inputStream.readLine();
			num = Integer.parseInt(line);
			// System.out.println(num);
			array1[i] = num;
			array2[i] = num;
			array3[i] = num;
			array4[i] = num;
		}
		inputStream.close();

	}

	public static void BubbleSort(int[] array) {
		for (int i = 0; i < (array.length - 1); i++) {
			// notSorted = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) /* For descending order use < */
				{
					int swap = array[j];
					array[j] = array[j + 1];
					array[j + 1] = swap;
				}
			}
		}
		// System.out.println("Bubble: Sorted list of numbers");
		// printArray(array);
	}

	public static void BubbleSortExit(int[] array) {
		boolean notSorted = true;
		for (int i = 0; i < (array.length - 1) && notSorted; i++) {
			notSorted = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) /* For descending order use < */
				{
					int swap = array[j];
					array[j] = array[j + 1];
					array[j + 1] = swap;
					notSorted = true;
				}
			}
		}
		// System.out.println("BubbleFastExit: Sorted list of numbers");
		// printArray(array);
	}

	public static void SelectionSort(int[] array) {
		int smallestElem;
		for (int i = 0; i < array.length -1; i++) {
			smallestElem = i;
			for (int j = i+1; j < array.length; j++) {
				if (array[smallestElem] > array[j]) {
					smallestElem = j;
				}
			}
			int swap = array[i];
			array[i] = array[smallestElem];
			array[smallestElem] = swap;
		}
		// System.out.println("Selection: Sorted list of numbers");
		// printArray(array);
	}
	
	public static void InsertionSort(int[] array) {
		int toInsert;
		int j;
		for (int i = 1; i < array.length; i++) {
			toInsert = array[i]; 
			for (j = i-1; j >= 0 && toInsert < array[j]; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = toInsert;			
		}
		// System.out.println("Insertion: Sorted list of numbers");
		// printArray(array);
	}
	
	
	public static void printArray(int[] array) {
		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}
	}
}