package ir.comet.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class FilesLocations {
    private String fileName;
    private List<String> filesList;


    public FilesLocations(){

        filesList = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return "FilesLocations{" +
                "fileName='" + fileName + '\'' +
                ", filesList=" + filesList +
                '}';
    }

    public String filesLocationsToJson()
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        return gson.toJson(this);
    }

    public FilesLocations filesLocationsFromJson(String json)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        return gson.fromJson(json,this.getClass());
    }

    public List<String> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<String> filesList) {
        this.filesList = filesList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
