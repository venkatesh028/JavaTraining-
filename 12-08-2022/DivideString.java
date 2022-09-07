public class DivideString {  
    public static void main(String[] args) {  
	String str = "aaacbbbbcccc";  
        int wordLength = str.length();  
        int number = 3;  
        int temporary = 0;
	int character = wordLength/number;   
        String[] word = new String [number];    
        if(wordLength % number != 0) {  
            System.out.println("Sorry this string cannot be divided into "+ number +" equal parts.");  
        } else { 
	    for(int index = 0; index < wordLength; index = index+character) {  
            String part = str.substring(index, index+character);  
            word[temporary] = part;  
            temporary++;  
            }  
    	    System.out.println(number + " equal parts of given string are ");  
            for(int index = 0; index < word.length; index++) {  
                System.out.println(word[index]);  
            }  
	}  
    }  
}  