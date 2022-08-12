import java.util.Scanner;

/**
 * Class BookingSystem helps the Admin to inclucde details about screens
 * Helps the user to buy the tickets 
 */
public class BookingSystem {
    static Scanner scanner = new Scanner(System.in);
    static int totalNoOfScreen = 10;
    static int isOpen = 0;
    static int activeScreen;
    static int[] cost = new int[totalNoOfScreen];
    static int[] seats = new int[totalNoOfScreen];
    static int[] seatsBooked = new int[totalNoOfScreen];
    static String[] movies = new String[totalNoOfScreen];

    /**
     * Print the tickets booked in that particular screen
     * And also print the balance tickets in that particular screen
     */ 
    public static void getAndDisplay(int screenNumber) {
	System.out.println("In Screen " + screenNumber + " "
			        + seatsBooked[screenNumber - 1] 
				+ " Tickets Are Booked");
	System.out.println("Balance " 
				+ ((seats[screenNumber - 1]) - (seatsBooked[screenNumber - 1])));
    }
    
    /**
     * Takes the admin to his page 
     * where he can ADD SCREENS, add seats, add ticket price 
     * and updte changes in future
     */  
    public static void login() {
	int isLogout = 1;
	int screenForUpdate;
	int action;
	final int ADD = 1;
	final int ADD_EXTRA_SEAT = 2;
	final int UPDATEMOVIE = 3;
	final int UPDATEPRICE = 4;
	final int TICKETSINFO = 5;
	final int LOGOUT = 6;

    	/* while condition run until admin select LOGOUT option */
	while (isLogout != 0) {
	    System.out.print("Enter '1' For Adding Screens '2' For Adding Extra Seats"
			         + " '3' For Updateing Movie '4' For Updateing The Price"
				 + " '5' To See How Many Tickets are Booked '6' For Logout : ");
	    action = scanner.nextInt();
	    switch (action) {
	    case ADD:
	        System.out.print("Enter the Number of Screens you need to add :");
		activeScreen = scanner.nextInt();                                                           

                // Running a for loop for getting infromation about each screen from the admin
		for (int screenNumber = 0; screenNumber < activeScreen; screenNumber++) {
		    System.out.print("How Many Seats are there in Screen "
				          + (screenNumber + 1 ) +" : ");
		    seats[screenNumber] = scanner.nextInt();
		    scanner.nextLine();                                                                           
		    System.out.print("What Movie is Streaming in Screen "
				          + (screenNumber + 1) + " : ");
		    movies[screenNumber] = scanner.nextLine();
		    System.out.print("What is The Cost of The Ticket For Screen "
			                  + (screenNumber + 1) + " : ");
		    cost[screenNumber] = scanner.nextInt();		    
		}
		isOpen = 1; 
		break;

	    case ADD_EXTRA_SEAT:
		int extraSeats;
		System.out.print("Enter Screen Number For What You Need To Add Extra Seats : ");
		screenForUpdate = scanner.nextInt();
		System.out.print("Enter The Number Seats You Need To Add : ");
		extraSeats = scanner.nextInt();
		seats[screenForUpdate-1] = seats[screenForUpdate-1] + extraSeats; 
		break;
	    
	    case UPDATEMOVIE:
		System.out.print("Enter The Screen Number For What You Need To UPDATE MOVIE : ");
		screenForUpdate = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter The Movie Name : ");
		movies[screenForUpdate-1] = scanner.nextLine();
		break;

	    case UPDATEPRICE:
		System.out.print("Enter Screen Number To Update Price : ");
		screenForUpdate = scanner.nextInt();
		System.out.print("Enter the New Price : ");
		cost[screenForUpdate-1] = scanner.nextInt();		
		break;
	
	    case TICKETSINFO:
		System.out.print("Enter Screen Number To get number Tickets are Booked :");
		getAndDisplay(scanner.nextInt());                                                            
		break;

	    case LOGOUT:
		isLogout = 0;
		break;

	    default:
		System.out.println("You Entered Wrong Number ");		 
	    }
        }  		     		
    } 
    
