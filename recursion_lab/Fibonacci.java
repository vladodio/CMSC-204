import java.util.ArrayList;

/**
 * 
 * @author Alex Ortunio
 *
 */
public class Fibonacci {
	public ArrayList<Integer> foundValues;
	
	public Fibonacci() {
		foundValues = new ArrayList<Integer>();
		foundValues.add(0);
		foundValues.add(1);
	}
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.calcFibonacci(9));
	}
	
	public int calcFibonacci(int n) {
	    if(foundValues.size() > n) {
	    	return foundValues.get(n);
	    }
	    int a = calcFibonacci(n - 1) + calcFibonacci(n - 2);
	    foundValues.add(a);
	    return calcFibonacci(n);
	}
}
