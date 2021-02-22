
/**
 * 
 * @author Alex Ortunio
 *
 */
public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		
		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;
		
		int sum = sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = sumOfArray(myArray, 5);
		System.out.println(sum);
	}
	
	/**
	 * Recursive method for generating sum of values in array
	 * @param arr array of Integers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	public static int sumOfArray(Integer[] arr, int num) {
		if(arr.length == 1 || num == 0) {
			return arr[0];
		}
		
		Integer[] shrunk_array = new Integer[arr.length-1];
		for(int i = 1; i < arr.length; i++) {
			shrunk_array[i-1] = arr[i];
		}
		
		return arr[0] + sumOfArray(shrunk_array,  num-1);
	}

}