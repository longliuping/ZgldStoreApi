/*
Navicat SQL Server Data Transfer

Source Server         : www.shop.com
Source Server Version : 105000
Source Host           : 115.28.20.167:1433
Source Database       : www.shop.com
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 105000
File Encoding         : 65001

Date: 2016-04-09 10:24:04
*/


-- ----------------------------
-- Table structure for Categories
-- ----------------------------
DROP TABLE [dbo].[Categories]
GO
CREATE TABLE [dbo].[Categories] (
[CategoryId] int NOT NULL IDENTITY(1,1) ,
[ParentCategoryId] int NULL ,
[Name] nvarchar(50) NULL ,
[displaysequence] int NULL ,
[IconUrl] nvarchar(200) NULL ,
[IndexChar] nvarchar(50) NULL ,
[Title] nvarchar(50) NULL ,
[Meta_Description] nvarchar(500) NULL ,
[Meta_Keywords] nvarchar(200) NULL ,
[Description] nvarchar(500) NULL ,
[Depth] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[Categories]', RESEED, 10)
GO

-- ----------------------------
-- Records of Categories
-- ----------------------------
SET IDENTITY_INSERT [dbo].[Categories] ON
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'1', null, N'代金卷', null, N'/category/category1.png', null, null, null, null, null, null)
GO
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'2', null, N'KTV', null, N'/category/category2.png', null, null, null, null, null, null)
GO
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'3', null, N'火锅', null, N'/category/category3.png', null, null, null, null, null, null)
GO
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'4', null, N'美发', null, N'/category/category4.png', null, null, null, null, null, null)
GO
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'5', null, N'洗浴/汗蒸', null, N'/category/category5.png', null, null, null, null, null, null)
GO
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'6', null, N'甜点饮品', null, N'/category/category6.png', null, null, null, null, null, null)
GO
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'7', null, N'自助餐', null, N'/category/category7.png', null, null, null, null, null, null)
GO
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'8', null, N'小吃快餐', null, N'/category/category8.png', null, null, null, null, null, null)
GO
GO
INSERT INTO [dbo].[Categories] ([CategoryId], [ParentCategoryId], [Name], [displaysequence], [IconUrl], [IndexChar], [Title], [Meta_Description], [Meta_Keywords], [Description], [Depth]) VALUES (N'9', null, N'云贵菜', null, N'/category/category9.png', null, null, null, null, null, null)
GO
GO
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO

-- ----------------------------
-- Indexes structure for table Categories
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table Categories
-- ----------------------------
ALTER TABLE [dbo].[Categories] ADD PRIMARY KEY ([CategoryId])
GO
