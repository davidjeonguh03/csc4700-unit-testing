package csc4700;
/**
 * The Item class represents an item and its name, cost, and description.
 *
 * @author  David Jeong
 */
public class Item {

    private String name;  // uniquely identifies the item
    private int cost;  // in dollars; ignore cents for this project
    private String description;
    /**
     * Compares this Item with another Item.
     * @return true if name is equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;

        return name.equals(item.name);

    }
    /**
     * Returns hashcode of item. Returns 0 if hashcode if item equals null.
     * @return the hashcode of this Item
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Gets name.
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets cost.
     * @return int cost.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets cost.
     * @param cost int cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Gets description.
     * @return String of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     * @param description String description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
