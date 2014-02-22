import java.util.HashMap;
import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = Integer.valueOf(input.nextLine());
		HashMap<String, String> map = new HashMap<String, String>();
			map.put("a", "2");
			map.put("b", "22");
			map.put("c", "222");
			map.put("d", "3");
			map.put("e", "33");
			map.put("f", "333");
			map.put("g", "4");
			map.put("h", "44");
			map.put("i", "444");
			map.put("j", "5");
			map.put("k", "55");
			map.put("l", "555");
			map.put("m", "6");
			map.put("n", "66");
			map.put("o", "666");
			map.put("p", "7");
			map.put("q", "77");
			map.put("r", "777");
			map.put("s", "7777");
			map.put("t", "8");
			map.put("u", "88");
			map.put("v", "888");
			map.put("w", "9");
			map.put("x", "99");
			map.put("y", "999");
			map.put("z", "9999");
			map.put(" ", "0");
		for (int i = 1; i<=cases; i++){
			String result = ""; //result will be a string of digits
			String message = input.nextLine();
			for (int x = 0; x<message.length(); x++){
				if (result.isEmpty() || (!result.isEmpty() && result.charAt(result.length()-1) != map.get(Character.toString(message.charAt(x))).charAt(0))){ 
					result = result+ map.get(Character.toString(message.charAt(x)));
				}
				else if (!result.isEmpty() && result.charAt(result.length()-1) == map.get(Character.toString(message.charAt(x))).charAt(0)){
					result = result + " " + map.get(Character.toString(message.charAt(x)));
				}

			}
			System.out.println("Case #"+i+": "+result);
			
		}
	}

}
