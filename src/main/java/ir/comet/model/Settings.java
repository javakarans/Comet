package ir.comet.model;


public class Settings {
    private long idOfFirstSlide;
    private long idOfSecondSlide;
    private long idOfThirdSlide;
    private long idOfFourthSlide;
    private String locationsOfSlide;
    private String locationsOFIconProduct;
    private String locationsOfImageProduct;
    private String adminUsername;
    private String adminPassword;

    public long getIdOfFirstSlide() {
        return idOfFirstSlide;
    }

    public void setIdOfFirstSlide(long idOfFirstSlide) {
        this.idOfFirstSlide = idOfFirstSlide;
    }

    public long getIdOfSecondSlide() {
        return idOfSecondSlide;
    }

    public void setIdOfSecondSlide(long idOfSecondSlide) {
        this.idOfSecondSlide = idOfSecondSlide;
    }

    public long getIdOfThirdSlide() {
        return idOfThirdSlide;
    }

    public void setIdOfThirdSlide(long idOfThirdSlide) {
        this.idOfThirdSlide = idOfThirdSlide;
    }

    public long getIdOfFourthSlide() {
        return idOfFourthSlide;
    }

    public void setIdOfFourthSlide(long idOfFourthSlide) {
        this.idOfFourthSlide = idOfFourthSlide;
    }

    public String getLocationsOfSlide() {
        return locationsOfSlide;
    }

    public void setLocationsOfSlide(String locationsOfSlide) {
        this.locationsOfSlide = locationsOfSlide;
    }

    public String getLocationsOFIconProduct() {
        return locationsOFIconProduct;
    }

    public void setLocationsOFIconProduct(String locationsOFIconProduct) {
        this.locationsOFIconProduct = locationsOFIconProduct;
    }

    public String getLocationsOfImageProduct() {
        return locationsOfImageProduct;
    }

    public void setLocationsOfImageProduct(String locationsOfImageProduct) {
        this.locationsOfImageProduct = locationsOfImageProduct;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
