//Day 4 – I have a string "I am learning Java". Reverse
//the string without using any system provided functions.
public class StrReverse{
	public static void main(String[] args){
		
		String inputStr = "I am learning Java";
       	        String reversed = "";
		
		System.out.println("Input String: "+inputStr);
		for(int i = inputStr.length()-1 ; i>=0; i--){
				reversed = reversed + inputStr.charAt(i);
		}
		System.out.println("Reverse String : "+ reversed);
		
		//Another way for String Reverse 
		System.out.println("Another way: ");
       	        char[] tochar = inputStr.toCharArray();
		System.out.println("Input String : "+inputStr);
		System.out.print("Reverse String : ");
          for(int i = inputStr.length()-1;i>=0;i--){
            System.out.print(tochar[i]);
		}
		
		 
		
		
	}
}
