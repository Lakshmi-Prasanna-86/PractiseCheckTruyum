package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author Prasanna
 *
 */
public interface CartDao {
	public void addCartItem(long userId, long menuItemId);

	public void removeCartItem(long userId, long menuItemId);

	List<MenuItem> getAllCartItems(long userid) throws CartEmptyException;
}
