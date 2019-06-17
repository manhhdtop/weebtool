-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 17, 2019 lúc 11:59 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `webtool`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  `discription` varchar(255) NOT NULL DEFAULT '',
  `type` int(11) NOT NULL DEFAULT '2' COMMENT '0: menu; 1: menu+category; 2: category',
  `created` double NOT NULL,
  `updated` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `parent_id`, `name`, `slug`, `discription`, `type`, `created`, `updated`) VALUES
(1, 0, 'Trang chủ', '', '', 0, 1560591546000, 1560591546000),
(2, 0, 'Bài viết', 'bai-viet', 'Chia sẻ kiến thức, kinh nghiệm về lập trình.', 1, 1560591546000, 1560591546000),
(3, 0, 'Thủ thuật', 'thu-thuat', '', 1, 1560591546000, 1560591546000),
(4, 0, 'Tool', 'tool', '', 1, 1560591546000, 1560591546000),
(5, 0, 'Liên hệ', 'lien-he', '', 0, 1560591546000, 1560591546000),
(7, 2, 'Java core', 'java-core', '', 1, 1560591546000, 1560591546000),
(8, 2, 'Java web', 'java-web', '', 1, 1560591546000, 1560591546000),
(9, 4, 'Timestamp', 'tool/timestamp', '', 1, 1560591546000, 1560591546000),
(10, 4, 'Tính ngày', 'tinh-ngay', '', 1, 1560591546000, 1560591546000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  `title` text NOT NULL,
  `discription` varchar(255) DEFAULT NULL,
  `content` text,
  `slug` varchar(255) NOT NULL,
  `created` double NOT NULL,
  `updated` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tag`
--

CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `created` double NOT NULL,
  `updated` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tag_post`
--

CREATE TABLE `tag_post` (
  `id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tag_post`
--
ALTER TABLE `tag_post`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tag`
--
ALTER TABLE `tag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tag_post`
--
ALTER TABLE `tag_post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
