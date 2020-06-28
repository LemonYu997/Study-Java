package chapter7.treeSet;

import java.util.Objects;

/**
 * 有部件编号和描述的Item
 * */
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    /**
     * 构造item
     * @param aDescription item的描述
     * @param aPartNumber item的部件编号
     * */
    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

    /**
     * 获得item的描述
     * @return 描述
     * */
    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[descripion=" + description + ", partNumber=" + partNumber + "]";
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject)
            return true;
        if (otherObject == null)
            return false;
        if (getClass() != otherObject.getClass())
            return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    public int compareTo(Item Other) {
        int diff = Integer.compare(partNumber, Other.partNumber);
        return diff != 0 ? diff : description.compareTo(Other.description);
    }
}
