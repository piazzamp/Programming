import java.util.*;

public class Library {


 	public static void main(String[] args) {
 		long ST = System.currentTimeMillis();
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int o = 0; o<cases; o++){
			int shelves = input.nextInt();
			int[] shelf = new int[shelves+1];
			for (int p = 1; p<=shelves; p++)
				shelf[p]=input.nextInt();
			//shelf 1 = shelf[1]
			
			int queries = input.nextInt();
			for (int q=0;q<queries; q++){
				//System.out.print("Query "+q+": ");
				if (input.nextInt()==1){ //update
					int x = input.nextInt();
					shelf[x]=input.nextInt();
				}
				else {//query begin end rank
					int begin = input.nextInt();
					int end= input.nextInt();
					int rank = input.nextInt();
					if (end==begin)
						System.out.println(shelf[begin]);
					else {
						int[] current = new int[end-begin+1];
						System.arraycopy(shelf, begin, current, 0, end-begin+1);
						Arrays.sort(current);
						System.out.println(current[rank-1]);
					}
				}
			}
		}
		long ET = System.currentTimeMillis();
		System.out.println("WHEW, that took "+(ET-ST)+" milliseconds");
	}
}

/*
test cases
# of shelves, n
n numbers indicating the # of books per shelf
# of queries, q
q lines of either updates (1 x k) or queries (0 x y k)
*/
