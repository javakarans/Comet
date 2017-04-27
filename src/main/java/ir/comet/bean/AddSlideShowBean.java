package ir.comet.bean;

import ir.comet.database.SlideShowDaoImp;
import ir.comet.model.SlideShow;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;


import static org.hibernate.internal.util.io.StreamCopier.BUFFER_SIZE;


@ManagedBean(name = "dtSlideShowBean")
public class AddSlideShowBean implements Serializable {
    private SlideShowDaoImp slideShowDaoImp = new SlideShowDaoImp();
    private SlideShow slideShow = new SlideShow();
    private UploadedFile uploadedFile;
    private Part file ;

    public void addSlide() throws IOException {

        int result;
        result= slideShowDaoImp.createSlideShow(slideShow);
        slideShow = new SlideShow();
    }


    public void f(FileUploadEvent event) {
        String uniqueID = UUID.randomUUID().toString();
        handleFileUpload(event.getFile(),uniqueID);
        //FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        //FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void handleFileUpload(UploadedFile uploaded,String fileId) {

        File result = new File("C:\\Users\\amir\\IdeaProjects\\Comet\\image\\".concat(fileId));


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(result);

            byte[] buffer = new byte[BUFFER_SIZE];

            int bulk;
            InputStream inputStream = uploaded.getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }

            fileOutputStream.close();
            inputStream.close();

            FacesMessage msg = new FacesMessage("Succesful", uploaded.getFileName()
                    + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException e) {
            e.printStackTrace();

            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "The files were not uploaded!", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }

    public void upload() throws Throwable {

        System.out.println("666666666666666666666666666666666666666");
        //System.out.println("salam");
        handleFileUpload(uploadedFile,String.valueOf(slideShow.getSlideId()));


        if(uploadedFile != null) {
            FacesMessage message = new FacesMessage("Succesful",  " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else
        {
            FacesMessage message = new FacesMessage("cancel",  " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        slideShow = new SlideShow();
    }

    public void m() throws Throwable {


      //  System.out.println(uploadedFile.getFileName());

       // uploadedFile.getContents();
    }

    public void save(FileUploadEvent e) throws IOException {

        System.out.println("gholam");
        e.getFile().getInputstream();
    }




    public SlideShow getSlideShow() {
        return slideShow;
    }

    public void setSlideShow(SlideShow slideShow) {
        this.slideShow = slideShow;
    }

    public SlideShowDaoImp getSlideShowDaoImp() {
        return slideShowDaoImp;
    }

    public void setSlideShowDaoImp(SlideShowDaoImp slideShowDaoImp) {
        this.slideShowDaoImp = slideShowDaoImp;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}
