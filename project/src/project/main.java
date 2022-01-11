package project;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import side.GuestDao;
import side.GuestDaoDerived;
import side.Guests;

public class main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws ParseException{
		GuestDao asDao = new GuestDaoDerived();
		do {
			System.out.println("Welcome To Terrace Gardens...");
			System.out.println("Select the Options from below :");
			System.out.println(" 1.	Register – registers a customer \n 2.	Book – Book a room \n 3.	Check Status – check for the rooms present status (Vacant / Booked) \n 4.	Email – Change/ update an email address of the customer \n 5.	All Bookings – Display all the bookings for a specific time period mentioned \n 6.	All customers – Display all the registered customer details \n 7.	Quit – Exit the program");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				Guests guests = inputMet();
				int result = asDao.addGuests(guests);
				if (result > 0) {
					System.out.println("Associates Details Added Successfully....");
				} else {
					System.out.println("Try to Add Again....");
				}
				break;
			case 2:
				int Price = asDao.booking();
				System.out.println("Booking confirmed... \n Check out Price is" + Price);
				break;
			case 3:
				int i=0;
				List<Guests> cList = asDao.getAllGuests();
				for(Guests people :cList) {
					i++;
				}
				int room=9-i;
				if(room>0)
					System.out.println("Number of vacant room are: "+room);
				else
					System.out.println("No vacant room is available");
				break;
			case 4:
				Guests guest = update();
				int result1 = asDao.updateEmail(guest);
				if (result1 > 0) {
					System.out.println("Customer Details Added Successfully....");
				} else {
					System.out.println("Try to Add Again....");
				}
				break;
			case 5:
				List<Guests> cuList = asDao.getAllBookings();
				for(Guests r :cuList) {
					System.out.println(r);
				}
				break;
			case 6:
				List<Guests> gussList = asDao.getAllGuests();
				for(Guests Guest :gussList) {
					System.out.println(Guest);
				}

				break;
			default:
				break;
			}
			System.out.println("Do you want to Continue  1. Yes \t 2. No");
		} while (scanner.nextInt() == 1);
	}
	static Guests inputMet() throws ParseException {
		System.out.println("Enter Guests Details :");
		System.out.println("Name : ");
		String name = scanner.next();
		System.out.print("Age :");
		int age = scanner.nextInt();
		System.out.println("Email : ");
		String email = scanner.next();
		System.out.println("Mobile : ");
		long mobile = scanner.nextLong();
		System.out.println("Check In Date (dd/MM/yyyy): ");
		String In = scanner.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date CheckIn_Date = sdf.parse(In);
		System.out.println("Check Out Date (dd/MM/yyyy): ");
		String Out = scanner.next();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date CheckOut_Date = sdf2.parse(Out);
		Guests guests = new Guests(name, age, email, mobile, CheckIn_Date, CheckOut_Date);
		return guests;
	}
	static Guests update() {
		System.out.println("Enter the Mobile Number:");
		Long mobile= scanner.nextLong();
		System.out.println("Enter the new email:");
		String email= scanner.next();
		Guests guest= new Guests(mobile, email);
		return guest;
	}
}
