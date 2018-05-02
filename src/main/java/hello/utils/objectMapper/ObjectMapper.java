package hello.utils.objectMapper;

import hello.dto.ProductDTO;
import hello.model.Product;

public class ObjectMapper {

    public static ProductDTO getProductDTOFromProductEntiry(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
