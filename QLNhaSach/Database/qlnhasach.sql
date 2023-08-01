-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2021 at 08:21 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlnhasach`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MAHD` int(11) NOT NULL,
  `MASACH` int(11) DEFAULT NULL,
  `DonGia` int(11) DEFAULT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiamGia` int(11) NOT NULL,
  `ThanhTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MAHD`, `MASACH`, `DonGia`, `SoLuong`, `GiamGia`, `ThanhTien`) VALUES
(1, 1, 275000, 1, 10, 247500),
(2, 1, 275000, 1, 10, 247500),
(2, 6, 120000, 1, 0, 120000),
(3, 15, 120000, 1, 0, 120000),
(4, 1, 275000, 1, 10, 247500),
(5, 15, 120000, 5, 0, 600000),
(5, 1, 275000, 3, 0, 825000),
(6, 1, 275000, 2, 10, 495000),
(7, 1, 275000, 1, 10, 247500),
(8, 1, 275000, 5, 10, 1237500),
(8, 2, 85000, 5, 10, 382500),
(9, 2, 82000, 3, 10, 62000),
(7, 1, 275000, 1, 10, 247500),
(10, 5, 126000, 3, 0, 378000);

-- --------------------------------------------------------

--
-- Table structure for table `chitietkhuyenmai`
--

CREATE TABLE `chitietkhuyenmai` (
  `MAKM` int(11) NOT NULL,
  `TenKhuyenMai` varchar(100) DEFAULT NULL,
  `NgayBD` date DEFAULT NULL,
  `NgayKT` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietkhuyenmai`
--

INSERT INTO `chitietkhuyenmai` (`MAKM`, `TenKhuyenMai`, `NgayBD`, `NgayKT`) VALUES
(1, 'Giảm 10% Tiểu Thuyết', '2021-05-01', '2021-05-03');

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MAPHIEU` int(11) NOT NULL,
  `MASACH` int(11) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MAPHIEU`, `MASACH`, `SoLuong`) VALUES
(1, 1, 5),
(2, 2, 2),
(3, 1, 6),
(4, 2, 1),
(5, 1, 1),
(6, 1, 10),
(7, 15, 5),
(8, 15, 6),
(9, 15, 5);

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `id` int(11) NOT NULL,
  `tenchucvu` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`id`, `tenchucvu`) VALUES
(0, 'Không Quyền'),
(1, 'Admin'),
(2, 'Quản Lý'),
(3, 'Nhân Viên');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` int(11) NOT NULL,
  `MANV` int(11) DEFAULT NULL,
  `MAKH` int(11) DEFAULT NULL,
  `NgayLapHD` date DEFAULT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MAHD`, `MANV`, `MAKH`, `NgayLapHD`, `ThanhTien`) VALUES
(1, 1, 1, '2021-05-17', 247500),
(2, 1, 1, '2021-05-17', 367500),
(3, 4, 2, '2021-05-17', 120000),
(4, 1, 1, '2021-05-12', 150000),
(5, 1, 1, '2021-05-18', 1425000),
(6, 1, 1, '2021-05-18', 495000),
(7, 1, 1, '2021-05-18', 150000),
(8, 1, 1, '2021-05-18', 1620000),
(9, 1, 1, '2021-05-18', 150000),
(10, 1, 1, '2021-09-05', 625500);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` int(11) NOT NULL,
  `Ho` varchar(50) DEFAULT NULL,
  `Ten` varchar(50) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `Sdt` varchar(10) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MAKH`, `Ho`, `Ten`, `DiaChi`, `Sdt`, `Email`) VALUES
(1, 'Nguyễn', 'Lim Thái Hồ', '163 Tô Hiến Thành, P3, Q10, TPHCM', '0904582372', 'kahn1234@gmail.com'),
(2, 'Minh ', 'Trần', '123 Hàm Nghi, P Dakao, Q.1', '0904582372', 'minhtran@gmail.com'),
(3, 'Trần', 'Thảo', '74 Đinh Tiên Hoàng, P13, Q.Bình Thạnh', '0932423323', 'thanhthao@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MAKM` int(11) NOT NULL,
  `MALOAI` varchar(5) DEFAULT NULL,
  `PhanTramGiam` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`MAKM`, `MALOAI`, `PhanTramGiam`) VALUES
(1, '1', 10);

-- --------------------------------------------------------

--
-- Table structure for table `loaisach`
--

CREATE TABLE `loaisach` (
  `MaLOAI` varchar(10) NOT NULL,
  `TenLoai` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loaisach`
--

INSERT INTO `loaisach` (`MaLOAI`, `TenLoai`) VALUES
('1', 'Tiểu Thuyết'),
('2', 'Trinh Thám'),
('3', 'Truyện Tranh'),
('4', 'Văn Học'),
('5', 'Đời Sống Tâm Lý'),
('6', 'Light Novel');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MANCC` int(11) NOT NULL,
  `TenNCC` varchar(100) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `Sdt` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MANCC`, `TenNCC`, `DiaChi`, `Sdt`) VALUES
(1, 'Nhà Xuất Bản Kim Đồng', '17 Lê Thánh Tôn', '0904582372'),
(2, 'Nhà Xuất Bản Văn Học', '6 Mạc Đĩnh Chi', '0932034456'),
(3, 'Nhà Xuất Bản ĐH Quốc Gia', '127 Nguyễn Đình Chiểu', '0904582372'),
(4, 'Nhà Xuất Bản Thời Đại', '34 Trần Cao Vân', '0923432123');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` int(11) NOT NULL,
  `Ho` varchar(50) DEFAULT NULL,
  `Ten` varchar(50) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Luong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `Ho`, `Ten`, `NgaySinh`, `Email`, `Luong`) VALUES
