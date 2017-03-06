package loops;

public class loop {
	public loop printEorO(int[] x, int[] y ){
		//method prints E if the remainder is 0, O otherwise
		
		for (int i= 1; 1 <= 15; i++){
			System.out.print(" " + i + " ");
		
		for (int j = 1; j <= 15; j++) {
			System.out.print("" + j + "");
		}
		int k = 1;
		while (k <= 15){
			if (k % 1 == 0){
				System.out.print("E");
			}
			else {
				System.out.print("O");
			}
		}
	}
	}
}
