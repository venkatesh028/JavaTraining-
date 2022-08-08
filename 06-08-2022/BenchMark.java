import java.util.Scanner;

public class BenchMark {
    public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("enter the numeber of iterations");
    int numberOfIteration = scanner.nextInt();
    int startingPoint;
    // for For loop
        long startTimeFor = System.nanoTime();
        for(startingPoint=0; startingPoint<numberOfIteration; startingPoint++);

        long elapsedTimeFor = System.nanoTime() - startTimeFor;
        System.out.println(elapsedTimeFor);
    // for While loop
    startingPoint = 0;
    long startTimeWhile = System.nanoTime();
        while(startingPoint<numberOfIteration){
            startingPoint++;
        }

        long elapsedTimeWhile = System.nanoTime() - startTimeWhile;
        System.out.println(elapsedTimeWhile);
    }      
}