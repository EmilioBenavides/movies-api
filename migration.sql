CREATE TABLE movies (
    id int unsigned not null auto_increment,
    title varchar(250) not null,
    year int,
    director varchar(250) not null,
    actors varchar(250) not null,
    rating varchar(250) not null,
    poster varchar(250) not null,
    genre varchar(250) not null,
    plot varchar(250) not null,
    primary key (id)
)
