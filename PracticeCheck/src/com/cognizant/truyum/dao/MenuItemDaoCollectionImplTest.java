package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * @author Prasanna
 *
 */
public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		System.out.println("Menu Item LIst: "
				+ menuItemDaoSqlImpl.getMenuItemListAdmin());
		List<MenuItem> menuItems = menuItemDaoSqlImpl.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem.toString());
		}
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		System.out.println("Menu Item LIst: "
				+ menuItemDaoSqlImpl.getMenuItemListCustomer());
		List<MenuItem> menuItems = menuItemDaoSqlImpl.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem.toString());
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem menuItem = new MenuItem(2, "Cake", 129.00f, true,
				DateUtil.convertToDate("11/12/2019"), "Main Course", false);
		MenuItemDaoCollectionImpl menuItemCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemCollectionImpl;
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println("Modified MeniItem details are: "
				+ menuItemDao.getMenuItem(2));
	}
}
