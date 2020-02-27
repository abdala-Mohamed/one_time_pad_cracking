package code_forces;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Map;
public class one_time_pad {
	public static void main(String args[]) throws IOException {
		String A = "1010111011011110000000100111001111000100110000001101101000110100011101111111100100011001000000011000101000000101110110100111000110100010010100110000111101011010000000000010000011100100111000001010110010101000000011111111001011011110";
		String B = "1010100011001000000001000010011011000010110111101100000101101101001100011111100100001101000101001001011100010010100101000111010110100100010101000100011101010110000111010111010011101110111100011011100010111111000011111111110011011100";
		String C = "1010100111010011000001000010011011010011110001111100101100100000001011101011100000000101000011101001011100010111110001110011010010100101010010000100101000010011000100100110110011100000111111011010101110100010000100101111101111011111";
		String D = "1011010010011011000101100110111111011010110001011000111000101010001001011111100100001010000101011001100100010100110100010011010010111000010011100000111101010101000101100111011110100111111111111011011010100101000100101111101111000001";
		String E = "1011010010011011000100100110111011010111110001011100001001101101001000001110101000000111000101001001110101000000110001110111000110110010010101010101110101010110010100110111001111101000111101001010110110111100000001111110000111010111";
		String F = "1011001111011110000101110110001111000100100010011101110000101000001000101110101100001011010000001001011100001110110100010011010010100101010010010100001001010110010100110111000011100110111101101111100110100000000000111110101011000001";
		String space = "0010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000";
		System.out.println("cipher A");
		xoring(A,B,space);
		xoring(A,C,space);
		xoring(A,D,space);
		xoring(A,E,space);
		xoring(A,F,space);
		
		System.out.println("cipher B");
		xoring(A,B,space);
		xoring(B,C,space);
		xoring(B,D,space);
		xoring(B,E,space);
		xoring(B,F,space);
		
		System.out.println("cipher C");
		xoring(A,C,space);
		xoring(B,C,space);
		xoring(C,D,space);
		xoring(C,E,space);
		xoring(C,F,space);
		
		System.out.println("cipher D");
		xoring(A,D,space);
		xoring(B,D,space);
		xoring(C,D,space);
		xoring(D,E,space);
		xoring(D,F,space);
		
		System.out.println("cipher E");
		xoring(A,E,space);
		xoring(B,E,space);
		xoring(C,E,space);
		xoring(D,E,space);
		xoring(E,F,space);
		
		System.out.println("cipher F");
		xoring(A,F,space);
		xoring(B,F,space);
		xoring(C,F,space);
		xoring(D,F,space);
		xoring(E,F,space);
		
		
		
		
		
	}
	
	private static void xoring(String A,String B,String space) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
	        sb.append(charOf(bitOf(A.charAt(i)) ^ bitOf(B.charAt(i))
	                ^ bitOf(space.charAt(i))));
	    }
		String result = sb.toString();
		convert(result);
		//char bits[] = result.toCharArray();
		/*for (int i=1;i<=result.length();i++) {
			//System.out.print(bits[i-1]);
			if(i%8==0) {
				//System.out.print(" ");
			}
		}*/
	}
	private static void convert(String letters) {
		String s = "";
		 for(int index = 0; index < letters.length(); index+=8) {
		     String temp = letters.substring(index, index+8);
		     int num = Integer.parseInt(temp,2);
		     char letter = '*';
		     if((num>=97 && num<=122)||num==32 ) {
		    	 letter = (char) num; 
		     }
		     s = s+letter;
		 }
		     System.out.println(s);
	}
	
	
	private static boolean bitOf(char in) {
	    return (in == '1');
	}

	private static char charOf(boolean in) {
	    return (in) ? '1' : '0';
	}
}
