package ir.comet.model;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String ItemName;
    private String keys;
    private String values;


    public Item() {

    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
