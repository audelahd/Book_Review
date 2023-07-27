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
    reco int,
    id VARCHAR2(10),
    CONSTRAINT FK_ID FOREIGN KEY(id) REFERENCES t_member(id)
);

insert into t_member
values('hong', '1212', 'ȫ�浿', 'hong@gmail.com', sysdate);

insert into t_member
values('lee', '1212', '�̼���', 'lee@gmail.com', sysdate);

insert into t_member
values('kim', '1212', '������', 'kimg@gmail.com', sysdate);   

insert into t_member
values('park', '1212', '������', 'park@gmail.com', sysdate); 

insert into t_book
values('book1', 'writer1', 'genre1', 'info');
insert into t_book
values('book2', 'writer2', 'genre2', 'info');
insert into t_book
values('book3', 'writer3', 'genre3', 'info');
insert into t_book
values('book4', 'writer4', 'genre4', 'info');
insert into t_book
values('book5', 'writer5', 'genre5', 'info');

insert into t_board(articleNO, parentNO, booktitle_, content, staring,  writeDate, reco, id)
values(1, 0,  'book1', '���� å�Դϴ�', 2.5, sysdate, 10,'hong');

insert into t_board(articleNO, parentNO,  booktitle_,content, staring,  writeDate, reco, id)
values(2, 0, 'book2', '���̵��� �б� �����ϴ�', 3.5, sysdate, 4,'park');

insert into t_board(articleNO, parentNO, booktitle_,content, staring,  writeDate, reco, id)
values(3, 0,  'book3', '�Ǵٰ� �Ϳ����ϴ�', 4.0, sysdate, 5,'park');

insert into t_board(articleNO, parentNO,  booktitle_,content, staring,  writeDate, reco, id)
values(4, 0,  'book4', '������ �Ǵ� å�Դϴ�', 3.0, sysdate,3, 'lee');

insert into t_board(articleNO, parentNO, booktitle_,content, staring,  writeDate,  reco,id)
values(5, 0,  'book5', '�������� �����Դϴ�', 1.0, sysdate,0, 'kim');

insert into t_board(articleNO, parentNO, booktitle_,content, staring,  writeDate,  reco,id)
values(6, 0,  'book5','�������� �� �����Դϴ�', 1.5, sysdate, 3,'lee');

commit;

select * from t_Board;
select * from t_Book;