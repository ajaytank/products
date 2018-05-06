package hello.controller;

import hello.dto.ProductRequest;
import hello.model.Cart;
import hello.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/cart/{cartId}")
    public void addProduct(@PathVariable("cartId") Integer cartId, @RequestBody ProductRequest productRequest) {
        cartService.addProduct(cartId, productRequest);
    }

    @GetMapping("/cart/{cartId}")
    public Cart getCart(@PathVariable("cartId") Integer cartId) {
        return cartService.getCart(cartId);
    }
}