    /** 
     * Book the tickets and print the screen number to the user
     * By getting the screen selected by the user 
     * And number of ticket asked by the user as a parameter 
     * Then updateing the seats booked for that screen
     */
    public static void bookTickets(int selected, int count) {
	System.out.println("Your Seat Number are ");
	int notBooked = seatsBooked[selected - 1] + 1;
	for (int seatNumber = notBooked ; seatNumber <= (notBooked + count); 
	         seatNumber++) {
	    System.out.println("Screen " + selected + " S" + seatNumber);
	}
	seatsBooked[selected - 1] = seatsBooked[selected - 1] + count;                                                                
    }
    
    /** 
     * Calculate the totatl price amount
     * By getting the price of ticket for the screen selected by the user
     */
    public static int calculateTotalPrice(int selected, int count) {
	return cost[selected-1] * count;		
    }
    
    /** Return true or false based on availability */
    public static boolean ticketsAvailabilityCheck (int selected, int count) {
	int countAvailable;
	countAvailable = seats[selected - 1] - seatsBooked[selected - 1];
	
	if (count <= countAvailable) {
	    return true;
	} else {
	    return false;
	} 
    }
    
    /* open the user dashboard */
    public static void userDashboard() {
	int selected;
	int count;
	int totalCost;
	String conformation;

	for (int screenNumber = 0; screenNumber < activeScreen; screenNumber++) {
	    System.out.println("Movie Streaming On Screen " + (screenNumber + 1) + 
                                 " is " + movies[screenNumber] + " Available Tickets " 
				  + (seats[screenNumber]) - (seatsBooked[screenNumber]));	
	}
	System.out.print("Select The Screen : ");
	selected = scanner.nextInt();
	System.out.print("How Many Tickets You Want : ");
	count = scanner.nextInt();	
	
	if ((0 < selected) && (selected <= activeScreen)) {
	    if (ticketsAvailabilityCheck(selected, count)) {
	        totalCost = calculateTotalPrice(selected,count);
		scanner.nextLine();
	        System.out.print("The Total Cost is " + totalCost + " Conform by 'yes' : ");
	        conformation = scanner.nextLine(); 
	        if (conformation.equalsIgnoreCase("yes")) {
		    bookTickets(selected,count);
	        } else {
		    System.out.println("Thanks For Comming Let's Do This Next Time,!");
	        }
	    } else {
	        System.out.println("Entered More Number of Tickets Than What I Have");
	    }		
	} else {
	    System.out.println("Please Enter Screen only where the Movies are Streamed "); 
	}
    }

    public static void main(String[] args) {
	int dashboard;
	int appRunning = 1;
	final int USER = 1;
	final int ADMIN = 2;
	final int QUIT = 3;
	System.out.print("Welcom To The Booking App....");
	
	while(appRunning != 0) {
	    System.out.print("Press '1' For User Access '2' For Admin Access "
			        + "'3' to Quit The App : ");
	    dashboard = scanner.nextInt();
	    
	    switch (dashboard) {
	    case USER:
	        System.out.println("Welcom User...");
		if (isOpen == 1) {
		    userDashboard();
		} else {
		    System.out.println("Sorry !!! No Movies are Streaming In Any Screens");
		}
	        break;
	
	    case ADMIN:
		int adminId;
		int adminPassword;
		System.out.print("Enter your admin Id : ");
		adminId = scanner.nextInt();
		System.out.print("Enter your Password : ");
		adminPassword = scanner.nextInt();
	
		if ((adminPassword == 101) && (adminId == 101)) {
	    	    System.out.println("Welcome Admin.. ");
		    login();	    
		} else {
	    	    System.out.println("Access denied ");
		}
		break;

	    case QUIT:
		System.out.println("Thanks For Comming !!");
		appRunning = 0;
		break;

	    default:
		System.out.println("We have only have selected options");
		break;
	    }
	}
    }
}
	        