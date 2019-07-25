create database clothes_shop;
use clothes_shop;
create table user(
	user_id bigint auto_increment,
    username varchar(64) not null,
    password varchar(128) not null,
    enabled bit not null,
    constraint user_pk primary key (user_id),
    constraint user_uk unique (username)
);
create table role(
	role_id bigint auto_increment,
    role_name varchar(30) not null,
    constraint role_pk primary key (role_id),
    constraint role_uk unique (role_name)
);
create table user_role(
	id bigint auto_increment,
    user_id bigint,
    role_id bigint,
    constraint user_role_pk primary key (id),
    constraint user_role_fk1 foreign key (user_id) references user(user_id),
    constraint user_role_fk2 foreign key (role_id) references role(role_id)
);
create table persistent_logins(
	series varchar(64),
    username varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    constraint persistents_login_pk primary key (series)
);
create table provider(
	provider_id bigint auto_increment,
    name nvarchar(255) not null,
    address varchar(125),
    phone varchar(25),
    email varchar(50),
    constraint provider_pk primary key (provider_id)
);
create table import(
	import_id bigint auto_increment,
    import_date varchar(25),
    total_price  varchar(10),
    constraint import_pk primary key (import_id)
);
create table user_info(
	user_id bigint,
    email varchar(50),
    phone varchar(25),
    first_name varchar(50),
    lastname varchar(50),
    image varchar(125),
    constraint user_info_pk primary key (user_id),
    constraint user_info_fk foreign key (user_id) references user (user_id)
);
create table cart(
	cart_id bigint auto_increment,
    quantity varchar(10),
    user_id bigint not null,
    constraint cart_pk primary key (cart_id),
    constraint cart_fk foreign key (user_id) references user(user_id)
);
create table payment(
	payment_id bigint auto_increment,
    total_price float,
    date_payment date,
    address_receive varchar(125),
    quantity int,
    postcode varchar(10),
    user_id bigint,
    constraint payment_pk primary key (payment_id),
    constraint payment_fk foreign key (user_id) references user(user_id)
);
create table category(
	category_id bigint auto_increment,
    name varchar(125),
    constraint category_pk primary key (category_id)
);
create table product(
	product_id bigint auto_increment,
    name varchar(125) not null,
    size varchar(25) not null,
    price float(25) not null,
    description varchar(1000),
<<<<<<< HEAD
    discount_amount float,
=======
>>>>>>> 08cad6b1b3a8ea9cc7ec4a0e7e2cde560ba8864e
    quantity varchar(10),
    image varchar(125),
    provider_id bigint,
    category_id bigint,
    constraint product_pk primary key (product_id),
    constraint product_fk1 foreign key (provider_id) references provider(provider_id),
    constraint product_fk2 foreign key (category_id) references category(category_id)
);
insert into product(name,size,price,description,quantity,image,provider_id,category_id) 
values ('Quần Jeans','30',300000,'Made in Vietnam',10,'',1,null);
create table import_product(
	import_id bigint,
    product_id bigint,
    constraint import_product_pk primary key (import_id,product_id),
    constraint import_product_fk foreign key (import_id) references import(import_id),
    constraint import_product_fk2 foreign key (product_id) references product(product_id)
);
create table cart_product(
	cart_id bigint,
    product_id bigint,
    constraint cart_product_pk primary key (cart_id,product_id),
    constraint cart_product_fk foreign key (cart_id) references cart(cart_id),
    constraint cart_product_fk2 foreign key (product_id) references product(product_id)
);
create table payment_product(
	payment_id bigint,
    product_id bigint,
    constraint payment_product_pk primary key (payment_id,product_id),
    constraint payment_product_fk foreign key (payment_id) references payment(payment_id),
    constraint payment_product_fk2 foreign key (product_id) references product(product_id)
);


-- ==================================================
delete from user_role;
delete from role;
delete from user;
-- ==================================================
select * from user;
select * from user_role;
select * from role;
-- ==================================================
SELECT  u.user_id FROM user u JOIN user_role ur ON u.user_id = ur.user_id JOIN role r ON ur.role_id = r.role_id where role_name='ROLE_ADMIN';
-- ==================================================
select * from persistent_logins;
-- ==================================================
select * from user_info;
delete from user_info;
insert into user_info values(59,'phamdaiyb98@gmail.com','0325808383','Đại','Phạm','');
insert into provider(name,address,phone,email) 
values('Công ty TNHH Hải Thành','Hà Nội','0123456789','haithanh@gmail.com'),
('Công ty TNHHMTV Nam Lan','Bắc Ninh','0838367467','namlan@yahoo.com.vn'),
('Công ty may mặc và dày da Sài Gòn','TP. Hồ Chí Minh','0583658356','saigonmay@gmail.com'),
('Tổng công ty may Hà Nội','Hà Nội','0547463836','hanoimay@yahoo.com.vn');
select * from provider;

