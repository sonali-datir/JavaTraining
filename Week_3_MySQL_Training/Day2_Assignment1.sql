-- Day 2 – Create a simple table to store id, name, email, contact for a given
-- user. We should not allow adding multiple users with same email to the table.
-- types Ability to write data to the table using insert queries

use training;


create table users (id int PRIMARY KEY auto_increment, user_name varchar(20), email varchar(50) UNIQUE KEY, contact int(10));
delete from users where id = 2;
insert into users(id, user_name, email, contact) values(2, "Joey", "joey@xyz.com", 234523456 );
insert into users(user_name, email, contact) values( "Chandler", "chandler@xyz.com", 234523456 );
insert into users(id, user_name, email, contact) values(1, "Ross", "ross@xyz.com", 1234567899 );
insert into users(user_name, email, contact) values( "Monica", "moica@xyz.com", 1564567899 );

select * from users;

drop table users;
