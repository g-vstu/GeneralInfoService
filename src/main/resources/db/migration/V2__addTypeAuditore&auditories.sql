CREATE TABLE "type_classroom"
(
    "type_classroom_id" BIGSERIAL PRIMARY KEY,
    "name"              varchar,
    "short_name"        varchar,
    "created"           date,
    "updated"           date,
    "status"            varchar
);

CREATE TABLE "classroom"
(
    "classroom_id"      BIGSERIAL PRIMARY KEY,
    "type_classroom_id" bigint,
    "department_id"     bigint,
    "frame"             varchar,
    "location"          varchar,
    "seats"             integer,
    "description"       varchar,
    "created"           date,
    "updated"           date,
    "status"            varchar
);

ALTER TABLE "classroom"
    ADD FOREIGN KEY ("type_classroom_id") REFERENCES "type_classroom" ("type_classroom_id");

ALTER TABLE "classroom"
    ADD FOREIGN KEY ("department_id") REFERENCES "department" ("department_id");