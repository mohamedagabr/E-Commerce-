package com.gabr.e_commerce.service;

import com.gabr.e_commerce.dto.CartDto;
import com.gabr.e_commerce.exception.ResourseNotFound;
import com.gabr.e_commerce.mapper.CartMapper;
import com.gabr.e_commerce.model.Cart;
import com.gabr.e_commerce.model.User;
import com.gabr.e_commerce.repository.CartRepository;
import com.gabr.e_commerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

  public CartDto addProductToCart(int productId){
      User user = getCurrentUser();
      if(user.getCart() == null){   // if cart not exist then create it and put it in user
          Cart cart = new Cart();
          cart.setUser(user);
          cartRepository.save(cart);    // Make Relationship by Direciton
          user.setCart(cart);
      }
      Cart cart = user.getCart();
      cart.getProducts().add(productRepository.findById(productId)
              .orElseThrow(()->new ResourseNotFound("Product with Id ("+productId+") Not Found")));
      Cart saved = cartRepository.save(cart);
      return cartMapper.toDto(saved);

  }
  public CartDto getCart(){
      User user = getCurrentUser();
      if(user.getCart() == null){
          Cart cart = new Cart();
          cart.setUser(user);
          cartRepository.save(cart);
          user.setCart(cart);
      }
      return cartMapper.toDto(user.getCart());
  }



    private User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
