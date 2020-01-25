package com.abid.cart.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.abid.cart.domain.model.Cart;
import com.abid.cart.domain.model.OrderDetail;

public class CartLineRepositoryImpl implements CartLineRepositoryCustom {

	@Override
	public List<CartLineRepository> list(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartLineRepository get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(CartLineRepository cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CartLineRepository cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(CartLineRepository cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CartLineRepository getByCartAndProduct(int cartId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CartLineRepository> listAvailable(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return false;
	}

}
