DROP TABLE user;

create table user
(
    id       integer primary,
    name     text,
    level    integer,
    followed boolean
);

INSERT INTO user (name, level, followed) VALUES ('Ned Stark', 5, 1);
INSERT INTO user (name, level, followed) VALUES ('Robert Baratheon', 5, 1);
INSERT INTO user (name, level, followed) VALUES ('Jaime Lannister', 4, 1);
INSERT INTO user (name, level, followed) VALUES ('Daenerys Targaryen', 4, 1);
INSERT INTO user (name, level, followed) VALUES ('Jon Snow', 3, 1);
INSERT INTO user (name, level, followed) VALUES ('Arya Stark', 3, 1);
INSERT INTO user (name, level, followed) VALUES ('Sansa Stark', 2, 1);
INSERT INTO user (name, level, followed) VALUES ('Tyrion Lannister', 2, 1);
INSERT INTO user (name, level, followed) VALUES ('Robb Stark', 1, 1);
INSERT INTO user (name, level, followed) VALUES ('Night King', 1, 1);
INSERT INTO user (name, level, followed) VALUES ('Eren Yeager', 5, 0);
INSERT INTO user (name, level, followed) VALUES ('Mikasa Ackerman', 5, 0);
INSERT INTO user (name, level, followed) VALUES ('Armin Arlert', 4, 0);
INSERT INTO user (name, level, followed) VALUES ('Reiner Braun', 4, 0);
INSERT INTO user (name, level, followed) VALUES ('Bertholdt Hoover', 3, 0);
INSERT INTO user (name, level, followed) VALUES ('Annie Leonhart', 3, 0);
INSERT INTO user (name, level, followed) VALUES ('Sasha Blouse', 2, 0);
INSERT INTO user (name, level, followed) VALUES ('Levi Ackerman', 2, 0);
INSERT INTO user (name, level, followed) VALUES ('Zeke Jaeger', 1, 0);
INSERT INTO user (name, level, followed) VALUES ('Pieck Finger', 1, 0);
commit;