import java.util.Scanner;

/*
 * Class BookingSystem helps the Admin to inclucde details about screens
 * Helps the user to buy the tickets 
 */
public class BookingSystem {
    static int totalNoOfScreens = 10;
    static int theaterOpen = 0;
    static int activeNoOfScreens;
    static int[] costOfTheTicket = new int[totalNoOfScreens];
    static int[] seats = new int[totalNoOfScreens];
    static int[] seatsBooked = new int[totalNoOfScreens];
    static String[] movies = new String[totalNoOfScreens];

    /**
     * Method getBookedTicketInfo will print the tickets booked in that particular screen
     * And also print the balance tickets in that particular screen
     */ 
    public static void getBookedTicketInfo(int screenNumber) {
	//just printing the number of tickets booked and balance ticket in particular screen by getting screen number from the admin

	System.out.println("In Screen " + screenNumber +" "+ seatsBooked[screenNumber - 1]+ " Tickets Are Booked");
	System.out.println("Balance " + (seats[screenNumber - 1] - seatsBooked[screenNumber - 1]));		
    }
    
    /**
     * Method loginToAdminControl takes the admin to his page 
     * where he can add screens, add seats, add ticket price and updte changes in future
     */  
    public static void loginToAdminControl() {
        Scanner scanner = new Scanner(System.in);
	int logOutFromAdminControl = 1;
	int task;
	
    	// while condition run until admin select logout option
	while (logOutFromAdminControl != 0) {
	    System.out.print("Enter '1' For Adding Screens '2' For Adding Extra Seats"
			         +" '3' For Updateing Movie '4' For Updateing The Price"
				 +" '5' To See How Many Tickets are Booked '6' For LogOut : ");
	    task = scanner.nextInt();
	    
	    switch (task) {
	    /**
	     * In this case getting the detail about the active screen 
	     * like what movie is streaming in that screen how many numbers of seats are there in that screen 
               and what is price for ticket 
             */             
	    case 1:
	        System.out.print("Enter the Number of Screens you need to add :");
		activeNoOfScreens = scanner.nextInt();                                                            //active number of screens 

                // Running a for loop for getting infromation about each screen from the admin
		for (int screenNumber = 0; screenNumber < activeNoOfScreens; screenNumber++) {
		    System.out.print("How Many Seats are there in Screen " + (screenNumber + 1 ) +" : ");
		    seats[screenNumber] = scanner.nextInt();
		    scanner.nextLine();                                                                           //here i am getting the string to avoid skipping
		    System.out.print("What Movie is Streaming in Screen " + (screenNumber + 1) + " : ");
		    movies[screenNumber] = scanner.nextLine();
		    System.out.print("What is The Cost of The Ticket For Screen " + (screenNumber + 1) + " : ");
		    costOfTheTicket[screenNumber] = scanner.nextInt();		    
		}
		theaterOpen = 1; 
		break;
            
            /**
             * This case is updates the number of seats in particular screen 
             * By getting screen number from the admin
             */
	    case 2:
		int screenNumberForUpdate;
		int extraSeats;
		System.out.print("Enter The Screen Number For What You Need To Add Extra Seats : ");
		screenNumberForUpdate = scanner.nextInt();
		System.out.print("Enter The Number Seats You Need To Add : ");
		extraSeats = scanner.nextInt();
		seats[screenNumberForUpdate-1] = seats[screenNumberForUpdate-1] + extraSeats; 
		break;
	    
	    /** 
	     * This case will update the movie in that particular screen
             * By getting the movie name from the admin
             */
	    case 3:
		System.out.print("Enter The Screen Number For What You Need To Update Movie : ");
		screenNumberForUpdate = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter The Movie Name : ");
		movies[screenNumberForUpdate-1] = scanner.nextLine();
		break;
	    
	    /**
             * This case is update the ticket price for particular screen
             * By getting the  from the admin
             */
	    case 4:
		System.out.print("Enter The Screen Number For What You Need To Update The Price : ");
		screenNumberForUpdate = scanner.nextInt();
		System.out.print("Enter the New Price : ");
		costOfTheTicket[screenNumberForUpdate-1] = scanner.nextInt();
		break;
	    /** 
             * This case is shows the number of tickets booked in particular screen
             * By getting the screen number from the admin
	     */	
	    case 5:
		System.out.print("Enter The Screen Number To Know How Many Tickets are Booked in That Screen :");
		getBookedTicketInfo(scanner.nextInt());                                                            //calling the getBookedTicketInfo to get the Booked tickets and balance tickets details
		break;
	    /** 
             * This is case log out the admin 
             */
	    case 6:
		logOutFromAdminControl = 0;
		break;

	    default:
		System.out.println("You Entered Wrong Number ");		 
	    }
        }  		     		
    }  
    
