package com.abid.cart.domain.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.abid.cart.domain.model.Address;
import com.abid.cart.domain.model.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	Session session = null;

	@PostConstruct
	public void init() {
		entityManager=entityManager.getEntityManagerFactory().createEntityManager();
		session = (Session) entityManager.unwrap(Session.class);	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			return session.createQuery(selectQuery, User.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception ex) {
			return null;
		}

	}

	@Override
	public boolean add(User user) {
		try {
			session.persist(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			// will look for this code later and why we need to change it
			session.persist(address);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			session.update(address);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return session.createQuery(selectQuery, Address.class).setParameter("userId", userId)
				.setParameter("isShipping", true).getResultList();

	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		try {
			return session.createQuery(selectQuery, Address.class)
					.setParameter("userId", userId).setParameter("isBilling", true).getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public User get(int id) {
		try {
			return session.get(User.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public Address getAddress(int addressId) {
		try {
			return session.get(Address.class, addressId);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
