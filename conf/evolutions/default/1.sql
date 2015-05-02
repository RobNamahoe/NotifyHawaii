# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table carrier (
  id                        bigint not null,
  name                      varchar(255),
  gateway                   varchar(255),
  constraint pk_carrier primary key (id))
;

create table news_article (
  id                        bigint not null,
  url                       varchar(255),
  title                     varchar(255),
  summary                   varchar(255),
  constraint pk_news_article primary key (id))
;

create table subscription (
  id                        bigint not null,
  type                      varchar(255),
  name                      varchar(255),
  constraint pk_subscription primary key (id))
;

create table user_info (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  telephone                 varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  carrier_id                bigint,
  constraint pk_user_info primary key (id))
;


create table user_info_subscription (
  user_info_id                   bigint not null,
  subscription_id                bigint not null,
  constraint pk_user_info_subscription primary key (user_info_id, subscription_id))
;
create sequence carrier_seq;

create sequence news_article_seq;

create sequence subscription_seq;

create sequence user_info_seq;

alter table user_info add constraint fk_user_info_carrier_1 foreign key (carrier_id) references carrier (id) on delete restrict on update restrict;
create index ix_user_info_carrier_1 on user_info (carrier_id);



alter table user_info_subscription add constraint fk_user_info_subscription_use_01 foreign key (user_info_id) references user_info (id) on delete restrict on update restrict;

alter table user_info_subscription add constraint fk_user_info_subscription_sub_02 foreign key (subscription_id) references subscription (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists carrier;

drop table if exists news_article;

drop table if exists subscription;

drop table if exists user_info_subscription;

drop table if exists user_info;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists carrier_seq;

drop sequence if exists news_article_seq;

drop sequence if exists subscription_seq;

drop sequence if exists user_info_seq;