    /** 
     * This method book the tickets and print the screen number to the user
     * By getting the screen selected by the user and number of ticket asked by the user as a parameter 
     * Then updateing the seats booked for that screen
     */
    public static void bookTickets(int screenSelected, int noOfTickets) {
	System.out.println("Your Seat Number are ");
	for (int seatNumber = (seatsBooked[screenSelected - 1] + 1); seatNumber <= (seatsBooked[screenSelected - 1] + noOfTickets); seatNumber++) {
	    System.out.println("Screen " + screenSelected + " S" + seatNumber);
	}
	seatsBooked[screenSelected - 1] = seatsBooked[screenSelected - 1] + noOfTickets;                                                                 // updateting the seats booked for that screen
    }
    
    /** 
     * This method calculate the totatl price amount
     * By getting the price of ticket for the screen selected by the user
     */

    public static int calculateTotalPrice(int screenSelected, int noOfTickets) {
	return costOfTheTicket[screenSelected-1] * noOfTickets;		
    }
    
    public static boolean ticketsAvailabilityCheck (int screenSelected, int noOfTickets) {
	int noOfTicketsAvailable;
	noOfTicketsAvailable = seats[screenSelected - 1] - seatsBooked[screenSelected - 1];
	
	if (noOfTickets <= noOfTicketsAvailable) {
	    return true;
	} else {
	    return false;
	} 
    }

    public static void openUserInterface() {
	Scanner scanner = new Scanner(System.in);
	int screenSelected;
	int noOfTickets;
	int totalCost;
	int conformation;

	for (int screenNumber = 0; screenNumber < activeNoOfScreens; screenNumber++) {
	    System.out.println("Movie Streaming On Screen " + (screenNumber + 1) + " is " 
			          + movies[screenNumber] +" Available Tickets " 
				  + (seats[screenNumber] - seatsBooked[screenNumber]));	
	}
	System.out.print("Select The Screen : ");
	screenSelected = scanner.nextInt();
	System.out.print("How Many Tickets You Want : ");
	noOfTickets = scanner.nextInt();
	
	
	if (0 < screenSelected && screenSelected <= activeNoOfScreens) {
	    if (ticketsAvailabilityCheck(screenSelected, noOfTickets)) {
	        totalCost = calculateTotalPrice(screenSelected,noOfTickets);
	        System.out.print("The Total Cost is " + totalCost +" Enter '1' To Proceed Booking ");
	        conformation = scanner.nextInt(); 
	        if (conformation == 1) {
		    bookTickets(screenSelected,noOfTickets);
	        } else {
		    System.out.println("Thanks For Comming Let's Do This Next Time,!");
	        }
	    } else {
	        System.out.println("You Entered More Number of Tickets Than What I Have");
	    }		
	} else {
	    System.out.println("Please Enter Screen Number only where the Movies are Streamed "); 
	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	int access;
	int appRunning = 1;
	System.out.print("Welcom To The Booking App....");
	
	while(appRunning != 0) {
	    System.out.print("Press '1' For User Access '2' For Admin Access '3' for Quit The App : ");
	    access = scanner.nextInt();
	    switch (access) {
	    case 1:
	        System.out.println("Welcom User...");
		if (theaterOpen == 1) {
		    openUserInterface();
		} else {
		    System.out.println("Sorry !!! Currently No Movies are Streaming In Any Screens");
		}
	        break;
	
	    case 2:
		int adminId;
		int adminPassword;
		System.out.print("Enter your admin Id : ");
		adminId = scanner.nextInt();
		System.out.print("Enter your Password : ");
		adminPassword = scanner.nextInt();
	
		if(adminPassword == 101 && adminId == 101) {
	    	    System.out.println("Welcome Admin.. ");
		    loginToAdminControl();
	    
		} else {
	    	    System.out.println("Access denied ");
		}
		break;

	    case 3:
		System.out.println("Thanks For Comming !!");
		appRunning = 0;
		break;

	    default:
		System.out.println("We have only Three options '1' for User '2' for Admin '3' to quit the app.. Give anything among this options");
		break;
	    }
	}
    }
}
	        