import csc4700.Item;
import csc4700.ShoppingCart;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


// Please delete this file prior to submitting your project.


public class ShoppingCartTest {

    @Test
    public void testJUnitIsConfiguredCorrectly() {
        assertTrue(true);
    }

    @Test
    public void testAdd(){
        ShoppingCart sc = new ShoppingCart();
        //adding null
        try {
            sc.addItem(null);
        }
        catch(NullPointerException e){
            assertTrue(true);
        }
        //adding normal
        Item item = new Item();
        sc.addItem(item);
        //add same
        sc.addItem(item);
    }
    @Test
    public void testDelete(){
        ShoppingCart sc = new ShoppingCart();
        //del null
        try{
            sc.deleteItem(null);
        }
        catch(NullPointerException e){
            assertTrue(true);
        }
        //del nonexistent
        sc.deleteItem(new Item());
        //setup tests
        Item item = new Item();
        sc.addItem(item);
        sc.addItem(item);
        //del normal
        sc.deleteItem(item);
        sc.deleteItem(item);
    }
    @Test
    public void testFindCartItem(){
        ShoppingCart sc = new ShoppingCart();
        Item item = new Item();
        item.setName("foo");
        sc.addItem(item);

        //find null
        sc.findCartItem(null);
        //find nonexistent
        sc.findCartItem(new Item());
        //find normal
        sc.findCartItem(item);
    }
    @Test
    public void testGetCartItems(){
        ShoppingCart sc = new ShoppingCart();
        sc.getCartItems();
    }
}
