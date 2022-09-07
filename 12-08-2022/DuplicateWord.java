public class DuplicateWord {    
    public static void main(String[] args) {    
        String sentance = "Big black bug bit a big black dog on his big black nose";    
        int count;        
        string = sentance.toLowerCase();    
        String words[] = sentance.split(" ");             
        System.out.println("Duplicate words in a given string : ");
     
        for (int index_i = 0; index_i < words.length; index_i++) {    
            count = 1;    
            for (int  index_j = index_i + 1; index_j < words.length; index_j++) {    
                if (words[index_i].equals(words[index_j])) {    
                    count++;       
                    words[index_j] = "0";    
                }    
            }    
  
            if (count > 1 && words[index_i] != "0") {  
                System.out.println(words[index_i]);   
	    } 
        }    
    }    
}    