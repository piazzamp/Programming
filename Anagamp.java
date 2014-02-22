import java.util.Scanner;

public class Anagamp {

	public static void main(String[] args) {
		// Find No. of overlapping chars, output: length+length-overlap
		Scanner input = new Scanner(System.in);
		String one = input.next();
		String two = input.next();
		if(one.equals(two))
			System.out.println("0");
		else{
			long count = 0;
			for (char at='a'; at<='z'; at++){ //if they both have it then don't delete any otherwise see how many to delete
					//if they both don't have it do nothing
				if ((one.indexOf(at)==-1 && two.indexOf(at)==-1));
						//if they both have it delete the difference
				else if (one.indexOf(at)!=-1 && two.indexOf(at)!=-1){
					long twocount = countof(two, at);
					long onecount = countof(one, at);
					count+= (twocount>onecount)?twocount-onecount :onecount-twocount;
				}
						//if two has it and one doesn't, delete all from two
				else if (one.indexOf(at)==-1 && two.indexOf(at)!=-1)
					count+=countof(two, at);
				//if one has it and two doesn't, delete all from one
				else if (one.indexOf(at)!=-1 && two.indexOf(at)==-1) //two lacks it and one has it; delete from one
					count+=countof(one,at);
			}
					
			System.out.println(count);
		}
		
	}
	public static long countof (String str, char ch){
		long result=0;
		//charAt
		for (int i = 0; i<str.length(); i++)
			if (str.charAt(i)==ch)
				result++;
		return result;
	}

}
