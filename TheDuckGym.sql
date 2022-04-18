create database TheDuckGym;
go
use TheDuckGym;
go
-- Tạo các bảng table
create table TaiKhoan(
ID nvarchar(7) primary key,
MatKhau nvarchar(50) not null,
NgayDK date default(FORMAT(getDate(),'yyyy-MM-dd')) not null,
Vaitro int not null
);
create table NhanVien(
IDNV nvarchar(7) primary key,
DienThoai nvarchar(10) not null unique,
HoTen nvarchar(50) not null,
);
create table HocVien(
IDHV nvarchar(7) primary key,
HoTen nvarchar(50) not null,
GioiTinh bit not null,
DienThoai nvarchar(10) not null unique,
GhiChu nvarchar(max) null
);
create table DungCu(
MaDC nvarchar(7) primary key,
TenDC nvarchar(50) not null,
SoLuong int not null,
TinhTrang nvarchar(50) not null,
HangSX nvarchar(50) not null,
GhiChu nvarchar(max) null
);
create table KhoaTap(
MaKT nvarchar(7) primary key,
TenKT nvarchar(50) not null,
TenHLV nvarchar(50) not null,
Gia float not null,
DienThoai nvarchar(10) not null unique,
SoBuoiTap int not null,
GhiChu nvarchar(max) null
);
create table LichTap(
STT int primary key IDENTITY(1,1),
IDHV nvarchar(7) not null,
MaKT nvarchar(7) not null,
HoTen nvarchar(50) not null,
TenHLV nvarchar(50) not null,
TenKT nvarchar(50) not null,
NgayTap nvarchar(50) not null,
GhiChu nvarchar(max)
);
create table DSDK(
MaDK int primary key IDENTITY(1,1),
IDHV nvarchar(7) not null,
MaKT nvarchar(7) not null,
HoTen nvarchar(50) not null,
HocPhi float not null,
NgayDongHP date Default(FORMAT(getDate(),'yyyy-MM-dd')) not null,
SoBuoiTap int not null,
TinhTrangKT nvarchar(50) not null,
GhiChu nvarchar(max) null
);
-- Tạo khoá ngoại
alter table LichTap
add constraint FK_LICHTAP_HOCVIEN
foreign key (IDHV) references HocVien(IDHV) ON UPDATE CASCADE ON DELETE NO ACTION;

alter table LichTap
add constraint FK_LICHTAP_KHOATAP
foreign key (MaKT) references KhoaTap(MaKT) ON UPDATE CASCADE ON DELETE NO ACTION;

alter table DSDK
add constraint FK_DSDK_HOCVIEN
foreign key (IDHV) references HocVien(IDHV) ON UPDATE CASCADE ON DELETE NO ACTION;

alter table DSDK
add constraint FK_DSDK_KHOATAP
foreign key (MaKT) references KhoaTap(MaKT) ON UPDATE CASCADE ON DELETE NO ACTION;

-- Hàm Proceduce
-- Truy vấn(Select) Các Bảng
-- TaiKhoan --
go
create proc sp_Select_TaiKhoan
as
begin
	select * from TaiKhoan
end
go
-- NhanVien --
create proc sp_Select_NhanVien
as
begin
	select * from NhanVien
end
go
-- HocVien --
create proc sp_Select_HocVien
as
begin
	select * from HocVien
end
go
-- DungCu --
create proc sp_Select_DungCu
as
begin
	select * from DungCu
end
go
-- KhoaTap --
create proc sp_Select_KhoaTap
as
begin
	select * from KhoaTap
end
go
-- LichTap --
create proc sp_Select_LichTap
as
begin
	select * from LichTap
end
go
-- DSDK --
create proc sp_Select_DSDK
as
begin
	select * from DSDK
end
go
-- Các chức năng thêm, xoá, sửa theo từng table
-- -----------------QUẢN LÝ--------------------
-- +++++QuanLyTaiKhoan
-- Them_QuanLyTaiKhoan
create proc sp_Them_QuanLyTaiKhoan(@ID nvarchar(7), @MatKhau nvarchar(50), @Vaitro int)
as
begin
	if(@ID in (Select IDHV from HocVien) or @ID in (Select IDNV from NhanVien))
	begin
		insert into TaiKhoan(ID,MatKhau,Vaitro)
		values (@ID,@MatKhau,@Vaitro)
	end
end
go
-- Xoa_QuanLyTaiKhoan
create proc sp_Xoa_QuanLyTaiKhoan(@ID nvarchar(7))
as
begin
	delete from TaiKhoan
	where ID like @ID;
end
go
-- Sua_QuanLyTaiKhoan
create proc sp_Sua_QuanLyTaiKhoan(@ID nvarchar(7), @MatKhau nvarchar(50), @Vaitro int)
as
begin
	update TaiKhoan
	set MatKhau = @MatKhau, Vaitro = @Vaitro
	where ID like @ID;
