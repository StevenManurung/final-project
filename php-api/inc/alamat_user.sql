-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Des 2023 pada 13.16
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbalamat`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `alamat_user`
--

CREATE TABLE `alamat_user` (
  `id` int(11) NOT NULL,
  `nama` varchar(75) NOT NULL,
  `nohp` int(13) NOT NULL,
  `provinsi` varchar(100) NOT NULL,
  `kota` varchar(50) NOT NULL,
  `kecamatan` varchar(50) NOT NULL,
  `kodepos` int(10) NOT NULL,
  `namajalan` text NOT NULL,
  `detailalamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `alamat_user`
--

INSERT INTO `alamat_user` (`id`, `nama`, `nohp`, `provinsi`, `kota`, `kecamatan`, `kodepos`, `namajalan`, `detailalamat`) VALUES
(1, 'Steven Manurung', 2147483647, 'Sumatera Utara', 'Medan', 'Medan Perjuangan', 20236, 'jl. perjuangan', 'yang ada pohon mangga'),
(2, 'aafsdad', 2131231, 'zsdasdasdas', 'dasdasda', 'sdasdas', 2131231, 'dasdasdas', 'asdasdada'),
(3, 'sdfsdf', 812640982, 'sdfsdfs', 'asd', 'adsas', 232, 'asdasd', 'asdasdas');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `alamat_user`
--
ALTER TABLE `alamat_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `alamat_user`
--
ALTER TABLE `alamat_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
