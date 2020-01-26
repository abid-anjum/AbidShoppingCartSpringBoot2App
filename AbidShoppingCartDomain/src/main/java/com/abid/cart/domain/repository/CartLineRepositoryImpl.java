package com.abid.cart.domain.repository;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.abid.cart.domain.model.Cart;
import com.abid.cart.domain.model.CartLine;
import com.abid.cart.domain.model.OrderDetail;

public class CartLineRepositoryImpl implements CartLineRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	Session session = null;

	
	@PostConstruct
	public void init() {
		entityManager=entityManager.getEntityManagerFactory().createEntityManager();
		session = (Session) entityManager.unwrap(Session.class);
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		try {

			return session.createQuery(query, CartLine.class).setParameter("cartId", cartId)
					.setParameter("productId", productId).getSingleResult();

		} catch (Exception ex) {
			return null;
		}

	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			session.persist(cartLine);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			session.update(cartLine);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartLine cartLine) {
		try {
			session.delete(cartLine);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public List<CartLine> list(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId";
		return session.createQuery(query, CartLine.class).setParameter("cartId", cartId)
				.getResultList();
	}

	@Override
	public CartLine get(int id) {
		return session.get(CartLine.class, Integer.valueOf(id));
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			session.update(cart);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return session.createQuery(query, CartLine.class).setParameter("cartId", cartId)
				.setParameter("available", true).getResultList();
	}

	@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		try {
			session.persist(orderDetail);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
