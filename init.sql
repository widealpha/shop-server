create database if not exists shop;

create table chat_message
(
    message_id     int auto_increment
        primary key,
    sender_account varchar(20)                         not null,
    target_account varchar(20)                         null,
    timestamp      timestamp default CURRENT_TIMESTAMP null,
    message        varchar(10000)                      null,
    read_times     int       default 0                 null
);

create table commodity
(
    commodity_id int auto_increment
        primary key,
    title        varchar(255)   not null,
    description  varchar(10000) null,
    price        double         not null,
    category     varchar(100)   null,
    image        varchar(1000)  null,
    account      varchar(100)   not null
);

create table user
(
    account  varchar(255) not null
        primary key,
    username varchar(255) null,
    password varchar(255) null
);

create table user_info
(
    account      varchar(20)    not null,
    head_image   varchar(255)   null,
    sex          int default 0  null comment '0是未知
1是男
2是女',
    location     varchar(255)   null,
    introduction varchar(10000) null,
    age          int            null,
    name         varchar(100)   null
);

create table want
(
    want_id     int auto_increment
        primary key,
    account     varchar(100)   not null,
    title       varchar(100)   not null,
    description varchar(10000) null
);

