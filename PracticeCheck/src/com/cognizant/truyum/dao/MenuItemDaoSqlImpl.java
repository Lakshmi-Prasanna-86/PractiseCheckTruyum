package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author prasanna
 */
public class MenuItemDaoSqlImpl implements MenuItemDao {
	@SuppressWarnings("static-access")
	public List<MenuItem> getMenuItemListAdmin() {
		ConnectionHandler ch = new ConnectionHandler();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ResultSet resultSet;
		boolean activeFlag, freeDeliveryFlag;
		try {
			conn = ch.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select me_id,me_name,me_active,me_date_of_launch,me_price,me_category,me_free_delivery from menu_item");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int id = resultSet.getInt("me_id");
					String name = resultSet.getString("me_name");
					Date dateOfLaunch = resultSet.getDate("me_date_of_launch");
					String active = resultSet.getString("me_active");
					float price = resultSet.getFloat("me_price");
					String category = resultSet.getString("me_category");
					String freeDelivery = resultSet
							.getString("me_free_delivery");
					if (freeDelivery != null && freeDelivery.equals("yes")) {
						freeDeliveryFlag = true;
					} else {
						freeDeliveryFlag = false;
					}
					if (active != null && active.equals("yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					MenuItem menuItem = new MenuItem(id, name, price,
							activeFlag, dateOfLaunch, category,
							freeDeliveryFlag);
					menuItemList.add(menuItem);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return menuItemList;
	}

	@SuppressWarnings("static-access")
	public List<MenuItem> getMenuItemListCustomer() {
		ConnectionHandler ch = new ConnectionHandler();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ResultSet resultSet;
		boolean activeFlag, freeDeliveryFlag;
		try {
			conn = ch.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select * from menu_item where me_date_of_launch <= now() and me_active='yes'");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					Date dateOfLaunch = resultSet.getDate(5);
					String active = resultSet.getString(4);
					float price = resultSet.getFloat(3);
					String category = resultSet.getString(6);
					String freeDelivery = resultSet.getString(7);
					if (freeDelivery != null && freeDelivery.equals("yes")) {
						freeDeliveryFlag = true;
					} else {
						freeDeliveryFlag = false;
					}
					if (active != null && active.equals("yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					MenuItem menuItem = new MenuItem(id, name, price,
							activeFlag, dateOfLaunch, category,
							freeDeliveryFlag);
					menuItemList.add(menuItem);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return menuItemList;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		Connection conn = ConnectionHandler.getConnection();
		String sql = "update menu_item set me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_free_delivery=?,me_category=? where me_id=?";
		try {
			if (conn != null) {
				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);
				preparedStatement.setString(1, menuItem.getName());
				preparedStatement.setFloat(2, menuItem.getPrice());
				if (menuItem.isActive()) {
					preparedStatement.setString(3, "yes");
				} else {
					preparedStatement.setString(3, "No");
				}
				preparedStatement.setDate(4, new java.sql.Date(menuItem
						.getDateOfLaunch().getTime()));

				if (menuItem.isFreeDelivery()) {
					preparedStatement.setString(5, "yes");
				} else {
					preparedStatement.setString(5, "No");
				}
				preparedStatement.setString(6, menuItem.getCategory());
				preparedStatement.setLong(7, menuItem.getId());
				preparedStatement.executeUpdate();

			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public MenuItem getMenuItem(long menuItemId) {
		ConnectionHandler ch = new ConnectionHandler();
		@SuppressWarnings("static-access")
		Connection connection = ch.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		MenuItem menuItem = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from menu_item where me_id=?");
				preparedStatement.setLong(1, menuItemId);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, freeDeliveryFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					String name = resultSet.getString(2);
					float price = resultSet.getFloat(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
					String category = resultSet.getString(6);
					String freeDelivery = resultSet.getString(7);
					if (active != null && active.equals("yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (freeDelivery != null && freeDelivery.equals("yes"))
						freeDeliveryFlag = true;
					else
						freeDeliveryFlag = false;
					menuItem = new MenuItem(menuItemId, name, price,
							activeFlag, date_of_launch, category,
							freeDeliveryFlag);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return menuItem;
	}
}
