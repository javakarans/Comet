package ir.comet.controller;

import ir.comet.database.ProductDaoImp;
import ir.comet.model.Brand;
import ir.comet.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 4/15/2017.
 */
public class ProductController {

    public double calProductPriceByDiscount(double productPrice,double discount){
        double finalPrice=productPrice-discount;
        return finalPrice;
    }
}
