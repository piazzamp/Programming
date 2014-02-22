import java.util.Scanner;

public class Sherlock {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//N K Q
		//take the lst K elements from the array and stick them on the front
		//(index+ops%ops)
		int elements = input.nextInt();
		int[] A = new int[elements];
		int ops = input.nextInt();
		ops=ops%elements;
		int cases = input.nextInt();
		for (int i = 0; i<elements; i++)
			A[i]=input.nextInt();
		int[] result = new int[elements];
		System.arraycopy(A, elements-ops, result, 0, ops);
		System.arraycopy(A, 0, result, ops, elements-ops);
		for (int i=0; i<cases; i++)
			System.out.println(result[input.nextInt()]);
	}

}
