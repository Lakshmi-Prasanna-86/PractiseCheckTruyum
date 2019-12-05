package com.cognizant.truyum.model;

import java.util.List;

/**
 * @author Prasanna
 *
 */
public class Cart {
	private List<MenuItem> menuItemList;
	private double total;

	public Cart() {
		super();
	}

	public Cart(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

}
