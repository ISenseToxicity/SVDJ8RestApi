BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "admin" (
	"admin_id"	bigint,
	"name"	varchar NOT NULL UNIQUE,
	"password"	varchar NOT NULL,
	CONSTRAINT "admin_pk" PRIMARY KEY("admin_id")
);
INSERT INTO "admin" VALUES(1, "name1", "password1");
INSERT INTO "admin" VALUES(2, "name2", "password2");
INSERT INTO "admin" VALUES(3, "name3", "password3");
INSERT INTO "admin" VALUES(4, "name4", "password4");
INSERT INTO "admin" VALUES(5, "name5", "password5");

CREATE TABLE IF NOT EXISTS "category" (
	"category_id"	bigint NOT NULL,
	"description"	varchar,
	"name"	varchar NOT NULL UNIQUE,
	CONSTRAINT "category_pk" PRIMARY KEY("category_id")
);
INSERT INTO "category" VALUES (1, "description1", "name1");
INSERT INTO "category" VALUES (2, "description2", "name2");
INSERT INTO "category" VALUES (3, "description3", "name3");
INSERT INTO "category" VALUES (4, "description4", "name4");
INSERT INTO "category" VALUES (5, "description5", "name5");

CREATE TABLE IF NOT EXISTS "question" (
	"question_id"	bigint NOT NULL,
	"question_text"	text NOT NULL,
	"extra_info_tile"	text,
	"extra_info_description"	text,
	"extra_info_video_url"	text,
	CONSTRAINT "question_pk" PRIMARY KEY("question_id")
);
INSERT INTO "question" VALUES(1, "question_text1", "extra_info_tile1", "extra_info_description1", "extra_info_video_url1");
INSERT INTO "question" VALUES(2, "question_text2", "extra_info_tile2", "extra_info_description2", "extra_info_video_url2");
INSERT INTO "question" VALUES(3, "question_text3", "extra_info_tile3", "extra_info_description3", "extra_info_video_url3");
INSERT INTO "question" VALUES(4, "question_text4", "extra_info_tile4", "extra_info_description4", "extra_info_video_url4");
INSERT INTO "question" VALUES(5, "question_text5", "extra_info_tile5", "extra_info_description5", "extra_info_video_url5");

CREATE TABLE IF NOT EXISTS "question_and_category" (
	"question_id"	bigint NOT NULL,
	"category_id"	bigint NOT NULL,
	CONSTRAINT "question_and_category_pk" PRIMARY KEY("question_id", "category_id"),
	CONSTRAINT "question_id_fk" FOREIGN KEY("question_id") REFERENCES "question"("question_id") on update cascade on delete cascade,
	CONSTRAINT "category_id_fk" FOREIGN KEY("category_id") REFERENCES "category"("category_id") on update cascade on delete cascade
);
INSERT INTO "question_and_category" VALUES(1,1);
INSERT INTO "question_and_category" VALUES(1,2);
INSERT INTO "question_and_category" VALUES(1,3);
INSERT INTO "question_and_category" VALUES(1,4);
INSERT INTO "question_and_category" VALUES(1,5);
INSERT INTO "question_and_category" VALUES(2,1);
INSERT INTO "question_and_category" VALUES(2,2);
INSERT INTO "question_and_category" VALUES(2,3);
INSERT INTO "question_and_category" VALUES(2,4);
INSERT INTO "question_and_category" VALUES(2,5);

CREATE TABLE IF NOT EXISTS "grant" (
	"grant_id"	int NOT NULL,
	"name"	varchar NOT NULL UNIQUE,
	"description"	text,
	CONSTRAINT "grant_pk" PRIMARY KEY("grant_id")
);
INSERT INTO "grant" VALUES(1, "nada niks", "geen subsidie");
INSERT INTO "grant" VALUES(2, "name2", "description2");
INSERT INTO "grant" VALUES(3, "name3", "description3");
INSERT INTO "grant" VALUES(4, "name4", "description4");
INSERT INTO "grant" VALUES(5, "name5", "description5");


CREATE TABLE IF NOT EXISTS "grant_and_category" (
	"grant_id"	bigint NOT NULL,
	"category_id"	bigint NOT NULL,
	CONSTRAINT "grant_and_category_pk" PRIMARY KEY("grant_id", "category_id"),
	CONSTRAINT "grant_id_fk" FOREIGN KEY("grant_id") REFERENCES "grant"("grant_id") on update cascade on delete cascade,
	CONSTRAINT "category_id_fk" FOREIGN KEY("category_id") REFERENCES "category"("category_id") on update cascade on delete cascade
);

