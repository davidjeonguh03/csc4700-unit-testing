import csc4700.Item;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;


// Please delete this file prior to submitting your project.


public class ItemTest {

    @Test
    public void testJUnitIsConfiguredCorrectly() {
        assertTrue(true);
    }
    @Test
    public void testEquals() {
        Item aItem = new Item();
        aItem.setName("foo");
        //test self
        assertTrue(aItem.equals(aItem));
        //test null
        Item bItem = null;
        assertFalse(aItem.equals(bItem));
        //test casting
        bItem = new Item();
        bItem.setName("foo");
        assertTrue(aItem.equals((Object)bItem));
        //test same
        bItem.setName("foo");
        assertTrue(aItem.equals(bItem));
        //test different
        bItem.setName("bar");
        assertFalse(aItem.equals(bItem));
    }
    @Test
    public void testGetSet() {
        Item item = new Item();
        //name
        String expectedName = "expected";
        item.setName(expectedName);
        assertEquals(expectedName, item.getName());
        //cost
        Random rand = new Random();
        int expectedCost = rand.nextInt(1024);
        item.setCost(expectedCost);
        assertEquals(expectedCost, item.getCost());
        //description
        String expectedDescription = "expected";
        item.setDescription(expectedDescription);
        assertEquals(expectedDescription, item.getDescription());
    }
    @Test
    public void testHashCode(){
        Item item = new Item();
        String name = "foo";
        item.setName(name);
        assertEquals(name.hashCode(), item.hashCode());
    }
}
