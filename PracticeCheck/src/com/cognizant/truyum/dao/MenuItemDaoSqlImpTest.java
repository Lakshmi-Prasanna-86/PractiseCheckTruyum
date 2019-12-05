package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * @author prasanna
 */
public class MenuItemDaoSqlImpTest {

	public static void main(String[] args) {
		testGetMenuItemsAdminSql();
		testGetMenuItemsCustomerSql();
		testModifyItems();
	}

	static void testGetMenuItemsAdminSql() {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDaoSqlImpl.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println("MenuItem Admin: " + menuItem);
		}
		System.out
		.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	static void testGetMenuItemsCustomerSql() {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDaoSqlImpl
				.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println("MenuItem Customer : " + menuItem);
		}
		System.out
		.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	static void testModifyItems() {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		try {
			MenuItem menuItem = new MenuItem(3, "Potato Chips", 100.00f, false,
					DateUtil.convertToDate("11/12/2018"), "Starters", true);
			menuItemDaoSqlImpl.modifyMenuItem(menuItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
