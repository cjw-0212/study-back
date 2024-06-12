DROP TABLE IF EXISTS author;
CREATE TABLE author
(
    author_id                int(11) NOT NULL AUTO_INCREMENT,
    author_username          varchar(255) DEFAULT NULL,
    author_password          varchar(255) DEFAULT NULL,
    author_email             varchar(255) DEFAULT NULL,
    author_bio               varchar(255) DEFAULT NULL,
    author_favourite_section varchar(255) DEFAULT NULL,
    PRIMARY KEY (author_id)
);

INSERT INTO author
VALUES (2, 'yitian', '123', 'yitian.z@foxmail.com', 'my_bio', '12');

DROP TABLE IF EXISTS blog;
CREATE TABLE blog
(
    blog_id    int(11) NOT NULL,
    blog_title varchar(255) DEFAULT NULL,
    author_id  int(11)      DEFAULT NULL,
    PRIMARY KEY (blog_id)
);

BEGIN;
INSERT INTO blog
VALUES (1, 'yitian_blog', 2);
COMMIT;

DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
    comment_id      int(11) NOT NULL,
    comment_content varchar(255) DEFAULT NULL,
    post_id         int(11)      DEFAULT NULL,
    PRIMARY KEY (comment_id)
);

BEGIN;
INSERT INTO comment
VALUES (1, 'Comment1', 1);
INSERT INTO comment
VALUES (2, 'Comment2', 1);
INSERT INTO comment
VALUES (3, 'Comment3', 2);
INSERT INTO comment
VALUES (4, 'Comment4', 3);
COMMIT;

DROP TABLE IF EXISTS post;
CREATE TABLE post
(
    post_id      int(11) NOT NULL,
    post_subject varchar(255) DEFAULT NULL,
    author_id    int(11)      DEFAULT NULL,
    draft_status int(11)      DEFAULT NULL,
    post_content varchar(255) DEFAULT NULL,
    blog_id      int(11)      DEFAULT NULL,
    PRIMARY KEY (post_id)
);

BEGIN;
INSERT INTO post
VALUES (1, 'subject1', 2, 1, 'Post1', 1);
INSERT INTO post
VALUES (2, 'subject2', 2, 1, 'Post2', 1);
INSERT INTO post
VALUES (3, 'subject3', 2, 1, 'Post3', 1);
COMMIT;

DROP TABLE IF EXISTS tag;
CREATE TABLE tag
(
    tag_id      int(11) NOT NULL,
    tag_content varchar(255) DEFAULT NULL,
    post_id     int(11)      DEFAULT NULL,
    PRIMARY KEY (tag_id)
);

BEGIN;
INSERT INTO tag
VALUES (1, 'Tag1', 1);
INSERT INTO tag
VALUES (2, 'Tag2', 2);
INSERT INTO tag
VALUES (3, 'Tag3', 3);
COMMIT;
