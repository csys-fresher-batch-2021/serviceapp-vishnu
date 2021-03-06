------user details table-----
--------------------------------
create table user_details(
	first_name varchar(20),
	last_name varchar(20),
	contact bigint,
	email varchar(50),
	password varchar(50)
);
alter table user_details add column user_id serial primary key;

insert into user_details(first_name, last_name, contact, email, password)
values('jacob', 'james', 9879564356, 'jacob@gmail.com', 'jacobjames123')
insert into user_details(first_name, last_name, contact, email, password)
values('rahul', 'raj', 9879564359, 'rahul@gmail.com', 'rahulraj123')

-------Admin details table-----
--------------------------------
create table admin_details(
	s_no serial not null primary Key,
	admin_email varchar(100) not null unique,
	admin_password varchar(100) not null
);

insert into admin_details(admin_email, admin_password)values('admin123@gmail.com', 'admin1234')


----------cars table--------
----------------------------
create table cars(
	available_cars(30)
);
insert into cars(available_cars)values('MARUTHI CELERIO')
insert into cars(available_cars)values('MARUTHI S-CROSS')
insert into cars(available_cars)values('MARUTHI VITARA BREZZA')



-----services table--------
create table services(
service_id serial primary key,
	service_name varchar(50) not null,
	service_charge int not null
);

insert into services(service_id,service_name, service_charge)values(DEFAULT,'CAR MACHINE POLISH', 3999);
insert into services(service_id,service_name, service_charge)values(DEFAULT,'DENT REMOVAL', 1999);
insert into services(service_id,service_name, service_charge)values(DEFAULT,'OIL SERVICE', 2999);

---booking details table------
---------------------------------
create table booking_details(
booking_id serial primary key,
	email_id varchar(50) not null,
	car_name varchar(50) not null,
	registration_no varchar(50) not null,
	service_type varchar(50) not null,
	service_center varchar(50) not null,
	booking_status varchar(50),
	booking_date date default current_date,
	booking_time time default current_time
	delivery_date varchar(35)
);


------service center table-----
-----------------------------------
create table service_centers(
    id serial primary key,
	center_name varchar(100),
	location varchar(50),	
	unique (center_name,location)
	);
insert into service_centers(center_name, location)values('auto barrack service station', 'chennai'); 
insert into service_centers(center_name, location)values('automech car service station', 'chennai');
insert into service_centers(center_name, location)values('abcd car service center', 'chennai');


----service rating table------
------------------------------
create table service_ratings(
id serial primary key,
service_center_id int not null,
booking_detail_id int not null,
rating int not null,
created_date timestamp not null default current_timestamp,
foreign key ( service_center_id) references services_centers(id),
foreign key ( booking_detail_id) references booking_details(id)
);