/* 1.	View Menu Item List Admin (TYUC001)
   a.	Frame insert scripts to add data into menu_item table.*/
 
  insert into menu_item values(1,'sandwitch','99.00','yes','2017-03-15','main course','yes');
  insert into menu_item values(2,'burger','129.00','yes','2017-12-23','main course','no');
  insert into menu_item values(3,'pizza','149.00','yes','2017-08-21','main course','no');
  insert into menu_item values(4,'french fries','57.00','no','2017-07-02','starters','yes');
  insert into menu_item values(5,'choclate brownie','32.00','yes','2022-11-02','dessert','yes');

/* b.	Frame SQL query to get all menu items */

  select * from menu_item;

/* 2.	View Menu Item List Customer (TYUC002)
   a.	Frame SQL query to get all menu items which after launch date and is active.*/

  select * from menu_item  where me_date_of_launch<=now() and me_active='yes';


/* 3.	Edit Menu Item (TYUC003)
   a.	Frame SQL query to get a menu items based on Menu Item Id */

   select * from menu_item where me_id=1;

/* b.	Frame update SQL menu_items table to update all the columns values based on Menu Item Id */
   
   update menu_item set me_name='cake',me_price='55.00',me_active='no',me_date_of_launch='2019-05-10',me_category='starters' where me_id=3;

/*4.	Add to Cart (TYUC004) */

  insert into cart values(1,1,1);
  insert into cart values(2,1,3);
  insert into cart values(3,1,5);

/* 5.	View Cart (TYUC005)
   a.	Frame SQL query to get all menu items in a particular user’s cart */

  select * from menu_item inner join cart on menu_item.me_id=cart.ct_pr_id and cart.ct_us_id=1;

/* b.	Frame SQL query to get the total price of all menu items in a particular user’s cart */

  select SUM(me_price) from menu_item inner join cart on menu_item.me_id=cart.ct_pr_id and cart.ct_us_id=1;

/* 6.	Remove Item from Cart (TYUC006)
   a.	Frame SQL query to remove a menu items from Cart based on User Id and Menu Item Id */

   delete from cart where ct_us_id=1 and ct_pr_id=1;