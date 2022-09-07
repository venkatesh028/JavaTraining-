public class BinarySearch {
    int binarySearch(int numbers[], int low, int high, int find) {
        while (low <= high) {
          int mid = low + (high - low) / 2;

          if (numbers[mid] == find) {
              return mid;
          }

          if (numbers[mid] < find) {
            low = mid + 1;
          } else {
              high = mid - 1;
          }
        }

        return -1;
    }
	
    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
	int numbers[] = {2,3,4,10,40};
	int numberLength = numbers.length;
	int find = 10;
	int result = obj.binarySearch(numbers, 0, numberLength-1, find);

	if (result == -1) {
	    System.out.println("Element not present");
	} else {
	    System.out.println("Element found at index " + result);
        }
    }
}