package com.abid.cart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abid.cart.domain.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> , CategoryRepositoryCustom {

}
interface CategoryRepositoryCustom
{
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	//boolean delete(Category category);
}