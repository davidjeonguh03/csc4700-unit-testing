package csc4700;

import java.util.ArrayList;
import java.util.List;

/**
 * The ShoppingCart represents a list of CartItem.
 *
 * @author  David Jeong
 */

public class ShoppingCart {

    private List<CartItem> cartItems = new ArrayList<CartItem>();
    /**
     * Adds an Item.
     *
     * @param item An Item
     * @throws NullPointerException if item equals null
     */
    public void addItem(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        CartItem cartItem = findCartItem(item);

        // If there is no CartItem, this is the first time it is being
        // added to the cart and we need to create the mapping object
        if (cartItem == null) {
            cartItem = new CartItem(item);
            cartItems.add(cartItem);
        }

        // Items may only be added one at a time in this implementation,
        // so simply increment the quantity.
        cartItem.incrementCountByOne();
    }
    /**
     * Deletes an Item.
     *
     * @param item An Item
     * @throws NullPointerException if item equals null
     */
    public void deleteItem(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        CartItem cartItem = findCartItem(item);

        // If there is no corresponding CartItem object, there is nothing
        // to delete. Some implementations will choose to throw an exception
        // in this case, however for this project we'll simply exit (having
        // met the end goal of not having the item in the cart).
        if (cartItem == null) {
            return;
        }

        if (cartItem.getCount() == 1) {
            // Removing the last of this item, so remove it
            // fully from the cart
            cartItems.remove(cartItem);
        }
        else {
            // Only decrement the quantity by one, but since there will still
            // be at least one of the item desired, leave the CartItem in place.
            cartItem.decrementCountByOne();
        }
    }
    /**
     * Finds an CartItem.
     *
     * @param item An Item
     * @return a CartItem representing item
     * @throws NullPointerException if item equals null
     */
    public CartItem findCartItem(Item item) {
        for (CartItem i : cartItems) {
            if (i.getItem().equals(item)) {
                return i;
            }
        }
        return null;
    }
    /**
     * Gets list of CartItem.
     *
     * @return a List of CartItem this ShoppingCart
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
