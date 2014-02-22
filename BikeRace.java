import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BikeRace {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int bikers = input.nextInt(); //number of bikers (coordinate pairs)
		int bikes = input.nextInt();
		int spots = input.nextInt();
		int[] bikerX = new int[bikers];
		int[] bikerY = new int[bikers];
		int[] bikeX = new int[bikes];
		int[] bikeY = new int[bikers];
		for (int i = 0; i<bikers; i++){
			bikerX[i]=input.nextInt();
			bikerY[i] = input.nextInt();
		}
		for (int i = 0; i<bikes; i++){
			bikeX[i]=input.nextInt();
			bikeY[i]=input.nextInt();
		}
		long[][] bikerider = new long[bikes][2]; //[bikeIndex][score, riderIndex]
		for (int u=0; u<bikes; u++){
			bikerider[u][1]=-1;
			bikerider[u][0]=Long.MAX_VALUE;
		}
		long[][] bikeArrays=new long[bikers][bikes];
		for (int y=0;y<bikers;y++){//find the closest bike for each biker 
			bikeArrays[y]=findClosestBikes(bikerider, y, bikerX, bikerY, bikeX, bikeY);
		}
		long[] costs = new long[bikes];
		ArrayList<Integer> usedIndex=new ArrayList<Integer>(); //bikes that have been taken already
		int mindex=0;
		//find the closest person to each bike
		for (int i=0; i<bikes;i++){
			long min = Long.MAX_VALUE;
			for (int p=0;p<bikers;p++){
				if (!usedIndex.contains(p) && bikeArrays[p][i]<min){
					min=bikeArrays[p][i];
					mindex=p;//best person for the bike
				}
			}
			usedIndex.add(mindex);
			costs[i]=min;
			//System.out.print("\nmindex:"+mindex+"\nmin:"+min);

		}
		Arrays.sort(costs);
		System.out.println(costs[spots-1]*costs[spots-1]);
			

	}
	
	public static long[] findClosestBikes(long[][] takenBikes, int bikerIndex, int[] bikerx, int[] bikery, int[] bikex, int[] bikey){
		long[] times = new long[bikex.length];
		for (int ike=0;ike<bikex.length;ike++)
			times[ike]=distanceToBike(bikerx[bikerIndex], bikery[bikerIndex], bikex[ike], bikey[ike]);
		return times;
		//times is an array of the times it takes the biker to reach each bike
	}
	
	public static long distanceToBike(int bikerx, int bikery, int bikex, int bikey){
		int dx=(bikerx>bikex)?bikerx-bikex:bikex-bikerx;
		int dy=(bikery>bikey)?bikery-bikey:bikey-bikery;
		return (long)Math.sqrt(dx*dx+dy*dy);
	}

}
