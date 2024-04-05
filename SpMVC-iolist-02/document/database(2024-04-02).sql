-- iolist
CREATE DATABASE iolistDB2;
USE iolistDB2;

CREATE TABLE tbl_iolist(
	io_seq	BIGINT		PRIMARY KEY AUTO_INCREMENT	,
	io_date	VARCHAR(10)	NOT NULL		,
	io_time	VARCHAR(10)	NOT NULL		,
	io_input	VARCHAR(1)	NOT NULL		,
	io_pname	VARCHAR(30)	NOT NULL		,
	io_price	INT	NOT NULL		,
	io_quan	INT	NOT NULL		,
	io_total	INT			
);

DESC tbl_iolist;


DROP TABLE tbl_iolist;