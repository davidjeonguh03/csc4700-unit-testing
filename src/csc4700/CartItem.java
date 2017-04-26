package csc4700;

import csc4700.exceptions.InvalidCountException;
/**
 * The CartItem class represents an Item and a count of that
 * Item.
 *
 * @author  David Jeong
 * @see Item
 */
public class CartItem {

    private Item item;
    private int count;
    /**
     * Constructs a new CartItem so it represents an Item.
     *
     * @param item An Item
     */
    public CartItem(Item item) {
        this.item = item;
        this.count = 0;
    }

    /**
     * Increments the count by one.
     */
    public void incrementCountByOne() {
        setCount(getCount() + 1);
    }
    /**
     * Decrement the count by one.
     */
    public void decrementCountByOne() {
        setCount(getCount() - 1);
    }
    /**
     * Compares this CartItem to another CartItem.
     * @return true if both Item are equal.
     * @see Item
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CartItem cartItem = (CartItem) o;

        return item.equals(cartItem.item);
    }

    /**
     * Returns hashcode of item. Returns 0 if hashcode if item equals null.
     * @return the hashcode of this Item
     */
    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }

    /**
     * Gets item.
     * @return This item.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets item.
     *
     * @param item Item to be set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Gets count of item.
     *
     * @return int count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets count of item.
     *
     * @param count count to be set
     */
    public void setCount(int count) {
        if (count <= 0) {
            throw new InvalidCountException();
        }
        this.count = count;
    }
}
