/*
 * Class Slice is get the last five element from the array
 */
public class Slice {
    public static void main(String[] args) {
	char[] name = new char[]{'v','e','n','k','a','t','e','s','h'};
	int startingNumber = name.length - 1;
        int endPoint = name.length - 5;
        for (int start = startingNumber; start >= endPoint; start--) {
		System.out.print(name[start]);
	}
    }
}
	 