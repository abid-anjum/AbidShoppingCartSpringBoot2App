package com.abid.cart.domain.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.abid.cart.domain.model.Category;

public class CategoryRepositoryImpl implements CategoryRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
	Session session = null;

	@PostConstruct
	public void init()
	{
        //session = entityManager.unwrap(Session.class);
	}
	
	@Override
	public List<Category> list() {
				
        session = entityManager.unwrap(Session.class);

		String selectActiveCategory = "FROM Category WHERE active = :active";
				
		Query query = session.createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
								
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Category get(int id) {

		return session.get(Category.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(Category category) {

		try {
			// add the category to the database table
			session.persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Category category) {

		try {
			// add the category to the database table
			session.update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
