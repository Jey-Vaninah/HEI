create database hei;

\c hei;

create table course (
                        id VARCHAR PRIMARY KEY,
                        name VARCHAR(50)

);

create table student(
                        std VARCHAR(8) PRIMARY KEY CHECK (std LIKE 'STD%'),
                        last_name VARCHAR(200) NOT NULL,
                        first_name VARCHAR(200) NOT NULL,
                        birthday DATE NOT NULL,
                        gender CHAR(1) CHECK (gender IN ('M', 'F')) NOT NULL,
                        "group" VARCHAR(2) NOT NULL,
                        level VARCHAR(2) CHECK (level IN ('L1', 'L2', 'L3', 'M1', 'M2')) NOT NULL,
                        address VARCHAR(200),
                        email VARCHAR(200) CHECK (email LIKE 'hei%') UNIQUE NOT NULL
);
