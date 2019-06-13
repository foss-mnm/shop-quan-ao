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
create table persistent_login(
	series varchar(64),
    username varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    constraint persistent_login_pk primary key (series)
);
select * from user;
select * from role where role_name = 'ROLE_ADMIN';
SELECT 
    username, password, role_name
FROM
    user u
        JOIN
    user_role ur ON u.user_id = ur.user_id
        JOIN
    role r ON ur.role_id = r.role_id;
rename table persistent_login to persistent_logins;
select * from persistent_logins;
delete from persistent_logins;
select * from hibernate_sequence;
delete from user;
delete from role;
delete from user_role;
alter table user drop column userid;
alter table role drop column roleid;
