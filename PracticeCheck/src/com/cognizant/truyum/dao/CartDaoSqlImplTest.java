package com.cognizant.truyum.dao;

import java.sql.SQLException;

/**
 * @author prasanna
 */
public class CartDaoSqlImplTest {
	public static void main(String args[]) throws CartEmptyException,
	SQLException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(1, 2);
		cartDaoSqlImpl.getAllCartItems(1);
		cartDaoSqlImpl.removeCartItem(1, 3);
	}
}
