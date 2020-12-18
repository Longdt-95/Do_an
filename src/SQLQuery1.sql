
drop database QuanLyThuVien;

create database QuanLyThuVien;



use QuanLyThuVien;


create table Category (
	category_id int identity(1,1) primary key,
	category_name nvarchar(255)
)

create table Book (
	book_id int identity(1,1) primary key,
	title nvarchar(155),
	author nvarchar(155),
	amount int,
	introduce nvarchar(155),
	category_id int foreign key references Category(category_id)
)

create table Users (
	user_id int identity(1,1) primary key,
	name nvarchar(155),
	phone nvarchar(155),
	level int,
	username varchar(155),
	password varchar(155),
	status int
)

create table Reader (
	reader_id int identity(1,1) primary key,
	name nvarchar(155),
	address nvarchar(255),
	email varchar(155),
	phone varchar(155)
)

create table Bill (
	bill_id int identity(1,1) primary key,
	reader_id int foreign key references Reader(reader_id),
	user_id int foreign key references Users(user_id),
	deposit nvarchar(155),
	date varchar(155),
	date_hen varchar(155)
)

create table bill_detail (
	bill_detail_id int identity(1,1) primary key,
	book_id int foreign key references Book(book_id),
	bill_id int foreign key references Bill(bill_id),
	date_pay varchar(155),
	fined varchar(155)
)