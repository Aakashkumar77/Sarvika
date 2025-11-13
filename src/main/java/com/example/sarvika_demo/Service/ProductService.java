package com.example.sarvika_demo.Service;

import com.example.sarvika_demo.Entity.Product;
import com.example.sarvika_demo.Exception.ProductNotFoundException;
import com.example.sarvika_demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
//        Product p1 = new Product(1,"Washing Machine","Samsung Product",20000);
//        Product p2 = new Product(2,"Television","Sony", 500000);
//        return List.of(p1,p2);
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    public Product addProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public Product updateProduct(Product product){
        return productRepository.saveAndFlush(product);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
