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


----------cars table--------
----------------------------
create table cars(
	available_cars(30)
);
insert into cars(available_cars)values('MARUTHI CELERIO')
insert into cars(available_cars)values('MARUTHI S-CROSS')
insert into cars(available_cars)values('MARUTHI VITARA BREZZA')

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
);
create sequence booking_id_sequence start 1001 increment 1;


-----services table--------
create table services(
service_id serial primary key,
	service_name varchar(50) not null,
	service_charge int not null
);
create sequence service_id_sequence start 100 increment 1 owned by services.service_id;
insert into services(service_id,service_name, service_charge)values(nextval('service_id_sequence'),'CAR MACHINE POLISH', 3999);
insert into services(service_id,service_name, service_charge)values(nextval('service_id_sequence'),'DENT REMOVAL', 1999);
insert into services(service_id,service_name, service_charge)values(nextval('service_id_sequence'),'OIL SERVICE', 2999);


----------service center table----------
----------------------------------------
create table service_centers_db(
	center_name varchar(100),
	location varchar(50)
);
insert into service_centers_db(center_name, location)values('auto barrack service station', 'chennai'); 
insert into service_center_db(center_name, location)values('automech car service station', 'chennai');
insert into service_center_db(center_name, location)values('abcd car service center', 'chennai');