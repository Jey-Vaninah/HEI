create table "student_follow_course_relation"(
    "course_id" varchar references "course"("id") not null,
    "student_std" varchar references "student"("std") not null,
    primary key ("course_id", "student_std")
);