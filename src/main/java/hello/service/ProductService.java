package hello.service;

import hello.dto.ProductDTO;
import hello.model.Product;
import hello.repository.ProductRepository;
import hello.utils.objectMapper.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductDTO getProductById(Integer id) {
        Optional<Product> productEntityOptional = productRepository.findById(id);
        if (productEntityOptional.isPresent()) {
            return ObjectMapper.getProductDTOFromProductEntiry(productEntityOptional.get());
        }
        return null;
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
