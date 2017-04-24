package ir.comet.bean;

import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.*;
import ir.comet.wrapper.BranchDetailsWrapper;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.UploadedFileWrapper;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hibernate.internal.util.io.StreamCopier.BUFFER_SIZE;

@ManagedBean(name = "dtAddProductBean")
@SessionScoped
public class AddProductBean implements Serializable {
    private Product product ;
    private ProductDaoImp productDaoImp;
    private UploadedFile uploadedFile;
    private List<BranchDetailsWrapper> branchDetailsWrapperList;
    private BranchDetailsDaoImp branchDetailsDaoImp;
    private BranchDetailsWrapper selectedBranchDetailsWrapper;
    private OtherDetails otherDetails;
    private Item item;
    private UploadedFile imageUploadedFile;
    private FilesLocations filesLocations;
    private String temp;

    @PostConstruct
       public void init() {
            filesLocations = new FilesLocations();
            otherDetails = new OtherDetails();
            item = new Item();
            product = new Product();
            productDaoImp = new ProductDaoImp();
            branchDetailsDaoImp = new BranchDetailsDaoImp();
            List<BranchDetails> branchDetailsList = branchDetailsDaoImp.getAlBranchDetails();
            branchDetailsWrapperList = new ArrayList<BranchDetailsWrapper>(branchDetailsList.size());
            for (BranchDetails branchDetails : branchDetailsList) {
                branchDetailsWrapperList.add(new BranchDetailsWrapper(branchDetails));
            }
    }

    public void addItem()
    {

        otherDetails.getItems().add(item);
        System.out.println(otherDetails.getItems().size());
        temp= item.getItemName();
        item = new Item();
    }

    public void removeItem(Item item)
    {
        otherDetails.getItems().remove(item);
    }


    public void loadFile(FileUploadEvent event) {
        String uniqueID = UUID.randomUUID().toString();
        filesLocations.getFilesList().add("C:\\Users\\amir\\IdeaProjects\\Comet\\image\\".concat(uniqueID).concat(event.getFile().getFileName()));
        handleFileUpload(event.getFile(),"C:\\Users\\amir\\IdeaProjects\\Comet\\image\\".concat(uniqueID).concat(event.getFile().getFileName()));
    }

    public void iconLoadFile(FileUploadEvent event) {
        String uniqueID = UUID.randomUUID().toString();
        product.setImageUrl("C:\\Users\\amir\\IdeaProjects\\Comet\\image\\".concat(uniqueID).concat(event.getFile().getFileName()));
        handleFileUpload(event.getFile(),"C:\\Users\\amir\\IdeaProjects\\Comet\\image\\".concat(uniqueID).concat(event.getFile().getFileName()));
    }

    public void save()
    {
        filesLocations.setFileName(String.valueOf(product.getProductId()));
        product.setImageLocationJson(filesLocations.filesLocationsToJson());
        product.setOtherDetailsJson(otherDetails.otherDetailsToJson());
        String uniqueID = UUID.randomUUID().toString();
        String icon = "C:\\Users\\amir\\IdeaProjects\\Comet\\image\\product\\icon\\";
        product.setBranchDetailsId(selectedBranchDetailsWrapper.getBranchDetailsWrapperId());
        productDaoImp.createProduct(product);
        product = new Product();
        otherDetails = new OtherDetails();
        filesLocations = new FilesLocations();
    }



    private void handleFileUpload(UploadedFile uploaded, String location) {
        File result = new File(location);

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

        } catch (IOException e1) {
            e1.printStackTrace();

            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "The files were not uploaded!", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<BranchDetailsWrapper> getBranchDetailsWrapperList() {
        return branchDetailsWrapperList;
    }

    public void setBranchDetailsWrapperList(List<BranchDetailsWrapper> branchDetailsWrapperList) {
        this.branchDetailsWrapperList = branchDetailsWrapperList;
    }

    public BranchDetailsWrapper getSelectedBranchDetailsWrapper() {
        return selectedBranchDetailsWrapper;
    }

    public void setSelectedBranchDetailsWrapper(BranchDetailsWrapper selectedBranchDetailsWrapper) {
        this.selectedBranchDetailsWrapper = selectedBranchDetailsWrapper;
    }

    public OtherDetails getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(OtherDetails otherDetails) {
        this.otherDetails = otherDetails;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public UploadedFile getImageUploadedFile() {
        return imageUploadedFile;
    }

    public void setImageUploadedFile(UploadedFile imageUploadedFile) {
        this.imageUploadedFile = imageUploadedFile;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
