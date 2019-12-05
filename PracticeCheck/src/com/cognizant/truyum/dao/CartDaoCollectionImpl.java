package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

/**
 * @author Prasanna
 *
 */
public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {

		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
			try {
				List<MenuItem> menuItemList = new ArrayList<MenuItem>();
				@SuppressWarnings("unused")
				Cart cart = new Cart(menuItemList, 0.0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addCartItem(long userid, long menuItemId) {
		List<MenuItem> menuItemList;
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemDaoCollectionImpl;
		Long userId = new Long(userid);
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			menuItemList = cart.getMenuItemList();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);
		} else {
			menuItemList = new CopyOnWriteArrayList<MenuItem>();
			menuItemList.add(menuItem);
			Cart cart = new Cart(menuItemList, menuItem.getPrice());
			userCarts.put(userId, cart);
		}
	}

	public List<MenuItem> getAllCartItems(long userid)
			throws CartEmptyException {
		Cart cart = userCarts.get(new Long(userid));
		if (cart == null) {
			throw new CartEmptyException("Cart is empty");
		}
		List<MenuItem> menuItemList = cart.getMenuItemList();
		if (menuItemList == null || menuItemList.size() == 0) {
			throw new CartEmptyException("Cart is empty");
		}
		double total = 0.0;
		for (MenuItem menuItem : menuItemList) {
			total = total + menuItem.getPrice();

		}
		cart.setTotal(total);
		return menuItemList;
	}

	public void removeCartItem(long userId, long menuItemId) {
		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			List<MenuItem> menuItemList = cart.getMenuItemList();
			for (MenuItem menuItem : menuItemList) {
				if (menuItem.getId() == menuItemId) {
					menuItemList.remove(menuItem);
				}
			}
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);
		}
	}
}
