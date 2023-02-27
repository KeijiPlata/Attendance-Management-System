-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 27, 2023 at 06:41 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `joysis_ams`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `student_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `remarks` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`student_id`, `name`, `status`, `date`, `remarks`) VALUES
(1, 'Lord Miacky Keiji Esternon Plata', 'Present', '2023-01-11', 'He was a good student.'),
(1, 'Lord Miacky Keiji Esternon Plata', 'Late', '2023-01-13', 'Walang ligo.'),
(1, 'Lord Miacky Keiji Esternon Plata', 'Absent', '2023-01-13', 'Nagkasakit.'),
(20, 'Reje Abordo Cuaresma', 'Present', '2023-01-13', 'Very good ka'),
(30, 'Charlene Joy Despolon Miral', 'Absent', '2023-01-13', 'Absent ka'),
(1, 'Lord Miacky Keiji Esternon Plata', 'Present', '2023-01-15', 'Mabait akong estudyante.'),
(18, 'John Ruwel Boridas Bartido', 'Absent', '2023-01-14', 'Good job'),
(19, 'Vince Ashley Morales Carillage', 'Present', '2023-01-14', 'Very good'),
(20, 'Reje Abordo Cuaresma', 'Late', '2023-01-14', 'Bad'),
(21, 'Bernard Andrew Sison De Guzman', 'Present', '2023-01-14', 'Good'),
(22, 'John Christopher Serote Go', 'Present', '2023-01-14', 'Good'),
(23, 'Ed Reinan Gaceta Jimenez', 'Present', '2023-01-14', 'Good'),
(24, 'Bea Angela Mata Jocson', 'Present', '2023-01-14', 'Very Good'),
(25, 'Rose Anne Magbanua Lopez', 'Present', '2023-01-14', 'Very Good'),
(26, 'Sebastian L Macaraig', 'Absent', '2023-01-14', 'Not good'),
(27, 'Andre Figuron Mandantes', 'Present', '2023-01-14', 'Very good'),
(28, 'Wendel  Dela Cruz Manosca', 'Present', '2023-01-14', 'Very good'),
(1, 'Lord Miacky Keiji Esternon Plata', 'Absent', '2023-01-15', 'Tsk'),
(35, 'John Zachary Mereul Bernados Tecson', 'Present', '2023-01-15', 'Good'),
(36, 'Rafael Duran Tedra', 'Present', '2023-01-15', 'Good'),
(37, 'Kisses Huretas Ureta', 'Late', '2023-01-15', 'Hayst'),
(38, 'Jula Mae Bueno Villanueva', 'Present', '2023-01-15', 'Very good'),
(46, 'Avan Hernandez Dizon', 'Late', '2023-01-15', 'Poor'),
(43, 'Michael Matthew Jordan', 'Present', '2023-01-15', 'Good');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `middlename` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `section` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `username`, `password`, `firstname`, `middlename`, `lastname`, `section`, `gender`) VALUES
(1, 'keiji', '12345', 'Lord Miacky Keiji', 'Esternon', 'Plata', 'DICT', 'Male'),
(17, 'kim', '1234', 'Kim Jacob', 'Laurio', 'Arizala', 'JavaNC', 'Male'),
(18, 'johnR', '1234', 'John Ruwel', 'Boridas', 'Bartido', 'JavaNC', 'Male'),
(19, 'vince', '1234', 'Vince Ashley', 'Morales', 'Carillage', 'JavaNC', 'Male'),
(20, 'reje', '1234', 'Reje', 'Abordo', 'Cuaresma', 'JavaNC', 'Male'),
(21, 'bernard', '1234', 'Bernard Andrew', 'Sison', 'De Guzman', 'JavaNC', 'Male'),
(22, 'jaycee', '1234', 'John Christopher', 'Serote', 'Go', 'JavaNC', 'Male'),
(23, 'ed', '1234', 'Ed Reinan', 'Gaceta', 'Jimenez', 'JavaNC', 'Male'),
(24, 'bea', '1234', 'Bea Angela', 'Mata', 'Jocson', 'JavaNC', 'Female'),
(25, 'rose', '1234', 'Rose Anne', 'Magbanua', 'Lopez', 'JavaNC', 'Female'),
(26, 'sebastian', '1234', 'Sebastian', 'L', 'Macaraig', 'JavaNC', 'Male'),
(27, 'andre', '1234', 'Andre', 'Figuron', 'Mandantes', 'JavaNC', 'Male'),
(28, 'wendel', '123456', 'Wendel ', 'Dela Cruz', 'Manosca', 'JavaNC', 'Male'),
(29, 'jay', '1234', 'Jay', 'Locaba', 'Miraflor', 'JavaNC', 'Male'),
(30, 'charlene', '1234', 'Charlene Joy', 'Despolon', 'Miral', 'JavaNC', 'Female'),
(31, 'jose', 'bossjose123', 'Jose Carlos', 'Carolino', 'Navea', 'JavaNC', 'Male'),
(32, 'precious', '1234', 'Precious Gemima', 'Renales', 'Palle', 'JavaNC', 'Female'),
(33, 'harvy', 'tetrisgod', 'Harvy ', 'W', 'Pontillas', 'JavaNC', 'Male'),
(34, 'renz', '1234', 'Renz Anthony', 'Bon', 'Rackhold', 'JavaNC', 'Male'),
(35, 'zach', '1234', 'John Zachary Mereul', 'Bernados', 'Tecson', 'JavaNC', 'Male'),
(36, 'raf', '1234', 'Rafael', 'Duran', 'Tedra', 'JavaNC', 'Male'),
(37, 'kisses', 'bebenidrew', 'Kisses', 'Huretas', 'Ureta', 'JavaNC', 'Female'),
(38, 'jula', '1234', 'Jula Mae', 'Bueno', 'Villanueva', 'JavaNC', 'Female'),
(39, 'herold', '1234', 'Herold', 'Caneda', 'Sayson', 'JavaNC', 'Male'),
(40, 'ben', '1234', 'Ben ', 'Curativo', 'Sinfuego', 'JavaNC', 'Male'),
(43, 'jordan', 'jordan123', 'Michael', 'Matthew', 'Jordan', 'CSS', 'Male'),
(45, 'naruto', '12345', 'Naruto ', 'Uzumaki', 'Uzumaki', 'Leaf Village', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `middlename` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `username`, `password`, `firstname`, `middlename`, `lastname`, `gender`) VALUES
(1, 'abdoljabol', '12345', 'Abdol Jabol', 'Jakulito', 'Salsalani', 'Male'),
(4, 'benz', 'trainernabibilingsystemnamin', 'Benz Vincent', 'A', 'Geraldizo', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
