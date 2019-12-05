package com.cognizant.truyum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

@WebServlet("/ShowEditMenuItemServlet")
public class ShowEditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditMenuItemServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		MenuItemDao menuItemDao = menuItemDaoSqlImpl;
		String menuItemId = request.getParameter("menuItemId");
		long menuitemId = Long.parseLong(menuItemId);
		MenuItem menuItem = menuItemDao.getMenuItem(menuitemId);
		System.out.println("Menu Item=" + menuItem);
		request.setAttribute("menuItem", menuItem);
		request.getRequestDispatcher("edit-menu-item.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