INSERT INTO "grant_and_category" VALUES(1,1);
INSERT INTO "grant_and_category" VALUES(1,2);
INSERT INTO "grant_and_category" VALUES(1,3);
INSERT INTO "grant_and_category" VALUES(1,4);
INSERT INTO "grant_and_category" VALUES(1,5);
INSERT INTO "grant_and_category" VALUES(2,1);
INSERT INTO "grant_and_category" VALUES(2,2);
INSERT INTO "grant_and_category" VALUES(2,3);
INSERT INTO "grant_and_category" VALUES(2,4);
INSERT INTO "grant_and_category" VALUES(2,5);

CREATE TABLE IF NOT EXISTS "result" (
	"result_id"	bigint NOT NULL,
	"grant_id"	bigint NOT NULL,
	"amount_questions"	integer,
	"total_time"	text,
	CONSTRAINT "result_pk" PRIMARY KEY("result_id"),
	CONSTRAINT "result_grant_fk" FOREIGN KEY("grant_id") REFERENCES "grant" on update cascade on delete restrict
);
INSERT INTO "result" VALUES(1,1,10, datetime("now"));
INSERT INTO "result" VALUES(2,1,20, datetime("now"));
INSERT INTO "result" VALUES(3,1,30, datetime("now"));
INSERT INTO "result" VALUES(4,1,40, datetime("now"));
INSERT INTO "result" VALUES(5,1,50, datetime("now"));

CREATE TABLE IF NOT EXISTS "route" (
	"route_id"	bigint,
	"total_time"	int,
	"result_id"	bigint,
	CONSTRAINT "route_pk" PRIMARY KEY("route_id"),
	CONSTRAINT "route_result_fk" FOREIGN KEY("result_id") REFERENCES "result" on update cascade on delete restrict
);
INSERT INTO "route" VALUES(1,10,1);
INSERT INTO "route" VALUES(2,20,2);
INSERT INTO "route" VALUES(3,30,3);
INSERT INTO "route" VALUES(4,40,4);
INSERT INTO "route" VALUES(5,50,5);

CREATE TABLE IF NOT EXISTS "answer" (
	"answer_id"	bigint NOT NULL,
	"question_id"	bigint NOT NULL,
	"answer_text"	varchar NOT NULL,
	"category_id"	bigint NOT NULL,
	CONSTRAINT "answer_pk" PRIMARY KEY("answer_id"),
	CONSTRAINT "answer_to_category_fk" FOREIGN KEY("category_id") REFERENCES "category" on update cascade on delete restrict,
	CONSTRAINT "answer_to_question_fk" FOREIGN KEY("question_id") REFERENCES "question" on update cascade on delete restrict
);
INSERT INTO "answer" VALUES(1, 1, "answer_text1", 1);
INSERT INTO "answer" VALUES(2, 2, "answer_text2", 2);
INSERT INTO "answer" VALUES(3, 3, "answer_text3", 3);
INSERT INTO "answer" VALUES(4, 4, "answer_text4", 4);
INSERT INTO "answer" VALUES(5, 5, "answer_text5", 5);
INSERT INTO "answer" VALUES(6, 1, "answer_text6", 1);
INSERT INTO "answer" VALUES(7, 2, "answer_text7", 2);
INSERT INTO "answer" VALUES(8, 3, "answer_text8", 3);
INSERT INTO "answer" VALUES(9, 4, "answer_text9", 4);
INSERT INTO "answer" VALUES(10, 5, "answer_text10", 5);

CREATE TABLE IF NOT EXISTS "given_answer" (
	"given_answer_id"	bigint,
	"question_id"	bigint,
	"elapsed_seconds"	int,
	"answer_id"	bigint NOT NULL,
	"route_id"	bigint,
	CONSTRAINT "given_answer_pk" PRIMARY KEY("given_answer_id"),
	FOREIGN KEY("question_id") REFERENCES "question" on update cascade on delete cascade,
	FOREIGN KEY("answer_id") REFERENCES "answer" on update cascade on delete restrict,
	CONSTRAINT "given_answer_route_fk" FOREIGN KEY("route_id") REFERENCES "route" on update cascade on delete restrict
);
INSERT INTO "given_answer" VALUES(1,1,10,1,1);
INSERT INTO "given_answer" VALUES(2,2,20,2,2);
INSERT INTO "given_answer" VALUES(3,3,30,3,3);
INSERT INTO "given_answer" VALUES(4,4,40,4,4);
INSERT INTO "given_answer" VALUES(5,5,50,5,5);

COMMIT;
