import java.math.BigInteger;
import java.util.Scanner;

public class CubeSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//first int define number of test cases: length of loop
		//each test case starts with n (size of 3d array) and m (number of operations ie length of inner loop)
		int cases = Integer.valueOf(input.nextLine());
		//int cases = input.nextInt();
		for (int i =0; i<cases; i++){
			int size = input.nextInt()+1; //add one slot for array totals
			int commands = input.nextInt(); //number of commands to expect
			int[][][] matrix = new int[size][size][size]; //default int is 0
			for (int l = 0; l<commands; l++){
				String command = input.next();
				if (command.startsWith("U")){ //UPDATE
					int x = input.nextInt();
					int y = input.nextInt();
					int z = input.nextInt();
					int value = input.nextInt();
					//System.out.println("x: "+x+"  y: "+y+"  z: "+z+"  value: "+value);
					matrix[x][y][z]=value; //update value
					matrix[0][0][0] += 1; //total of all elements in the cube would be too big
					matrix[x][0][0] += 1; //increment total of row x 
					matrix [x][y][0] += 1; //increment total of column y
				}
				else if (command.startsWith("Q")){
					//query: add all blocks between x1 y1 z1 and x2 y2 z2
					int x1 = input.nextInt();
					int y1 = input.nextInt();
					int z1 = input.nextInt();

					int x2 = input.nextInt();
					int y2 = input.nextInt();
					int z2 = input.nextInt();

					long total = 0;
					//update 1 1 1 is matrix[1][1][1]
					if (matrix[0][0][0]>0)
						for (int p = x1; p<=x2; p++){
							if(matrix[p][0][0]>0)
								for (int q = y1; q<=y2; q++){  
									if(matrix[p][q][0]>0)
										for (int s = z1; s<=z2; s++){
											total += matrix[p][q][s];
										}
								}
						}
					System.out.println(total);
				}
			}

		}

	}

}

/*
50
83 545
UPDATE 44 37 21 994699866
QUERY 6 58 45 58 79 61
QUERY 1 1 1 83 83 83
UPDATE 32 25 19 270680576
QUERY 25 14 21 38 47 82
QUERY 1 1 1 83 83 83
QUERY 1 1 1 83 83 83
UPDATE 42 1 83 809346301
UPDATE 18 33 55 656479720
UPDATE 36 24 74 807138358
UPDATE 42 3 44 316887770
QUERY 1 1 1 83 83 83
UPDATE 25 17 10 760936459
QUERY 1 1 1 83 83 83
QUERY 1 1 1 83 83 83
QUERY 1 1 1 83 83 83
UPDATE 40 57 35 441548258
QUERY 1 1 1 83 83 83
 */