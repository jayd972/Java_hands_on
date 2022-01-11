package side;

import java.util.List;

public interface GuestDao {
	public int addGuests(Guests guests);
	public int booking();
	public int updateEmail(Guests guests);
	public List<Guests> getAllGuests();
	public List<Guests> getAllBookings();
}
