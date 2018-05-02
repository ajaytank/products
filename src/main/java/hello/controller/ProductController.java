package hello.controller;

import hello.dto.ProductDTO;
import hello.model.Product;
import hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/product")
    public String postProduct(@RequestBody Product product) {
        productService.save(product);
        return "Success!";
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }
}
