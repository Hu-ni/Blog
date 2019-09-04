use webcc;

drop table if exists user;
drop table if exists bulletin;

create table user(
    seq bigint primary key auto_increment,
    name varchar(255) not null,
    id varchar(100) unique not null,
    password varchar(255) not null,
    gender integer not null,
    age integer not null,
    profile varchar(255) not null
)engine = InnoDB default charset=utf8;

create table bulletin(
    seq bigint primary key auto_increment,
    title varchar(255) not null,
    content text not null,
    writer bigint not null,
    created datetime default current_timestamp,
    rcnum integer not null,
    views integer not null,
    foreign key (writer) references user (seq)
     on update cascade
     on delete cascade
)engine = InnoDB default charset=utf8;
