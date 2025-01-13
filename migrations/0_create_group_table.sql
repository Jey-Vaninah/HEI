create table "group" (
    "id" varchar primary key,
    "name" varchar not null,
    "year" int check ("year" > 0) not null,
    "promotion" varchar(1) check ("promotion" in ('G', 'H', 'J', 'K')) not null
);
