//package ir.comet.wrapper;
//
//import ir.comet.model.Product;
//import ir.comet.model.ProductOrderDetail;
//
///**
// * Created by Mohammad on 4/24/2017.
// */
//public class UserProductCart {
//
//    private Product product;
//    private ProductOrderDetail productOrderDetail;
//
//    public UserProductCart(Product product){
//        this.product=product;
//        productOrderDetail =new ProductOrderDetail();
//        fillProductCart();
//        totalPrice();
//        calTotalPriceAfterDiscount();
//
//    }
//
//    public void calTotalPriceAfterDiscount(){
//        System.out.println(productOrderDetail.getQuantity());
//        long price = product.getPrice();
//        long discount = product.getDiscount();
//        long totalPrice=(price-discount)* productOrderDetail.getQuantity();
//        productOrderDetail.setTotalPriceAfterDiscountAndTax(totalPrice);
//    }
//
//    public void totalPrice(){
//        long price = product.getPrice();
//        int quantity = productOrderDetail.getQuantity();
//        productOrderDetail.setTotalPrice(price*quantity);
//    }
//
//    public long calPriceByDiscount(){
//        long price = product.getPrice();
//        long discount = product.getDiscount();
//        return (price-discount);
//    }
//
//    private void fillProductCart(){
//        productOrderDetail.setProductId(product.getProductId());
//        productOrderDetail.setQuantity(1);
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public ProductOrderDetail getProductOrderDetail() {
//        return productOrderDetail;
//    }
//
//    public void setProductOrderDetail(ProductOrderDetail productOrderDetail) {
//        this.productOrderDetail = productOrderDetail;
//    }
//}