end
go
-- +++++QuanLyNhanVien
-- Them_QuanLyNhanVien
create proc sp_Them_QuanLyNhanVien (@IDNV nvarchar(7), @DienThoai nvarchar(50), @HoTen nvarchar(50) )
as
begin
	insert into NhanVien(IDNV,DienThoai,HoTen)
	values (@IDNV,@DienThoai,@HoTen);
	insert into TaiKhoan(ID,MatKhau,VaiTro)
	values (@IDNV,'123',1);
end
go
-- Xoa_QuanLyNhanVien
create proc sp_Xoa_QuanLyNhanVien(@IDNV nvarchar(7))
as
begin
	delete from TaiKhoan
	where ID like @IDNV;
	delete from NhanVien
	where IDNV like @IDNV;
end
go
-- Sua_QuanLyNhanVien
create proc sp_Sua_QuanLyNhanVien (@IDNV nvarchar(7), @DienThoai nvarchar(50), @HoTen nvarchar(50) )
as
begin
	update NhanVien
	set DienThoai = @DienThoai, HoTen = @HoTen
	where IDNV like @IDNV;
end
go
-- +++++QuanLyKhoaTap
-- Them_QuanLyKhoaTap
create proc sp_Them_QuanLyKhoaTap (@MAKT nvarchar(7), @TenKT nvarchar(50), @TenHLV nvarchar(50),@Gia float, @DienThoai nvarchar(10), @SoBuoiTap int, @GhiChu nvarchar(max) )
as
begin
	insert into KhoaTap(MAKT,TenKT,TenHLV,Gia,DienThoai,SoBuoiTap,GhiChu)
	values (@MAKT,@TenKT,@TenHLV,@Gia,@DienThoai,@SoBuoiTap, @GhiChu)
end
go
-- Xoa_QuanLyKhoaTap
create proc sp_Xoa_QuanLyKhoaTap (@MAKT nvarchar(7))
as
begin
	delete from KhoaTap
	where MAKT like @MAKT;
end
go
-- Sua_QuanLyKhoaTap
create proc sp_Sua_QuanLyKhoaTap (@MAKT nvarchar(7), @TenKT nvarchar(50), @TenHLV nvarchar(50),@Gia float, @DienThoai nvarchar(10), @SoBuoiTap int, @GhiChu nvarchar(max) )
as
begin
	update KhoaTap
	set TenKT = @TenKT, TenHLV = @TenHLV,Gia = @Gia, DienThoai = @DienThoai, SoBuoiTap = @SoBuoiTap, GhiChu = @GhiChu
	where MAKT like @MAKT;
end
go
-- +++++QuanLyDungCu
-- Them_ QuanLyDungCu
create proc sp_Them_QuanLyDungCu (@MaDC nvarchar(7), @TenDC nvarchar(50), @SoLuong int,@TinhTrang nvarchar(50), @HangSX nvarchar(50), @GhiChu nvarchar(max))
as
begin
	insert into DungCu (MaDC,TenDC,SoLuong,TinhTrang,HangSX,GhiChu)
	values (@MADC,@TenDC,@SoLuong,@TinhTrang,@HangSX,@GhiChu)
end
go
-- Xoa_ QuanLyDungCu
create proc sp_Xoa_QuanLyDungCu (@MADC nvarchar(7))
as
begin
	delete from DungCu
	where MADC like @MADC;
end
go
-- Sua_ QuanLyDungCu
create proc sp_Sua_QuanLyDungCu (@MADC nvarchar(7), @TenDC nvarchar(50), @SoLuong int,@TinhTrang nvarchar(50), @HangSX nvarchar(50), @GhiChu nvarchar(max))
as
begin
	update DungCu
	set TenDC = @TenDC, SoLuong = @SoLuong,TinhTrang = @TinhTrang, HangSX = @HangSX, GhiChu = @GhiChu
	where MADC like @MADC;
end
go
-- +++++QuanLyLichTap
-- Them_QuanLyLichTap
create proc sp_Them_QuanLyLichTap(@IDHV nvarchar(7),@MaKT nvarchar(7) ,@HoTen nvarchar(50) ,@TenHLV nvarchar(50),@TenKT nvarchar(50) ,@NgayTap nvarchar(50) , @GhiChu nvarchar(max))
as
begin
	insert into LichTap(IDHV,MaKT,HoTen,TenHLV,TenKT,NgayTap,GhiChu)
	values (@IDHV,@MaKT,@HoTen,@TenHLV,@TenKT,@NgayTap,@GhiChu)
end
go
-- Xoa_QuanLyLichTap
create proc sp_Xoa_QuanLyLichTap(@STT int, @IDHV nvarchar(7))
as
begin
	delete from LichTap
	where STT = @STT;
end
go
-- Sua_QuanLyLichTap
create proc sp_Sua_QuanLyLichTap (@STT int,@IDHV nvarchar(7),@MaKT nvarchar(7) ,@HoTen nvarchar(50) ,@TenHLV nvarchar(50),@TenKT nvarchar(50) ,@NgayTap nvarchar(50) , @GhiChu nvarchar(max))
as
begin
	update LichTap
	set IDHV = @IDHV, MaKT = @MaKT, HoTen = @HoTen,TenHLV = @TenHLV, TenKT = @TenKT, NgayTap = @NgayTap, GhiChu = @GhiChu
	where STT = @STT
