package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * @author Prasanna
 *
 */
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		super();
		if (menuItemList == null) {
			try {
				menuItemList = new ArrayList<MenuItem>();
				menuItemList.add(new MenuItem(1, "Sandwich", 99.00f, true,
						DateUtil.convertToDate("15/03/2017"), "Main Course",
						true));
				menuItemList.add(new MenuItem(2, "Burger", 129.00f, true,
						DateUtil.convertToDate("23/12/2017"), "Main Course",
						false));
				menuItemList.add(new MenuItem(3, "Pizza", 149.00f, true,
						DateUtil.convertToDate("21/08/2018"), "Main Course",
						false));
				menuItemList
				.add(new MenuItem(4, "French Fries", 57.00f, false,
						DateUtil.convertToDate("02/07/2017"),
						"Starters", true));
				menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.00f,
						true, DateUtil.convertToDate("02/11/2022"), "Dessert",
						true));
			} catch (ParseException pe) {
				System.out.println("ParseException " + pe.getMessage());
			}
		}
	}

	public List<MenuItem> getMenuItem() {
		return menuItemList;
	}

	public void setMenuItem(List<MenuItem> menuItem) {
		this.menuItemList = menuItem;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemListCust = new ArrayList<MenuItem>();
		Date today = new Date();
		for (MenuItem menuitem : menuItemList) {
			if (menuitem.getDateOfLaunch().getTime() <= today.getTime()
					&& menuitem.isActive()) {
				menuItemListCust.add(menuitem);
			}
		}
		return menuItemListCust;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem menuitem : menuItemList) {
			if (menuItem.getId() == menuitem.getId()) {
				menuitem.setName(menuItem.getName());
				menuitem.setCategory(menuItem.getCategory());
				menuitem.setDateOfLaunch(menuItem.getDateOfLaunch());
				menuitem.setFreeDelivery(menuItem.isFreeDelivery());
				menuitem.setPrice(menuItem.getPrice());
				menuitem.setActive(menuItem.isActive());
			}
		}
	}

	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem mi : menuItemList) {
			if (menuItemId == mi.getId()) {
				return mi;
			}
		}
		return null;
	}
}
