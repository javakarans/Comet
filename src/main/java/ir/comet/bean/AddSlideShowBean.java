package ir.comet.bean;


import ir.comet.database.SlideShowDaoImp;
import ir.comet.model.SlideShow;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@ManagedBean
@ViewScoped
public class AddSlideShowBean implements Serializable {

    private SlideShow slideShow;
    private SlideShowDaoImp slideShowDaoImp;
    private List<SlideShow> slideShowList;
    private UploadedFile uploadedFile;
    private static String image_location = StaticSettings.imageUrlServer;
    private static String image_locationDB = StaticSettings.imageUrlDB;
    private String filename;
    private String uniqueID;
    private FacesMessage msg;
    private SlideShow selectedSlide;

    @PostConstruct
    public void init()
    {
        slideShow = new SlideShow();
        slideShowDaoImp = new SlideShowDaoImp();
        slideShowList = slideShowDaoImp.getAllSlideShow();
    }

    public void addSlide(){
        System.out.println("222222222222222222222222222222222222222222222");
        slideShow.setImageLocation(filename);
        boolean result = slideShowDaoImp.createSlideShow(slideShow);
        if (result)
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "ذخیره شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            slideShow = new SlideShow();
            slideShowList = slideShowDaoImp.getAllSlideShow();
        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void removeSlide(SlideShow slideShow)
    {
        System.out.println("asdfghjkl;'lkjhgfdsfghjkl;kjhgfdsadfdfhj");
        boolean result = slideShowDaoImp.deleteSlideShow(slideShow);
        if (result)
        {
            slideShowList = slideShowDaoImp.getAllSlideShow();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "حذف شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void editSlide()
    {
        selectedSlide.setImageLocation(filename);
        boolean result = slideShowDaoImp.updateSlideShow(selectedSlide);
        if (result)
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "به روز رسانی شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            slideShowList = slideShowDaoImp.getAllSlideShow();
        }
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void processFileUploadEdit(FileUploadEvent event) throws IOException {
        uniqueID = UUID.randomUUID().toString();
        this.uploadedFile = event.getFile();
        String[] tokens = uploadedFile.getFileName().split("\\.(?=[^\\.]+$)");
        String fileExtention = tokens[1];
        try {
            InputStream inputStream = event.getFile().getInputstream();
            filename = image_locationDB+uniqueID+"."+fileExtention;
            Path des = Paths.get(image_location+uniqueID+"."+fileExtention);
            Files.copy(inputStream,des);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public SlideShow getSlideShow() {
        return slideShow;
    }

    public void setSlideShow(SlideShow slideShow) {
        this.slideShow = slideShow;
    }

    public List<SlideShow> getSlideShowList() {
        return slideShowList;
    }

    public void setSlideShowList(List<SlideShow> slideShowList) {
        this.slideShowList = slideShowList;
    }

    public SlideShow getSelectedSlide() {
        return selectedSlide;
    }

    public void setSelectedSlide(SlideShow selectedSlide) {
        this.selectedSlide = selectedSlide;
    }
}
