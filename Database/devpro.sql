create table product(
product_id	int	 auto_increment,
product_name	nvarchar(100)	not null,
product_price	nvarchar(50)	not null,
product_discount	nvarchar(5)	,
product_image	nvarchar(150)	,
product_rate	nvarchar(5)	,
product_description	nvarchar(200),	
product_warranty	nvarchar(200),	
product_created_date	nvarchar(20)	not null,
product_buyed	bit	not null,
product_expired_date	nvarchar(20)	not null,
constraint product_pk primary key (product_id) 
);

drop table product;
insert into product(product_name,product_price,product_discount,product_image,product_rate,product_description,product_warranty,
product_created_date,product_buyed,product_expired_date)value('dsa','dasd','dasd','dasd','dsad','dasd','dasd','sadsd',1,'dasd');
update product set product_name='set',product_price='set',product_discount='set',product_image='set',
product_rate='set',product_description='set',
product_warranty='set',product_created_date='set',product_buyed=1,product_expired_date='set' where product_id='2';
select * from product;

