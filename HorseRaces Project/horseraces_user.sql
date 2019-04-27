
create table user
(
    login    varchar(30)              not null,
    password varchar(30)              not null,
    type     enum ('client', 'admin') not null,
    constraint user_login_uindex
        unique (login)
);

alter table user
    add primary key (login);


INSERT INTO user (login, password, type) VALUES ('ilya', 'admin', 'admin');
INSERT INTO user (login, password, type) VALUES ('test', '123', 'client');