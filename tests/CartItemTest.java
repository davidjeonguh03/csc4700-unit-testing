import csc4700.CartItem;
import csc4700.Item;
import csc4700.exceptions.InvalidCountException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


// Please delete this file prior to submitting your project.


public class CartItemTest {

    @Test
    public void testJUnitIsConfiguredCorrectly() {
        assertTrue(true);
    }

    @Test
    public void testConstructor(){
        CartItem cartItem = new CartItem(new Item());
    }
    @Test
    public void testGetCount() {
        Item item1 = new Item();
        item1.setName("foo");
        CartItem cartItem = new CartItem(item1);
        cartItem.getCount();
    }
    @Test
    public void testIncrementCountByOne(){
        Item item1 = new Item();
        item1.setName("foo");
        CartItem cartItem = new CartItem(item1);
        int count1 = cartItem.getCount()+1;
        cartItem.incrementCountByOne();
        int count2 = cartItem.getCount();
        assertEquals(count1, count2);
    }
    @Test
    public void testDecrementCountByOne(){
        Item item1 = new Item();
        item1.setName("foo");
        CartItem cartItem = new CartItem(item1);
        cartItem.incrementCountByOne();
        cartItem.incrementCountByOne();
        int count1 = cartItem.getCount();
        cartItem.decrementCountByOne();
        int count2 = cartItem.getCount()+1;
        assertEquals(count1, count2);
    }
    @Test
    public void testEquals(){
        Item item1 = new Item();
        item1.setName("foo");
        CartItem cartItem = new CartItem(item1);
        //test null
        try {
            cartItem.equals(null);
        }
        catch(NullPointerException e){
            assertTrue(true);
        }
        //test self
        cartItem.equals(cartItem);
        //test same
        Item item2 = new Item();
        item2.setName("foo");
        cartItem.equals(new CartItem(item2));
    }
    @Test
    public void testHashCode(){
        Item item1 = new Item();
        item1.setName("foo");
        CartItem cartItem = new CartItem(item1);
        cartItem.incrementCountByOne();
        cartItem.hashCode();
    }
    @Test
    public void testGetSetItem() {
        CartItem cartItem = new CartItem(null);
        Item expected = new Item();
        cartItem.setItem(expected);
        assertEquals(expected, cartItem.getItem());
    }
    @Test
    public void testSetCount(){
        Item item1 = new Item();
        item1.setName("foo");
        CartItem cartItem = new CartItem(item1);
        //normal set
        cartItem.setCount(10);
        //neg set
        try {
            cartItem.setCount(-10);
        }
        catch(InvalidCountException e){
            assertTrue(true);
        }
    }
}
