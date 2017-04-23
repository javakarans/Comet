package ir.comet.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class OtherDetails {
    private List<Item> items;

    public OtherDetails() {
        items = new ArrayList<Item>();
    }

    public String otherDetailsToJson()
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        return gson.toJson(this.otherDetailsToJson());
    }

    public OtherDetails otherDetailsFromJson(String json)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        return gson.fromJson(json,this.getClass());
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
