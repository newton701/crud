package com.crud.crud.controller;


import com.crud.crud.entity.Product;
import com.crud.crud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

     @Autowired
     private ProductService service;

     @PostMapping("/addProduct")
     public Product addProduct(@RequestBody Product product)
     {
         log.info("entering to addproduct with value :{} ",product);
         return service.saveProduct(product);
     }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products)
    {
        log.info("entering to addproducts with values :{} ",products);
        return service.saveProducts(products);
    }


    @GetMapping("/products")
    public List<Product> findAllProduct()
    {
        log.info("entering into findAllProduct method in the controller....");
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id)
    {
        log.info("want to find product details by using id....");
        return service.getProductById(id);
    }


    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name)
    {
        log.info("want to find product details by using name....");
        return service.getProductByName(name);
    }


    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
        log.info("update the product....");
        return service.updateProduct(product);
    }


    @DeleteMapping ("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        log.info("delete a product by using id....");
        return service.deleteProduct(id);
    }


}
