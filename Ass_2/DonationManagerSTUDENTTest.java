
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {

		manager = new DonationManager();

	}

	@After
	public void tearDown() throws Exception {

		manager = null;
	}

	@Test
	public void testManagerLoadcontainer() {
		try {
			manager.managerLoadContainer(new DonationPackage("pencil", 14));
			manager.managerLoadContainer(new DonationPackage("Books", 14));
			manager.managerLoadContainer(new DonationPackage("NoteBooks", 12));
			manager.managerLoadContainer(new DonationPackage("Bench", 22));
			manager.managerLoadContainer(new DonationPackage("iPad", 16));

		} catch (ContainerException e) {
			System.out.println("Should not throw exception ");
		}
	}

	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new Volunteer("Giao"));
			manager.managerQueueVolunteer(new Volunteer("Wang"));
			manager.managerQueueVolunteer(new Volunteer("Li"));
			manager.managerQueueVolunteer(new Volunteer("Heken"));
			manager.managerQueueVolunteer(new Volunteer("May"));
			manager.managerQueueVolunteer(new Volunteer("Eric"));

		} catch (VolunteerException e) {

			System.out.println(e + "here");
		}

	}

	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueVolunteer(new Volunteer("Sang"));
			manager.managerQueueVolunteer(new Volunteer("Danni"));
			manager.managerQueueVolunteer(new Volunteer("Alsa"));
			manager.managerQueueVolunteer(new Volunteer("Ral"));
			manager.managerQueueVolunteer(new Volunteer("Leny"));
			manager.managerQueueVolunteer(new Volunteer("Ques"));

		} catch (RecipientException e) {

			System.out.println(e + "here");
		}
	}

	@Test
	public void testDonatePackage() {
		Volunteer v1;
		Recipient r1;
		DonationPackage d1, d2;

		v1 = new Volunteer("Monica");
		r1 = new Recipient("MC College");

		d1 = new DonationPackage("Pens", 10);
		d2 = new DonationPackage("Books", 20);

		try {
			manager.managerLoadContainer(d1);
			manager.managerLoadContainer(d2);

			assertEquals(manager.donatePackage(), 1);

			manager.managerQueueVolunteer(v1);
			assertEquals(manager.donatePackage(), 2);

			manager.managerQueueRecipient(r1);

			assertEquals(manager.donatePackage(), 0);

			assertEquals(manager.donatePackage(), 2);

		} catch (ContainerException | VolunteerException | RecipientException e) {

			e.printStackTrace();
		}

	}

}
