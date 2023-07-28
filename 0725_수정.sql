drop table t_board;
drop table t_member;
drop table t_book;

create sequence seq_boardnum nocache;

create table t_member(
    id varchar2(10) primary key,
    pwd varchar2(10),
    name varchar2(50),
    email varchar2(50),
    joinDate date default sysdate
);


CREATE TABLE t_book(
    booktitle VARCHAR2(500) NOT NULL,
    bookwriter VARCHAR2(100) NOT NULL,
    genre VARCHAR2(100) NOT NULL,
    bookinfo VARCHAR2(4000)
);

CREATE TABLE t_board (
    articleNO NUMBER(10) primary key,
    parentNO NUMBER(10) default 0,
    content VARCHAR2(4000),
    staring float,
    writeDate DATE default SYSDATE NOT NULL,
    booktitle_ VARCHAR2(500) NOT NULL,
    reco int default 0,
    id VARCHAR2(10),
    CONSTRAINT FK_ID FOREIGN KEY(id) REFERENCES t_member(id)
);

insert into t_member
values('hong', '1212', '홍길동', 'hong@gmail.com', sysdate);

insert into t_member
values('lee', '1212', '이순신', 'lee@gmail.com', sysdate);

insert into t_member
values('kim', '1212', '김유신', 'kimg@gmail.com', sysdate);   

insert into t_member
values('park', '1212', '박찬욱', 'park@gmail.com', sysdate); 


commit;

select * from t_Board;
select * from t_Book;