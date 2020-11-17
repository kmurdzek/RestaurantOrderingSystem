/**
 * 
 */
package ordering;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Kacper Murdzek, Taranvir
 *
 */
class OrderTest {

	Order order;

	OrderLine line1;
	OrderLine line2;
	OrderLine line3;
	OrderLine line4;
	OrderLine line5;

	ChickenSandwich chicken1;
	ChickenSandwich chicken2;
	BeefSandwich beef1;
	BeefSandwich beef2;
	FishSandwich fish1;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		order = new Order();

		chicken1 = new ChickenSandwich(); // sandwich with no extra ingredients

		chicken2 = new ChickenSandwich(); // sandwich with 3 ingredients
		chicken2.add(Extra.Tomatos);
		chicken2.add(Extra.Spinach);
		chicken2.add(Extra.Peppers);

		beef1 = new BeefSandwich(); // sandwich with 1 extra ingredient
		beef1.add(Extra.Lettuce);

		beef2 = new BeefSandwich(); // sandwich with 7 extra ingredients
		beef2.add(Extra.Mushrooms);
		beef2.add(Extra.Bacon);
		beef2.add(Extra.Cheddar);
		beef2.add(Extra.Lettuce);
		beef2.add(Extra.Mayonaise);
		beef2.add(Extra.Onion);
		beef2.add(Extra.Tomatos);

		fish1 = new FishSandwich(); // sandwich with 6 extra ingredients
		fish1.add(Extra.Bacon);
		fish1.add(Extra.Cheddar);
		fish1.add(Extra.Ketchup);
		fish1.add(Extra.Lettuce);
		fish1.add(Extra.Mayonaise);
		fish1.add(Extra.Mushrooms);

		// these are the orderLine objects
		line1 = new OrderLine(1, chicken1, chicken1.price());
		line2 = new OrderLine(2, beef1, beef1.price());
		line3 = new OrderLine(3, fish1, fish1.price());
		line4 = new OrderLine(4, chicken2, chicken2.price());
		line5 = new OrderLine(5, beef2, beef2.price());
	}

	/**
	 * Test method for {@link ordering.Order#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		assertTrue(order.add(line1)); // should return true with no extras
		assertTrue(order.add(line2)); // should return true with 1 extra
		assertTrue(order.add(line3)); // should return true with 6 extras
		assertTrue(order.add(line4)); // should return true with 3 extras
		assertTrue(order.add(line5)); // should return true with 7 extras, because the 7th extra will not be accepted
										// in the sandwich class
	}

	/**
	 * Test method for {@link ordering.Order#remove(java.lang.Object)}.
	 */
	@Test
	void testRemove() {

		assertFalse(order.remove(line1)); // should return false because line1 is not yet added

		order.add(line1);
		assertTrue(order.remove(line1)); // should return true because line1 was added

		assertFalse(order.remove(line1)); // should return false because line1 was already removed

		order.add(line1);
		order.add(line2);
		order.add(line3);
		order.add(line4);
		order.add(line5);

		assertTrue(order.remove(line2)); // should return true
		assertTrue(order.remove(line3)); // should return true
		assertTrue(order.remove(line4)); // should return true
		assertTrue(order.remove(line5)); // should return true

		assertTrue(order.remove(line1)); // should return true
		assertFalse(order.remove(line2)); // should return false
		assertFalse(order.remove(line3)); // should return false
		assertFalse(order.remove(line4)); // should return false
		assertFalse(order.remove(line5)); // should return false

	}

	/**
	 * Test method for {@link ordering.Order#size()}.
	 */
	@Test
	void testSize() {
		assertEquals(0, order.size()); // return 0 when the order is empty
		order.add(line1);
		assertEquals(1, order.size()); // should return 1 when order is empty
		order.add(line2);
		assertEquals(2, order.size()); // should return 2 when order is empty
		order.add(line3);
		assertEquals(3, order.size()); // should return 3 when order is empty

	}

	/**
	 * Test method for {@link ordering.Order#getOrderLines()}.
	 */
	@Test
	void testGetOrderLines() {

		ArrayList<OrderLine> orderlineTest = new ArrayList<OrderLine>(); // array of OrderLines to compare to the return
																			// of getOrderLines

		assertEquals(orderlineTest, order.getOrderLines()); // both lists are null so they should be equal

		orderlineTest.add(line1);
		order.add(line1);
		assertEquals(orderlineTest, order.getOrderLines()); // both lists contain the same orderLine so they should be
															// the same

		orderlineTest.add(line2); // adds orderLines to the test array
		orderlineTest.add(line3);
		orderlineTest.add(line4);
		orderlineTest.add(line5);

		order.add(line2);
		order.add(line3);
		order.add(line4);
		order.add(line5);
		assertEquals(orderlineTest, order.getOrderLines()); // lists should return equal

		order.remove(line5);
		assertNotEquals(orderlineTest, order.getOrderLines()); // should return not equal

		order.remove(line4);
		order.remove(line3);
		order.remove(line2);
		order.remove(line1);
		assertNotEquals(orderlineTest, order.getOrderLines()); // should return not equal

		orderlineTest.remove(line1);
		orderlineTest.remove(line2);
		orderlineTest.remove(line3);
		orderlineTest.remove(line4);
		orderlineTest.remove(line5);
		assertEquals(orderlineTest, order.getOrderLines()); // lists should return equal

	}

}
