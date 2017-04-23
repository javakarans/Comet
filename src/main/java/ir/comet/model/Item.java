package ir.comet.model;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String ItemName;
    private List<String> subItems;

    public Item() {
        subItems = new ArrayList<String>();
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public List<String> getSubItems() {
        return subItems;
    }

    public void setSubItems(List<String> subItems) {
        this.subItems = subItems;
    }
}
