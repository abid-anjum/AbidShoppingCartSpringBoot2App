package com.abid.cart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abid.cart.domain.model.Cart;
import com.abid.cart.domain.model.CartLine;
import com.abid.cart.domain.model.Category;
import com.abid.cart.domain.model.OrderDetail;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long> , CartLineRepositoryCustom {

}

interface CartLineRepositoryCustom
{

	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	// updating the cart
	boolean updateCart(Cart cart);
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
	
	// adding order details
	boolean addOrderDetail(OrderDetail orderDetail);
}