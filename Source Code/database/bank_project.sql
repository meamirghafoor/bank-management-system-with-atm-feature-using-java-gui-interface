-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2021 at 05:54 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `bank_acc` varchar(20) NOT NULL,
  `atm_acc` varchar(20) NOT NULL,
  `atm_status` varchar(20) NOT NULL,
  `bank_status` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `father` varchar(100) NOT NULL,
  `dob` varchar(50) NOT NULL,
  `cnic` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `acc_type` varchar(20) NOT NULL,
  `postal` varchar(20) NOT NULL,
  `gen` varchar(20) NOT NULL,
  `contect` varchar(20) NOT NULL,
  `blnc` int(11) NOT NULL,
  `address` varchar(300) NOT NULL,
  `join_date` varchar(20) NOT NULL,
  `image` longblob NOT NULL,
  `title` varchar(100) NOT NULL,
  `atm_join` varchar(20) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` varchar(5) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `image` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `user`, `pass`, `image`) VALUES
('1', 'amirghafoorcss@gmail.com', '12344321', 0xffd8ffe000104a46494600010101006000600000ffe110f24578696600004d4d002a000000080004013b00020000000d0000084a8769000400000001000008589c9d00010000001a000010d0ea1c00070000080c0000003e000000001cea000000080000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000416d697220476861666f6f72000000059003000200000014000010a69004000200000014000010ba929100020000000339370000929200020000000339370000ea1c00070000080c0000089a000000001cea000000080000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000323032313a30333a30362031373a33363a343900323032313a30333a30362031373a33363a343900000041006d0069007200200047006800610066006f006f0072000000ffe10b1f687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f003c3f787061636b657420626567696e3d27efbbbf272069643d2757354d304d7043656869487a7265537a4e54637a6b633964273f3e0d0a3c783a786d706d65746120786d6c6e733a783d2261646f62653a6e733a6d6574612f223e3c7264663a52444620786d6c6e733a7264663d22687474703a2f2f7777772e77332e6f72672f313939392f30322f32322d7264662d73796e7461782d6e7323223e3c7264663a4465736372697074696f6e207264663a61626f75743d22757569643a66616635626464352d626133642d313164612d616433312d6433336437353138326631622220786d6c6e733a64633d22687474703a2f2f7075726c2e6f72672f64632f656c656d656e74732f312e312f222f3e3c7264663a4465736372697074696f6e207264663a61626f75743d22757569643a66616635626464352d626133642d313164612d616433312d6433336437353138326631622220786d6c6e733a786d703d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f223e3c786d703a437265617465446174653e323032312d30332d30365431373a33363a34392e3937313c2f786d703a437265617465446174653e3c2f7264663a4465736372697074696f6e3e3c7264663a4465736372697074696f6e207264663a61626f75743d22757569643a66616635626464352d626133642d313164612d616433312d6433336437353138326631622220786d6c6e733a64633d22687474703a2f2f7075726c2e6f72672f64632f656c656d656e74732f312e312f223e3c64633a63726561746f723e3c7264663a53657120786d6c6e733a7264663d22687474703a2f2f7777772e77332e6f72672f313939392f30322f32322d7264662d73796e7461782d6e7323223e3c7264663a6c693e416d697220476861666f6f723c2f7264663a6c693e3c2f7264663a5365713e0d0a0909093c2f64633a63726561746f723e3c2f7264663a4465736372697074696f6e3e3c2f7264663a5244463e3c2f783a786d706d6574613e0d0a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020200a202020202020202020202020202020202020202020202020202020203c3f787061636b657420656e643d2777273f3effdb00430007050506050407060506080707080a110b0a09090a150f100c1118151a19181518171b1e27211b1d251d1718222e222528292b2c2b1a202f332f2a32272a2b2affdb0043010708080a090a140b0b142a1c181c2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2a2affc0001108008200ab03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00d8a28a2bf453e6028a28a0028a28a0028a28a0028a28a0028aced635ed3b41b5f3f54b95894f0abd59fe80726a4d2f57b1d6acc5d69b3acd19eb8e0a9f423a834aeaf62b95daf6d0bb4514532428a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a2a96ababd8e8b64d75a95c2c318e99eac7d00ea4d2bdb71a4dbb22ed71faf78e5219df4ff000f46b7d7a387973fba87b727b9f61df8f6ac7b8d535bf1c5c1b5d3524b1d30fde01b1248beacdc851edd79e86b61348b6f0b595bdbd8c6925f4c708f8c04e8095073c9240c9c9e79e062b1ad5552839cb65f7fa7a9bc29ae6b6eca3a67845a7b9fed4f155e179e4fe299b6b7d147f00ffc7bfdde45437fe1fbed0ee0ea9e18b96b881725846433a8f423a3afebfce8f11dafd8847a7befb8beba8c492de4ae44710dc0649f4ff78e071d32056959f86ef0db3ddc321b7be8c8f2e68e5c8ba01472dcb639cf1923be3b571d3c557e794553565babebdfb5aff3f996f91ef2fc3fafeba17bc3de30b5d5f65bdd6cb7bb3c001b2929ff0064fafb1e7eb5d2570d2787e1f12d8b5eda20b4d454e26464da9311ce48e769f71d083d7151e93e29d4344b8fecff0011452ba46003230cc918f5ff006d3fda1cfd6bbe1523520a70d9fdff00d7e3dcc251b3febfafebe477b45456f730dddba4f6b2a4d14832ae87208a96accc28a28a601451450014514500145145001451450014515e7de25d5f5dd5b51bad274d68b4ab581b6493cf3ac6f37fbb9238fa7e752dd8a493d5bb235fc41e37834e99ac7488c5fea38e555b11c3eeedd07d3f9564e97e10bfd6ef5754f135c3caf9ca823181e88a7ee8f73cfb0eb597a1c92e80fe445a2da5e4d12ac8d37f6944a993c6724f2df8923b601ae83fe134d5ce3fe24569c8ff00a0bc1c7eb59f32bea6b7495a0d7de8ebedad61b380436d1ac6839c0ee7d4fa9f7ac1f1286b5d4f4cd4ca17860728e029620923047be011f5c0ef596de38d59248d1b41b6cc84e08d5612060124920e14601e4e2992f8d350b906d65f0edb48b2236e56d4a1285470727a0fc7af6acaba8d6a6e29db66b4ea9dd7e2850f7257bafbd7f99a7e23d45963b7b98b4d8efb4f299378b71e5988b1c704738c1e7149e178bfb1f436babb8fec76cd1a958b7eec9cb1dc00ee432a80393b738c9ae51af759b7763a5d9c766acc32835781d7f2dc33ee4e4fbd3d753d5bed4926a360ba83bc8b1c71aea716d04f0001b8900e7939039e78ae2e6acea7b4e4f7be5cbf7db99fa58bf6749fdb5f7ff48ecfc2e92b5b5c5cca86359a5628b9cf1b9989fcd88fc2afeaba3d9eb36de4dec5bb1f71c70c87d41ae54f8e35284c7126816d820ecf2f5484a80013d41c01806a4ff84d357e7fe24569c0cffc85e0ff001aedc3a8d1a6a9def6ebe7d5fde4547cd3e6bafbd19b2d9eb5e09bb33d9b89ec9db2f90446fcff0010fe06f71c1fd2bb0d13c4565ae447c8262b851fbcb793865f7f71ee2b9cb9f1bea71dabbcfa05ab45b7e61fdab03f1f404935ce4f6578fae24967670690cac7246a70bf94c3d086c81db6f3f4e315d0aa424fb3febfab89f2dbde6bef47ae51589e1dd4af2ee26835030cd2c6a0f9f6ee1958648c36380dc6700f423a74adbaa32f40a28a298051451400514514005145140051451401cdf8af47baba68756b1befb2cfa74523a8d9b831c67a1e3b1fceb174097c55aed8acf1f88638b744b27364871b8b0c7bfddaec758ff9015fff00d7b49ffa09ae77e1e7fc8122e08ff4487f9c959fda35e76a28c1d362d7bc6565e45e6b81616dccca2d947dd6da46463debb2f10e832eb16f66b6d786d64b59448ac173b881c67f1c1c7b573ff0e7fe3d93838d9360f6ff005d5ddd11b4a2ae129be6f46ff368f3bf0edef8a75e5ca6bf1c7f2b1e6d10f46dbf873515b0f11f8827bcd2ae35f40893c903e2d9413b3073c608ff00eb55cf86e7f744020e125e8b8ff96bdfd6a4f0a9ff008a9f521e9a95cf6f65a3b7a7f91529b57b5b7ecbbb37353f0e35ff0085edf484ba3118446a65031b828c11ed919ae674ab9f14ea3a94f689afc68219e48326d10fdcc7f422bd0eb85f0a7fc8cfa8f0b9fed1b9edcf45efe94dfc4473b4be652797c4d79acde68936bd1b2075b776fb220c878cb7f2045771a269cfa568f059cb39b8923077ca472e49249fd6b92b7dbff0b2351e5777daedf8239c792fd3dabbca2213936dafeb641451455998514514005145140051451400514514005145417b7b069d6335dddbf970c2a59db19c0a43dc8759ff009015ff00fd7b49ff00a09ae73e1d907458f1b722d61071d7abf5ac6f107880788750d3d74e3aba69bb24374d6f03a9652060818f985461b478a08e3b6b8f10da2c48a99b7b331ef0a3037617e63ee79acb9e37bdcd793449b347e1c63c91c2e764b9c75ff5a7ad7795e4f766d6cf4d8a3f0f7f6e2dd46d852b6a62670cc4fccc172dc9e87e95afe25f10cdab0d3ecb484d5e1905c8fb4f956ef1b6cc107071cfd288cd2560704ddefd5fe7724f86e73160e7849719edfbd3d29fe156ff008aa35153ff00411b9233f45e95936d16856906cb397c456e4f2658ad595986738240aaf3a6976b673cba5b7885af598b893c86477391b86fdbc671f9d4b9c52dff00ad06e29df5ebfe7fe67ac570be146ff8a9b515c9ff00908dc9c638e8b5575bf125ddc785adf4db28b558f561e524a45bc8ac4f1bbe6c77aa915be896724bb24f114772cc7cc996d5bcc0c7afcc07b5539c6fb93c8b97734eddb1f12351193cdddbf18e0fee5fbd7795e552c3a3c69733dacbe2092fd94949a4b66de1b185f9b19f6fa5749e1bf1759c76b67a5ea4d7b1df9183f698d89019be4dcd8eb82a334e3257e51ca176dafeb44763451456a621451450014514500145145001451450015e7be20f10ea5ae45abe8d63a7c1e42c86d4caf3e1c91d48503a57a1579b69b7b73a5789357bbfb0cd710477d3b32c58df9380300919e3d2a24afa171972abfe6491c9a95944a8fa758ea4c8aaab2333a14554550a06de985a71bfd41467fe119d3be4e9899bf4f96b5bfe13b38cff00c23faaf4cffab5ff001a41e3dce31e1fd57e6191fbb5ff001acdf2b77b8a3eeab69f8195f6fd4071ff0008ce9dc7cdc4cfd7fef9eb47dbf502003e19d3b1f7b999faff00df3d6b5878f372823c3faae0ff00d335ff001a4ff84f7a7fc53faaf271fea97fc697bbdcabfa7dff00f04cafb7ea0c39f0ce9df3f27333febf2d1f6fd4181cf8674ec3707333febf2d6b0f1e6738f0feabc1c7faa5ff001a43e3dc673e1fd578383fbb5ff1a3ddee17f4fbff00e0995fda1a875ff84674fc9f97fd73f4ff00be7a502ff511f77c33a70c7ca3f7cfd3fef9e95adff09e7247fc23faae475fddaff8d27fc2798ce7c3faaf033fead7fc68f77b85fd3eff00f82657dbf505e9e19d3fe41c6267fd3e5aa0d6faa36a535f476167668b1a31822dcde69470ff002fcbd4ed02ba51e3cc903fe11fd5724647eed7fc690f8f33c7fc23faae4838fddaff008d38b49dee177e5f816fc29e25bad7d64379631db7cbba368e5de186707e841ae8eb8af87f6f2dbdbc6b708524303b1463f32832b6011dba719aed6b58bba21b4dbb79fe614514550828a28a0028a2b2757f11d968d3c56f32cd3dd4dcc76f6f1ef761eb8a0a8c253768a35a8ae765f18db8d2efae63b2ba49ecd559edae93ca6c31c03deb634dbcfed1d2edaf3cbf2fcf8964d99cedc8ce33de8b32a54a7057922d54325a5bcafbe5b789d8f76404d4d45220aff60b3ff9f483fefd8a3ec167ff003e907fdfb15cf1f1fe9fb6675d3f5278a06d924ab0294439c7277715d1595e437f6515d5abef8655dc8d8c714eda5cd674ea53d64ac27d82cffe7d60ff00bf628fb059ff00cfac1ff7ec558a29195d95fec167ff003eb07fdfb147d82cff00e7d60ffbf62b3ef35ffb278a2cb47fb36ffb5217f3bccc6dc6ee318e7eefad6c53b6972e519c6d7eba95fec167ff003e907fdfb147d82cff00e7d60ffbf62a9df6bf6ba7eb367a64d1ccd35dff00ab645054738e79cfe953ea9a97f665bacbf62bbbcdcdb765a45e630e3a919e9c5161f24ee97725fb059ffcfa41ff007ec51f60b3ff009f483fefd8a9c1ca8382323a1a5a5633bb191431420886348c1ea1140cd3ea8cba9f95ab4561f62bc7f31777da122cc2bd782d9e0f1fa8a8f44d72db5eb7966b349516294c4c25001240078c13c734ec5b84adcd6d0d2a28a476da8cdd703348cc5a2b23c35aeffc243a5b5e7d9becfb6531ecdfbfa01ce703d6b5e9b562a7170938cb7415c97887429351f114579a36a915aeab6f10fdd487aaf386efea47422badaccd4fc39a4eb132cba8d9acd228c070cca71e99523342d1dcd6854f672bb7f85ff03879f5cd42fb43d7b4fd5d6196e6d235537310033890020e38fa74ef4cd0c0d47c45a4db78847970c3668d630920a49c0c13ee704e3d80edcf771f87349874b974e8ac912d66c7988ac417c1c8cb6727f3a4b8f0e6957705a433dae56cc0101123ab46063a3039ec3bd5a924767d6a959c62ad7bfcb448e0753b893c3f36bda1c4ac3edce8d6c00ecc7903f038fc2bd1b48b05d3347b5b25ff0096318527d4f73f9e6b1f52f0dcfa9f8c2cb5395a01696883e5c9f319812476c632477ae9295fdd31c4d6538c52f57ebb7e9f89e53a6e9d797da0ebcd0ea62d6da3959a580c408971cfdece474abe9a969ba8787346b5bbd2e5b89999e382ce094a23107192c4e7f5eb9aea1bc0fe1d790c8da76598ee27ce9393ff007d55cbcf0e691a85ac36d75631b4300c44ab94d9f42a451ccac744f174a52bebbdfb5b4b747afe0717e1e33da6abaf69e607b2816cddfec667f3446d81fc5dfaff009c5640d150780a3d6c5d5c8b8866c469bfe44f9f1c0c641efd6bd26cfc35a4584933d9d9ac4d345e549b5db057d319f6ebd69dff0008ee97fd8ffd95f65ff42ddbbcaf31bae73d739ebef4737e81f5d8a95d5f757f92b3ea717addd5f1f126857561189ef5b4ede8ac7ab156c9f7f5f7ad8f87b159c9a4cb7a9219b509a43f6a77fbc0e7207d0f5cf73f4c0dff00ec3d385e5addfd9ff7f671f95036f6f917046319c1ea7ad2d9e89a7d85fcf79676fe54f719f34abb61b9cfddce3f4a7ccad6feb730a98884a97b34adb7eba7a1cc789bfe4a1e81f87fe846ac7c49ff00915d3febe53f9356dea9e1dd2b5a9925d4ed7ce78d76a9f319703f022abaf83b424b392d56c710c8eaecbe73f2467073bb3dcd4a6acbcbfcc70af4d3849def1f2ff8272d75a447adfc42bcb39a79e08cd92b3185b05be54e0fa8f6f6ac286c1aebc0936a52dedd17b1b911c10f99fbb5076f20763f376f4af548f48b18b547d46383176f1f96d26f6e578e319c761daabc7e19d222d265d352d316933f98f1f9afcb71ce739ec3bd3e6b2febb9ac31aa292d74e5fc37fbce52f146a5e2ff000f2de0f316e74ec4a3246edc8f9e9f5aa3e18b2b7b7f0eeadabdbc59d46c5a4104818e631b3aedce0f53d4577dfd87a70bcb5bbfb3fefece3f2a06dedf22e08c63383d4f5a8a1f0d6916faa1d460b254ba249de19b192307e5ce3b9ed47368d7afe64fd6e3c9cbaecbf06f4f477ff8079e5ae9da8dde8d0ea5a6e9d22ddab798daa1d4972d8273b9588c7ff5b9cd6b4102788bc6b7e9ae3171670661844a5429f979054fe3f8d74cfe0cf0f4971e73699186ce70acc17fef9071fa54f7de19d1f52bb4b9bdb08e4950001b2572074c80707f1a6e49952c641beab7d7aadbcffc8c6f86bff22bc9ff005f2dfc96baeaa7a6e9567a3da9b7d3a1f2622c5caee2dc9f724fa55ca993bbb9c35a6aa5494d7561451452310a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2803fffd9);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `father` varchar(70) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `marital` varchar(20) NOT NULL,
  `cnic` varchar(20) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `postal` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `contect` varchar(20) NOT NULL,
  `edu` varchar(100) NOT NULL,
  `incom` varchar(20) NOT NULL,
  `address` varchar(300) NOT NULL,
  `status` varchar(30) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `joiningdate` varchar(30) NOT NULL,
  `image` longblob NOT NULL,
  `login_status` varchar(30) NOT NULL,
  `log_time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `bnk` varchar(20) NOT NULL,
  `se_acc` varchar(20) NOT NULL,
  `se_name` varchar(50) NOT NULL,
  `re_name` varchar(50) NOT NULL,
  `re_acc` varchar(20) NOT NULL,
  `date` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `amount` varchar(20) NOT NULL,
  `type` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `strength`
--

CREATE TABLE `strength` (
  `id` varchar(5) NOT NULL,
  `empid` varchar(20) NOT NULL,
  `acc_atm` int(11) NOT NULL,
  `acc_bank` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `strength`
--

INSERT INTO `strength` (`id`, `empid`, `acc_atm`, `acc_bank`) VALUES
('1', '1000', 12000, 20000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
