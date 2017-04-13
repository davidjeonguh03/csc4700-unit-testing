import csc4700.Backup;
import csc4700.Item;
import csc4700.ShoppingCart;
import csc4700.exceptions.SerializedFormatException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertTrue;


// Please delete this file prior to submitting your project.


public class BackupTest {

    @Test
    public void testJUnitIsConfiguredCorrectly() {
        assertTrue(true);
    }
    @Test
    public void testConstructor(){
        Backup bu = new Backup();
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
            assertTrue(false);
        }
        catch(NullPointerException e){
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
        try {
            String s = null;
            bu.deserializeShoppingCart(s);
            assertTrue(false);
        }
        catch(NullPointerException e){
        }
        catch(SerializedFormatException e){}
        //serial serialized format exception
        try {
            String s = "foobar";
            bu.deserializeShoppingCart(s);
            assertTrue(false);
        }
        catch(SerializedFormatException e){
        }
        //serial norm
        String s = "foob";
        s = bu.serializeShoppingCart(sc);
        try {
            bu.deserializeShoppingCart(s);
        }
        catch(SerializedFormatException e){
            assertTrue(false);
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
        //norm save
        try {
            bu.saveShoppingCart(sc, new File("out/save.txt"));
        }
        catch(IOException e){
            assertTrue(false);
        }
    }
    @Test
    public void testLoadShoppingCart(){
        Backup bu = new Backup();
        //norm load
        try {
            File s = new File("out/save.txt");
            bu.loadShoppingCart(s);
        }
        catch(SerializedFormatException e){
            assertTrue(false);
        }
        catch(IOException e){
            assertTrue(false);
        }
        //nonexistent path load
        try {
            File s = new File("out/save2.txt");
            bu.loadShoppingCart(s);
            assertTrue(false);
        }
        catch(IOException e){}
        catch(SerializedFormatException e){
            assertTrue(false);
        }
    }

}
