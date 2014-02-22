import java.math.BigInteger;
import java.util.Scanner;
public class FloatingRocks{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		int cases = Integer.valueOf(input.nextLine());
		for (int i = 0; i<cases; i++){
			long x1 = input.nextLong();
			long y1 = input.nextLong();
			
			long x2 = input.nextLong();
			long y2 = input.nextLong(); //rise/run and star at the smallest x value
			BigInteger RI = new BigInteger(Long.toString(y2-y1));
			BigInteger RU = new BigInteger(Long.toString(x2-x1));
			BigInteger gcd = RI.gcd(RU);
			RI = RU.divide(gcd);
			RU = RU.divide(gcd);
			long rise =RI.longValue();
			long run = RU.longValue();
			long count = 0;
			long X;
			long Y;
			if(x2==x1)
				System.out.println(0);
			else if (x1<x2){
				X=x1;
				Y=y1;
				while (X<x2){
					X+=run;
					Y+=rise;
					count++;
				}
			}
			else if (x2<x1){
				X=x2;
				Y=y2;
				while(X<x1){
					X+=run;
					Y+=rise;
					count++;
				}
			}
			System.out.println(count-1);
		}
	}

}
