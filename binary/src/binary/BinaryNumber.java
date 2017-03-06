/**
 * Harkirat Kang
 * CS 284B
 * Assignment 3
 * I pledge my honor that I have abided by the Stevens honor system
 */


package binary;

public class BinaryNumber {
	private int[] data;
	private boolean overflow;
	
	/**
	 * creates a binary number of length, length, and only has zeros
	 * @param length
	 */
	
	public BinaryNumber(int length){
		data = new int[length];
		for (int i=0; i<length; i++){
			data[i] = 0;
		}
	}
	
	/**
	 * creates a binary number out of a string
	 * @param str
	 */
	
	@SuppressWarnings("null")
	public BinaryNumber(String str){
		if ((str==null)&&(str.length()<1)){
			System.out.println("The string is empty");
			return;
		}
		data = new int[str.length()];
		for (int i = 0; i <str.length(); i++){
			data[i] = Character.getNumericValue(str.charAt(i));
		}
	}
	
	/**
	 * determines the length of a binary number
	 * @return
	 */
	
	
	public int getLength(){
		return data.length;
	}
	
	/**
	 * obtains a digit of the binary number from the given index
	 * @param index
	 * @return
	 */
	
	public int getDigit(int index){
		if (index+1 > data.length){
			System.out.println("index out of bounds");
		}
		return index;
		
	}
	public BinaryNumber add(BinaryNumber aBinaryNumber){
		String newBiNum = "";
		int overflowNum = 0;
		if (data.length != aBinaryNumber.getLength()){
			System.out.println("the two binary numbers are of different lengths");
		}
		
		for(int i=0; i <aBinaryNumber.getLength(); i++){
			if(data[i]+ aBinaryNumber.getDigit(i) + overflowNum == 0){
				newBiNum = newBiNum + "0";

			}
			else if(data[i]+ aBinaryNumber.getDigit(i)+overflowNum == 1){
				newBiNum = newBiNum + "1";
				overflowNum = 0;
			}
			else if(data[i]+ aBinaryNumber.getDigit(i)+overflowNum == 1){
				newBiNum = newBiNum + "0";
				
			}
			else if(data[i] + aBinaryNumber.getDigit(i) + overflowNum == 3){
				newBiNum = newBiNum + "1";
				overflowNum = 1;
			}
		}
		
		if(overflowNum == 1){
    		newBiNum = newBiNum + "1";
    		overflow = true;
    	}
    	return new BinaryNumber(newBiNum);
    }
	
	/**
	 * determines if the binary number is in overflow
	 * @return
	 */
	
    public boolean isInOverflow() {
    	if (overflow == true){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    /**
     * transforms a binary number to its decimal form
     * @return
     */
    
    public int toDecimal() {
            double bidecimal = 0;
            for(int i = 0; i < data.length; i++){
                    bidecimal = bidecimal+(data[i]*Math.pow(2, i));
            }
            return (int) bidecimal;
    }
    
    /**
     * turns a binary number into a string
     */
    
    public String toString() {
    		int bn = 0;
    		String s = String.valueOf(bn);
			return s;
		}
		
  
    
    /**
     * shifts all digits in a binary number to the right by the given amount, replacing each shift with 0
     * @param amount
     * @return
     */
    
    public BinaryNumber shiftR(int amount) {
    	int[] data1 = new int[amount+data.length];
    	for (int i = 0; i < amount; i++) {
    		data1[i] = 0;
    	}
    	for (int i = 0; i <data.length; i++) {
    		data1[amount] = data[i];
    		amount++;
    	}
    	data = data1;
		String s = new String();
		for (int i = 0; i < data.length; i++) {
			s = s.concat(Integer.toString(data[i]));
		}
		return new BinaryNumber(s);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNumber a = new BinaryNumber("11");
    	System.out.println(a.toDecimal());     
    	System.out.println(a.getLength());
    	System.out.println(a.toString());
    	System.out.println(a.shiftR(3));
				
		}
	
	}


