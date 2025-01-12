create table "student"(
    "std" varchar(8) primary key check (std like 'STD%'),
    "last_name" varchar(200) not null,
    "first_name" varchar(200) not null,
    "birthday" date not null,
    "gender" char(1) check (gender in ('M', 'F')) not null,
    "level" varchar(2) check (level in ('L1', 'L2', 'L3', 'M1', 'M2')) not null,
    "address" varchar(200),
    "email" varchar(200) check (email like 'hei%') unique not null
);
