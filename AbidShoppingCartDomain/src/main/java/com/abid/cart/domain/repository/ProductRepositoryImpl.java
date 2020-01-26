package com.abid.cart.domain.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.abid.cart.domain.model.Product;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	Session session = null;

	@PostConstruct
	public void init() {
		entityManager=entityManager.getEntityManagerFactory().createEntityManager();
		session = (Session) entityManager.unwrap(Session.class);	}

	/*
	 * SINGLE
	 */

	@Override
	public Product get(int productId) {
		try {
			return session.get(Product.class, Integer.valueOf(productId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 * LIST
	 */

	@Override
	public List<Product> list() {
		return session.createQuery("FROM Product", Product.class).getResultList();
	}

	/*
	 * INSERT
	 */
	@Override
	public boolean add(Product product) {
		try {
			session.persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/*
	 * UPDATE
	 */
	@Override
	public boolean update(Product product) {
		try {
			session.update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return session.createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return session.createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return session
				.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

	@Override
	public List<Product> getProductsByParam(String param, int count) {

		String query = "FROM Product WHERE active = true ORDER BY " + param + " DESC";

		return session.createQuery(query, Product.class).setFirstResult(0)
				.setMaxResults(count).getResultList();

	}

}
