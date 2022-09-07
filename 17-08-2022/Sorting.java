public class Sorting {    
    public static void main(String[] args) {            
        int [] array = new int [] {5, 2, 8, 7, 1};     
        int temporary = 0;    
  
        System.out.println("Elements of original array: ");    
        for (int index = 0; index < array.length; index++) {     
            System.out.print(array[index] + " ");    
        }    
            
        //Sort the array in descending order    
        for (int index = 0; index < array.length; index++) {     
            for (int index_j = (index + 1); index_j < array.length; index_j++) {     
               if(array[index] < array[index_j]) {    
                   temporary = array[index];    
                   array[index] = array[index_j];    
                   array[index_j] = temporary;    
               }     
            }     
        }    
            
        System.out.println();   

        System.out.println("Elements of array sorted in descending order: ");    
        for (int index = 0; index < array.length; index++) {     
            System.out.print(array[index] + " ");    
        }    
    }    
}  