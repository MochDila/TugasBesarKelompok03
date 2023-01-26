-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2022 at 04:19 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tugasbesar_kelompok03`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_akun_admin`
--

CREATE TABLE `t_akun_admin` (
  `nama_depan` varchar(30) NOT NULL,
  `nama_belakang` varchar(30) NOT NULL,
  `nama_lengkap` varchar(30) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_akun_admin`
--

INSERT INTO `t_akun_admin` (`nama_depan`, `nama_belakang`, `nama_lengkap`, `jabatan`, `email`, `password`) VALUES
('admin', 'admin', 'admin', 'admin', 'admin', 'admin'),
('Ajeng', 'Kartini', 'Ajeng Kartini', 'manager', 'cartinfood@cartin.com', '313200863cartin');

-- --------------------------------------------------------

--
-- Table structure for table `t_akun_profile_pelanggan`
--

CREATE TABLE `t_akun_profile_pelanggan` (
  `kode_pelanggan` varchar(15) NOT NULL,
  `nama_depan` varchar(200) NOT NULL,
  `nama_belakang` varchar(200) NOT NULL,
  `nama_lengkap` varchar(200) NOT NULL,
  `tempat_lahir` varchar(200) NOT NULL,
  `tanggal_lahir` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `no_telepon` varchar(30) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `kelurahan` varchar(200) NOT NULL,
  `kecamatan` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_akun_profile_pelanggan`
--

INSERT INTO `t_akun_profile_pelanggan` (`kode_pelanggan`, `nama_depan`, `nama_belakang`, `nama_lengkap`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, `no_telepon`, `alamat`, `kelurahan`, `kecamatan`, `email`, `password`) VALUES
('KP002', 'test', ' test', ' test', ' test', '2022-07-20', ' ', ' test', ' test', 'test', 'test', '1', '1'),
('KP003', 'Muhammad', ' Dila', ' Muhammad Dila', ' Bandung', '2002-11-21', 'Pria', ' 08155236589', ' Jl. Cempaka 1 No. 33', ' Rancaekek', 'Rancakeke', 'muhammaddila@gmail.com', 'dila12345'),
('KP001', 'Muhammad', ' Dila', ' Muhammad Dila', ' Bandung', '2002-11-21', 'Pria', '08122635168', ' Jl. Cempaka 1 No 33 RT. 05 RW. 06', ' Rancakek', ' Rancakek Kencana', 'muhdila21@gmail.com', 'muhdila21');

-- --------------------------------------------------------

--
-- Table structure for table `t_keranjang`
--

CREATE TABLE `t_keranjang` (
  `kode_keranjang` varchar(30) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `harga_barang` varchar(30) NOT NULL,
  `email_pelanggan` varchar(30) NOT NULL,
  `tgl_pemesanan` varchar(30) NOT NULL,
  `jumlah_pemesanan` varchar(30) NOT NULL,
  `total_biaya` varchar(30) NOT NULL,
  `kode_barang` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_keranjang`
--

INSERT INTO `t_keranjang` (`kode_keranjang`, `nama_barang`, `harga_barang`, `email_pelanggan`, `tgl_pemesanan`, `jumlah_pemesanan`, `total_biaya`, `kode_barang`) VALUES
('KKRJ002', 'Baso Tahu Medium', '20000', 'muhammaddila@gmail.com', '14/07/2022', '1', '20000', 'KBRCF02'),
('KKRJ003', 'Baso Tahu Lengkap', '25000', 'muhammaddila@gmail.com', '14/07/2022', '1', '25000', 'KBRCF03'),
('KKRJ009', 'Catering Kecil', '500000', 'muhammaddila@gmail.com', '14/07/2022', '1', '500000', 'KBRCF17'),
('KKRJ010', 'Frozen Original', '20000', 'muhammaddila@gmail.com', '14/07/2022', '1', '20000', 'KBRCF20'),
('KKRJ011', 'Frozen Siomay', '20000', 'muhammaddila@gmail.com', '14/07/2022', '1', '20000', 'KBRCF21'),
('KKRJ013', 'Frozen Siomay', '20000', 'muhammaddila@gmail.com', '14/07/2022', '1', '20000', 'KBRCF21'),
('KKRJ014', 'Baso Tahu Lengkap', '25000', '1', '16/07/2022', '1', '25000', 'KBRCF03'),
('KKRJ015', 'Baso Tahu Lengkap', '25000', '1', '16/07/2022', '1', '25000', 'KBRCF03'),
('KKRJ016', 'Baso Tahu Lengkap', '25000', '1', '16/07/2022', '1', '25000', 'KBRCF03');

-- --------------------------------------------------------

--
-- Table structure for table `t_laporan_transaksi`
--

CREATE TABLE `t_laporan_transaksi` (
  `kode_laporan_transaksi` varchar(30) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `harga_barang` varchar(30) NOT NULL,
  `email_pelanggan` varchar(30) NOT NULL,
  `jumlah_pemesanan` varchar(30) NOT NULL,
  `tanggal_pemesanan` varchar(30) NOT NULL,
  `total_biaya` varchar(30) NOT NULL,
  `kode_barang` varchar(30) NOT NULL,
  `grand_total` varchar(30) NOT NULL,
  `uang_bayar` varchar(30) NOT NULL,
  `kembalian` varchar(30) NOT NULL,
  `kode_transaksi` varchar(30) NOT NULL,
  `total_pendapatan` varchar(30) NOT NULL,
  `Bulan` varchar(30) NOT NULL,
  `Tahun` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_laporan_transaksi`
--

INSERT INTO `t_laporan_transaksi` (`kode_laporan_transaksi`, `nama_barang`, `harga_barang`, `email_pelanggan`, `jumlah_pemesanan`, `tanggal_pemesanan`, `total_biaya`, `kode_barang`, `grand_total`, `uang_bayar`, `kembalian`, `kode_transaksi`, `total_pendapatan`, `Bulan`, `Tahun`) VALUES
('KLTR001', 'Jus Alpukat', '15000', 'muhdila21@gmail.com', '2', '16/07/2022', '30000', 'KBRCF09', '70000', '100000', '-30000', '0000716', '70000', 'Juli 2022', '2022'),
('KLTR002', 'Jus Stroberi', '15000', 'muhdila21@gmail.com', '2', '16/07/2022', '30000', 'KBRCF10', '70000', '100000', '-30000', '0000716', '70000', 'Juli 2022', '2022'),
('KLTR003', 'Jus Lemon', '12000', 'muhdila21@gmail.com', '2', '16/07/2022', '24000', 'KBRCF08', '70000', '100000', '-30000', '0000716', '70000', 'Juli 2022', '2022'),
('KLTR004', 'Air Mineral 450 ml', '3500', 'muhdila21@gmail.com', '2', '16/07/2022', '7000', 'KBRCF06', '70000', '100000', '-30000', '0001016', '70000', 'Oktober 2022', '2022'),
('KLTR005', 'Baso Tahu Lengkap', '25000', 'muhdila21@gmail.com', '1', '16/07/2022', '25000', 'KBRCF03', '70000', '100000', '-30000', '0001016', '70000', 'Oktober 2022', '2022'),
('KLTR006', 'Frozen Dimsum', '20000', 'muhdila21@gmail.com', '1', '16/07/2022', '20000', 'KBRCF22', '70000', '100000', '-30000', '0001016', '70000', 'Oktober 2022', '2022'),
('KLTR007', 'Frozen Siomay', '20000', 'muhdila21@gmail.com', '1', '16/07/2022', '20000', 'KBRCF21', '70000', '100000', '-30000', '0001016', '70000', 'Oktober 2022', '2022'),
('KLTR008', 'Baso Tahu Medium', '20000', 'muhdila21@gmail.com', '1', '16/10/2023', '20000', 'KBRCF02', '70000', '100000', '-30000', '0001016', '70000', 'Oktober 2023', '2023'),
('KLTR009', 'Jus Alpukat', '15000', 'muhdila21@gmail.com', '1', '16/10/2023', '15000', 'KBRCF09', '70000', '100000', '-30000', '0001016', '70000', 'Oktober 2023', '2023'),
('KLTR010', 'Jus Stroberi', '15000', 'muhdila21@gmail.com', '1', '16/10/2023', '15000', 'KBRCF10', '70000', '100000', '-30000', '0001016', '70000', 'Oktober 2023', '2023'),
('KLTR011', 'Frozen Siomay', '20000', 'muhdila21@gmail.com', '1', '16/10/2023', '20000', 'KBRCF21', '70000', '100000', '-30000', '0001016', '70000', 'Oktober 2023', '2023');

-- --------------------------------------------------------

--
-- Table structure for table `t_master_bahan_baku`
--

CREATE TABLE `t_master_bahan_baku` (
  `kode_bahan_baku` varchar(30) NOT NULL,
  `nama_bahan_baku` varchar(30) NOT NULL,
  `tgl_masuk` varchar(30) NOT NULL,
  `satuan_jumlah` varchar(30) NOT NULL,
  `jumlah_bahan_baku` varchar(30) NOT NULL,
  `harga_bahan_baku` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_master_bahan_baku`
--

INSERT INTO `t_master_bahan_baku` (`kode_bahan_baku`, `nama_bahan_baku`, `tgl_masuk`, `satuan_jumlah`, `jumlah_bahan_baku`, `harga_bahan_baku`) VALUES
('CFBH001', 'Tepung Terigu', '15/06/2022', 'Kilogram', '25', '170000'),
('CFBH002', 'Telur', '21/06/2022', 'Kilogram', '5', '125000'),
('CFBH003', 'Tepung Tapioka', '21/06/2022', 'Kilogram', '25', '210000'),
('CFBH004', 'Bawang Daun', '21/06/2022', 'Kilogram', '1', '18000'),
('CFBH005', 'Ikan Tenggiri', '21/06/2022', 'Kilogram', '10', '800000'),
('CFBH006', 'Pangsit', '21/06/2022', 'Kilogram', '6', '80000'),
('CFBH007', 'Ayam Pilet', '21/06/2022', 'Kilogram', '3', '171000'),
('CFBH008', 'Garam', '21/06/2022', 'Bal', '1', '53500'),
('CFBH009', 'Mentega Putih', '21/06/2022', 'Kilogram', '10', '97000'),
('CFBH010', 'Pala', '21/06/2022', 'Kilogram', '1', '75000'),
('CFBH011', 'Micin', '21/06/2022', 'Kilogram', '1', '45000'),
('CFBH012', 'Lada Bubuk', '21/06/2022', 'Picies', '12', '10500');

-- --------------------------------------------------------

--
-- Table structure for table `t_master_barang`
--

CREATE TABLE `t_master_barang` (
  `kode_barang` varchar(15) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `tgl_masuk` varchar(30) NOT NULL,
  `jumlah_barang` varchar(30) NOT NULL,
  `harga_barang` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_master_barang`
--

INSERT INTO `t_master_barang` (`kode_barang`, `nama_barang`, `tgl_masuk`, `jumlah_barang`, `harga_barang`) VALUES
('KBRCF01', 'Baso Tahu Original', '21/06/2022', '45', '15000'),
('KBRCF02', 'Baso Tahu Medium', '21/06/2022', '45', '20000'),
('KBRCF03', 'Baso Tahu Lengkap', '21/06/2022', '1', '25000'),
('KBRCF04', 'Baso Tahu Special', '21/06/2022', '35', '32000'),
('KBRCF05', 'Air Mineral 330 ml', '21/06/2022', '50', '2800'),
('KBRCF06', 'Air Mineral 450 ml', '21/06/2022', '47', '3500'),
('KBRCF07', 'Air Mineral 600 ml', '21/06/2022', '48', '4500'),
('KBRCF08', 'Jus Lemon', '21/06/2022', '48', '12000'),
('KBRCF09', 'Jus Alpukat', '21/06/2022', '1', '15000'),
('KBRCF10', 'Jus Stroberi', '21/06/2022', '36', '15000'),
('KBRCF11', 'Coca Cola Kaleng', '21/06/2022', '50', '5000'),
('KBRCF12', 'Sprite Kaleng', '21/06/2022', '50', '5000'),
('KBRCF13', 'Fanta Kaleng', '21/06/2022', '48', '5000'),
('KBRCF14', 'Kopi Original', '21/06/2022', '50', '7000'),
('KBRCF15', 'Kopi Capuccino', '21/06/2022', '48', '9000'),
('KBRCF16', 'Kopi Misto', '21/06/2022', '45', '9000'),
('KBRCF17', 'Catering Kecil', '21/06/2022', '9', '500000'),
('KBRCF18', 'Catering Medium', '21/06/2022', '8', '750000'),
('KBRCF19', 'Catering Besar', '21/06/2022', '5', '1000000'),
('KBRCF20', 'Frozen Original', '21/06/2022', '7', '20000'),
('KBRCF21', 'Frozen Siomay', '21/06/2022', '35', '20000'),
('KBRCF22', 'Frozen Dimsum', '21/06/2022', '36', '20000'),
('KBRCF23', 'Paria', '21/06/2022', '100', '2500'),
('KBRCF24', 'Tahu Kecil', '21/06/2022', '93', '1500'),
('KBRCF25', 'Siomay Kecil', '21/06/2022', '20', '1500'),
('KBRCF26', 'Telur', '21/06/2022', '200', '3000'),
('KBRCF27', 'Kol', '21/06/2022', '200', '3000'),
('KBRCF28', 'Kentang', '21/06/2022', '200', '3000'),
('KBRCF29', 'Tahu', '21/06/2022', '1000', '2500'),
('KBRCF30', 'Siomay', '21/06/2022', '1000', '2500');

-- --------------------------------------------------------

--
-- Table structure for table `t_pembayaran`
--

CREATE TABLE `t_pembayaran` (
  `kode_pembayaran` varchar(30) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `harga_barang` varchar(30) NOT NULL,
  `email_pelanggan` varchar(30) NOT NULL,
  `jumlah_pemesanan` varchar(30) NOT NULL,
  `tanggal_pemesanan` varchar(30) NOT NULL,
  `total_biaya` varchar(30) NOT NULL,
  `kode_barang` varchar(30) NOT NULL,
  `grand_total` varchar(30) NOT NULL,
  `uang_bayar` varchar(30) NOT NULL,
  `kembalian` varchar(30) NOT NULL,
  `kode_transaksi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_akun_admin`
--
ALTER TABLE `t_akun_admin`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `t_akun_profile_pelanggan`
--
ALTER TABLE `t_akun_profile_pelanggan`
  ADD PRIMARY KEY (`email`),
  ADD KEY `kode_pelanggan` (`kode_pelanggan`);

--
-- Indexes for table `t_keranjang`
--
ALTER TABLE `t_keranjang`
  ADD PRIMARY KEY (`kode_keranjang`);

--
-- Indexes for table `t_laporan_transaksi`
--
ALTER TABLE `t_laporan_transaksi`
  ADD PRIMARY KEY (`kode_laporan_transaksi`);

--
-- Indexes for table `t_master_bahan_baku`
--
ALTER TABLE `t_master_bahan_baku`
  ADD PRIMARY KEY (`kode_bahan_baku`);

--
-- Indexes for table `t_master_barang`
--
ALTER TABLE `t_master_barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indexes for table `t_pembayaran`
--
ALTER TABLE `t_pembayaran`
  ADD PRIMARY KEY (`kode_pembayaran`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_keranjang`
--
ALTER TABLE `t_keranjang`
  ADD CONSTRAINT `t_keranjang_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `t_master_barang` (`kode_barang`),
  ADD CONSTRAINT `t_keranjang_ibfk_2` FOREIGN KEY (`email_pelanggan`) REFERENCES `t_akun_profile_pelanggan` (`email`);

--
-- Constraints for table `t_laporan_transaksi`
--
ALTER TABLE `t_laporan_transaksi`
  ADD CONSTRAINT `t_laporan_transaksi_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `t_master_barang` (`kode_barang`),
  ADD CONSTRAINT `t_laporan_transaksi_ibfk_2` FOREIGN KEY (`email_pelanggan`) REFERENCES `t_akun_profile_pelanggan` (`email`);

--
-- Constraints for table `t_pembayaran`
--
ALTER TABLE `t_pembayaran`
  ADD CONSTRAINT `t_pembayaran_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `t_master_barang` (`kode_barang`),
  ADD CONSTRAINT `t_pembayaran_ibfk_2` FOREIGN KEY (`email_pelanggan`) REFERENCES `t_akun_profile_pelanggan` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
