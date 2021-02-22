-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2019 at 06:51 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posyandu2`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_bayi`
--

CREATE TABLE `data_bayi` (
  `kdBayi` varchar(5) NOT NULL,
  `NIK` varchar(20) NOT NULL,
  `nmBayi` varchar(20) NOT NULL,
  `tglLahir` date NOT NULL,
  `jenKelamin` varchar(1) NOT NULL,
  `nmOrtu` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `RT` varchar(10) NOT NULL,
  `noTelp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_bayi`
--

INSERT INTO `data_bayi` (`kdBayi`, `NIK`, `nmBayi`, `tglLahir`, `jenKelamin`, `nmOrtu`, `alamat`, `RT`, `noTelp`) VALUES
('B01', '123', 'asd', '0000-00-00', 'p', 'qwer', 'zxc', '1', '123');

-- --------------------------------------------------------

--
-- Table structure for table `data_petugas`
--

CREATE TABLE `data_petugas` (
  `kdPetugas` varchar(5) NOT NULL,
  `nmPetugas` varchar(20) DEFAULT NULL,
  `noTelp` varchar(15) DEFAULT NULL,
  `alamat` varchar(30) DEFAULT NULL,
  `possisi` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_petugas`
--

INSERT INTO `data_petugas` (`kdPetugas`, `nmPetugas`, `noTelp`, `alamat`, `possisi`) VALUES
('P1', '1', '123', 'asd', '123');

-- --------------------------------------------------------

--
-- Table structure for table `pemeriksaan`
--

CREATE TABLE `pemeriksaan` (
  `kdBayi` varchar(5) DEFAULT NULL,
  `beratBdn` int(5) DEFAULT NULL,
  `tinggiBdn` int(5) DEFAULT NULL,
  `tglPemeriksaan` date DEFAULT NULL,
  `kdPetugas` varchar(5) DEFAULT NULL,
  `Keterangan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pemeriksaan`
--

INSERT INTO `pemeriksaan` (`kdBayi`, `beratBdn`, `tinggiBdn`, `tglPemeriksaan`, `kdPetugas`, `Keterangan`) VALUES
('B01', 11, 123, '1990-12-12', 'P1', 'sehat');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_bayi`
--
ALTER TABLE `data_bayi`
  ADD PRIMARY KEY (`kdBayi`);

--
-- Indexes for table `data_petugas`
--
ALTER TABLE `data_petugas`
  ADD PRIMARY KEY (`kdPetugas`);

--
-- Indexes for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD KEY `fkKdBayi` (`kdBayi`),
  ADD KEY `fkKdPetugas` (`kdPetugas`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD CONSTRAINT `fkKdBayi` FOREIGN KEY (`kdBayi`) REFERENCES `data_bayi` (`kdBayi`),
  ADD CONSTRAINT `fkKdPetugas` FOREIGN KEY (`kdPetugas`) REFERENCES `data_petugas` (`kdPetugas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
