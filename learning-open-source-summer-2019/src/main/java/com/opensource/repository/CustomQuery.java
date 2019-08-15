package com.opensource.repository;

public interface CustomQuery {

	//nativeQuery
	String USER_CHECKDUPLICATE_USERNAME = 
			"select exists(select u from User u where u.username = :username)";
	
	//nativeQuery
	String USER_CHECK_EXISTED_OTHER_ADMIN= 
			"SELECT count(*) FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id where role_name='ROLE_ADMIN'";

	String USERINFO_UPDATE_USER_INFO = 
			"update UserInfo set firstName=:firstName, lastName=:lastName, email=:email,phone=:phone where userId=:userId";
	
	//nativeQuery
	String USER_FIND_USER_ID_WITH_ROLE_ADMIN = 
			"SELECT  u.user_id FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id where role_name='ROLE_ADMIN'";
	
	String USER_UPDATE_ADMIN_LOGIN_DATA = 
			"update User set username=:username,password=:password where userID=:userID";
	
	//native
	String PRODUCT_LOAD_BY_CATEGORY = 
			"select * from product p join category c on c.category_id = p.category_id where c.category_id = :id";
	
	String CART_LOAD_LIST_PRODUCT = 
			"select cp from CartProduct cp join cp.product p join cp.cart c join c.user u where u.username =:username";
	
	String CART_CHECK_EXISTED_PRODUCT = 
			"select cp from CartProduct cp join cp.cart c join c.user u where cp.product.productId = :id and u.username =:username";
	
	String CART_UPDATE_QUANTITY = 
			"update CartProduct set quantity = (quantity + 1) where cartProductId = :id";
	
	String CART_GET_CART = 
			"select c from Cart c join c.user  u where u.username =:username";
	
	String USER_LOAD_USER_INFO = 
			"SELECT  * FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id where role_name='ROLE_MEMBER'";
	
	String USER_IS_CUSTOMER="select u.username, u.password from user u join user_role u1 on u.user_id=u1.user_id where role_id <> 1";
	
//	String INFORMATION_PAYMENT="select pr.name,ui.first_name,ui.lastname,ui.phone,p.address_receive,p.postcode,p.date_payment,p.total_price,p.status " + 
//			"from payment p join user u on p.user_id=u.user_id " + 
//			"join user_info ui on ui.user_id=u.user_id " + 
//			"join payment_product pp on pp.payment_id=p.payment_id " + 
//			"join product pr on pr.product_id=pp.product_id " + 
//			"join user_role ur on ur.user_id=u.user_id " + 
//			"where ur.role_id=2";
}
