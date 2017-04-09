import csc4700.Backup;
import csc4700.Item;
import csc4700.ShoppingCart;
import csc4700.exceptions.SerializedFormatException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;


// Please delete this file prior to submitting your project.


public class BackupTest {

    @Test
    public void testJUnitIsConfiguredCorrectly() {
        assertTrue(true);
    }
    @Test
    public void testSerializeShoppingCart(){
        //setup
        Backup bu = new Backup();
        ShoppingCart sc = new ShoppingCart();
        Item item1 = new Item();
        item1.setName("foo");
        Item item2 = new Item();
        item2.setName("bar");
        sc.addItem(item1);
        sc.addItem(item2);

        //serial null
        try {
            bu.serializeShoppingCart(null);
        }
        catch(NullPointerException e){
            assertTrue(true);
        }
        //serial norm
        bu.serializeShoppingCart(sc);
    }
    @Test
    public void testDeserializeShoppingCart(){
        //setup
        Backup bu = new Backup();
        ShoppingCart sc = new ShoppingCart();
        Item item1 = new Item();
        item1.setName("foo");
        Item item2 = new Item();
        item2.setName("bar");
        sc.addItem(item1);
        sc.addItem(item2);

        //serial null
        String s;
        try {
            bu.deserializeShoppingCart(s);
        }
        catch(NullPointerException e){
            assertTrue(true);
        }
        //serial norm
        s = bu.serializeShoppingCart(sc);
        try {
            bu.deserializeShoppingCart(s);
        }
        catch(SerializedFormatException e){

        }
    }
    @Test
    public void testSaveSC(){
        //setup
        Backup bu = new Backup();
        ShoppingCart sc = new ShoppingCart();
        Item item1 = new Item();
        item1.setName("foo");
        Item item2 = new Item();
        item2.setName("bar");
        sc.addItem(item1);
        sc.addItem(item2);
        try {
            bu.saveShoppingCart(sc, new File(""));
            bu.saveShoppingCart(sc, new File(""));
        }
        catch(IOException e){}
    }
    @Test
    public void testloadShoppingCart(){
        try {
            Backup bu = new Backup();
            try {
                File s = new File("");
                bu.loadShoppingCart(s);
                bu.loadShoppingCart(s);
            }
            catch(IOException e){}
            catch(SerializedFormatException e){}
        }
        catch(IOException e){}
    }

}
