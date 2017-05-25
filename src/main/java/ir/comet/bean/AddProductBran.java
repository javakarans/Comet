package ir.comet.bean;


import ir.comet.database.BranchBrandDaoImp;
import ir.comet.database.ProductDaoImp;
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
    private static String image_location = StaticSettings.imageUrl;
    private String imageFilename;
    private String iconFilename;
    private String uniqueID;
    private OtherDetails otherDetails;
    private TechnicalSpecification technicalSpecification;
    private TechnicalSpecificationDetails technicalSpecificationDetails;


    @PostConstruct
    public void init()
    {
        technicalSpecification = new TechnicalSpecification();
        technicalSpecificationDetails = new TechnicalSpecificationDetails();
        otherDetails = new OtherDetails();
        product = new Product();
        productDaoImp = new ProductDaoImp();
        productList = productDaoImp.getAllProducts();
        branchBrandDaoImp = new BranchBrandDaoImp();
        branchBrandList = branchBrandDaoImp.getAlBranchBrand();
    }

    public void addProduct()
    {
        product.setImageUrl(iconFilename);
        product.setImageLocationJson(imageFilename);
        product.setOtherDetailsJson(otherDetails.otherDetailsToJson());
        boolean result = productDaoImp.createProduct(product);
        if (result)
        {
            productList = productDaoImp.getAllProducts();
            product = new Product();
            otherDetails = new OtherDetails();
        }
        else
        {

        }
    }

    public void addTSToOrder()
    {
        technicalSpecification.setProduct(product);

        product = productDaoImp.getProduct(product.getProductId());

    }

    public void processFileUploadIcon(FileUploadEvent event) throws IOException {
        uniqueID = UUID.randomUUID().toString();
        this.uploadedFile = event.getFile();
        String[] tokens = uploadedFile.getFileName().split("\\.(?=[^\\.]+$)");
        String fileExtention = tokens[1];
        try {
            InputStream inputStream = event.getFile().getInputstream();
            iconFilename = image_location+uniqueID+"."+fileExtention;
            Path des = Paths.get(iconFilename);
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
            imageFilename = image_location+uniqueID+"."+fileExtention;
            Path des = Paths.get(imageFilename);
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
}
