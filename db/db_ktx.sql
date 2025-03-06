/*
 Navicat Premium Data Transfer

 Source Server         : 157.66.218.70 - k3
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39-0ubuntu0.24.04.2)
 Source Host           : 157.66.218.70:3306
 Source Schema         : db_ktx

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39-0ubuntu0.24.04.2)
 File Encoding         : 65001

 Date: 20/11/2024 14:34:12
*/

CREATE DATABASE db_ktx;
use db_ktx;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_type_id` bigint NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `created_date` datetime(6) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `extra_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `is_default` bigint NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sort_order` int NULL DEFAULT NULL,
  `status` bigint NULL DEFAULT NULL,
  `value` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (7, 4, '12312', 'anonymousUser', '2024-02-01 10:22:20.218000', '', NULL, NULL, NULL, NULL, '12313', NULL, NULL, NULL);
INSERT INTO `category` VALUES (8, 5, 'DT_2', 'anonymousUser', '2024-02-27 14:20:16.135000', '', NULL, NULL, NULL, NULL, 'Đối tượng 2', NULL, NULL, NULL);
INSERT INTO `category` VALUES (9, 5, 'DT_3', 'anonymousUser', '2024-02-27 14:20:26.103000', '', NULL, NULL, NULL, NULL, 'Đối tượng 3', NULL, NULL, NULL);
INSERT INTO `category` VALUES (10, 5, 'DT_4', 'anonymousUser', '2024-02-27 14:20:35.843000', '', NULL, NULL, NULL, NULL, 'Đối tượng 4', NULL, NULL, NULL);
INSERT INTO `category` VALUES (19, 6, '01', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Kinh', NULL, NULL, NULL);
INSERT INTO `category` VALUES (20, 6, '02', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Tày', NULL, NULL, NULL);
INSERT INTO `category` VALUES (21, 6, '03', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Thái', NULL, NULL, NULL);
INSERT INTO `category` VALUES (22, 6, '04', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Hoa', NULL, NULL, NULL);
INSERT INTO `category` VALUES (23, 6, '05', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Khơ-me', NULL, NULL, NULL);
INSERT INTO `category` VALUES (24, 6, '06', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Mường', NULL, NULL, NULL);
INSERT INTO `category` VALUES (25, 6, '07', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Nùng', NULL, NULL, NULL);
INSERT INTO `category` VALUES (26, 6, '08', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'HMông', NULL, NULL, NULL);
INSERT INTO `category` VALUES (27, 6, '09', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Dao', NULL, NULL, NULL);
INSERT INTO `category` VALUES (28, 6, '10', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Gia-rai', NULL, NULL, NULL);
INSERT INTO `category` VALUES (29, 6, '11', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Ngái', NULL, NULL, NULL);
INSERT INTO `category` VALUES (30, 6, '12', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Ê-đê', NULL, NULL, NULL);
INSERT INTO `category` VALUES (31, 6, '13', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Ba na', NULL, NULL, NULL);
INSERT INTO `category` VALUES (32, 6, '14', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Xơ-Đăng', NULL, NULL, NULL);
INSERT INTO `category` VALUES (33, 6, '15', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Sán Chay', NULL, NULL, NULL);
INSERT INTO `category` VALUES (34, 6, '16', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Cơ-ho', NULL, NULL, NULL);
INSERT INTO `category` VALUES (35, 6, '17', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Chăm', NULL, NULL, NULL);
INSERT INTO `category` VALUES (36, 6, '18', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Sán Dìu', NULL, NULL, NULL);
INSERT INTO `category` VALUES (37, 6, '19', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Hrê', NULL, NULL, NULL);
INSERT INTO `category` VALUES (38, 6, '20', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Mnông', NULL, NULL, NULL);
INSERT INTO `category` VALUES (39, 6, '21', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Ra-glai', NULL, NULL, NULL);
INSERT INTO `category` VALUES (40, 6, '22', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Xtiêng', NULL, NULL, NULL);
INSERT INTO `category` VALUES (41, 6, '23', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Bru-Vân Kiều', NULL, NULL, NULL);
INSERT INTO `category` VALUES (42, 6, '24', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Thổ', NULL, NULL, NULL);
INSERT INTO `category` VALUES (43, 6, '25', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Giáy', NULL, NULL, NULL);
INSERT INTO `category` VALUES (44, 6, '26', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Cơ-tu', NULL, NULL, NULL);
INSERT INTO `category` VALUES (45, 6, '27', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Gié Triêng', NULL, NULL, NULL);
INSERT INTO `category` VALUES (46, 6, '28', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Mạ', NULL, NULL, NULL);
INSERT INTO `category` VALUES (47, 6, '29', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Khơ-mú', NULL, NULL, NULL);
INSERT INTO `category` VALUES (48, 6, '30', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Co', NULL, NULL, NULL);
INSERT INTO `category` VALUES (49, 6, '31', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Tà-ôi', NULL, NULL, NULL);
INSERT INTO `category` VALUES (50, 6, '32', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Chơ-ro', NULL, NULL, NULL);
INSERT INTO `category` VALUES (51, 6, '33', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Kháng', NULL, NULL, NULL);
INSERT INTO `category` VALUES (52, 6, '34', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Xinh-mun', NULL, NULL, NULL);
INSERT INTO `category` VALUES (53, 6, '35', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Hà Nhì', NULL, NULL, NULL);
INSERT INTO `category` VALUES (54, 6, '36', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Chu ru', NULL, NULL, NULL);
INSERT INTO `category` VALUES (55, 6, '37', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Lào', NULL, NULL, NULL);
INSERT INTO `category` VALUES (56, 6, '38', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'La Chí', NULL, NULL, NULL);
INSERT INTO `category` VALUES (57, 6, '39', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'La Ha', NULL, NULL, NULL);
INSERT INTO `category` VALUES (58, 6, '40', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Phù Lá', NULL, NULL, NULL);
INSERT INTO `category` VALUES (59, 6, '41', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'La Hủ', NULL, NULL, NULL);
INSERT INTO `category` VALUES (60, 6, '42', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Lự', NULL, NULL, NULL);
INSERT INTO `category` VALUES (61, 6, '43', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Lô Lô', NULL, NULL, NULL);
INSERT INTO `category` VALUES (62, 6, '44', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Chứt', NULL, NULL, NULL);
INSERT INTO `category` VALUES (63, 6, '45', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Mảng', NULL, NULL, NULL);
INSERT INTO `category` VALUES (64, 6, '46', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Pà Thẻn', NULL, NULL, NULL);
INSERT INTO `category` VALUES (65, 6, '47', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Co Lao', NULL, NULL, NULL);
INSERT INTO `category` VALUES (66, 6, '48', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Cống', NULL, NULL, NULL);
INSERT INTO `category` VALUES (67, 6, '49', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Bố Y', NULL, NULL, NULL);
INSERT INTO `category` VALUES (68, 6, '50', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Si La', NULL, NULL, NULL);
INSERT INTO `category` VALUES (69, 6, '51', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Pu Péo', NULL, NULL, NULL);
INSERT INTO `category` VALUES (70, 6, '52', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Brâu', NULL, NULL, NULL);
INSERT INTO `category` VALUES (71, 6, '53', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Ơ Đu', NULL, NULL, NULL);
INSERT INTO `category` VALUES (72, 6, '54', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Rơ măm', NULL, NULL, NULL);
INSERT INTO `category` VALUES (73, 6, '55', 'system', '2023-10-07 22:30:43.558000', NULL, NULL, NULL, NULL, NULL, 'Người nước ngoài', NULL, NULL, NULL);
INSERT INTO `category` VALUES (74, 7, 'HOC_VIEN', 'anonymousUser', '2024-03-04 14:44:10.168000', '', NULL, NULL, NULL, NULL, 'Học viên', NULL, NULL, NULL);
INSERT INTO `category` VALUES (75, 7, '01', 'anonymousUser', '2024-03-06 14:29:53.005000', '', NULL, NULL, NULL, NULL, 'Thiếu Úy', NULL, NULL, NULL);
INSERT INTO `category` VALUES (76, 7, '02', 'anonymousUser', '2024-03-06 14:30:00.383000', '', NULL, NULL, NULL, NULL, 'Trung Úy', NULL, NULL, NULL);
INSERT INTO `category` VALUES (77, 5, 'CHUA_DU_DK', 'anonymousUser', '2024-03-06 16:11:51.357000', '', NULL, NULL, NULL, NULL, 'Chưa đủ điều kiện', NULL, NULL, NULL);
INSERT INTO `category` VALUES (78, 7, '03', 'anonymousUser', '2024-04-05 20:40:12.934000', '', NULL, NULL, NULL, NULL, 'Thượng Úy', NULL, NULL, NULL);
INSERT INTO `category` VALUES (79, 7, '04', 'anonymousUser', '2024-04-05 20:40:30.085000', '', NULL, NULL, NULL, NULL, 'Đại Úy', NULL, NULL, NULL);
INSERT INTO `category` VALUES (80, 7, '05', 'anonymousUser', '2024-04-05 20:40:38.885000', '', NULL, NULL, NULL, NULL, 'Thiếu Tá', NULL, NULL, NULL);
INSERT INTO `category` VALUES (81, 7, '06', 'anonymousUser', '2024-04-05 20:40:47.195000', '', NULL, NULL, NULL, NULL, 'Trung Tá', NULL, NULL, NULL);
INSERT INTO `category` VALUES (82, 7, '07', 'anonymousUser', '2024-04-05 20:40:57.485000', '', NULL, NULL, NULL, NULL, 'Thượng Tá', NULL, NULL, NULL);
INSERT INTO `category` VALUES (83, 7, '08', 'anonymousUser', '2024-04-05 20:41:07.825000', '', NULL, NULL, NULL, NULL, 'Đại Tá', NULL, NULL, NULL);
INSERT INTO `category` VALUES (84, 7, '10', 'anonymousUser', '2024-04-05 20:41:19.865000', '', NULL, NULL, NULL, NULL, 'Thiếu Tướng', NULL, NULL, NULL);
INSERT INTO `category` VALUES (85, 7, '11', 'anonymousUser', '2024-04-05 20:41:25.383000', '', NULL, NULL, NULL, NULL, 'Trung Tướng', NULL, NULL, NULL);
INSERT INTO `category` VALUES (86, 8, 'HK1', '500-500', '2024-11-07 08:40:13.254000', '', NULL, NULL, NULL, NULL, 'Học kỳ 1', NULL, NULL, NULL);
INSERT INTO `category` VALUES (87, 8, 'HK2', '500-500', '2024-11-07 08:40:26.099000', '', NULL, NULL, NULL, NULL, 'Học kỳ 2', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for category_type
-- ----------------------------
DROP TABLE IF EXISTS `category_type`;
CREATE TABLE `category_type`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `created_date` datetime(6) NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` datetime(6) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `status` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category_type
-- ----------------------------
INSERT INTO `category_type` VALUES (6, 'DT', 'anonymousUser', '2024-03-04 13:12:20.675000', NULL, NULL, 'Dân tộc', NULL);

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã lớp',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Tên lớp',
  `department_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã khoa',
  `created_date` datetime NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (2, 'CNTT15', 'Công nghệ thông tin 15', 'CNTT', '2024-11-06 22:21:32', '500-500', '2024-11-06 22:28:26', '500-500');
INSERT INTO `classroom` VALUES (5, 'MMT15', 'Mạng máy tính 15', 'CNTT', '2024-11-07 16:51:21', '500-500', NULL, NULL);
INSERT INTO `classroom` VALUES (6, 'ATTT15', 'An toàn thông tin 15', 'CNTT', '2024-11-07 16:56:55', '500-500', '2024-11-07 18:27:02', '500-500');
INSERT INTO `classroom` VALUES (7, 'DTVT', 'Điện tử viễn thông 15', 'DTVT', '2024-11-09 21:49:39', '500-500', '2024-11-09 21:49:44', '500-500');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã hợp đồng',
  `student_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã sinh viên',
  `room_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã phòng',
  `from_date` date NOT NULL COMMENT 'Từ ngày',
  `to_date` date NULL DEFAULT NULL COMMENT 'Đến ngày',
  `status` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'ACTIVE - Còn hiệu lực; INACTIVE - Hết hạn',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, 'HD00001', '16150346', '417-N7', '2024-10-01', '2024-11-30', 'ACTIVE', '2024-11-11 17:23:44', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (2, 'HD00002', '16150347', '417-N7', '2024-10-01', '2025-03-13', 'ACTIVE', '2024-11-11 18:08:25', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (3, 'HD00003', '16150349', '417-N7', '2024-09-01', NULL, 'ACTIVE', '2024-11-11 18:10:03', 'CB001', '2024-11-12 14:54:15', 'CB001');
INSERT INTO `contract` VALUES (4, 'HD00004', '16150355', '401-N7', '2024-11-20', NULL, 'INACTIVE', '2024-11-11 18:11:52', 'CB001', '2024-11-11 18:15:04', 'CB001');
INSERT INTO `contract` VALUES (7, 'HD00005', '16150386', '401-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (8, 'HD00006', '16150387', '401-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (9, 'HD00007', '16150388', '401-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (10, 'HD00008', '16150389', '401-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (11, 'HD00009', '16150390', '401-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (12, 'HD00010', '16150391', '401-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (13, 'HD00011', '16150392', '401-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (14, 'HD00012', '16150393', '401-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (15, 'HD00013', '16150394', '402-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (16, 'HD00014', '16150395', '402-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (17, 'HD00015', '16150396', '402-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (18, 'HD00016', '16150397', '402-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (19, 'HD00017', '16150400', '402-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (20, 'HD00018', '16150402', '402-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (21, 'HD00019', '16150404', '402-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (22, 'HD00020', '16150405', '402-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (23, 'HD00021', '16150406', '403-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (24, 'HD00022', '16150407', '403-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (25, 'HD00023', '16150408', '403-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (26, 'HD00024', '16150409', '403-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (27, 'HD00025', '16150410', '403-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (28, 'HD00026', '16150411', '403-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (29, 'HD00027', '16150412', '403-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (30, 'HD00028', '16150413', '403-N7', '2024-11-01', NULL, 'INACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (31, 'HD00029', '16150414', '404-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (32, 'HD00030', '16150415', '404-N7', '2024-11-01', NULL, 'INACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (33, 'HD00031', '16150416', '404-N7', '2024-11-01', NULL, 'INACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (34, 'HD00032', '16150418', '404-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (35, 'HD00033', '16150419', '404-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (36, 'HD00034', '16150420', '404-N7', '2024-11-01', NULL, 'INACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (37, 'HD00035', '16150421', '404-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (38, 'HD00036', '16150422', '404-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (39, 'HD00037', '16150423', '405-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (40, 'HD00038', '16150424', '405-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (41, 'HD00039', '16150425', '405-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (42, 'HD00040', '16150426', '405-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (43, 'HD00041', '16150366', '502-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (44, 'HD00042', '16150369', '502-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (45, 'HD00043', '16150374', '502-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (46, 'HD00044', '16150375', '502-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (47, 'HD00045', '16150377', '502-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (48, 'HD00046', '16150381', '502-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (49, 'HD00047', '16150385', '502-N7', '2024-11-01', '2024-11-12', 'INACTIVE', '2024-11-12 14:54:56', 'CB001', '2024-11-12 16:12:43', 'CB001');
INSERT INTO `contract` VALUES (50, 'HD00048', '16150398', '502-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (51, 'HD00049', '16150399', '503-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (52, 'HD00050', '16150401', '503-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (53, 'HD00051', '16150403', '503-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (54, 'HD00052', '16150417', '503-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (55, 'HD00053', '16150431', '503-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (56, 'HD00054', '16150442', '503-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (57, 'HD00055', '16150448', '503-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (58, 'HD00056', '16150457', '503-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (59, 'HD00057', '16150459', '504-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (60, 'HD00058', '16150463', '504-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (61, 'HD00059', '16150470', '504-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (62, 'HD00060', '16150471', '510-N7', '2024-11-01', NULL, 'ACTIVE', '2024-11-12 14:54:56', 'CB001', '2024-11-17 14:57:49', 'CB001');
INSERT INTO `contract` VALUES (63, 'HD00061', '16150512', '504-N7', '2024-11-01', '2024-11-13', 'INACTIVE', '2024-11-12 14:54:56', 'CB001', '2024-11-13 09:02:46', 'CB001');
INSERT INTO `contract` VALUES (66, '7', '123', '56', '2024-11-18', NULL, 'ACTIVE', '2024-11-18 10:49:55', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (69, 'HD2411673AE459', '16150381', '507-N7', '2024-11-12', NULL, 'ACTIVE', '2024-11-18 13:53:14', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (70, 'HD2411673AE5AA', '16150364', '508-N7', '2024-11-19', NULL, 'ACTIVE', '2024-11-18 06:58:51', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (71, 'HD2410673AE5C3', '16150405', '509-N7', '2024-09-30', NULL, 'ACTIVE', '2024-11-18 06:59:16', 'CB001', NULL, NULL);
INSERT INTO `contract` VALUES (72, 'HD2411673AE679', '16150356', '417-N7', '2024-11-20', '2024-11-18', 'INACTIVE', '2024-11-18 07:02:18', 'CB001', '2024-11-18 07:02:58', 'CB001');
INSERT INTO `contract` VALUES (73, 'HD2411673AE6C9', '16150356', '417-N7', '2024-11-29', NULL, 'ACTIVE', '2024-11-18 07:03:37', 'CB001', NULL, NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `fullname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `date_of_birth` date NULL DEFAULT NULL,
  `address` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `gender` int NULL DEFAULT NULL COMMENT '0-nữ, 1-nam, 2-khác',
  `ethnic` int NULL DEFAULT NULL COMMENT 'dân tộc',
  `organization_work` int NULL DEFAULT NULL COMMENT 'đơn vị công tác',
  `is_outside` int NULL DEFAULT NULL COMMENT 'ngoài học viện',
  `organization_outside` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'đơn vị công tác ngoài học viện',
  `rank_level` int NULL DEFAULT NULL COMMENT 'cấp bậc',
  `is_party_member` int NULL DEFAULT NULL COMMENT 'đảng viên',
  `party_date` date NULL DEFAULT NULL COMMENT 'Ngày vào đảng',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'STUDENT - học viên, OFFICERS - cán bộ',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `phone_number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `type_defence_security` bigint NULL DEFAULT NULL,
  `status_defence_security` int NULL DEFAULT NULL,
  `first_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1974 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1970, 'CB001', 'Nguyễn Xuân X', '1998-08-04', 'Hưng Yên', 1, 19, 3, 0, NULL, 76, 1, '2024-02-01', 'OFFICERS', '2024-04-13 09:50:30', 'D53.TS.B1.003', '2024-11-17 14:14:33', 'CB001', '1312323', 10, 1, 'Nguyễn Xuân', 'X');
