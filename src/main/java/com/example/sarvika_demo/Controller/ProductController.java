package com.example.sarvika_demo.Controller;

import com.example.sarvika_demo.Entity.Product;
import com.example.sarvika_demo.Service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/products")
@Tag(name = "Product Controller", description = "Product management APIs")
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "Get all products", description = "Retrieve a list of all products")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping("/get")
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    @Operation(summary = "Get product by ID", description = "Retrieve a product by its unique ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved student")
    @ApiResponse(responseCode = "404", description = "Student not found")
    @GetMapping("get/{id}")
    public Product getProductById(@Parameter(description = "ID of the student to retrieve") @PathVariable int id){
        return productService.getProductById(id);
    }

    @Operation(summary = "Add a new product", description = "Create a new product entry")
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @Operation(summary = "Update a product", description = "Update an existing product")
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @Operation(summary = "Delete a product", description = "Delete a product by its ID")
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

}
