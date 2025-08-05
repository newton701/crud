package com.example.crud.demo.crud.service;

import com.example.crud.demo.crud.entity.Product;
import com.example.crud.demo.crud.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository repository;


    /**
     * This method use for save the the product details into database
     * @param product
     * @return product details
     */

    public Product saveProduct(Product product) {
        return repository.save(product);
    }


    /**
     * This method use for save the all the product details into database
     * @param products
     * @return  list of product details
     */

    public List<Product> saveProducts(List<Product> products)
    {
        log.info("entering to add-products with values in service class : {}",products);

        log.info("try t get product name: {}",products.get(0).getName());

        log.info("try to get product name and Qty: {} {}",products.get(0).getName(),products.get(0).getQuantity());

        log.info("looking for name of the product {} with price  : {}",products.get(0).getName(),products.get(0).getPrice());
        return repository.saveAll(products);
    }


    /**
     * this method is used for get all the products details from my database
     * @return the list of products
     */
    public List<Product> getProducts()
    {
        log.info("entering to get getProducts method service class ");
        log.warn(" marking warn part");
        log.error("error ");
        return repository.findAll();
    }

    /**
     * This method is used for getting the product details by my id
     * (if you put the product id then it will show you that preferred id column details
     * @param id
     * @return the details of that id which i need
     */

    public Product getProductById(int id)
    {
        log.info("i need the information by id : {}",id);
        return repository.findById(id).orElse(null);
    }


    /**
     * this method is used to getting the product details by my name
     * (if you put the product name then it will show you that preferred name column details
     * @param name
     * @return the details of that name which i need
     */
    public Product getProductByName(String name)
    {
        log.info("i need the information by name : {}",name);
        return repository.findByName(name);
    }


    /**
     * This method is used to delete the product by using the id because id is my primary key
     * @param id
     * @return the delete part
     */
    public String deleteProduct(int id)
    {
        log.info("the deleted item product is is : {}",id);
        repository.deleteById(id);
        return "product removed !! " + id;
    }


    /**
     * This method is used to update the product
     * @param product
     * @return updated item
     */
    public Product updateProduct(Product product)
    {
        log.info("my updated product is : {}",product);
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}