INSERT INTO `employee` VALUES (1971, 'CB002', 'Phan Trung A', '1998-02-18', 'Đông Anh, Hà Nội', 1, 19, 4, 0, NULL, 78, 1, '2021-02-15', 'OFFICERS', '2024-04-13 15:26:15', '500-500', '2024-11-17 14:14:43', 'CB001', NULL, 9, 1, 'Phan Trung', 'A');
INSERT INTO `employee` VALUES (1972, 'CB003', 'Nguyễn Hữu B', '1998-07-30', 'Mê Linh, Hà Nội', 1, 19, 9, 0, NULL, 79, 1, '2022-05-23', 'OFFICERS', '2024-04-13 18:47:05', '500-500', '2024-11-17 14:14:50', 'CB001', NULL, 10, 1, 'Nguyễn Hữu', 'B');
INSERT INTO `employee` VALUES (1973, 'CB004', 'Trần Trung C', '1998-07-28', 'Ninh Bình', 1, 19, 3, 0, NULL, 79, 1, '2020-08-26', 'OFFICERS', '2024-04-24 09:42:38', '500-500', '2024-11-17 14:15:00', 'CB001', '0987654321', 10, 1, 'Trần Trung', 'C');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `parent_id` bigint NULL DEFAULT NULL COMMENT 'Id đơn vị cha',
  `org_type` bigint NULL DEFAULT NULL COMMENT 'Loại đơn vị',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `establish_date` date NULL DEFAULT NULL COMMENT 'Ngày thành lập',
  `expired_date` date NULL DEFAULT NULL COMMENT 'Ngày dừng hoạt động',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `org_level` int NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `sort_order` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES (1, '001', 'Học viện X', 0, NULL, '', '2023-10-24', NULL, '/1/', 1, 'anonymousUser', '2023-10-10 20:35:24', 'anonymousUser', '2024-04-05 03:52:24', '00002');
INSERT INTO `organization` VALUES (3, 'QLHV', 'Phòng Quản lý học viên', 1, NULL, NULL, '2023-10-24', NULL, '/1/3/', 2, 'anonymousUser', '2023-10-10 20:35:24', NULL, NULL, '0000200007');
INSERT INTO `organization` VALUES (9, 'CT', 'Phòng Chính trị', 1, NULL, '', NULL, NULL, '/1/9/', 2, 'anonymousUser', '2024-02-27 22:31:23', 'anonymousUser', '2024-03-12 08:25:57', '0000200006');
INSERT INTO `organization` VALUES (56, 'CNTT', 'Khoa Công nghệ thông tin', 1, NULL, '', NULL, NULL, '/1/56/', 2, '500-500', '2024-11-06 21:51:48', NULL, NULL, '0000200002');
INSERT INTO `organization` VALUES (57, 'DTVT', 'Khoa Điện tử viễn thông', 1, NULL, '', NULL, NULL, '/1/57/', 2, '500-500', '2024-11-07 16:55:42', '500-500', '2024-11-07 23:22:04', '0000200003');
INSERT INTO `organization` VALUES (58, 'HTTT', 'Bộ môn Hệ thống thông tin', 56, NULL, '', NULL, NULL, '/1/56/58/', 3, '500-500', '2024-11-07 16:56:06', NULL, NULL, '000020000200002');
INSERT INTO `organization` VALUES (59, 'ATTT', 'Bộ môn An toàn thông tin', 56, NULL, '', NULL, NULL, '/1/56/59/', 3, '500-500', '2024-11-07 16:56:24', NULL, NULL, '000020000200001');
INSERT INTO `organization` VALUES (60, 'TDH', 'Khoa Tự động hóa', 1, NULL, '', NULL, NULL, '/1/60/', 2, '500-500', '2024-11-07 23:21:36', NULL, NULL, '0000200005');
INSERT INTO `organization` VALUES (61, 'KNN', 'Khoa Ngoại ngữ', 1, NULL, '', NULL, NULL, '/1/61/', 2, '500-500', '2024-11-09 21:49:03', NULL, NULL, '0000200004');

