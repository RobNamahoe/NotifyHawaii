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
  topic                     varchar(255),
  provider                  varchar(255),
  url                       varchar(255),
  title                     varchar(255),
  summary                   varchar(255),
  article_date              varchar(255),
  timestamp                 timestamp not null,
  constraint pk_news_article primary key (id))
;

create table news_services_subscription (
  id                        bigint not null,
  site                      varchar(255),
  topic                     varchar(255),
  method                    varchar(255),
  hour                      varchar(255),
  period                    varchar(255),
  user_id                   bigint,
  constraint pk_news_services_subscription primary key (id))
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

create sequence carrier_seq;

create sequence news_article_seq;

create sequence news_services_subscription_seq;

create sequence user_info_seq;

alter table news_services_subscription add constraint fk_news_services_subscription__1 foreign key (user_id) references user_info (id);
create index ix_news_services_subscription__1 on news_services_subscription (user_id);
alter table user_info add constraint fk_user_info_carrier_2 foreign key (carrier_id) references carrier (id);
create index ix_user_info_carrier_2 on user_info (carrier_id);



# --- !Downs

drop table if exists carrier cascade;

drop table if exists news_article cascade;

drop table if exists news_services_subscription cascade;

drop table if exists user_info cascade;

drop sequence if exists carrier_seq;

drop sequence if exists news_article_seq;

drop sequence if exists news_services_subscription_seq;

drop sequence if exists user_info_seq;

