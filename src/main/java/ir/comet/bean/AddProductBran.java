package ir.comet.bean;


import ir.comet.database.BranchBrandDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.database.TechnicalSpecificationDaoImp;
import ir.comet.database.TechnicalSpecificationDetailsDaoImp;
import ir.comet.model.*;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ManagedBean
@ViewScoped
public class AddProductBran {

    private Product product;
    private ProductDaoImp productDaoImp;
    private List<Product> productList;
    private List<BranchBrand> branchBrandList;
    private BranchBrandDaoImp branchBrandDaoImp;
    private UploadedFile uploadedFile;
    private static String image_locationServer = StaticSettings.imageUrlServer;
    private static String image_locationDB = StaticSettings.imageUrlDB;
    private String imageFilename;
    private String iconFilename;
    private String uniqueID;
    private OtherDetails otherDetails;
    private TechnicalSpecification technicalSpecification;
    private TechnicalSpecificationDetails technicalSpecificationDetails;
    private TechnicalSpecification selectedTechnicalSpecification;
    private List<TechnicalSpecification> specificationList;
    private List<TechnicalSpecificationDetails> detailsList;


    @PostConstruct
    public void init()
    {
        product = new Product();
        technicalSpecification = new TechnicalSpecification();
        technicalSpecificationDetails = new TechnicalSpecificationDetails();
        otherDetails = new OtherDetails();
        productDaoImp = new ProductDaoImp();
        productList = productDaoImp.getAllProducts();
        branchBrandDaoImp = new BranchBrandDaoImp();
        branchBrandList = branchBrandDaoImp.getAlBranchBrand();
        specificationList=new ArrayList<>();
        detailsList=new ArrayList<>();
    }

    public void addProduct()
    {
        TechnicalSpecificationDaoImp technicalSpecificationDaoImp=new TechnicalSpecificationDaoImp();
        TechnicalSpecificationDetailsDaoImp technicalSpecificationDetailsDaoImp=new TechnicalSpecificationDetailsDaoImp();
        product.setImageUrl(iconFilename);
        product.setImageLocationJson(imageFilename);
        boolean result = productDaoImp.createProduct(product);
        if (result)
        {
            for (TechnicalSpecification specification:specificationList
                 ) {
                technicalSpecificationDaoImp.createTechnicalSpecification(specification);
            }
            for (TechnicalSpecificationDetails details:detailsList
                 ) {
                technicalSpecificationDetailsDaoImp.createTechnicalSpecificationDetails(details);
            }
            productList = productDaoImp.getAllProducts();
            product = new Product();
        }
        else
        {

        }
    }

    public List<TechnicalSpecificationDetails> filterTechnicalSpecificationList(){
        List<TechnicalSpecificationDetails> list=new ArrayList<>();
        for (TechnicalSpecificationDetails details:detailsList){
            if(details.getTechnicalSpecification().equals(selectedTechnicalSpecification)){
                list.add(details);
            }
        }
        return list;
    }

    public void removeTS(TechnicalSpecification technicalSpecification)
    {
        product.getTechnicalSpecificationList().remove(technicalSpecification);
    }

    public void addTSToProduct()
    {
        technicalSpecification.setProduct(product);
        specificationList.add(technicalSpecification);
//        product.getTechnicalSpecificationList().add(technicalSpecification);
        technicalSpecification = new TechnicalSpecification();
    }

    public void addTSDToProduct()
    {
        technicalSpecificationDetails.setTechnicalSpecification(selectedTechnicalSpecification);
        detailsList.add(technicalSpecificationDetails);
//        selectedTechnicalSpecification.getTechnicalSpecificationDetailss().add(technicalSpecificationDetails);
        technicalSpecificationDetails = new TechnicalSpecificationDetails();
    }

    public void processFileUploadIcon(FileUploadEvent event) throws IOException {
        uniqueID = UUID.randomUUID().toString();
        this.uploadedFile = event.getFile();
        String[] tokens = uploadedFile.getFileName().split("\\.(?=[^\\.]+$)");
        String fileExtention = tokens[1];
        try {
            InputStream inputStream = event.getFile().getInputstream();
            iconFilename=image_locationDB + uniqueID + "."+fileExtention;
            Path des = Paths.get(image_locationServer +uniqueID+"."+fileExtention);
            Files.copy(inputStream,des);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public void processFileUploadImage(FileUploadEvent event) throws IOException {
        uniqueID = UUID.randomUUID().toString();
        this.uploadedFile = event.getFile();
        String[] tokens = uploadedFile.getFileName().split("\\.(?=[^\\.]+$)");
        String fileExtention = tokens[1];
        try {
            InputStream inputStream = event.getFile().getInputstream();
            imageFilename = image_locationDB + uniqueID + "."+fileExtention;
            Path des = Paths.get(image_locationServer +uniqueID+"."+fileExtention);
            Files.copy(inputStream,des);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<BranchBrand> getBranchBrandList() {
        return branchBrandList;
    }

    public void setBranchBrandList(List<BranchBrand> branchBrandList) {
        this.branchBrandList = branchBrandList;
    }

    public OtherDetails getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(OtherDetails otherDetails) {
        this.otherDetails = otherDetails;
    }

    public TechnicalSpecification getTechnicalSpecification() {
        return technicalSpecification;
    }

    public void setTechnicalSpecification(TechnicalSpecification technicalSpecification) {
        this.technicalSpecification = technicalSpecification;
    }

    public TechnicalSpecificationDetails getTechnicalSpecificationDetails() {
        return technicalSpecificationDetails;
    }

    public void setTechnicalSpecificationDetails(TechnicalSpecificationDetails technicalSpecificationDetails) {
        this.technicalSpecificationDetails = technicalSpecificationDetails;
    }

    public TechnicalSpecification getSelectedTechnicalSpecification() {
        return selectedTechnicalSpecification;
    }

    public void setSelectedTechnicalSpecification(TechnicalSpecification selectedTechnicalSpecification) {
        this.selectedTechnicalSpecification = selectedTechnicalSpecification;
    }

    public List<TechnicalSpecification> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<TechnicalSpecification> specificationList) {
        this.specificationList = specificationList;
    }

    public List<TechnicalSpecificationDetails> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(List<TechnicalSpecificationDetails> detailsList) {
        this.detailsList = detailsList;
    }
}