end
go
-- +++++QuanLyHocVien
-- Them_QuanLyHocVien
create proc sp_Them_QuanLyHocVien(@IDHV nvarchar(7), @HoTen nvarchar(50), @GioiTinh bit, @DienThoai varchar(10), @GhiChu nvarchar(max))
as
begin
	insert into HocVien
	values (@IDHV,@HoTen,@GioiTinh,@DienThoai,@GhiChu);
	insert into TaiKhoan(ID,MatKhau,VaiTro)
	values (@IDHV,'123',2);
end
go
-- Xoa_QuanLyHocVien
create proc sp_Xoa_QuanLyHocVien(@IDHV nvarchar(7))
as
begin
	delete from TaiKhoan
	where ID like @IDHV;
	delete from HocVien
	where IDHV like @IDHV;
end
go
-- Sua_QuanLyHocVien
create proc sp_Sua_QuanLyHocVien(@IDHV nvarchar(7), @HoTen nvarchar(50), @GioiTinh bit, @DienThoai varchar(10), @GhiChu nvarchar(max))
as
begin
	Update HocVien
	set HoTen = @HoTen, GioiTinh = @GioiTinh, DienThoai = @DienThoai, GhiChu = @GhiChu
	where IDHV like @IDHV;
end
go
-- +++++DSDK
-- Sua_DSDK
create proc sp_Sua_QuanLyDSDK(@MaDK int, @TinhTrangKT nvarchar(50),@GhiChu nvarchar(50))
as
begin
	update DSDK
	set TinhTrangKT = @TinhTrangKT, GhiChu = @GhiChu
	where MaDK = @MaDK;
end
go
-- Các câu lệnh PROC thực hiện chức năng
-- -----------------NHÂN VIÊN,HỌC VIÊN-------------------
-- DoiMatKhau
create proc sp_DoiMatKhau(@ID nvarchar(7),@MatKhau nvarchar(50))
as
begin
	Update TaiKhoan
	set MatKhau = @MatKhau
	where ID like @ID;
end
go
-- Form Quản lý dụng cụ dùng chung với quản lý
-- -----------------QUẢN LÝ---------------------
-- ThongKeDoanhThu
create proc sp_ThongKeDoanhThu
as
begin
	Select IDHV, HocPhi, NgayDongHP from DSDK
end
go
-- -----------------HỌC VIÊN--------------------
-- DangKyKhoaTap_KhoaTap
create proc sp_DangKyKhoaTap(@MaKT nvarchar(7), @IDHV nvarchar(7))
as
begin
	declare @HoTen nvarchar(50),@HocPhi float,@SoBuoiTap int;
	set @HoTen = (Select HoTen from HocVien where IDHV like @IDHV);
	set @HocPhi = (Select Gia from KhoaTap where MaKT like @MaKT);
	set @SoBuoiTap = (Select SoBuoiTap from KhoaTap where MaKT like @MaKT);
	Insert into DSDK(IDHV,MaKT,HoTen,HocPhi,SoBuoiTap,TinhTrangKT,GhiChu)
	values (@IDHV,@MaKT,@HoTen,@HocPhi,@SoBuoiTap,N'Chưa xếp lịch','');
end
go
-- HuyKhoaTap_DSDK
create proc sp_HuyKhoaTap(@MaKT nvarchar(7), @IDHV nvarchar(7))
as
begin
	Update DSDK
	set TinhTrangKT = N'Đã Huỷ'
	where MaKT like @MaKT and IDHV like @IDHV;
	Delete from LichTap
	where MaKT like @MaKT and IDHV like @IDHV;
end
go
----------------------Insert dữ liệu--------------------------
exec sp_Them_QuanLyNhanVien 'DuyNNT','0912571469',N'Nguyễn Ngọc Thái Duy';
go
exec sp_Them_QuanLyHocVien 'ThanhNP',N'Nguyễn Phước Thạnh',1,'0945667843','';
go
exec sp_Them_QuanLyNhanVien 'MinhLX','0912511469',N'Lê Xuân Minh';
go
exec sp_Sua_QuanLyTaiKhoan 'DuyNNT','123456',0;
go
exec sp_Them_QuanLyKhoaTap 'NT18990', N'Nâng tạ', N'Lê Xuân Minh',300000, '0933456654', 7, '';
exec sp_Them_QuanLyKhoaTap 'NT18991', N'Nâng tạ', N'Lê Xuân Minh',300000, '0933453654', 7, '';
exec sp_Them_QuanLyKhoaTap 'NT18992', N'Nâng tạ', N'Lê Xuân Minh',300000, '0933451654', 7, '';
go
exec sp_Them_QuanLyDungCu 'DC12346',N'Tạ 20kg',5,N'Hỏng 5/8','Vinhdata','';