import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] ray = new int[length];
        //fill the array and determine the total all in one loop!
        int total = 0;
        for (int i =0; i<length; i++){
            ray[i]=input.nextInt();
            total+= ray[i];
        }
        
        //mean
        double mean = total / (1.0*length);
        
        //median
        Arrays.sort(ray);
        double median;
        if (length%2==0)//then there are an even num of elements
        	median= (ray[length/2]+ray[(length/2)-1])/2.0;
        else //odd no. of elements
        	median = ray[length/2];
        
        //mode, keys are entries, values are counts
        TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
        for (int i : ray){
            if (count.containsKey(i))
                count.put(i,(count.get(i).intValue()+1));
            else
                count.put(i,1);
        }
        int maxcount = -5;
        int mode = -1;
        for (int i = 0; i<length; i++){
            if (count.get(ray[i])>maxcount){
                maxcount=count.get(ray[i]);
                mode=ray[i];
            }
        }
        
        //standard deviation
        double sTotal = 0;
        for (int i =0; i<length; i++){
            sTotal=sTotal + (ray[i]-mean)*(ray[i]-mean);
        }
        double SD = Math.sqrt(sTotal/length);
        
        //.95 confidence interval
        double var = 1.96*SD/Math.sqrt(length); //1.96 = Z score @ .95
        double lBound = mean-var;
        double uBound = mean+var;
        
        //output it
        System.out.println();
        System.out.println((double)Math.round(mean*10)/10);
        System.out.println((double)Math.round(median*10)/10);
        System.out.println(mode);
        System.out.println((double)Math.round(SD*10)/10);
        System.out.println((double)Math.round(lBound*10)/10 + " " + (double)Math.round(uBound*10)/10);
    }
}