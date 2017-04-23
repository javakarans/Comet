package ir.comet.model;


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