-- ----------------------------
-- Table structure for p_action
-- ----------------------------
DROP TABLE IF EXISTS `p_action`;
CREATE TABLE `p_action`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_action
-- ----------------------------
INSERT INTO `p_action` VALUES (2, 'INSERT', 'Thêm mới');
INSERT INTO `p_action` VALUES (3, 'UPDATE', 'Cập nhật');
INSERT INTO `p_action` VALUES (4, 'IMPORT', 'Import dữ liệu');
INSERT INTO `p_action` VALUES (5, 'VIEW', 'Tìm kiếm');
INSERT INTO `p_action` VALUES (6, 'DELETE', 'Xóa');
INSERT INTO `p_action` VALUES (7, 'UPDATE_STATUS', 'Cập nhật trạng thái');
INSERT INTO `p_action` VALUES (8, 'EXPORT', 'Xuất dữ liệu');
INSERT INTO `p_action` VALUES (9, 'APPROVE', 'Phê duyệt');
INSERT INTO `p_action` VALUES (10, 'BRAG', 'Dồn túi & làm phách');
INSERT INTO `p_action` VALUES (11, 'DATA_SYNTHESIS', 'Tổng hợp dữ liệu');
INSERT INTO `p_action` VALUES (12, 'MNG_STUDENT', 'Quản lý sinh viên');

-- ----------------------------
-- Table structure for p_menu
-- ----------------------------
DROP TABLE IF EXISTS `p_menu`;
CREATE TABLE `p_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `parent_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `router_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sort_order` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_menu
-- ----------------------------
INSERT INTO `p_menu` VALUES (1, 'MNG_ROOM', 'Quản lý phòng', NULL, NULL, 'pi pi-building', 1);
INSERT INTO `p_menu` VALUES (2, 'ROOM_TYPE', 'Loại phòng', 'MNG_ROOM', '/ktx/loai-phong', NULL, 2);
INSERT INTO `p_menu` VALUES (3, 'ROOM', 'Phòng', 'MNG_ROOM', '/ktx/phong', NULL, 3);
INSERT INTO `p_menu` VALUES (4, 'CONTRACT', 'Quản lý hợp đồng', NULL, '/ktx/hop-dong', 'pi pi-file', 4);
INSERT INTO `p_menu` VALUES (5, 'MNG_WATER_ELECTRIC', 'Quản lý điện nước', NULL, NULL, 'pi pi-money-bill', 5);
INSERT INTO `p_menu` VALUES (6, 'WATER_ELECTRIC', 'Nhập thông tin điện nước', 'MNG_WATER_ELECTRIC', '/ktx/dien-nuoc', NULL, 6);
INSERT INTO `p_menu` VALUES (7, 'WATER_ELECTRIC_BILL', 'Lập hóa đơn điện nước', 'MNG_WATER_ELECTRIC', '/ktx/hoa-don', NULL, 7);
INSERT INTO `p_menu` VALUES (8, 'MNG_ORGANIZATION', 'Tổ chức - biên chế', NULL, NULL, 'pi pi pi-sitemap', 8);
INSERT INTO `p_menu` VALUES (9, 'ORGANIZATION', 'Khoa', 'MNG_ORGANIZATION', '/bien-che-to-chuc/khoa', NULL, 9);
INSERT INTO `p_menu` VALUES (10, 'CLASSROOM', 'Lớp học', 'MNG_ORGANIZATION', '/bien-che-to-chuc/lop', NULL, 10);
INSERT INTO `p_menu` VALUES (11, 'EMPLOYEE', 'Hồ sơ cán bộ', 'MNG_ORGANIZATION', '/bien-che-to-chuc/ho-so', NULL, 11);
INSERT INTO `p_menu` VALUES (12, 'STUDENT', 'Hồ sơ sinh viên', 'MNG_ORGANIZATION', '/bien-che-to-chuc/sinh-vien', NULL, 12);
INSERT INTO `p_menu` VALUES (15, 'SETTING', 'Thiết lập', NULL, NULL, 'pi pi-fw pi-cog', 15);
INSERT INTO `p_menu` VALUES (16, 'CATEGORY', 'Danh mục dùng chung', 'SETTING', '/setting/category', NULL, 16);
INSERT INTO `p_menu` VALUES (17, 'MANAGEMENT', 'Quản trị', NULL, NULL, 'pi pi-users', 17);
INSERT INTO `p_menu` VALUES (18, 'ROLE', 'Vai trò', 'MANAGEMENT', '/permission/role', NULL, 18);
INSERT INTO `p_menu` VALUES (19, 'USER', 'Người dùng', 'MANAGEMENT', '/permission/user', NULL, 19);

