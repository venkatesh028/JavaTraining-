/*
 *Class Armstrong is used to find out the given number is armstrong or not 
 */
public class Armstrong {
    public static void main(String[] args) {
        int number = 371;
	int originalNumber;
	int remainder;
	int result = 0;
        originalNumber = number;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }

        if(result == number)
            System.out.println(number + " is an Armstrong number.");
        else
            System.out.println(number + " is not an Armstrong number.");
    }
}
