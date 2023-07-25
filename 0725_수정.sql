drop table t_board;
drop table t_member;
drop table t_book;

create table t_member(
    id varchar2(10) primary key,
    pwd varchar2(10),
    name varchar2(50),
    email varchar2(50),
    joinDate date default sysdate
);

CREATE TABLE t_book(
    booknum int,
    booktitle VARCHAR2(500) NOT NULL,
    bookwriter VARCHAR2(100) NOT NULL,
    genre VARCHAR2(100) NOT NULL,

    PRIMARY KEY (booknum)
);

CREATE TABLE t_board (
    articleNO NUMBER(10) primary key,
    parentNO NUMBER(10) default 0,
    content VARCHAR2(4000),
    staring float,
    writeDate DATE default SYSDATE NOT NULL,
    id VARCHAR2(10),
    CONSTRAINT FK_ID FOREIGN KEY(id) REFERENCES t_member(id),
    booknum int REFERENCES t_book (booknum)
);

insert into t_member
values('hong', '1212', '홍길동', 'hong@gmail.com', sysdate);

insert into t_member
values('lee', '1212', '이순신', 'lee@gmail.com', sysdate);

insert into t_member
values('kim', '1212', '김유신', 'kimg@gmail.com', sysdate);   

insert into t_member
values('park', '1212', '박찬욱', 'park@gmail.com', sysdate); 

insert into t_book
values(1,'book1', 'writer1', 'genre1');
insert into t_book
values(2,'book2', 'writer2', 'genre2');
insert into t_book
values(3,'book3', 'writer3', 'genre3');
insert into t_book
values(4,'book4', 'writer4', 'genre4');
insert into t_book
values(5,'book5', 'writer5', 'genre5');

insert into t_board(articleNO, parentNO, booknum, content, staring,  writeDate, id)
values(1, 0, 1, '좋은 책입니다', 2.5, sysdate, 'hong');

insert into t_board(articleNO, parentNO, booknum, content, staring,  writeDate, id)
values(2, 0, 2, '아이들이 읽기 좋습니다', 3.5, sysdate, 'park');

insert into t_board(articleNO, parentNO, booknum, content, staring,  writeDate, id)
values(3, 0, 3, '판다가 귀엽습니다', 4.0, sysdate, 'park');

insert into t_board(articleNO, parentNO, booknum, content, staring,  writeDate, id)
values(4, 0, 4, '도움이 되는 책입니다', 3.0, sysdate, 'lee');

insert into t_board(articleNO, parentNO, booknum, content, staring,  writeDate, id)
values(5, 0, 5, '생각보다 별로입니다', 1.0, sysdate, 'kim');

insert into t_board(articleNO, parentNO, booknum, content, staring,  writeDate, id)
values(6, 0, 5, '생각보다 더 별로입니다', 1.5, sysdate, 'lee');

commit;

select * from t_Board;