-- ----------------------------
-- Table structure for p_resource
-- ----------------------------
DROP TABLE IF EXISTS `p_resource`;
CREATE TABLE `p_resource`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_resource
-- ----------------------------
INSERT INTO `p_resource` VALUES (1, 'ORGANIZATION', 'Đơn vị', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (2, 'EMPLOYEE', 'Cán bộ/Học viện', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (16, 'CATEGORY', 'Danh mục dùng chung', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (17, 'ROLE', 'Vai trò', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (18, 'USER', 'Người dùng', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (19, 'CLASSROOM', 'Lớp học', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (20, 'STUDENT', 'Sinh viên', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (21, 'ROOM_TYPE', 'Loại phòng', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (22, 'ROOM', 'Phòng', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (23, 'WATER_ELECTRIC', 'Chỉ số điện/nước', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (24, 'WATER_ELECTRIC_BILL', 'Hóa đơn điện/nước', NULL, NULL, NULL, NULL);
INSERT INTO `p_resource` VALUES (25, 'CONTRACT', 'Hợp đồng', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for p_resource_action
-- ----------------------------
DROP TABLE IF EXISTS `p_resource_action`;
CREATE TABLE `p_resource_action`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `resource_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `action_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_resource_action
-- ----------------------------
INSERT INTO `p_resource_action` VALUES (2, 'ORGANIZATION', 'INSERT');
INSERT INTO `p_resource_action` VALUES (3, 'ORGANIZATION', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (4, 'ORGANIZATION', 'VIEW');
INSERT INTO `p_resource_action` VALUES (5, 'ORGANIZATION', 'DELETE');
INSERT INTO `p_resource_action` VALUES (7, 'EMPLOYEE', 'INSERT');
INSERT INTO `p_resource_action` VALUES (8, 'EMPLOYEE', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (9, 'EMPLOYEE', 'VIEW');
INSERT INTO `p_resource_action` VALUES (10, 'EMPLOYEE', 'DELETE');
INSERT INTO `p_resource_action` VALUES (30, 'CLASSROOM', 'INSERT');
INSERT INTO `p_resource_action` VALUES (31, 'CLASSROOM', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (32, 'CLASSROOM', 'VIEW');
INSERT INTO `p_resource_action` VALUES (33, 'CLASSROOM', 'DELETE');
INSERT INTO `p_resource_action` VALUES (59, 'CATEGORY', 'SEARCH');
INSERT INTO `p_resource_action` VALUES (60, 'CATEGORY', 'INSERT');
INSERT INTO `p_resource_action` VALUES (61, 'CATEGORY', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (62, 'CATEGORY', 'VIEW');
INSERT INTO `p_resource_action` VALUES (63, 'CATEGORY', 'DELETE');
INSERT INTO `p_resource_action` VALUES (65, 'ROLE', 'INSERT');
INSERT INTO `p_resource_action` VALUES (66, 'ROLE', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (67, 'ROLE', 'VIEW');
INSERT INTO `p_resource_action` VALUES (68, 'ROLE', 'DELETE');
INSERT INTO `p_resource_action` VALUES (70, 'USER', 'INSERT');
INSERT INTO `p_resource_action` VALUES (71, 'USER', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (72, 'USER', 'VIEW');
INSERT INTO `p_resource_action` VALUES (73, 'USER', 'DELETE');
INSERT INTO `p_resource_action` VALUES (76, 'CLASSROOM', 'MNG_STUDENT');
INSERT INTO `p_resource_action` VALUES (77, 'STUDENT', 'INSERT');
INSERT INTO `p_resource_action` VALUES (78, 'STUDENT', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (79, 'STUDENT', 'VIEW');
INSERT INTO `p_resource_action` VALUES (80, 'STUDENT', 'DELETE');
INSERT INTO `p_resource_action` VALUES (94, 'ROOM_TYPE', 'INSERT');
INSERT INTO `p_resource_action` VALUES (95, 'ROOM_TYPE', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (96, 'ROOM_TYPE', 'DELETE');
INSERT INTO `p_resource_action` VALUES (97, 'ROOM_TYPE', 'VIEW');
INSERT INTO `p_resource_action` VALUES (98, 'ROOM', 'INSERT');
INSERT INTO `p_resource_action` VALUES (99, 'ROOM', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (100, 'ROOM', 'DELETE');
INSERT INTO `p_resource_action` VALUES (101, 'ROOM', 'VIEW');
INSERT INTO `p_resource_action` VALUES (102, 'WATER_ELECTRIC', 'INSERT');
INSERT INTO `p_resource_action` VALUES (103, 'WATER_ELECTRIC', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (104, 'WATER_ELECTRIC', 'DELETE');
INSERT INTO `p_resource_action` VALUES (105, 'WATER_ELECTRIC', 'VIEW');
INSERT INTO `p_resource_action` VALUES (106, 'WATER_ELECTRIC_BILL', 'INSERT');
INSERT INTO `p_resource_action` VALUES (107, 'WATER_ELECTRIC_BILL', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (108, 'WATER_ELECTRIC_BILL', 'DELETE');
INSERT INTO `p_resource_action` VALUES (109, 'WATER_ELECTRIC_BILL', 'VIEW');
INSERT INTO `p_resource_action` VALUES (110, 'CONTRACT', 'INSERT');
INSERT INTO `p_resource_action` VALUES (111, 'CONTRACT', 'UPDATE');
INSERT INTO `p_resource_action` VALUES (112, 'CONTRACT', 'DELETE');
INSERT INTO `p_resource_action` VALUES (113, 'CONTRACT', 'VIEW');

-- ----------------------------
-- Table structure for p_role
-- ----------------------------
DROP TABLE IF EXISTS `p_role`;
CREATE TABLE `p_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_role
-- ----------------------------
INSERT INTO `p_role` VALUES (1, 'QLHV', 'Quản lý học viên', '2024-04-08 20:03:44', 'anonymousUser', NULL, NULL);
INSERT INTO `p_role` VALUES (2, 'ADMIN', 'Quản trị viên', '2024-04-08 20:03:56', 'anonymousUser', NULL, NULL);

-- ----------------------------
-- Table structure for p_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `p_role_menu`;
CREATE TABLE `p_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `menu_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 212 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_role_menu
-- ----------------------------
INSERT INTO `p_role_menu` VALUES (40, 'QPAN', 'HOME');
INSERT INTO `p_role_menu` VALUES (41, 'QPAN', 'OVERALL_STATISTICS');
INSERT INTO `p_role_menu` VALUES (42, 'QPAN', 'MNG_CLASS');
INSERT INTO `p_role_menu` VALUES (43, 'QPAN', 'EMP_REQUEST');
INSERT INTO `p_role_menu` VALUES (44, 'QPAN', 'EMP_DIVISION');
INSERT INTO `p_role_menu` VALUES (45, 'QPAN', 'EMPLOYEE_CLASSROOM_ATTEND');
INSERT INTO `p_role_menu` VALUES (46, 'QPAN', 'COURSE');
INSERT INTO `p_role_menu` VALUES (47, 'QPAN', 'CLASSROOM');
INSERT INTO `p_role_menu` VALUES (48, 'QPAN', 'CLASSROOM_SCHEDULE');
INSERT INTO `p_role_menu` VALUES (49, 'QPAN', 'GRADING_ASSIGNMENTS');
INSERT INTO `p_role_menu` VALUES (50, 'QPAN', 'CERTIFICATE_APPROVAL');
INSERT INTO `p_role_menu` VALUES (51, 'QPAN', 'CERTIFICATE_BOOK');
INSERT INTO `p_role_menu` VALUES (52, 'QPAN', 'STATISTICS_LOOK_UP');
INSERT INTO `p_role_menu` VALUES (53, 'QPAN', 'STATISTICS');
INSERT INTO `p_role_menu` VALUES (54, 'QPAN', 'EMPLOYEE_SEARCH');
INSERT INTO `p_role_menu` VALUES (145, 'GV', 'SUBJECT');
INSERT INTO `p_role_menu` VALUES (146, 'GV', 'SCHOOL_YEAR');
INSERT INTO `p_role_menu` VALUES (147, 'GV', 'CLASS_SUBJECT');
INSERT INTO `p_role_menu` VALUES (148, 'GV', 'MNG_SCORE');
INSERT INTO `p_role_menu` VALUES (149, 'GV', 'ENTER_SCORE');
INSERT INTO `p_role_menu` VALUES (150, 'GV', 'TABLE_SCORE');
INSERT INTO `p_role_menu` VALUES (179, 'ADMIN', 'MNG_ORGANIZATION');
INSERT INTO `p_role_menu` VALUES (180, 'ADMIN', 'ORGANIZATION');
INSERT INTO `p_role_menu` VALUES (181, 'ADMIN', 'CLASSROOM');
INSERT INTO `p_role_menu` VALUES (182, 'ADMIN', 'EMPLOYEE');
INSERT INTO `p_role_menu` VALUES (183, 'ADMIN', 'STUDENT');
INSERT INTO `p_role_menu` VALUES (184, 'ADMIN', 'EDUCATION_TYPE');
INSERT INTO `p_role_menu` VALUES (185, 'ADMIN', 'TRAINING_COURSE');
INSERT INTO `p_role_menu` VALUES (186, 'ADMIN', 'SETTING');
INSERT INTO `p_role_menu` VALUES (187, 'ADMIN', 'CATEGORY');
INSERT INTO `p_role_menu` VALUES (188, 'ADMIN', 'MANAGEMENT');
INSERT INTO `p_role_menu` VALUES (189, 'ADMIN', 'ROLE');
INSERT INTO `p_role_menu` VALUES (190, 'ADMIN', 'USER');
INSERT INTO `p_role_menu` VALUES (191, 'ADMIN', 'MNG_ROOM');
INSERT INTO `p_role_menu` VALUES (192, 'ADMIN', 'ROOM_TYPE');
INSERT INTO `p_role_menu` VALUES (193, 'ADMIN', 'ROOM');
INSERT INTO `p_role_menu` VALUES (194, 'ADMIN', 'CONTRACT');
INSERT INTO `p_role_menu` VALUES (195, 'ADMIN', 'MNG_WATER_ELECTRIC');
INSERT INTO `p_role_menu` VALUES (196, 'ADMIN', 'WATER_ELECTRIC');
INSERT INTO `p_role_menu` VALUES (197, 'ADMIN', 'WATER_ELECTRIC_BILL');
INSERT INTO `p_role_menu` VALUES (198, 'QLHV', 'MNG_ORGANIZATION');
INSERT INTO `p_role_menu` VALUES (199, 'QLHV', 'ORGANIZATION');
INSERT INTO `p_role_menu` VALUES (200, 'QLHV', 'CLASSROOM');
INSERT INTO `p_role_menu` VALUES (201, 'QLHV', 'EMPLOYEE');
INSERT INTO `p_role_menu` VALUES (202, 'QLHV', 'STUDENT');
INSERT INTO `p_role_menu` VALUES (203, 'QLHV', 'SETTING');
INSERT INTO `p_role_menu` VALUES (204, 'QLHV', 'CATEGORY');
INSERT INTO `p_role_menu` VALUES (205, 'QLHV', 'MNG_ROOM');
INSERT INTO `p_role_menu` VALUES (206, 'QLHV', 'ROOM_TYPE');
INSERT INTO `p_role_menu` VALUES (207, 'QLHV', 'ROOM');
INSERT INTO `p_role_menu` VALUES (208, 'QLHV', 'CONTRACT');
INSERT INTO `p_role_menu` VALUES (209, 'QLHV', 'MNG_WATER_ELECTRIC');
INSERT INTO `p_role_menu` VALUES (210, 'QLHV', 'WATER_ELECTRIC');
INSERT INTO `p_role_menu` VALUES (211, 'QLHV', 'WATER_ELECTRIC_BILL');

-- ----------------------------
-- Table structure for p_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `p_role_resource`;
CREATE TABLE `p_role_resource`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `resource_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_role_resource
-- ----------------------------
INSERT INTO `p_role_resource` VALUES (1, 'ADMIN', 'ORGANIZATION');
INSERT INTO `p_role_resource` VALUES (3, 'ADMIN', 'EMPLOYEE');
INSERT INTO `p_role_resource` VALUES (4, 'ADMIN', 'OVERALL_STATISTICS');
INSERT INTO `p_role_resource` VALUES (14, 'ADMIN', 'EDUCATION_TYPE');
INSERT INTO `p_role_resource` VALUES (16, 'ADMIN', 'TRAINING_COURSE');
INSERT INTO `p_role_resource` VALUES (17, 'ADMIN', 'CATEGORY');
INSERT INTO `p_role_resource` VALUES (18, 'ADMIN', 'ROLE');
INSERT INTO `p_role_resource` VALUES (19, 'ADMIN', 'USER');
INSERT INTO `p_role_resource` VALUES (20, 'ADMIN', 'CLASSROOM');
INSERT INTO `p_role_resource` VALUES (21, 'QLHV', 'OVERALL_STATISTICS');
INSERT INTO `p_role_resource` VALUES (22, 'QLHV', 'EMPLOYEE');
INSERT INTO `p_role_resource` VALUES (23, 'QLHV', 'ORGANIZATION');
INSERT INTO `p_role_resource` VALUES (24, 'QLHV', 'EMPLOYEE_REQUEST');
INSERT INTO `p_role_resource` VALUES (25, 'QLHV', 'STATISTICS_BY_COURSE');
INSERT INTO `p_role_resource` VALUES (26, 'QLHV', 'SEARCH_PROFILES');
INSERT INTO `p_role_resource` VALUES (28, 'GV', 'ORGANIZATION');
INSERT INTO `p_role_resource` VALUES (30, 'GV', 'TRAINING_COURSE');
INSERT INTO `p_role_resource` VALUES (32, 'GV', 'EMPLOYEE');
INSERT INTO `p_role_resource` VALUES (33, 'GV', 'EMPLOYEE_CLASSROOM_ATTEND');
INSERT INTO `p_role_resource` VALUES (34, 'QPAN', 'ORGANIZATION');
INSERT INTO `p_role_resource` VALUES (35, 'QPAN', 'EMPLOYEE');
INSERT INTO `p_role_resource` VALUES (36, 'QPAN', 'EMPLOYEE_REQUEST');
INSERT INTO `p_role_resource` VALUES (37, 'QPAN', 'EMPLOYEE_CLASSROOM');
INSERT INTO `p_role_resource` VALUES (38, 'QPAN', 'EMPLOYEE_CLASSROOM_ATTEND');
INSERT INTO `p_role_resource` VALUES (39, 'QPAN', 'COURSE');
INSERT INTO `p_role_resource` VALUES (40, 'QPAN', 'CLASSROOM_SCHEDULE');
INSERT INTO `p_role_resource` VALUES (41, 'QPAN', 'GRADING_ASSIGNMENTS');
INSERT INTO `p_role_resource` VALUES (42, 'QPAN', 'CERTIFICATE_APPROVAL');
INSERT INTO `p_role_resource` VALUES (43, 'QPAN', 'CERTIFICATE_BOOK');
INSERT INTO `p_role_resource` VALUES (44, 'QPAN', 'CLASSROOM');
INSERT INTO `p_role_resource` VALUES (45, 'QPAN', 'EDUCATION_TYPE');
INSERT INTO `p_role_resource` VALUES (46, 'QPAN', 'TRAINING_COURSE');
INSERT INTO `p_role_resource` VALUES (47, 'QPAN', 'CATEGORY');
INSERT INTO `p_role_resource` VALUES (48, 'ADMIN', 'STUDENT');
INSERT INTO `p_role_resource` VALUES (49, 'ADMIN', 'SUBJECT');
INSERT INTO `p_role_resource` VALUES (50, 'ADMIN', 'SCHOOL_YEAR');
INSERT INTO `p_role_resource` VALUES (52, 'GV', 'STUDENT');
INSERT INTO `p_role_resource` VALUES (53, 'GV', 'SUBJECT');
INSERT INTO `p_role_resource` VALUES (54, 'GV', 'CLASS_SUBJECT');
INSERT INTO `p_role_resource` VALUES (55, 'GV', 'SCHOOL_YEAR');
INSERT INTO `p_role_resource` VALUES (56, 'QLHV', 'EDUCATION_TYPE');
INSERT INTO `p_role_resource` VALUES (57, 'QLHV', 'TRAINING_COURSE');
INSERT INTO `p_role_resource` VALUES (58, 'QLHV', 'CATEGORY');
INSERT INTO `p_role_resource` VALUES (59, 'QLHV', 'CLASSROOM');
INSERT INTO `p_role_resource` VALUES (60, 'QLHV', 'STUDENT');
INSERT INTO `p_role_resource` VALUES (61, 'QLHV', 'SUBJECT');
INSERT INTO `p_role_resource` VALUES (62, 'QLHV', 'SCHOOL_YEAR');
INSERT INTO `p_role_resource` VALUES (63, 'QLHV', 'CLASS_SUBJECT');
INSERT INTO `p_role_resource` VALUES (64, 'ADMIN', 'ROOM_TYPE');
INSERT INTO `p_role_resource` VALUES (65, 'ADMIN', 'ROOM');
INSERT INTO `p_role_resource` VALUES (66, 'ADMIN', 'WATER_ELECTRIC');
INSERT INTO `p_role_resource` VALUES (67, 'ADMIN', 'WATER_ELECTRIC_BILL');
INSERT INTO `p_role_resource` VALUES (68, 'ADMIN', 'CONTRACT');
INSERT INTO `p_role_resource` VALUES (69, 'QLHV', 'ROOM_TYPE');
INSERT INTO `p_role_resource` VALUES (70, 'QLHV', 'ROOM');
INSERT INTO `p_role_resource` VALUES (71, 'QLHV', 'WATER_ELECTRIC');
INSERT INTO `p_role_resource` VALUES (72, 'QLHV', 'WATER_ELECTRIC_BILL');
INSERT INTO `p_role_resource` VALUES (73, 'QLHV', 'CONTRACT');

-- ----------------------------
-- Table structure for p_role_resource_action
-- ----------------------------
DROP TABLE IF EXISTS `p_role_resource_action`;
CREATE TABLE `p_role_resource_action`  (
  `role_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `resource_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `action_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`role_code`, `resource_code`, `action_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_role_resource_action
-- ----------------------------
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CATEGORY', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CATEGORY', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CATEGORY', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CATEGORY', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CLASSROOM', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CLASSROOM', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CLASSROOM', 'MNG_STUDENT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CLASSROOM', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CLASSROOM', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CONTRACT', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CONTRACT', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CONTRACT', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'CONTRACT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EDUCATION_TYPE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EDUCATION_TYPE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EDUCATION_TYPE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EDUCATION_TYPE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EMPLOYEE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EMPLOYEE', 'EXPORT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EMPLOYEE', 'IMPORT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EMPLOYEE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EMPLOYEE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'EMPLOYEE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ORGANIZATION', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ORGANIZATION', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ORGANIZATION', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ORGANIZATION', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'OVERALL_STATISTICS', 'EXPORT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'OVERALL_STATISTICS', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROLE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROLE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROLE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROLE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROOM', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROOM', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROOM', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROOM', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROOM_TYPE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROOM_TYPE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROOM_TYPE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'ROOM_TYPE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'SCHOOL_YEAR', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'SCHOOL_YEAR', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'SCHOOL_YEAR', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'SCHOOL_YEAR', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'STUDENT', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'STUDENT', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'STUDENT', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'STUDENT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'SUBJECT', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'SUBJECT', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'SUBJECT', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'SUBJECT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'TRAINING_COURSE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'TRAINING_COURSE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'TRAINING_COURSE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'TRAINING_COURSE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'USER', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'USER', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'USER', 'SEARCH');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'USER', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'USER', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'WATER_ELECTRIC', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'WATER_ELECTRIC', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'WATER_ELECTRIC', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'WATER_ELECTRIC', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'WATER_ELECTRIC_BILL', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'WATER_ELECTRIC_BILL', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'WATER_ELECTRIC_BILL', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('ADMIN', 'WATER_ELECTRIC_BILL', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('GV', 'CLASS_SUBJECT', 'MNG_STUDENT');
INSERT INTO `p_role_resource_action` VALUES ('GV', 'CLASS_SUBJECT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('GV', 'EMPLOYEE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('GV', 'EMPLOYEE_CLASSROOM_ATTEND', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('GV', 'EMPLOYEE_CLASSROOM_ATTEND', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('GV', 'SCHOOL_YEAR', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('GV', 'STUDENT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('GV', 'SUBJECT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CATEGORY', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CATEGORY', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CATEGORY', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CATEGORY', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASS_SUBJECT', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASS_SUBJECT', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASS_SUBJECT', 'MNG_STUDENT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASS_SUBJECT', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASS_SUBJECT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASSROOM', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASSROOM', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASSROOM', 'MNG_STUDENT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASSROOM', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CLASSROOM', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CONTRACT', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CONTRACT', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CONTRACT', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'CONTRACT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EDUCATION_TYPE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EDUCATION_TYPE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EDUCATION_TYPE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EDUCATION_TYPE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE_REQUEST', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE_REQUEST', 'IMPORT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE_REQUEST', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE_REQUEST', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'EMPLOYEE_REQUEST', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ORGANIZATION', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ORGANIZATION', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ORGANIZATION', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ORGANIZATION', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'OVERALL_STATISTICS', 'EXPORT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'OVERALL_STATISTICS', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ROOM', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ROOM', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ROOM', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ROOM', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ROOM_TYPE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ROOM_TYPE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ROOM_TYPE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'ROOM_TYPE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SCHOOL_YEAR', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SCHOOL_YEAR', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SCHOOL_YEAR', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SCHOOL_YEAR', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SEARCH_PROFILES', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'STATISTICS_BY_COURSE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'STUDENT', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'STUDENT', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'STUDENT', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'STUDENT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SUBJECT', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SUBJECT', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SUBJECT', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'SUBJECT', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'TRAINING_COURSE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'TRAINING_COURSE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'TRAINING_COURSE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'TRAINING_COURSE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'WATER_ELECTRIC', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'WATER_ELECTRIC', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'WATER_ELECTRIC', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'WATER_ELECTRIC', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'WATER_ELECTRIC_BILL', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'WATER_ELECTRIC_BILL', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'WATER_ELECTRIC_BILL', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QLHV', 'WATER_ELECTRIC_BILL', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CATEGORY', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CERTIFICATE_APPROVAL', 'APPROVE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CERTIFICATE_APPROVAL', 'DATA_SYNTHESIS');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CERTIFICATE_APPROVAL', 'EXPORT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CERTIFICATE_APPROVAL', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CERTIFICATE_APPROVAL', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CERTIFICATE_BOOK', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CERTIFICATE_BOOK', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CLASSROOM', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CLASSROOM', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CLASSROOM', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CLASSROOM', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CLASSROOM_SCHEDULE', 'IMPORT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'CLASSROOM_SCHEDULE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'COURSE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'COURSE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'COURSE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'COURSE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EDUCATION_TYPE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EDUCATION_TYPE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EDUCATION_TYPE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EDUCATION_TYPE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE', 'EXPORT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_CLASSROOM', 'APPROVE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_CLASSROOM', 'IMPORT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_CLASSROOM', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_CLASSROOM', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_CLASSROOM', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_CLASSROOM_ATTEND', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_CLASSROOM_ATTEND', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_REQUEST', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_REQUEST', 'IMPORT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_REQUEST', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'EMPLOYEE_REQUEST', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'GRADING_ASSIGNMENTS', 'BRAG');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'GRADING_ASSIGNMENTS', 'EXPORT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'GRADING_ASSIGNMENTS', 'IMPORT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'GRADING_ASSIGNMENTS', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'ORGANIZATION', 'VIEW');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'TRAINING_COURSE', 'DELETE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'TRAINING_COURSE', 'INSERT');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'TRAINING_COURSE', 'UPDATE');
INSERT INTO `p_role_resource_action` VALUES ('QPAN', 'TRAINING_COURSE', 'VIEW');

-- ----------------------------
-- Table structure for p_user
-- ----------------------------
DROP TABLE IF EXISTS `p_user`;
CREATE TABLE `p_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `employee_id` bigint NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password_hash` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_logged` datetime NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_user
-- ----------------------------
INSERT INTO `p_user` VALUES (12, 1970, 'CB001', '$2a$10$H4sag0ZdH4Io14B7mffGlOmXD/dmmFcwxJ5UmKIsb5Q0foFdRpT3K', '2024-11-19 13:03:18', '2024-04-13 09:50:48', '500-500', '2024-04-23 05:47:40', '500-500');
INSERT INTO `p_user` VALUES (13, 1971, 'CB002', '$2a$10$64e5GDmDJ8qpUGDedDSu..pKsLPGTLNwrYKVAXmAXcwQY9ZQ6bZMq', NULL, '2024-04-13 15:26:36', '500-500', '2024-11-11 20:03:43', 'CB001');
INSERT INTO `p_user` VALUES (14, 1972, 'CB003', '$2a$10$K2Pl7o5idcECZT1YEjD0fu7BlDrmRW/BpmnfnDDYOo/kARpg/I1cK', NULL, '2024-04-13 18:47:22', '500-500', '2024-11-13 09:16:01', 'CB001');
INSERT INTO `p_user` VALUES (16, 1973, 'CB004', '$2a$10$Ako2O/CcV90WaL5VrI3dK.ju0xC/fSlWPTXpxfLDnqZvsMmglgl5q', '2024-11-10 11:52:48', '2024-04-24 09:42:59', '500-500', '2024-11-10 09:49:11', '500-500');

-- ----------------------------
-- Table structure for p_user_domain
-- ----------------------------
DROP TABLE IF EXISTS `p_user_domain`;
CREATE TABLE `p_user_domain`  (
  `user_id` bigint NOT NULL,
  `domain` bigint NOT NULL,
  PRIMARY KEY (`user_id`, `domain`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_user_domain
-- ----------------------------

-- ----------------------------
-- Table structure for p_user_role
-- ----------------------------
DROP TABLE IF EXISTS `p_user_role`;
CREATE TABLE `p_user_role`  (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of p_user_role
-- ----------------------------
INSERT INTO `p_user_role` VALUES (12, 2);
INSERT INTO `p_user_role` VALUES (13, 1);
INSERT INTO `p_user_role` VALUES (14, 1);
INSERT INTO `p_user_role` VALUES (16, 1);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã phòng',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Tên phòng',
  `room_type_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã loại phòng',
  `amount` int NOT NULL COMMENT 'Số người',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '417-N7', '417-N7', 'L1', 8, '2024-11-11 16:00:26', 'CB001', '2024-11-12 14:54:52', 'CB001');
INSERT INTO `room` VALUES (2, '401-N7', '401-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (3, '402-N7', '402-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (4, '403-N7', '403-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (5, '404-N7', '404-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (6, '405-N7', '405-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (7, '406-N7', '406-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (8, '407-N7', '407-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (9, '408-N7', '408-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (10, '409-N7', '409-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (11, '410-N7', '410-N7', 'L1', 8, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (12, '501-N7', '501-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (13, '502-N7', '502-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (14, '503-N7', '503-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (15, '504-N7', '504-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (16, '505-N7', '505-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (17, '506-N7', '506-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (18, '507-N7', '507-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (19, '508-N7', '508-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (20, '509-N7', '509-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', NULL, NULL);
INSERT INTO `room` VALUES (21, '510-N7', '510-N7', 'L2', 10, '2024-11-11 16:00:41', 'CB001', '2024-11-17 14:56:17', 'CB001');
INSERT INTO `room` VALUES (22, '56', 'lo', 'L1', 7, '2024-11-18 10:46:47', 'CB001', NULL, NULL);

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã loại phòng',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Tên loại phòng',
  `building` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Đơn nguyên',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES (1, 'L1', 'Loại 1', '', '2024-11-11 15:45:51', 'CB001', NULL, NULL);
INSERT INTO `room_type` VALUES (2, 'L2', 'Loại 2', 'B', '2024-11-11 15:46:01', 'CB001', NULL, NULL);
INSERT INTO `room_type` VALUES (5, 'L3', 'Loại 3', '', '2024-11-13 09:02:24', 'CB001', NULL, NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã sinh viên',
  `fullname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Họ và tên',
  `first_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Họ và đệm',
  `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Tên',
  `date_of_birth` date NULL DEFAULT NULL COMMENT 'Ngày sinh',
  `address` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Quê quán',
  `gender` int NULL DEFAULT NULL COMMENT '0-nữ, 1-nam, 2-khác',
  `classroom_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã lớp',
  `phone_number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Số điện thoại',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 342 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, '16150346', 'Nguyễn Xuân Sơn', NULL, NULL, '1998-05-01', 'Hưng Yên', 1, 'CNTT15', '0987654321', '2024-11-06 23:41:29', '500-500', NULL, NULL);
INSERT INTO `student` VALUES (3, '16150347', 'Nguyễn Văn A', NULL, NULL, '2024-11-06', '2222', 1, 'CNTT15', '11111', '2024-11-06 23:41:43', '500-500', NULL, NULL);
INSERT INTO `student` VALUES (172, '16150349', 'Khổng Minh Tiến Anh', NULL, NULL, '1998-10-17', 'Hà Nội', 1, 'CNTT15', '0917101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (173, '16150350', 'Lê Tuấn Anh', NULL, NULL, '1998-11-14', 'Hà Giang', 1, 'CNTT15', '0914111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (174, '16150351', 'Ngô Quốc Anh', NULL, NULL, '1998-04-21', 'Hà Nội', 1, 'CNTT15', '0921041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (175, '16150352', 'Nguyễn Khắc Hoàng Anh', NULL, NULL, '1998-07-20', 'Hà Nội', 1, 'CNTT15', '0920071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (176, '16150353', 'Phạm Nguyễn Ngọc Anh', NULL, NULL, '1997-08-01', 'Thái Bình', 0, 'CNTT15', '0901081997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (177, '16150354', 'Trần Việt Anh', NULL, NULL, '1998-12-22', 'Hải Dương', 1, 'CNTT15', '0922121998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (178, '16150355', 'Lê Trung Cường', NULL, NULL, '1998-06-27', 'Hà Nam', 1, 'CNTT15', '0927061998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (179, '16150356', 'Trần Xuân Diệu', NULL, NULL, '1998-01-26', 'Hà Nội', 1, 'CNTT15', '0926011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (180, '16150357', 'Nguyễn Vũ Chí Dũng', NULL, NULL, '1998-07-20', 'Hà Nội', 1, 'CNTT15', '0920071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (181, '16150358', 'Kiều Hoàng Duy', NULL, NULL, '1998-02-27', 'Hà Nội', 1, 'CNTT15', '0927021998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (182, '16150359', 'Nguyễn Thị Đào', NULL, NULL, '1998-11-03', 'Hà Nội', 0, 'CNTT15', '0903111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (183, '16150360', 'Nguyễn Thành Đạt', NULL, NULL, '1998-12-06', 'Hà Nam', 1, 'CNTT15', '0906121998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (184, '16150361', 'Nguyễn Tiến Đạt', NULL, NULL, '1997-07-16', 'Hà Nội', 1, 'CNTT15', '0916071997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (185, '16150362', 'Phạm Quốc Đạt', NULL, NULL, '1998-07-20', 'Hà Nội', 1, 'CNTT15', '0920071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (186, '16150363', 'Trần Đăng Định', NULL, NULL, '1998-02-23', 'Nam Định', 1, 'CNTT15', '0923021998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (187, '16150364', 'Nguyễn Thị Hằng', NULL, NULL, '1996-07-03', 'Gia Lai', 0, 'CNTT15', '0903071996', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (188, '16150365', 'Phan Văn Hậu', NULL, NULL, '1998-03-05', 'Thái Bình', 1, 'CNTT15', '0905031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (189, '16150366', 'Trần Thị Hiền', NULL, NULL, '1998-01-09', 'Hà Nam', 0, 'CNTT15', '0909011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (190, '16150367', 'Vũ Minh Hoan', NULL, NULL, '1998-08-21', 'Bắc Giang', 1, 'CNTT15', '0921081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (191, '16150368', 'Đặng Huy Hoàng', NULL, NULL, '1998-07-27', 'Hà Tĩnh', 1, 'CNTT15', '0927071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (192, '16150369', 'Lê Thị Ánh Hồng', NULL, NULL, '1998-01-06', 'Bình Định', 0, 'CNTT15', '0906011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (193, '16150370', 'Bùi Nhật Hưng', NULL, NULL, '1998-08-01', 'Hà Nội', 1, 'CNTT15', '0901081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (194, '16150371', 'Phạm Gia Hưng', NULL, NULL, '1998-05-04', 'Hà Nội', 1, 'CNTT15', '0904051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (195, '16150372', 'Phạm Thành Hưng', NULL, NULL, '1998-05-25', 'Hải Phòng', 1, 'CNTT15', '0925051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (196, '16150373', 'Vương Thành Hưng', NULL, NULL, '1998-10-24', 'Hải Dương', 1, 'CNTT15', '0924101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (197, '16150374', 'Đỗ Thị Hương', NULL, NULL, '1998-02-15', 'Hà Nội', 0, 'CNTT15', '0915021998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (198, '16150375', 'Trịnh Thị Hương', NULL, NULL, '1998-07-28', 'Gia Lai', 0, 'CNTT15', '0928071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (199, '16150376', 'Nguyễn Hữu Huy', NULL, NULL, '1998-11-20', 'Quảng Ninh', 1, 'CNTT15', '0920111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (200, '16150377', 'Hoàng Thị Thu Huyền', NULL, NULL, '1998-11-01', 'Nam Định', 0, 'CNTT15', '0901111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (201, '16150378', 'Nguyễn Xuân Khánh', NULL, NULL, '1998-11-02', 'Gia Lai', 1, 'CNTT15', '0902111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (202, '16150379', 'Vũ Hồng Khánh', NULL, NULL, '1998-05-24', 'Nam Định', 1, 'CNTT15', '0924051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (203, '16150380', 'Nguyễn Mạnh Linh', NULL, NULL, '1998-12-30', 'Hà Nam', 1, 'MMT15', '0930121998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (204, '16150381', 'Nguyễn Thị Thùy Linh', NULL, NULL, '1998-05-18', 'Hà Nội', 0, 'MMT15', '0918051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (205, '16150382', 'Đặng Vũ Phi Long', NULL, NULL, '1998-07-09', 'Hà Nội', 1, 'MMT15', '0909071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (206, '16150383', 'Nguyễn Huy Long', NULL, NULL, '1998-10-12', 'Hà Nội', 1, 'MMT15', '0912101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (207, '16150384', 'Dương Văn Minh', NULL, NULL, '1997-10-28', 'Hà Nam', 1, 'MMT15', '0928101997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (208, '16150385', 'Nguyễn Thị Nga', NULL, NULL, '1998-07-16', 'Hà Tĩnh', 0, 'MMT15', '0916071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (209, '16150386', 'Đặng Cao Nguyên', NULL, NULL, '1998-04-11', 'Đắc Lắc', 1, 'MMT15', '0911041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (210, '16150387', 'Nguyễn Văn Nhật', NULL, NULL, '1997-03-20', 'Hải Dương', 1, 'MMT15', '0920031997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (211, '16150388', 'Vũ Thành Phúc', NULL, NULL, '1998-10-03', 'Thái Bình', 1, 'MMT15', '0903101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (212, '16150389', 'Nguyễn Minh Phụng', NULL, NULL, '1998-05-24', 'Thái Bình', 1, 'MMT15', '0924051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (213, '16150390', 'Nguyễn Minh Quang', NULL, NULL, '1998-05-22', 'Hà Nội', 1, 'MMT15', '0922051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (214, '16150391', 'Nguyễn Xuân Quang', NULL, NULL, '1997-10-27', 'Hải Dương', 1, 'MMT15', '0927101997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (215, '16150392', 'Kiều Duy Sơn', NULL, NULL, '1998-04-22', 'Hà Nội', 1, 'MMT15', '0922041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (216, '16150393', 'Vương Văn Tân', NULL, NULL, '1997-01-01', 'Hà Giang', 1, 'MMT15', '0901011997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (217, '16150394', 'Khuất Văn Thắng', NULL, NULL, '1998-12-17', 'Hà Nội', 1, 'MMT15', '0917121998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (218, '16150395', 'Phan Tiến Thành', NULL, NULL, '1998-10-25', 'Hà Tĩnh', 1, 'MMT15', '0925101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (219, '16150396', 'Vũ Tiến Thành', NULL, NULL, '1998-05-13', 'Hà Nội', 1, 'MMT15', '0913051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (220, '16150397', 'Nguyễn Văn Thống', NULL, NULL, '1998-10-31', 'Hà Nội', 1, 'MMT15', '0931101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (221, '16150398', 'Nguyễn Thị Anh Thư', NULL, NULL, '1998-05-14', 'Bà Rịa - Vũng Tàu', 0, 'MMT15', '0914051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (222, '16150399', 'Nguyễn Thị Thanh Thư', NULL, NULL, '1998-05-21', 'Hà Nội', 0, 'MMT15', '0921051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (223, '16150400', 'Nguyễn Hồ Tuấn Trung', NULL, NULL, '1998-01-10', 'Hà Nội', 1, 'MMT15', '0910011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (224, '16150401', 'Lê Thị Cẩm Tú', NULL, NULL, '1997-12-21', 'Hà Tĩnh', 0, 'MMT15', '0921121997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (225, '16150402', 'Trần Việt Tuấn', NULL, NULL, '1998-03-16', 'Hà Nam', 1, 'MMT15', '0916031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (226, '16150403', 'Lương Thị Tuyền', NULL, NULL, '1998-01-04', 'Bắc Giang', 0, 'MMT15', '0904011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (227, '16150404', 'Bùi Xuân Việt', NULL, NULL, '1998-11-29', 'Bắc Giang', 1, 'MMT15', '0929111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (228, '16150405', 'Đỗ Đức Việt', NULL, NULL, '1998-10-05', 'Phú Thọ', 1, 'MMT15', '0905101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (229, '16150406', 'Nguyễn Long Vũ', NULL, NULL, '1998-11-02', 'Hà Nội', 1, 'MMT15', '0902111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (230, '16150407', 'Đoàn Ngô Dũng', NULL, NULL, '1998-02-17', 'Nam Định', 1, 'MMT15', '0917021998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (231, '16150408', 'Tạ Quang Duy', NULL, NULL, '1998-06-19', 'Hà Nội', 1, 'MMT15', '0919061998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (232, '16150409', 'Đinh Minh Đức', NULL, NULL, '1998-12-03', 'Hải Dương', 1, 'MMT15', '0903121998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (233, '16150410', 'Trần Đức Lân', NULL, NULL, '1994-12-15', 'Hải Dương', 1, 'MMT15', '0915121994', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (234, '16150411', 'Phạm Tường Trung', NULL, NULL, '1994-09-20', 'Sơn La', 1, 'MMT15', '0920091994', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (235, '16150412', 'NguyễN TuấN Anh', NULL, NULL, '1998-08-13', 'Hà Nội', 1, 'MMT15', '0913081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (236, '16150413', 'Nguyễn Trung Dũng', NULL, NULL, '1998-01-29', 'Hòa Bình', 1, 'MMT15', '0929011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (237, '16150414', 'Nguyễn Văn Dũng', NULL, NULL, '1998-10-20', 'Hà Tĩnh', 1, 'MMT15', '0920101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (238, '16150415', 'Nguyễn Tiến Đạt', NULL, NULL, '1998-04-30', 'Hà Nội', 1, 'MMT15', '0930041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (239, '16150416', 'Vũ Tuấn Khanh', NULL, NULL, '1998-05-10', 'Hải Dương', 1, 'MMT15', '0910051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (240, '16150417', 'Nguyễn Thị Thuỳ Linh', NULL, NULL, '1998-10-17', 'Hà Nội', 0, 'MMT15', '0917101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (241, '16150418', 'Trịnh Tiến Linh', NULL, NULL, '1998-04-15', 'Gia Lai', 1, 'MMT15', '0915041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (242, '16150419', 'Nguyễn Ngọc Quý', NULL, NULL, '1998-07-27', 'Hà Nam', 1, 'MMT15', '0927071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (243, '16150420', 'Phạm Hoàng Sơn', NULL, NULL, '1997-10-12', 'Hải Dương', 1, 'MMT15', '0912101997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (244, '16150421', 'Bùi Thanh Trung', NULL, NULL, '1998-03-02', 'Kon Tum', 1, 'MMT15', '0902031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (245, '16150422', 'Trần Vũ Trường', NULL, NULL, '1997-03-01', 'Quảng Bình', 1, 'MMT15', '0901031997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (246, '16150423', 'Trần Văn Tuấn', NULL, NULL, '1998-03-14', 'Hà Tĩnh', 1, 'MMT15', '0914031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (247, '16150424', 'Vương Đình Bách', NULL, NULL, '1998-12-21', 'Hà Nội', 1, 'MMT15', '0921121998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (248, '16150425', 'Lê Hữu Bình', NULL, NULL, '1997-12-26', 'Hà Nội', 1, 'MMT15', '0926121997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (249, '16150426', 'Lê Văn Cường', NULL, NULL, '1998-03-19', 'Hải Dương', 1, 'MMT15', '0919031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (250, '16150427', 'Lê Văn Doanh', NULL, NULL, '1998-07-29', 'Bắc Giang', 1, 'MMT15', '0929071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (251, '16150428', 'Cù Bách Trần Dương', NULL, NULL, '1997-12-10', 'Nam Định', 1, 'MMT15', '0910121997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (252, '16150429', 'Khuất Quang Duy', NULL, NULL, '1998-04-27', 'Hà Nội', 1, 'MMT15', '0927041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (253, '16150430', 'Đỗ Trung Đức', NULL, NULL, '1998-03-31', 'Hòa Bình', 1, 'MMT15', '0931031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (254, '16150431', 'Nguyễn Thị Hồng Gấm', NULL, NULL, '1998-10-23', 'Tây Ninh', 0, 'MMT15', '0923101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (255, '16150432', 'Nguyễn Đức Giang', NULL, NULL, '1998-08-14', 'Hà Nội', 1, 'MMT15', '0914081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (256, '16150433', 'Tạ Hoàng Hải', NULL, NULL, '1998-10-23', 'Hà Nội', 1, 'MMT15', '0923101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (257, '16150434', 'Dương Minh Hiếu', NULL, NULL, '1998-01-13', 'Hải Dương', 1, 'MMT15', '0913011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (258, '16150435', 'Phạm Hoàng Hiếu', NULL, NULL, '1998-05-17', 'Hà Nội', 1, 'MMT15', '0917051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (259, '16150436', 'Vũ Xuân Hinh', NULL, NULL, '1998-11-26', 'Nam Định', 1, 'MMT15', '0926111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (260, '16150437', 'Đỗ Hoàng Huy', NULL, NULL, '1998-09-06', 'Hà Nội', 1, 'MMT15', '0906091998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (261, '16150438', 'Lương Minh Huy', NULL, NULL, '1998-03-28', 'Hà Nội', 1, 'MMT15', '0928031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (262, '16150439', 'Mai Thế Huy', NULL, NULL, '1998-09-07', 'Hà Nội', 1, 'MMT15', '0907091998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (263, '16150440', 'Phạm Hồng Kim', NULL, NULL, '1997-07-07', 'Hà Nam', 1, 'MMT15', '0907071997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (264, '16150441', 'Vũ Xuân Long', NULL, NULL, '1998-08-29', 'Bắc Giang', 1, 'MMT15', '0929081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (265, '16150442', 'Bùi Thị Trà Mi', NULL, NULL, '1998-02-24', 'Hà Nội', 0, 'MMT15', '0924021998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (266, '16150443', 'Nguyễn Bá Nhất', NULL, NULL, '1997-01-20', 'Hà Nội', 1, 'MMT15', '0920011997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (267, '16150444', 'Vũ Hữu Quân', NULL, NULL, '1998-02-11', 'Hà Nam', 1, 'MMT15', '0911021998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (268, '16150445', 'Nguyễn Bá Quang', NULL, NULL, '1997-08-01', 'Hà Nội', 1, 'MMT15', '0901081997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (272, '16150446', 'Nguyễn Minh Quang', NULL, NULL, '1997-10-15', 'Hà Nội', 1, 'MMT15', '0915101997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (273, '16150447', 'Nguyễn Văn Sáng', NULL, NULL, '1998-11-11', 'Hải Dương', 1, 'MMT15', '0911111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (274, '16150448', 'Trần Ngọc Thanh', NULL, NULL, '1998-11-16', 'Hà Nội', 0, 'MMT15', '0916111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (275, '16150449', 'Nguyễn Thành Trung', NULL, NULL, '1998-08-22', 'Hà Nội', 1, 'ATTT15', '0922081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (276, '16150450', 'Phạm Thế Anh', NULL, NULL, '1998-04-25', 'Hà Nội', 1, 'ATTT15', '0925041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (277, '16150451', 'Trần Văn Dũng', NULL, NULL, '1998-01-08', 'Hà Tĩnh', 1, 'ATTT15', '0908011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (278, '16150452', 'Nguyễn Mạnh Duy', NULL, NULL, '1997-08-29', 'Hà Nội', 1, 'ATTT15', '0929081997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (279, '16150453', 'Nguyễn Phương Đông', NULL, NULL, '1994-04-16', 'Hà Nam', 1, 'ATTT15', '0916041994', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (280, '16150454', 'Nguyễn Bá Hiếu', NULL, NULL, '1998-10-08', 'Hà Nội', 1, 'ATTT15', '0908101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (281, '16150455', 'Vũ Huy Hùng', NULL, NULL, '1996-12-02', 'Hà Nam', 1, 'ATTT15', '0902121996', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (282, '16150456', 'Hoàng Đình Huy', NULL, NULL, '1998-09-10', 'Gia Lai', 1, 'ATTT15', '0910091998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (283, '16150457', 'Đặng Thị Hoài Lan', NULL, NULL, '1998-03-17', 'Hà Nam', 0, 'ATTT15', '0917031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (284, '16150458', 'Nguyễn Văn Lộc', NULL, NULL, '1997-05-07', 'Hà Nội', 1, 'ATTT15', '0907051997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (285, '16150459', 'Nguyễn Ngọc Luyến', NULL, NULL, '1998-07-22', 'Bến Tre', 0, 'ATTT15', '0922071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (286, '16150460', 'Đinh Tiến Mạnh', NULL, NULL, '1998-09-23', 'Hà Nội', 1, 'ATTT15', '0923091998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (287, '16150461', 'Nghiêm Xuân Nam', NULL, NULL, '1998-01-01', 'Hà Nội', 1, 'ATTT15', '0901011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (288, '16150462', 'Nguyễn Xuân Phong', NULL, NULL, '1997-07-13', 'Hà Tĩnh', 1, 'ATTT15', '0913071997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (289, '16150463', 'Hà Thị Phương', NULL, NULL, '1998-10-30', 'Bắc Cạn', 0, 'ATTT15', '0930101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (290, '16150464', 'Lê Văn Quang', NULL, NULL, '1998-11-09', 'Gia Lai', 1, 'ATTT15', '0909111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (291, '16150465', 'Nguyễn Thành Quyết', NULL, NULL, '1998-05-30', 'Hà Nội', 1, 'ATTT15', '0930051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (292, '16150466', 'Mai Ngọc Sơn', NULL, NULL, '1998-08-16', 'Hà Nội', 1, 'ATTT15', '0916081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (293, '16150467', 'Lê Xuân Tài', NULL, NULL, '1998-10-25', 'Hà Nội', 1, 'ATTT15', '0925101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (294, '16150468', 'Nguyễn Tá Thái', NULL, NULL, '1997-09-12', 'Hà Nội', 1, 'ATTT15', '0912091997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (295, '16150469', 'Chu Hoàng Vũ', NULL, NULL, '1998-05-17', 'Quảng Ninh', 1, 'ATTT15', '0917051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (296, '16150470', 'Cao Thị Vân Anh', NULL, NULL, '1998-10-15', 'Gia Lai', 0, 'ATTT15', '0915101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (297, '16150471', 'Đào Thị Ngọc Ánh', NULL, NULL, '1998-10-13', 'Hà Nội', 0, 'ATTT15', '0913101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (298, '16150472', 'Nguyễn Việt Anh', NULL, NULL, '1998-04-07', 'Hà Nội', 1, 'ATTT15', '0907041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (299, '16150473', 'Phạm Hoàng Anh', NULL, NULL, '1998-07-08', 'Hà Nội', 1, 'ATTT15', '0908071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (300, '16150474', 'Phạm Việt Anh', NULL, NULL, '1998-05-07', 'Hà Nội', 1, 'ATTT15', '0907051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (301, '16150475', 'Trần Thế Anh', NULL, NULL, '1998-05-13', 'Thái Bình', 1, 'ATTT15', '0913051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (302, '16150476', 'Trần Tiến Anh', NULL, NULL, '1998-12-31', 'Thái Bình', 1, 'ATTT15', '0931121998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (303, '16150477', 'Trần Tuấn Anh', NULL, NULL, '1997-07-06', 'Sơn La', 1, 'ATTT15', '0906071997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (304, '16150478', 'Đỗ Quang Bách', NULL, NULL, '1998-01-29', 'Hà Nội', 1, 'ATTT15', '0929011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (305, '16150479', 'Nguyễn Văn Bảo', NULL, NULL, '1998-03-23', 'Bắc Giang', 1, 'ATTT15', '0923031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (306, '16150480', 'Trần Trọng Bình', NULL, NULL, '1998-09-29', 'Nam Định', 1, 'ATTT15', '0929091998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (307, '16150481', 'Cao Minh Châu', NULL, NULL, '1997-09-24', 'Hà Nội', 1, 'ATTT15', '0924091997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (308, '16150482', 'Chu Tiến Chung', NULL, NULL, '1998-08-18', 'Hà Tĩnh', 1, 'ATTT15', '0918081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (309, '16150483', 'Đặng Trần Việt Cường', NULL, NULL, '1998-05-19', 'Hà Nội', 1, 'ATTT15', '0919051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (310, '16150484', 'Nguyễn Đình Cường', NULL, NULL, '1998-03-22', 'Hà Nội', 1, 'ATTT15', '0922031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (311, '16150485', 'Phạm Đức Cường', NULL, NULL, '1997-03-17', 'Hà Nam', 1, 'ATTT15', '0917031997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (312, '16150486', 'Vương Quốc Cường', NULL, NULL, '1998-04-09', 'Bắc Giang', 1, 'ATTT15', '0909041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (313, '16150487', 'Lê Tuấn Dũng', NULL, NULL, '1998-01-14', 'Gia Lai', 1, 'ATTT15', '0914011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (314, '16150488', 'Lê Văn Dũng', NULL, NULL, '1998-12-08', 'Thanh Hóa', 1, 'ATTT15', '0908121998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (315, '16150489', 'Trần Anh Dũng', NULL, NULL, '1998-09-01', 'Hà Nội', 1, 'ATTT15', '0901091998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (316, '16150490', 'Nguyễn Thành Duy', NULL, NULL, '1998-08-03', 'Hà Nội', 1, 'ATTT15', '0903081998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (317, '16150491', 'Chu Hải Đăng', NULL, NULL, '1998-01-18', 'Hà Nội', 1, 'ATTT15', '0918011998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (318, '16150492', 'Nguyễn Hải Đông', NULL, NULL, '1998-03-18', 'Bắc Giang', 1, 'ATTT15', '0918031998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (319, '16150493', 'Chu Việt Hà', NULL, NULL, '1998-10-23', 'Hà Nội', 1, 'ATTT15', '0923101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (320, '16150494', 'Trịnh Văn Hà', NULL, NULL, '1996-10-10', 'Đắc Lắc', 1, 'ATTT15', '0910101996', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (321, '16150495', 'Vũ Xuân Hà', NULL, NULL, '1998-05-04', 'Hà Tĩnh', 1, 'ATTT15', '0904051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (322, '16150496', 'Phạm Năng Hải', NULL, NULL, '1998-04-02', 'Hòa Bình', 1, 'ATTT15', '0902041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (323, '16150497', 'Trần Minh Hiệp', NULL, NULL, '1998-10-27', 'Hà Nội', 1, 'ATTT15', '0927101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (324, '16150498', 'Bùi Vinh Hiếu', NULL, NULL, '1998-07-21', 'Hà Nội', 1, 'ATTT15', '0921071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (325, '16150499', 'Đinh Văn Hiếu', NULL, NULL, '1998-09-19', 'Nam Định', 1, 'ATTT15', '0919091998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (326, '16150500', 'Nguyễn Công Hiếu', NULL, NULL, '1998-11-29', 'Hải Dương', 1, 'ATTT15', '0929111998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (327, '16150501', 'Nguyễn Danh Hiếu', NULL, NULL, '1998-10-30', 'Hà Nội', 1, 'ATTT15', '0930101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (328, '16150502', 'Trần Minh Hiếu', NULL, NULL, '1998-07-27', 'Hà Nội', 1, 'ATTT15', '0927071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (329, '16150503', 'Vũ Minh Hiếu', NULL, NULL, '1998-05-16', 'Nam Định', 1, 'ATTT15', '0916051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (330, '16150504', 'Lê Chí Minh Hoàng', NULL, NULL, '1998-02-25', 'Hòa Bình', 1, 'ATTT15', '0925021998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (331, '16150505', 'Lê Hoàng', NULL, NULL, '1998-04-27', 'Bắc Cạn', 1, 'ATTT15', '0927041998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (332, '16150506', 'Tạ Tuấn Hoàng', NULL, NULL, '1998-05-26', 'Hà Nội', 1, 'ATTT15', '0926051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (333, '16150507', 'Trần Huy Hoàng', NULL, NULL, '1998-07-09', 'Hà Nội', 1, 'ATTT15', '0909071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (334, '16150508', 'Nông Thành Hợp', NULL, NULL, '1998-10-23', 'Bắc Giang', 1, 'ATTT15', '0923101998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (335, '16150509', 'Hoàng Quang Huân', NULL, NULL, '1998-05-04', 'Hải Dương', 1, 'ATTT15', '0904051998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (336, '16150510', 'Nguyễn Việt Hùng', NULL, NULL, '1997-08-12', 'Hà Nội', 1, 'ATTT15', '0912081997', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (337, '16150511', 'Tạ Huy Hùng', NULL, NULL, '1998-07-17', 'Hà Nội', 1, 'ATTT15', '0917071998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (338, '16150512', 'Nguyễn Thị Thu Hường', NULL, NULL, '1998-02-16', 'Hà Nam', 0, 'ATTT15', '0916021998', NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (340, '12312312', 'Nguyễn Văn A', NULL, NULL, '2024-11-13', NULL, 1, 'DTVT', NULL, '2024-11-09 21:50:08', '500-500', NULL, NULL);
INSERT INTO `student` VALUES (341, '123', 'minh', NULL, NULL, '2024-11-06', 'ninh binh', 1, 'DTVT', '089856854', '2024-11-18 10:49:23', 'CB001', NULL, NULL);

-- ----------------------------
-- Table structure for water_electric
-- ----------------------------
DROP TABLE IF EXISTS `water_electric`;
CREATE TABLE `water_electric`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `month` int NOT NULL COMMENT 'Tháng',
  `year` int NOT NULL COMMENT 'Năm',
  `room_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã phòng',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Water - Công tơ nước; ELECTRIC - Công tơ điện',
  `old_numeral` int NOT NULL COMMENT 'Chỉ số cũ',
  `new_numeral` int NOT NULL COMMENT 'Chỉ số mới',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of water_electric
-- ----------------------------
INSERT INTO `water_electric` VALUES (1, 8, 2024, '417-N7', 'ELECTRIC', 10, 51, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (2, 9, 2024, '417-N7', 'ELECTRIC', 51, 100, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (3, 10, 2024, '417-N7', 'ELECTRIC', 100, 134, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (4, 11, 2024, '417-N7', 'ELECTRIC', 134, 167, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (5, 8, 2024, '417-N7', 'WATER', 0, 10, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (6, 9, 2024, '417-N7', 'WATER', 10, 14, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (7, 10, 2024, '417-N7', 'WATER', 14, 21, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (8, 11, 2024, '417-N7', 'WATER', 21, 32, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (9, 8, 2024, '401-N7', 'ELECTRIC', 12, 15, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (10, 9, 2024, '401-N7', 'ELECTRIC', 15, 36, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (11, 10, 2024, '401-N7', 'ELECTRIC', 36, 65, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (12, 11, 2024, '401-N7', 'ELECTRIC', 65, 100, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (13, 8, 2024, '401-N7', 'WATER', 0, 10, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (14, 9, 2024, '401-N7', 'WATER', 10, 21, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (15, 10, 2024, '401-N7', 'WATER', 21, 34, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (16, 11, 2024, '401-N7', 'WATER', 34, 45, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (17, 10, 2024, '402-N7', 'ELECTRIC', 10, 20, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (18, 11, 2024, '402-N7', 'ELECTRIC', 20, 36, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (19, 10, 2024, '402-N7', 'WATER', 10, 20, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (20, 11, 2024, '402-N7', 'WATER', 20, 31, '2024-11-13 09:03:33', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (21, 11, 2024, '56', 'ELECTRIC', 67, 80, '2024-11-18 10:50:50', 'CB001', NULL, NULL);
INSERT INTO `water_electric` VALUES (22, 11, 2024, '56', 'WATER', 123, 126, '2024-11-18 10:53:49', 'CB001', NULL, NULL);

-- ----------------------------
-- Table structure for water_electric_bill
-- ----------------------------
DROP TABLE IF EXISTS `water_electric_bill`;
CREATE TABLE `water_electric_bill`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã hóa đơn',
  `room_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã phòng',
  `month` int NOT NULL COMMENT 'Tháng',
  `year` int NOT NULL COMMENT 'Năm',
  `total_money` int NOT NULL COMMENT 'Thành tiền',
  `status` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Trạng thái: PAID - Đã thanh toán; NOT_YET - Chưa thanh toán',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of water_electric_bill
-- ----------------------------
INSERT INTO `water_electric_bill` VALUES (1, 'HDDN202408000002', '401-N7', 8, 2024, 109000, 'PAID', '2024-11-13 09:11:01', 'CB001', '2024-11-13 09:12:23', 'CB001');
INSERT INTO `water_electric_bill` VALUES (3, 'HDDN202408000001', '417-N7', 8, 2024, 223000, 'PAID', '2024-11-13 09:11:03', 'CB001', '2024-11-13 09:13:03', 'CB001');
INSERT INTO `water_electric_bill` VALUES (4, 'HDDN202409000002', '401-N7', 9, 2024, 228000, 'NOT_YET', '2024-11-13 09:11:25', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill` VALUES (6, 'HDDN202409000001', '417-N7', 9, 2024, 207000, 'PAID', '2024-11-13 09:11:26', 'CB001', '2024-11-13 09:13:07', 'CB001');
INSERT INTO `water_electric_bill` VALUES (7, 'HDDN202410000002', '401-N7', 10, 2024, 376000, 'NOT_YET', '2024-11-13 09:11:48', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill` VALUES (8, 'HDDN202410000003', '402-N7', 10, 2024, 240000, 'NOT_YET', '2024-11-13 09:11:48', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill` VALUES (9, 'HDDN202410000001', '417-N7', 10, 2024, 276000, 'PAID', '2024-11-13 09:11:49', 'CB001', '2024-11-13 09:13:11', 'CB001');
INSERT INTO `water_electric_bill` VALUES (10, 'HDDN202411000002', '401-N7', 11, 2024, 505000, 'NOT_YET', '2024-11-13 09:12:05', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill` VALUES (11, 'HDDN202411000003', '402-N7', 11, 2024, 410000, 'NOT_YET', '2024-11-13 09:12:06', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill` VALUES (12, 'HDDN202411000001', '417-N7', 11, 2024, 495000, 'NOT_YET', '2024-11-13 09:12:07', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill` VALUES (13, 'HDDN202411000007', '406-N7', 11, 2024, 0, 'PAID', '2024-11-17 14:57:29', 'CB001', '2024-11-18 10:52:54', 'CB001');
INSERT INTO `water_electric_bill` VALUES (15, 'HDDN202411000022', '56', 11, 2024, 133500, 'NOT_YET', '2024-11-18 10:54:15', 'CB001', NULL, NULL);

-- ----------------------------
-- Table structure for water_electric_bill_detail
-- ----------------------------
DROP TABLE IF EXISTS `water_electric_bill_detail`;
CREATE TABLE `water_electric_bill_detail`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bill_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Mã hóa đơn điện nước',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Water - Công tơ nước; ELECTRIC - Công tơ điện',
  `consumption` int NOT NULL COMMENT 'Mức tiêu thụ',
  `unit_price` decimal(10, 2) NOT NULL COMMENT 'Đơn giá',
  `money` decimal(10, 2) NOT NULL COMMENT 'Thành tiền',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of water_electric_bill_detail
-- ----------------------------
INSERT INTO `water_electric_bill_detail` VALUES (1, 'HDDN202408000002', 'ELECTRIC', 3, 3000.00, 9000.00, '2024-11-13 09:11:02', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (2, 'HDDN202408000002', 'WATER', 10, 10000.00, 100000.00, '2024-11-13 09:11:02', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (3, 'HDDN202408000001', 'ELECTRIC', 41, 3000.00, 123000.00, '2024-11-13 09:11:03', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (4, 'HDDN202408000001', 'WATER', 10, 10000.00, 100000.00, '2024-11-13 09:11:03', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (5, 'HDDN202409000002', 'ELECTRIC', 21, 3000.00, 63000.00, '2024-11-13 09:11:25', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (6, 'HDDN202409000002', 'WATER', 11, 15000.00, 165000.00, '2024-11-13 09:11:25', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (7, 'HDDN202409000001', 'ELECTRIC', 49, 3000.00, 147000.00, '2024-11-13 09:11:27', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (8, 'HDDN202409000001', 'WATER', 4, 15000.00, 60000.00, '2024-11-13 09:11:27', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (9, 'HDDN202410000002', 'ELECTRIC', 29, 4000.00, 116000.00, '2024-11-13 09:11:48', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (10, 'HDDN202410000002', 'WATER', 13, 20000.00, 260000.00, '2024-11-13 09:11:48', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (11, 'HDDN202410000003', 'ELECTRIC', 10, 4000.00, 40000.00, '2024-11-13 09:11:49', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (12, 'HDDN202410000003', 'WATER', 10, 20000.00, 200000.00, '2024-11-13 09:11:49', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (13, 'HDDN202410000001', 'ELECTRIC', 34, 4000.00, 136000.00, '2024-11-13 09:11:50', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (14, 'HDDN202410000001', 'WATER', 7, 20000.00, 140000.00, '2024-11-13 09:11:50', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (15, 'HDDN202411000002', 'ELECTRIC', 35, 5000.00, 175000.00, '2024-11-13 09:12:05', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (16, 'HDDN202411000002', 'WATER', 11, 30000.00, 330000.00, '2024-11-13 09:12:06', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (17, 'HDDN202411000003', 'ELECTRIC', 16, 5000.00, 80000.00, '2024-11-13 09:12:06', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (18, 'HDDN202411000003', 'WATER', 11, 30000.00, 330000.00, '2024-11-13 09:12:07', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (19, 'HDDN202411000001', 'ELECTRIC', 33, 5000.00, 165000.00, '2024-11-13 09:12:07', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (20, 'HDDN202411000001', 'WATER', 11, 30000.00, 330000.00, '2024-11-13 09:12:08', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (22, 'HDDN202411000022', 'ELECTRIC', 13, 4500.00, 58500.00, '2024-11-18 10:54:15', 'CB001', NULL, NULL);
INSERT INTO `water_electric_bill_detail` VALUES (23, 'HDDN202411000022', 'WATER', 3, 25000.00, 75000.00, '2024-11-18 10:54:15', 'CB001', NULL, NULL);

-- ----------------------------
-- View structure for room_summary
-- ----------------------------
DROP VIEW IF EXISTS `room_summary`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `room_summary` AS select `r`.`id` AS `id`,`r`.`code` AS `code`,`r`.`name` AS `name`,`r`.`amount` AS `amount`,ifnull(`t`.`in_use`,0) AS `in_use` from (`room` `r` left join (select `c`.`room_code` AS `room_code`,count(`c`.`id`) AS `in_use` from `contract` `c` where ((1 = 1) and (`c`.`status` = 'ACTIVE')) group by `c`.`room_code`) `t` on((`t`.`room_code` = `r`.`code`)));

-- ----------------------------
-- View structure for v_room_summary
-- ----------------------------
DROP VIEW IF EXISTS `v_room_summary`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_room_summary` AS select `r`.`id` AS `id`,`r`.`code` AS `code`,`r`.`name` AS `name`,`r`.`amount` AS `amount`,ifnull(`t`.`in_use`,0) AS `in_use` from (`room` `r` left join (select `c`.`room_code` AS `room_code`,count(`c`.`id`) AS `in_use` from `contract` `c` where ((1 = 1) and (`c`.`status` = 'ACTIVE')) group by `c`.`room_code`) `t` on((`t`.`room_code` = `r`.`code`)));

SET FOREIGN_KEY_CHECKS = 1;