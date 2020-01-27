package com.abid.cart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abid.cart.domain.model.Address;
import com.abid.cart.domain.model.Product;
import com.abid.cart.domain.model.security.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> , UserRepositoryCustom{

}
interface UserRepositoryCustom
{

	// user related operation
	User getByEmail(String email);
	User get(int id);

	boolean add(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	

	
}
