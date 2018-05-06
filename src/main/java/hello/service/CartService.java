package hello.service;

import hello.dto.ProductRequest;
import hello.model.Cart;
import hello.model.Product;
import hello.repository.CartRepository;
import hello.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    public void addProduct(Integer cartId, ProductRequest productRequest) {
        Cart cart = cartRepository.findById(cartId).get();
        Integer productId = productRequest.getProductId();
        Product product = productRepository.findById(productId).get();
        cart.addProduct(product);
        cartRepository.save(cart);
    }

    public Cart getCart(Integer cartId){
        Cart cart = cartRepository.findById(cartId).get();
        return cart;
    }
}
