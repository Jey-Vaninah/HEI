create table "student"(
    "id" varchar primary key,
    "ref" varchar(8) check ("ref" like 'STD%'),
    "name" varchar(200) not null,
    "birthdate" date not null,
    "gender" char(1) check ("gender" in ('M', 'F')) not null,
    "group_id" varchar references "group"("id") not null
);
