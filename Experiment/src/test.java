import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class BubbleSort {
	// Variables
	static int size = 1000000; // size of the array to use

	public static void main(String[] args) {
		int[] array1 = new int[size];
		int[] array2 = new int[size];
		int[] array3 = new int[size];
		int[] array4 = new int[size];

		try {
			start(array1, array2, array3, array4);
		} catch (IOException e) {
		}
		// same values

		long startTime = System.nanoTime();
		BubbleSort(array1);
		long endTime = System.nanoTime();
		System.out.println("Total execution time: " + (endTime - startTime));
		System.out.println("Sorted list of numbers");

		startTime = System.nanoTime();
		BubbleSortExit(array2);
		endTime = System.nanoTime();
		System.out.println("Total execution time: " + (endTime - startTime));
		System.out.println("Sorted list of numbers");
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
		// printArray(array);
	}

	public static void SelectionSort(int[] array) {
		
		// printArray(array);
	}
	
	public static void InsertionSort(int[] array) {
		
		// printArray(array);
	}
	
	
	public static void printArray(int[] array) {
		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}
	}
}