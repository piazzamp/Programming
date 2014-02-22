import java.util.*;


public class CuttingBoard {

	public static void main(String[] args) {
		// print answer % 1000000007
		Scanner input = new Scanner(System.in);
		int tests = Integer.valueOf(input.nextLine());
		for (int t = 0; t<tests; t++){
			long totalCost = 0;
			int m = input.nextInt()-1;
			int n = input.nextInt()-1;
			//segment counts:
			int horizontals = 1;
			int verticals = 1;

			long[] y = new long[m];
			long[] x = new long[n];
			for (int i = 0; i<m; i++)
				y[i]=input.nextLong();
			for (int i = 0; i<n; i++)
				x[i]=input.nextLong();
			long[] costs = new long[m+n];
			System.arraycopy(x, 0, costs, 0, x.length);
			System.arraycopy(y, 0, costs, x.length, y.length);

			Arrays.sort(costs);
			Arrays.sort(x);
			Arrays.sort(y);
			//x are vertical cuts, producing horizontal segments, consuming vertical segments
			int xindex = x.length;
			int yindex = y.length;
			
			for (int index=m+n-1; index>=0; index--){

				long cost = costs[index]; //cost = highest cost
				
			
				//if it's in both choose the one with the smaller no. of segments
				//System.out.println("index: "+index+"  cost: "+cost+"\n binsearch x(0,"+xindex+"): "+Arrays.binarySearch(x, 0, xindex, cost)+"\nbinsearch y(0,"+yindex+"): "+Arrays.binarySearch(y, 0, yindex, cost));
				//System.out.print(cost+" * ");
				if (Arrays.binarySearch(x, 0, xindex, cost)>=0 && Arrays.binarySearch(y, 0, yindex, cost)>=0){
					if (verticals>=horizontals){
						//use horizontal cut (y)
						//System.out.print(horizontals+"\t\t1\n");
						totalCost+=horizontals*cost;
						verticals++;
						yindex--;
					}
					else {
						//System.out.print(verticals+"\t\t2\n");
						totalCost+=verticals*cost;
						horizontals++;
						xindex--;
					}
				}

				else if (Arrays.binarySearch(y, 0, yindex, cost)>=0 && Arrays.binarySearch(x, 0, xindex, cost)<0){
					//System.out.print(horizontals+"\t\t3\n");
					totalCost += horizontals*cost;
					verticals+=1;
					yindex--;
				}
				else if (Arrays.binarySearch(x, 0, xindex, cost)>=0 && Arrays.binarySearch(y, 0, yindex, cost)<0){
					//System.out.print(verticals+"\t\t4\n");
					totalCost += verticals*cost;
					horizontals+=1;
					xindex--;
				}
			}
			System.out.println(totalCost%1000000007);
		}
	}
}
