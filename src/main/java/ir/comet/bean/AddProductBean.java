package ir.comet.bean;

import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.BranchDetails;
import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.UploadedFileWrapper;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
    private  UploadedFile uploadedFile1;
    private  UploadedFile uploadedFile2;
    private  UploadedFile uploadedFile3;
    private  UploadedFile uploadedFile4;
    private List<BranchDetailsWrapper> branchDetailsWrapperList;
    private BranchDetailsDaoImp branchDetailsDaoImp;


    @PostConstruct
    public void init() {
        product = new Product();
        productDaoImp = new ProductDaoImp();
        branchDetailsDaoImp = new BranchDetailsDaoImp();
        List<BranchDetails> branchDetailsList = branchDetailsDaoImp.getAlBranchDetails();
        branchDetailsWrapperList = new ArrayList<BranchDetailsWrapper>(branchDetailsList.size());
        for (BranchDetails branchDetails : branchDetailsList) {
            branchDetailsWrapperList.add(new BranchDetailsWrapper(branchDetails));
        }
    }

    public void save()
    {
        String uniqueID = UUID.randomUUID().toString();
        String icon = "C:\\Users\\amir\\IdeaProjects\\Comet\\image\\product\\icon\\";
        String image = "C:\\Users\\amir\\IdeaProjects\\Comet\\image\\product\\image\\";
        if (uploadedFile != null){
            handleFileUpload(uploadedFile,icon.concat(uniqueID));
            product.setImageUrl(icon.concat(uniqueID));

        }
        if (uploadedFile1 != null){
            handleFileUpload(uploadedFile1,image.concat(uniqueID).concat("1"));
            product.setImageLocation1(image.concat(uniqueID).concat("1"));
        }
        if (uploadedFile2 != null){
            handleFileUpload(uploadedFile2,image.concat(uniqueID).concat("2"));
            product.setImageLocation2(image.concat(uniqueID).concat("2"));
        }
        if (uploadedFile3 != null){
            handleFileUpload(uploadedFile3,image.concat(uniqueID).concat("3"));
            product.setImageLocation3(image.concat(uniqueID).concat("3"));
        }
        if (uploadedFile4 != null){
            handleFileUpload(uploadedFile4,image.concat(uniqueID).concat("4"));
            product.setImageLocation4(image.concat(uniqueID).concat("4"));
        }
        productDaoImp.createProduct(product);
        product = new Product();
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

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public UploadedFile getUploadedFile1() {
        return uploadedFile1;
    }

    public void setUploadedFile1(UploadedFile uploadedFile1) {
        this.uploadedFile1 = uploadedFile1;
    }

    public UploadedFile getUploadedFile2() {
        return uploadedFile2;
    }

    public void setUploadedFile2(UploadedFile uploadedFile2) {
        this.uploadedFile2 = uploadedFile2;
    }

    public UploadedFile getUploadedFile3() {
        return uploadedFile3;
    }

    public void setUploadedFile3(UploadedFile uploadedFile3) {
        this.uploadedFile3 = uploadedFile3;
    }

    public UploadedFile getUploadedFile4() {
        return uploadedFile4;
    }

    public void setUploadedFile4(UploadedFile uploadedFile4) {
        this.uploadedFile4 = uploadedFile4;
    }

    public List<BranchDetailsWrapper> getBranchDetailsWrapperList() {
        return branchDetailsWrapperList;
    }

    public void setBranchDetailsWrapperList(List<BranchDetailsWrapper> branchDetailsWrapperList) {
        this.branchDetailsWrapperList = branchDetailsWrapperList;
    }
}