(1, 'Admin', 'Admin', '2001-10-10', 'admin@gmail.com', 18000),
(2, 'Lim', 'Hồ', '2001-10-30', 'kahn12345678@gmail.com', 18000),
(3, 'Thanh', 'Trần', '2021-05-03', 'thanhtran@gmail.com', 19000),
(4, 'Thành', 'Tâm', '2021-05-03', 'thanhtam@gmail.com', 17000);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `MAPHIEU` int(11) NOT NULL,
  `MANV` int(11) DEFAULT NULL,
  `MANCC` int(11) DEFAULT NULL,
  `Ngay` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`MAPHIEU`, `MANV`, `MANCC`, `Ngay`) VALUES
(1, 1, 1, '2021-05-16'),
(2, 2, 2, '2021-05-16'),
(3, 1, 1, '2021-05-16'),
(4, 2, 3, '2021-05-12'),
(5, 1, 1, '2021-05-17'),
(6, 1, 1, '2021-05-17'),
(7, 1, 1, '2021-05-17'),
(8, 1, 1, '2021-05-17'),
(9, 1, 1, '2021-05-18');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MASACH` int(11) NOT NULL,
  `NhaXuatBan` varchar(100) DEFAULT NULL,
  `MaLoai` varchar(10) DEFAULT NULL,
  `TenSach` varchar(100) DEFAULT NULL,
  `TacGia` varchar(100) DEFAULT NULL,
  `DonGia` int(11) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MASACH`, `NhaXuatBan`, `MaLoai`, `TenSach`, `TacGia`, `DonGia`, `SoLuong`) VALUES
(1, '2', '1', 'Before I Fall', 'Lauren Oliver', 275000, 13),
(2, '3', '1', 'Don Quixote', 'Miguel de Cervantes', 85000, 0),
(3, '3', '1', 'A Game Of Thrones', 'George R.R Martin', 170000, 9),
(4, '3', '1', 'The Witcher: The Last Wish', 'Andrzej Sapkowski', 220000, 7),
(5, '1', '2', 'Sherlock Holmes', 'Arthur Conan Doyle', 126000, 1),
(6, '1', '2', 'The Book Thief', 'Markus Zusak', 120000, 11),
(7, '1', '3', 'Barakamon', 'Yoshino Satsuki', 55000, 5),
(8, '1', '3', 'Conan', 'Aoyama Gosho', 22000, 16),
(9, '1', '3', 'Doraemon', 'Fujiko F Fujio', 15000, 22),
(10, '1', '4', 'Chí Phèo', 'Nam Cao', 120000, 52),
(11, '1', '4', 'Tắt Đèn', 'Ngô Tất Tố', 120000, 15),
(12, '1', '5', 'Gã Nghiện Giày', 'Phil Knight', 165000, 23),
(13, '1', '5', 'Cà Phê Cùng Tony', 'Tony Buổi Sáng', 85000, 23),
(14, '1', '6', '5cm Per Second', 'Shinkai Makoto', 25000, 30),
(15, '1', '6', 'Another', 'Yukito Ayatsuji', 120000, 30);

-- --------------------------------------------------------

--
-- Table structure for table `tbltaikhoan`
--

CREATE TABLE `tbltaikhoan` (
  `id` int(11) NOT NULL,
  `tendangnhap` varchar(50) DEFAULT NULL,
  `matkhau` varchar(50) DEFAULT NULL,
  `capbac` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbltaikhoan`
--

INSERT INTO `tbltaikhoan` (`id`, `tendangnhap`, `matkhau`, `capbac`) VALUES
(1, 'admin', '123', 1),
(2, 'limtaeho', '123', 2),
(3, 'nhanvien', '123', 3),
(4, 'khachhang', '123', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `MASACH` (`MASACH`);

--
-- Indexes for table `chitietkhuyenmai`
--
ALTER TABLE `chitietkhuyenmai`
  ADD PRIMARY KEY (`MAKM`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MAPHIEU`),
  ADD KEY `MASACH` (`MASACH`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MAKH` (`MAKH`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MAKM`),
  ADD KEY `MALOAI` (`MALOAI`);

--
-- Indexes for table `loaisach`
--
ALTER TABLE `loaisach`
  ADD PRIMARY KEY (`MaLOAI`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MANCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);

--
-- Indexes for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`MAPHIEU`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MANCC` (`MANCC`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MASACH`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- Indexes for table `tbltaikhoan`
--
ALTER TABLE `tbltaikhoan`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MASACH`) REFERENCES `sach` (`MASACH`);

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MASACH`) REFERENCES `sach` (`MASACH`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`);

--
-- Constraints for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD CONSTRAINT `khuyenmai_ibfk_1` FOREIGN KEY (`MALOAI`) REFERENCES `loaisach` (`MaLOAI`);

--
-- Constraints for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `phieunhaphang_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `phieunhaphang_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`);

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loaisach` (`MaLOAI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
