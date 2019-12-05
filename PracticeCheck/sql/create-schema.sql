/* script to create truyum database */
CREATE DATABASE IF NOT EXISTS truyum;

/* script to create change to truyum database; */
USE truyum;

/*script to create table user */
CREATE  TABLE IF NOT EXISTS user (
  us_id INT NOT NULL AUTO_INCREMENT ,
  us_name VARCHAR(60) NOT NULL ,
  PRIMARY KEY (us_id) );

/*script to create table menu_item */  
CREATE  TABLE IF NOT EXISTS menu_item (
  me_id INT NOT NULL AUTO_INCREMENT ,
  me_name VARCHAR(100) NOT NULL ,
  me_price DECIMAL(8,2) NOT NULL ,
  me_active VARCHAR(3) NOT NULL ,
  me_date_of_launch DATE NOT NULL ,
  me_category VARCHAR(45) NOT NULL ,
  me_free_delivery VARCHAR(3) NOT NULL ,
  PRIMARY KEY (me_id) );
  
/*script to create table cart */
CREATE  TABLE IF NOT EXISTS cart (
  ct_id INT NOT NULL AUTO_INCREMENT  ,
  ct_us_id INT NOT NULL ,
  ct_pr_id INT NOT NULL ,
  PRIMARY KEY (ct_id) ,
  CONSTRAINT ct_us_id
    FOREIGN KEY (ct_us_id )
    REFERENCES user (us_id ),
  CONSTRAINT ct_pr_id
    FOREIGN KEY (ct_pr_id )
    REFERENCES menu_item (me_id ));