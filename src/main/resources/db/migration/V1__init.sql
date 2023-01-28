CREATE TABLE "faculty"
(
    "faculty_id"        BIGSERIAL PRIMARY KEY,
    "type_education_id" bigint,
    "name"              varchar,
    "short_name"        varchar,
    "dean"              varchar,
    "discription"       varchar,
    "created"           date,
    "updated"           date,
    "status"            varchar
);

CREATE TABLE "type_education"
(
    "type_education_id" BIGSERIAL PRIMARY KEY,
    "name"              varchar,
    "created"           date,
    "updated"           date,
    "status"            varchar
);

CREATE TABLE "department"
(
    "department_id"                BIGSERIAL PRIMARY KEY,
    "faculty_id"                   bigint,
    "name"                         varchar,
    "short_name"                   varchar,
    "department_auditorium_number" varchar,
    "created"                      date,
    "updated"                      date,
    "status"                       varchar
);

CREATE TABLE "specialty"
(
    "specialty_id"    BIGSERIAL PRIMARY KEY,
    "faculty_id"      bigint,
    "code_speciality" varchar,
    "name"            varchar,
    "short_name"      varchar,
    "training_period" float,
    "qualification"   varchar,
    "discription"     varchar,
    "created"         date,
    "updated"         date,
    "status"          varchar
);

CREATE TABLE "students_group"
(
    "group_id"      BIGSERIAL PRIMARY KEY,
    "specialty_id"  bigint,
    "department_id" bigint,
    "name"          varchar,
    "year_start"    date,
    "year_end"      date,
    "course"        integer,
    "created"       date,
    "updated"       date,
    "status"        varchar
);

CREATE TABLE "discipline"
(
    "discipline_id" BIGSERIAL PRIMARY KEY,
    "department_id" bigint,
    "name"          varchar,
    "short_name"    varchar,
    "created"       date,
    "updated"       date,
    "status"        varchar
);

CREATE TABLE "student"
(
    "student_id"              BIGSERIAL PRIMARY KEY,
    "group_id"                bigint,
    "number_studentbook"      integer,
    "surname"                 varchar,
    "name"                    varchar,
    "patronymic"              varchar,
    "birthday"                date,
    "phone"                   varchar,
    "address"                 varchar,
    "list_identificatior"     integer,
    "sub_group_identificator" integer,
    "paid"                    boolean,
    "created"                 date,
    "updated"                 date,
    "status"                  varchar
);

CREATE TABLE "employee"
(
    "employee_id" BIGSERIAL PRIMARY KEY,
    "surname"  varchar,
    "name" varchar,
    "patronymic" varchar,
    "degree"      varchar,
    "position"    varchar,
    "photo"       varchar,
    "created"     date,
    "updated"     date,
    "status"      varchar
);

CREATE TABLE "staff"
(
    "department_id" bigint,
    "employee_id"   bigint,
    "created"       date,
    "updated"       date,
    "status"        varchar
);

CREATE TABLE "period_class"
(
    "period_class_id" BIGSERIAL PRIMARY KEY,
    "number_class"    integer,
    "time_start"      time,
    "time_stop"       time,
    "created"         date,
    "updated"         date,
    "status"          varchar
);

CREATE TABLE "type_class"
(
    "type_class_id" BIGSERIAL PRIMARY KEY,
    "name"          varchar,
    "created"       date,
    "updated"       date,
    "status"        varchar
);

ALTER TABLE "department"
    ADD FOREIGN KEY ("faculty_id") REFERENCES "faculty" ("faculty_id");

ALTER TABLE "discipline"
    ADD FOREIGN KEY ("department_id") REFERENCES "department" ("department_id");

ALTER TABLE "staff"
    ADD FOREIGN KEY ("employee_id") REFERENCES "employee" ("employee_id");

ALTER TABLE "staff"
    ADD FOREIGN KEY ("department_id") REFERENCES "department" ("department_id");

ALTER TABLE "students_group"
    ADD FOREIGN KEY ("specialty_id") REFERENCES "specialty" ("specialty_id");

ALTER TABLE "student"
    ADD FOREIGN KEY ("group_id") REFERENCES "students_group" ("group_id");

ALTER TABLE "faculty"
    ADD FOREIGN KEY ("type_education_id") REFERENCES "type_education" ("type_education_id");

ALTER TABLE "specialty"
    ADD FOREIGN KEY ("faculty_id") REFERENCES "faculty" ("faculty_id");

ALTER TABLE "students_group"
    ADD FOREIGN KEY ("department_id") REFERENCES "department" ("department_id");
