public class LibraryTest {
	public static void main(String[] args) {
		int TEST_CASES = 2;
		System.out.println(TEST_CASES);
		for (int i =0; i<TEST_CASES; i++){
			int shelves = 3;//(int)Math.random()*10000;
			System.out.println(shelves);
			for (int s=0; s<shelves; s++){
				System.out.print((int)((Math.random()*1000)+1)+" ");
			}
			int queries = 3;
			System.out.println(queries);
			for (int q=0;q<queries; q++){
				if(q%2==0)//update
					System.out.println("1 "+(int)(Math.random()*shelves)+" "+(int)(Math.random()*10000)+1);
				else {//query{
					int x=(int)(Math.random()*shelves)+1;
					int y=(int)(Math.random()*shelves)+1;
					if (y<x){
						int temp=x;
						x=y;
						y=temp;
					}//x is always less than y
					System.out.println("0 "+x+" "+y+" "+(int)(Math.random()*(y-x+1))+1);
				}
			}
		}
	}
}