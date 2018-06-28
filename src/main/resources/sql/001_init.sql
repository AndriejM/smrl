begin transaction;

drop table if exists "links" cascade;
drop sequence if exists "links_seq";

create sequence "links_seq" start 100000;
create table "links" (
  "id" bigint primary key default "nextval"('"links_seq"'),
  "text" text not null
);

end transaction;