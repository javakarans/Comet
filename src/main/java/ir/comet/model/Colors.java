package ir.comet.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Colors {
    private List<String> colorsList;

    public Colors()
    {
        colorsList = new ArrayList<String>();
    }

    public String colorsToJson()
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        return gson.toJson(this);
    }

    public Colors colorsFromJson(String json)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        return gson.fromJson(json,this.getClass());
    }

    public List<String> getColorsList() {
        return colorsList;
    }

    public void setColorsList(List<String> colorsList) {
        this.colorsList = colorsList;
    }
}
