package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet("/EditMenuItemServlet")
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditMenuItemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		MenuItemDao menuItemDao = menuItemDaoSqlImpl;
		long id = Long.parseLong(request.getParameter("menuId"));
		String name = request.getParameter("itemName");
		double price = Double.parseDouble(request.getParameter("price"));
		String active = request.getParameter("active");
		boolean activeFlag;
		if (active.equals("yes")) {
			activeFlag = true;
		} else {
			activeFlag = false;
		}
		String category = request.getParameter("itemType");
		boolean freeDelivery = request.getParameter("freedelivery") != null;
		String dol = request.getParameter("date");
		MenuItem menuItem = new MenuItem();
		menuItem.setId(id);
		menuItem.setName(name);
		menuItem.setPrice((float) price);
		menuItem.setActive(activeFlag);
		menuItem.setCategory(category);
		menuItem.setFreeDelivery(freeDelivery);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateOfLaunch = sdf.parse(dol);
			menuItem.setDateOfLaunch(dateOfLaunch);
			menuItemDao.modifyMenuItem(menuItem);
			response.sendRedirect("edit-menu-item-status.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(menuItem);
	}

}
