create table "student_follow_course"(
    "course_id" varchar references "course"("id") not null,
    "student_ref" varchar references "student"("ref") not null,
    primary key ("course_id", "student_ref")
)