package csc4700;

import csc4700.exceptions.SerializedFormatException;

import java.io.*;
/**
 * The BackUp class saves and loads ShoppingCarts.
 *
 * @author  David Jeong
 * @see ShoppingCart
 */
public class Backup {


    public static final String FIELD_SEPARATOR = ",";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * Serializes a ShoppingCart.
     * The method is not recommended for use outside of
     * the saveShoppingCart method.
     *
     * @param cart ShoppingCart to be serialized
     * @return String of serialized ShoppingCart
     * @throws NullPointerException if cart is null
     */
    public String serializeShoppingCart(ShoppingCart cart) {
        if (cart == null) {
            throw new NullPointerException();
        }

        StringBuffer allCartItems = new StringBuffer();
        for (CartItem cartItem : cart.getCartItems()) {
            Item item = cartItem.getItem();
            StringBuffer itemLine = new StringBuffer();
            itemLine.append(item.getName());
            itemLine.append(FIELD_SEPARATOR);
            itemLine.append(item.getCost());
            itemLine.append(FIELD_SEPARATOR);
            itemLine.append(item.getDescription());
            itemLine.append(FIELD_SEPARATOR);
            itemLine.append(cartItem.getCount());

            allCartItems.append(itemLine.toString());
            allCartItems.append(LINE_SEPARATOR);
        }

        return allCartItems.toString();
    }

    /**
     * Deserializes a ShoppingCart.
     * The method is not recommended for use outside of
     * the loadShoppingCart method.
     *
     * @param s String of serialized ShoppingCart
     * @return Deserialized ShoppingCart
     * @throws NullPointerException if s is null
     * @throws SerializedFormatException if s is not properly formatted
     * @see SerializedFormatException
     */
    public ShoppingCart deserializeShoppingCart(String s) throws SerializedFormatException {
        if (s == null) {
            throw new NullPointerException();
        }

        ShoppingCart cart = new ShoppingCart();

        String[] allCartItems = s.split(LINE_SEPARATOR);
        for (String cartItemLine : allCartItems) {
            String[] itemLinePieces = cartItemLine.split(FIELD_SEPARATOR);
            if (itemLinePieces.length != 4) {
                throw new SerializedFormatException();
            }

            Item item = new Item();
            item.setName(itemLinePieces[0]);
            item.setCost(Integer.parseInt(itemLinePieces[1]));
            item.setDescription(itemLinePieces[2]);

            // Yes, no one in their right mind would design it this way instead of
            // just exposing the set count through the cart itself. I'm just doing it here
            // for project purposes; don't judge me :)
            int numItems = Integer.parseInt(itemLinePieces[3]);
            for (int i = 1; i <= numItems; i++) {
                cart.addItem(item);
            }
        }

        return cart;
    }

    /**
     * Saves a ShoppingCart at the desired File location.
     * If the designated file already exists, it will be deleted.
     * @param saveMe ShoppingCart to be serialized
     * @param location File save location
     * @throws IOException if location references a nonexistent file
     */
    public void saveShoppingCart(ShoppingCart saveMe, File location) throws IOException {

        // If there is already a file at the given location, delete it before continuing.
        if (location.exists()) {
            location.delete();
        }

        // Serialize the contact list to be written to the file.
        String serialized = serializeShoppingCart(saveMe);

        BufferedWriter bw = new BufferedWriter(new FileWriter(location));
        bw.write(serialized);
        bw.close();
    }
    /**
     * Loads a ShoppingCart from the designated File location.
     * @param location File load location
     * @return Saved ShoppingCart at location
     * @throws IOException if location references a nonexistent file
     * @throws SerializedFormatException if saved string is not properly formatted
     */
    public ShoppingCart loadShoppingCart(File location)
            throws IOException, SerializedFormatException {

        // If the file isn't found, throw an error.
        if (!location.exists()) {
            throw new FileNotFoundException();
        }

        // Read in the contents of the serialized file.
        BufferedReader br = new BufferedReader(new FileReader(location));
        String line;
        StringBuffer allLines = new StringBuffer();
        while ((line = br.readLine()) != null) {
            allLines.append(line);
            allLines.append(LINE_SEPARATOR);
        }

        // Deserialize the contents into a ContactList.
        ShoppingCart result = deserializeShoppingCart(allLines.toString());
        return result;
    }

}
