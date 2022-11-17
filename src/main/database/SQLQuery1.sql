create database DuAn1_CuaHangDienThoai
go
use DuAn1_CuaHangDienThoai
go
CREATE TABLE Hang(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma VARCHAR(10) NOT NULL,
	TenHang NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang DongSp
CREATE TABLE DongSP(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma VARCHAR(10) NOT NULL,
	TenDongSP NVARCHAR(50) NOT NULL,
	GiaNhap BIGINT NOT NULL,
	GiaBan BIGINT NOT NULL,
	IdHang int NOT NULL FOREIGN KEY REFERENCES dbo.Hang(Id),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang CoSo
CREATE TABLE CoSo(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma VARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang CuaHang
create TABLE CuaHang(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma VARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	DiaChi NVARCHAR(MAX) NOT NULL,
	IdCoSo int NOT NULL FOREIGN KEY REFERENCES dbo.CoSo(Id),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang DungLuong
CREATE TABLE DungLuong(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma VARCHAR(10) NOT NULL,
	Ten NVARCHAR(10) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang MauSac
CREATE TABLE MauSac(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma VARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang LoaiSanPham
create table LoaiSanPham(
	Id int identity(1,1) not null primary key,
	Ma varchar(10) not null,
	IdDongSp int FOREIGN KEY REFERENCES DongSP(Id),
	IdMauSac int FOREIGN KEY REFERENCES MauSac(Id),
	IdDungLuong int FOREIGN KEY REFERENCES DungLuong(Id),
	TrangThai bit,
	NgayTao Date,
	NgaySua Date
)
-- Tao bang ChiTietSP
CREATE TABLE ChiTietSP(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Imei varchar(15) not null,
	IdLoaiSp int not null FOREIGN KEY REFERENCES LoaiSanPham(Id),
	IdCuaHang int NOT NULL FOREIGN KEY REFERENCES dbo.CuaHang(Id),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai BIT NOT NULL
)
-- Tao bang ChucVu 
CREATE TABLE ChucVu(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma VARCHAR(10) NOT NULL,
	Ten VARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE, 
	TrangThai bit
)
-- Tao bang Rank
CREATE TABLE Rank(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma VARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	MucChi BIGINT NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang NguoiDung 
CREATE TABLE NguoiDung(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma VARCHAR(10) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	GioiTinh BIT NOT NULL,
	NgaySinh DATE NOT NULL,
	Sdt VARCHAR(10) NOT NULL,
	DiaChi NVARCHAR(MAX),
	ThanhPho NVARCHAR(50) NOT NULL,
	IdChucVu int NOT NULL FOREIGN KEY REFERENCES dbo.ChucVu(Id),
	IdRank int NOT NULL FOREIGN KEY REFERENCES dbo.Rank(Id),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang BaoHanh
CREATE TABLE BaoHanh(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma VARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	ThoiGian INT,
	Gia BIGINT NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
-- Tao bang HoaDon 
CREATE TABLE HoaDon(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma VARCHAR(10) NOT NULL,
	IDNguoiDung int NOT NULL FOREIGN KEY REFERENCES dbo.NguoiDung(Id),
	NgayMua DATE NOT NULL,
	Sdt VARCHAR(10) NOT NULL,
	DiaChi NVARCHAR(MAX),
	TinhTrang BIT
)
-- Tao bang ChiTietBaoHanh
CREATE TABLE ChiTietBaoHanh(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	IdHoaDon int NOT NULL FOREIGN KEY REFERENCES dbo.HoaDon(Id),
	IdBaoHanh int NOT NULL FOREIGN KEY REFERENCES dbo.BaoHanh(Id),
	NgayBaoHanh DATE NOT NULL,
	NgayKetThuc DATE NOT NULL
)
-- Tao bang HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
	Id int identity(1,1) PRIMARY KEY,
	IdHoaDon int FOREIGN KEY REFERENCES dbo.HoaDon(Id) NOT NULL,
	IdSanPham int FOREIGN KEY REFERENCES dbo.ChiTietSP(Id) NOT NULL,
	SoLuong INT NOT NULL,
	DonGia BIGINT NOT NULL,
	ThanhTien BIGINT NOT NULL,
)
-- Tao bang GioHang
CREATE TABLE GioHang(
	Id int identity(1,1) PRIMARY KEY,
	Ma VARCHAR(10) NOT NULL,
	IdNguoiDung int FOREIGN KEY REFERENCES dbo.NguoiDung(Id) NOT NULL,
	NgayTao DATE NOT NULL,
	TrangThai BIT not null 
)
-- Tao bang GioHangChiTiet
CREATE TABLE GioHangChiTiet(
	Id int identity(1,1) PRIMARY KEY,
	IdGioHang int FOREIGN KEY REFERENCES dbo.GioHang(Id) NOT NULL,
	IdSanPham int FOREIGN KEY REFERENCES dbo.ChiTietSP(Id) NOT NULL,
	SoLuong INT NOT NULL,
	DonGia BIGINT NOT NULL,
	ThanhTien BIGINT NOT NULL
)
-- Tao bang Account
CREATE TABLE Account(
	Id int identity(1,1) PRIMARY KEY,
	UserName VARCHAR(50) NOT NULL,
	Pass varchar(18) not null,
	IdNguoiDung int FOREIGN KEY REFERENCES dbo.NguoiDung(Id) NOT NULL,
	TrangThai int
)
alter table Account add TrangThai int
alter table HoaDonChiTiet add TrangThai int
alter table ChiTietBaoHanh add TrangThai int