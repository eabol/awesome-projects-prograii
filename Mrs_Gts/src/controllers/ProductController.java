package controllers;

import models.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    public List<ProductModel> createProductList() {
        final List<ProductModel> products = new ArrayList<ProductModel>();
        products.add(new ProductModel("Galletas", 1.50, 10));
        products.add(new ProductModel("Chocolates", 1.10, 10));
        products.add(new ProductModel("Bebida", 1.05, 10));
        products.add(new ProductModel("Bocadillo", 1.75, 10));
        return products;
    }
}
