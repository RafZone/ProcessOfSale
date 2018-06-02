package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.Item;
class ItemTest {

	@Test
	void test() {
		Item item1 = new Item(333, 22, "item1");
		Item item2 = new Item(333, 22, "item1");
		boolean check = item1.equals(item2);
		assertEquals(true, check);
	}

}
