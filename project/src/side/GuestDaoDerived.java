package side;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Connect.connect;

public class GuestDaoDerived implements GuestDao {
	Connection connection;
	static int price;
	public GuestDaoDerived() {
		this.connection = connect.createConnection();
	}

	@Override
	public int addGuests(Guests guests) {
		int result = 0;
		try{
			PreparedStatement ps = connection.prepareStatement("insert into guests values(?,?,?,?,?,?)");
			ps.setString(1, guests.getName());
			ps.setInt(2, guests.getAge());
			ps.setString(3, guests.getEmail());
			ps.setLong(4, guests.getMobile());
			java.sql.Date jd = new java.sql.Date(guests.getInDate().getTime());
			ps.setDate(5, jd);
			java.sql.Date ld = new java.sql.Date(guests.getOutDate().getTime());
			ps.setDate(6, ld);
			result = ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Error in addGuest: " + e);
		}
		return result;
	}

	@Override
	public int booking() {
		System.out.println("Choose a type of room: \n 1. AC Rooms \n 2. Non-AC Rooms");
		Scanner sc =new Scanner(System.in);
		int a=sc.nextInt();
		switch(a) {
		case 1:
			price=1000;
			System.out.println("Avail Laundry service by paying extra 250 Rs. \n press 1 for extra service and 0 to continue without services.");
			int b=sc.nextInt();
			switch(b) {
			case 1:
				System.out.println("Laundry service will be provided to you.");
				price=price+250;
				break;
			}
			break;
		case 2:
			price=700;
			System.out.println("Avail Laundry service by paying extra 250 Rs. \n press 1 for extra service and 0 to continue without services.");
			int c=sc.nextInt();
			switch(c) {
			case 1:
				System.out.println("Laundry service will be provided to you.");
				price=price+250;
				break;
			}
			break;
		}
		return price;
	}

	@Override
	public int updateEmail(Guests guest) {
		int result = 0;
		try {
			String qry = "update associates set email=? where mobile=?";
			PreparedStatement ps = connection.prepareStatement(qry);
			ps.setString(1, guest.getEmail());
			ps.setLong(2, guest.getMobile());
		} catch (Exception e) {
			System.out.println("Error in Update Associates...: " + e);
		}
		return result;
	}

	@Override
	public List<Guests> getAllGuests() {
		List<Guests> aList = new ArrayList<>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from guests");
			while (rs.next()) {
				Guests guests = new Guests();
				guests.setName(rs.getString(1));
				guests.setAge(rs.getInt(2));				
				guests.setEmail(rs.getString(3));
				guests.setMobile(rs.getLong(4));
				guests.setInDate(rs.getDate(5));
				guests.setOutDate(rs.getDate(6));
				aList.add(guests);
			}
		} catch (Exception e) {
			System.out.println("Error in Get All : " + e);
		}
		return aList;
	}

	@Override
	public List<Guests> getAllBookings() {
		
		List<Guests> cList = new ArrayList<>();
		String date1;
		String date2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first date:");
		date1 = sc.nextLine();
		System.out.println("Enter the second date:");
		date2 = sc.nextLine();
		Guests customer = new Guests();
		try {
			PreparedStatement pst = connection.prepareStatement("select * from customer where Check_in_Date between ? and ?;");
			java.sql.Date jd = new java.sql.Date(customer.getInDate().getTime());
			pst.setDate(1, jd);
			java.sql.Date jd1 = new java.sql.Date(customer.getInDate().getTime());
			pst.setDate(2, jd1);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				customer.setName(rs.getString(1));
				customer.setAge(rs.getInt(2));
				customer.setEmail(rs.getString(3));
				customer.setMobile(rs.getLong(4));
				customer.setInDate(rs.getDate(5));
				customer.setOutDate(rs.getDate(6));
				cList.add(customer);
			}
		} catch (Exception e) {
			System.out.println("Error in Get By Date : " + e);
		}
		return cList;
	}
}
