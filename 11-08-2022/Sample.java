class DisplayOverloading {
    public void disp(char character) {
        System.out.println(character);
    }

    public void disp(int number) {
       System.out.println(c );
    }
}

public class Sample {
    public static void main(String args[]) {
        DisplayOverloading obj = new DisplayOverloading();
        obj.disp('a');
        obj.disp(5);
    }
}