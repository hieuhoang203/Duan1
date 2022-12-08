create database DuAn1_CuaHangDienThoai
go
use DuAn1_CuaHangDienThoai
go
-- Tao bang Hang
CREATE TABLE Hang(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	TenHang NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.Hang (Ma,TenHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'AP',N'Apple','2022-11-19',NULL,1),
	 (N'NK',N'Nokia','2022-11-19',NULL,1),
	 (N'HW',N'Huawei','2022-11-19',NULL,1),
	 (N'SS',N'SamSung','2022-11-19',NULL,1),
	 (N'XI',N'Xiaomi','2022-11-19',NULL,1),
	 (N'ROG',N'Rog phone','2022-11-19',NULL,1);

-- Tao bang DongSp
CREATE TABLE DongSP(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	TenDongSP NVARCHAR(50) NOT NULL,
	GiaNhap BIGINT NOT NULL,
	GiaBan BIGINT NOT NULL,
	IdHang int NOT NULL FOREIGN KEY REFERENCES dbo.Hang(Id),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.DongSP (Ma,TenDongSP,GiaNhap,GiaBan,IdHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'DSP1',N'iPhone 8',6500000,7000000,1,'2022-11-19',NULL,1),
	 (N'DSP2',N'iPhone X',9000000,9500000,1,'2022-11-19',NULL,1),
	 (N'DSP3',N'Galaxy Note 20 Ulta',24000000,25000000,4,'2022-11-19',NULL,1),
	 (N'DSP4',N'Nokia 1280',350000,450000,2,'2022-11-21',NULL,1),
	 (N'DSP5',N'Rog Shark Phone 3',10000000,11000000,6,'2022-11-21',NULL,1);

-- Tao bang CoSo
CREATE TABLE CoSo(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.CoSo (Ma,Ten,NgayThem,NgaySua,TrangThai) VALUES
	 (N'HN',N'Hà Nội','2022-11-19',NULL,1),
	 (N'HCM',N'Tp. Hồ Chí Minh','2022-11-19','2022-11-19',1),
	 (N'DN',N'Đà Nẵng','2022-11-19',NULL,1),
	 (N'TN',N'Tây Nguyên','2022-11-19',NULL,1),
	 (N'CT',N'Cần Thơ','2022-11-19',NULL,1);

-- Tao bang CuaHang
create TABLE CuaHang(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	DiaChi NVARCHAR(MAX) NOT NULL,
	IdCoSo int NOT NULL FOREIGN KEY REFERENCES dbo.CoSo(Id),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.CuaHang (Ma,Ten,DiaChi,IdCoSo,NgayThem,NgaySua,TrangThai) VALUES
	 (N'CH1',N'CellPhoneS',N'Thôn Kim Trung, Kim Quan, Thạch Thất',1,'2022-11-19',NULL,1),
	 (N'CH2',N'Điện máy xanh',N'Quận 1',2,'2022-11-19',NULL,1),
	 (N'CH3',N'Táo Đen Store',N'Sơn Trà',3,'2022-11-19',NULL,1),
	 (N'CH4',N'Thế giới di động',N'Kon Tum',4,'2022-11-19',NULL,1),
	 (N'CH5',N'FPT Shop',N'Số 2 Hòa Bình, Tân An, Ninh Kiều',5,'2022-11-19',NULL,1);

-- Tao bang DungLuong
CREATE TABLE DungLuong(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(10) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.DungLuong (Ma,Ten,NgayThem,NgaySua,TrangThai) VALUES
	 (N'DL1',N'16Gb','2022-11-19',NULL,1),
	 (N'DL2',N'32Gb','2022-11-19',NULL,1),
	 (N'DL3',N'64Gb','2022-11-19',NULL,1),
	 (N'DL4',N'128Gb','2022-11-19',NULL,1),
	 (N'DL5',N'512Gb','2022-11-19',NULL,1),
	 (N'DL6',N'1T','2022-11-19',NULL,1);

-- Tao bang MauSac
CREATE TABLE MauSac(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.MauSac (Ma,Ten,NgayThem,NgaySua,TrangThai) VALUES
	 (N'RED',N'Đỏ','2022-11-19',NULL,1),
	 (N'BLUE',N'Xanh dương','2022-11-19',NULL,1),
	 (N'GREEN',N'Xanh lá','2022-11-19',NULL,1),
	 (N'YELLOW',N'Vàng','2022-11-19',NULL,1),
	 (N'BLACK',N'Đen','2022-11-19','2022-11-24',1);

-- Tao bang LoaiSanPham
create table LoaiSanPham(
	Id int identity(1,1) not null primary key,
	Ma NVARCHAR(10) not null,
	IdDongSp int FOREIGN KEY REFERENCES DongSP(Id),
	IdMauSac int FOREIGN KEY REFERENCES MauSac(Id),
	IdDungLuong int FOREIGN KEY REFERENCES DungLuong(Id),
	TrangThai bit,
	NgayTao Date,
	NgaySua Date
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.LoaiSanPham (Ma,IdDongSp,IdMauSac,IdDungLuong,TrangThai,NgayTao,NgaySua) VALUES
	 (N'LSP1',1,1,1,1,'2022-11-19',NULL),
	 (N'LSP2',1,5,2,1,'2022-11-19',NULL),
	 (N'LSP3',2,3,4,1,'2022-11-19',NULL),
	 (N'LSP4',3,5,5,1,'2022-11-19',NULL),
	 (N'LSP5',4,5,1,1,'2022-11-21',NULL),
	 (N'LSP6',5,3,5,1,'2022-11-21',NULL);

-- Tao bang ChiTietSP
CREATE TABLE ChiTietSP(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Imei NVARCHAR(16) not null,
	IdLoaiSp int not null FOREIGN KEY REFERENCES LoaiSanPham(Id),
	IdCuaHang int NOT NULL FOREIGN KEY REFERENCES dbo.CuaHang(Id),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai BIT NOT NULL
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000001',1,1,'2022-11-24',NULL,0),
	 (N'100000000000002',1,1,'2022-11-24',NULL,0),
	 (N'100000000000003',1,1,'2022-11-24',NULL,0),
	 (N'100000000000004',1,1,'2022-11-24',NULL,0),
	 (N'100000000000005',1,1,'2022-11-24',NULL,0),
	 (N'100000000000006',1,1,'2022-11-24',NULL,1),
	 (N'100000000000007',1,1,'2022-11-24',NULL,0),
	 (N'100000000000008',1,1,'2022-11-24',NULL,1),
	 (N'100000000000009',1,1,'2022-11-24',NULL,0),
	 (N'100000000000010',1,1,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000011',1,1,'2022-11-24',NULL,1),
	 (N'100000000000012',1,1,'2022-11-24',NULL,1),
	 (N'100000000000013',1,1,'2022-11-24',NULL,1),
	 (N'100000000000014',1,1,'2022-11-24',NULL,1),
	 (N'100000000000015',1,1,'2022-11-24',NULL,1),
	 (N'100000000000016',1,1,'2022-11-24',NULL,1),
	 (N'100000000000017',1,1,'2022-11-24',NULL,1),
	 (N'100000000000018',1,1,'2022-11-24',NULL,1),
	 (N'100000000000019',1,1,'2022-11-24',NULL,1),
	 (N'100000000000020',1,1,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000021',1,1,'2022-11-24',NULL,1),
	 (N'100000000000022',1,1,'2022-11-24',NULL,1),
	 (N'100000000000023',2,1,'2022-11-24',NULL,1),
	 (N'100000000000024',2,1,'2022-11-24',NULL,1),
	 (N'100000000000025',2,1,'2022-11-24',NULL,0),
	 (N'100000000000026',2,1,'2022-11-24',NULL,0),
	 (N'100000000000027',2,1,'2022-11-24',NULL,1),
	 (N'100000000000028',2,1,'2022-11-24',NULL,1),
	 (N'100000000000029',2,1,'2022-11-24',NULL,1),
	 (N'100000000000030',2,1,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000031',2,1,'2022-11-24',NULL,1),
	 (N'100000000000032',2,1,'2022-11-24',NULL,1),
	 (N'100000000000033',2,1,'2022-11-24',NULL,1),
	 (N'100000000000034',2,1,'2022-11-24',NULL,1),
	 (N'100000000000035',2,1,'2022-11-24',NULL,1),
	 (N'100000000000036',2,1,'2022-11-24',NULL,1),
	 (N'100000000000037',2,1,'2022-11-24',NULL,1),
	 (N'100000000000038',2,1,'2022-11-24',NULL,1),
	 (N'100000000000039',2,1,'2022-11-24',NULL,1),
	 (N'100000000000040',2,1,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000041',2,1,'2022-11-24',NULL,1),
	 (N'100000000000042',3,1,'2022-11-24',NULL,1),
	 (N'100000000000043',3,1,'2022-11-24',NULL,0),
	 (N'100000000000044',3,1,'2022-11-24',NULL,1),
	 (N'100000000000045',3,1,'2022-11-24',NULL,1),
	 (N'100000000000046',3,1,'2022-11-24',NULL,1),
	 (N'100000000000047',3,1,'2022-11-24',NULL,1),
	 (N'100000000000048',3,1,'2022-11-24',NULL,1),
	 (N'100000000000049',3,1,'2022-11-24',NULL,0),
	 (N'100000000000050',3,2,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000051',3,2,'2022-11-24',NULL,1),
	 (N'100000000000052',3,2,'2022-11-24',NULL,1),
	 (N'100000000000053',3,2,'2022-11-24',NULL,1),
	 (N'100000000000054',3,2,'2022-11-24',NULL,1),
	 (N'100000000000055',3,2,'2022-11-24',NULL,1),
	 (N'100000000000056',3,2,'2022-11-24',NULL,1),
	 (N'100000000000057',3,2,'2022-11-24',NULL,1),
	 (N'100000000000058',3,2,'2022-11-24',NULL,1),
	 (N'100000000000059',3,2,'2022-11-24',NULL,1),
	 (N'100000000000060',3,2,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000061',4,2,'2022-11-24',NULL,1),
	 (N'100000000000062',4,2,'2022-11-24',NULL,1),
	 (N'100000000000063',4,2,'2022-11-24',NULL,1),
	 (N'100000000000064',4,2,'2022-11-24',NULL,1),
	 (N'100000000000065',4,2,'2022-11-24',NULL,1),
	 (N'100000000000066',4,2,'2022-11-24',NULL,1),
	 (N'100000000000067',4,2,'2022-11-24',NULL,1),
	 (N'100000000000068',4,2,'2022-11-24',NULL,1),
	 (N'100000000000069',4,2,'2022-11-24',NULL,1),
	 (N'100000000000070',4,2,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000071',4,2,'2022-11-24',NULL,1),
	 (N'100000000000072',4,2,'2022-11-24',NULL,1),
	 (N'100000000000073',4,2,'2022-11-24',NULL,1),
	 (N'100000000000074',4,2,'2022-11-24',NULL,1),
	 (N'100000000000075',4,2,'2022-11-24',NULL,1),
	 (N'100000000000076',4,2,'2022-11-24',NULL,1),
	 (N'100000000000077',4,2,'2022-11-24',NULL,1),
	 (N'100000000000078',5,2,'2022-11-24',NULL,1),
	 (N'100000000000079',5,2,'2022-11-24',NULL,1),
	 (N'100000000000080',5,2,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000081',5,2,'2022-11-24',NULL,1),
	 (N'100000000000082',5,2,'2022-11-24',NULL,1),
	 (N'100000000000083',5,2,'2022-11-24',NULL,1),
	 (N'100000000000084',5,2,'2022-11-24',NULL,1),
	 (N'100000000000085',5,2,'2022-11-24',NULL,1),
	 (N'100000000000086',5,2,'2022-11-24',NULL,1),
	 (N'100000000000087',5,2,'2022-11-24',NULL,1),
	 (N'100000000000088',5,2,'2022-11-24',NULL,1),
	 (N'100000000000089',5,2,'2022-11-24',NULL,1),
	 (N'100000000000090',5,2,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000091',5,2,'2022-11-24',NULL,1),
	 (N'100000000000092',6,2,'2022-11-24',NULL,1),
	 (N'100000000000093',6,2,'2022-11-24',NULL,1),
	 (N'100000000000094',6,2,'2022-11-24',NULL,1),
	 (N'100000000000095',6,2,'2022-11-24',NULL,1),
	 (N'100000000000096',6,2,'2022-11-24',NULL,1),
	 (N'100000000000097',6,2,'2022-11-24',NULL,1),
	 (N'100000000000098',6,2,'2022-11-24',NULL,1),
	 (N'100000000000099',6,2,'2022-11-24',NULL,1),
	 (N'100000000000100',6,2,'2022-11-24',NULL,1);
INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietSP (Imei,IdLoaiSp,IdCuaHang,NgayThem,NgaySua,TrangThai) VALUES
	 (N'100000000000101',4,2,'2022-11-25',NULL,1);

-- Tao bang ChucVu 
CREATE TABLE ChucVu(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE, 
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChucVu (Ma,Ten,NgayThem,NgaySua,TrangThai) VALUES
	 (N'AD',N'Admin','2022-11-19',NULL,1),
	 (N'MK',N'Marketing','2022-11-19',NULL,1),
	 (N'KT',N'Kế toán','2022-11-19',NULL,1),
	 (N'TN',N'Thu ngân','2022-11-19',NULL,1);

-- Tao bang NguoiDung 
CREATE TABLE NguoiDung(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	GioiTinh BIT NOT NULL,
	NgaySinh DATE NOT NULL,
	Email VARCHAR(50) NOT NULL,
	DiaChi NVARCHAR(MAX),
	IdChucVu int NOT NULL FOREIGN KEY REFERENCES dbo.ChucVu(Id),
	IdCuaHang int NOT NULL FOREIGN KEY REFERENCES dbo.CuaHang(Id),
	Anh varchar(max),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.NguoiDung (Ma,HoTen,GioiTinh,NgaySinh,Email,DiaChi,IdChucVu,IdCuaHang,Anh,NgayThem,NgaySua,TrangThai) VALUES
	 (N'HVH1',N'Hoàng Văn Hiếu',1,'2003-09-08',N'hieuhoangbgt@gmail.com',N'Bắc Giang',1,1,N'C:\Users\admin\Pictures\Saved Pictures\me.jpg','2022-11-19',NULL,1),
	 (N'LTDT1',N'Lê Thị Diệu Thúy',0,'2003-06-08',N'thuyltdph23050@fpt.edu.vn',N'Thạch Thất',4,1,N'C:\Users\admin\Pictures\Saved Pictures\anhthe.jpg','2022-11-19',NULL,1),
	 (N'VPT1',N'Vũ Phương Thảo',0,'2003-12-11',N'thaovpph27640@fpt.edu.vn',N'Hà Nội',4,2,N'C:\Users\admin\Pictures\Saved Pictures\madahashi.jpg','2022-11-24',NULL,1),
	 (N'VVN1',N'Vũ Văn Nguyên',1,'2000-01-01',N'nguyenvvhkt@gmail.com',N'Hà Nội',4,1,N'C:\Users\admin\Pictures\Saved Pictures\dekstop.png','2022-11-30',NULL,1);

-- Tao bang BaoHanh
CREATE TABLE BaoHanh(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	ThoiGian INT,
	Gia BIGINT NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.BaoHanh (Ma,Ten,ThoiGian,Gia,NgayThem,NgaySua,TrangThai) VALUES
	 (N'BH2',N'Phá hoại',1,345000,'2022-11-20',NULL,1),
	 (N'BH3',N'Báo đời',2,500000,'2022-11-20',NULL,1),
	 (N'BH4',N'Báo đốm',3,1000000,'2022-11-20',NULL,1);

-- Tao bang HoaDon 
CREATE TABLE HoaDon(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	IDNguoiDung int NOT NULL FOREIGN KEY REFERENCES dbo.NguoiDung(Id),
	NgayMua DATE NOT NULL,
	Sdt VARCHAR(10) NOT NULL,
	DiaChi NVARCHAR(MAX),
	TongTien bigint not null,
	TinhTrang BIT
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.HoaDon (Ma,IDNguoiDung,NgayMua,Sdt,DiaChi,TongTien,TinhTrang) VALUES
	 (N'HD1',5,'2022-11-26',N'0966628527',N'Lý Viên',8000000,1),
	 (N'HD2',5,'2022-11-27',N'0966628527',N'Lý Viên',10345000,1),
	 (N'HD7',5,'2022-11-27',N'0966628527',N'Lý Viên',14000000,1),
	 (N'HD4',5,'2022-11-27',N'0966628527',N'Lý Viên',14000000,1),
	 (N'HD5',5,'2022-11-30',N'0966628527',N'Lý Viên',7500000,1);

-- Tao bang ChiTietBaoHanh
CREATE TABLE ChiTietBaoHanh(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	IdHoaDon int NOT NULL FOREIGN KEY REFERENCES dbo.HoaDon(Id),
	IdBaoHanh int NOT NULL FOREIGN KEY REFERENCES dbo.BaoHanh(Id),
	NgayBaoHanh DATE NOT NULL,
	NgayKetThuc DATE NOT NULL,
	TrangThai bit not null
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.ChiTietBaoHanh (IdHoaDon,IdBaoHanh,NgayBaoHanh,NgayKetThuc,TrangThai) VALUES
	 (49,4,'2022-11-26','2025-11-25',1),
	 (50,3,'2022-11-27','2024-11-26',1),
	 (50,2,'2022-11-27','2023-11-27',1),
	 (53,3,'2022-11-30','2024-11-29',1);

-- Tao bang HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
	Id int identity(1,1) PRIMARY KEY,
	IdHoaDon int FOREIGN KEY REFERENCES dbo.HoaDon(Id) NOT NULL,
	IdSanPham int FOREIGN KEY REFERENCES dbo.ChiTietSP(Id) NOT NULL,
	SoLuong INT NOT NULL,
	DonGia BIGINT NOT NULL,
	ThanhTien BIGINT NOT NULL,
	TrangThai bit not null
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.HoaDonChiTiet (IdHoaDon,IdSanPham,SoLuong,DonGia,ThanhTien,TrangThai) VALUES
	 (49,14,1,7000000,7000000,1),
	 (50,54,1,9500000,9500000,1),
	 (51,15,1,7000000,7000000,1),
	 (51,18,1,7000000,7000000,1),
	 (52,36,1,7000000,7000000,1),
	 (52,37,1,7000000,7000000,1),
	 (53,20,1,7000000,7000000,1);

-- Tao bang GioHang
CREATE TABLE GioHang(
	Id int identity(1,1) PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
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
	ThanhTien BIGINT NOT NULL,
	TrangThai bit not null
)
-- Tao bang Account
CREATE TABLE Account(
	Id int identity(1,1) PRIMARY KEY,
	UserName NVARCHAR(50) NOT NULL,
	Pass NVARCHAR(18) not null,
	IdNguoiDung int FOREIGN KEY REFERENCES dbo.NguoiDung(Id) NOT NULL,
	TrangThai int
)

INSERT INTO DuAn1_CuaHangDienThoai.dbo.Account (UserName,Pass,IdNguoiDung,TrangThai) VALUES
	 (N'hieuhoangbgt@gmail.com',N'Dieuthuy@2003',4,1),
	 (N'thuyltdph23050@fpt.edu.vn',N'T08062003',5,1),
	 (N'thaovpph27640@fpt.edu.vn',N'12345678',8,1),
	 (N'nguyenvvhkt@gmail.com',N'12345678',9,1);
