drop table t_board;
drop table t_member;
drop table t_tag;

create table t_member(
    id varchar2(10) primary key,
    pwd varchar2(10),
    name varchar2(50),
    email varchar2(50),
    joinDate date default sysdate
);


CREATE TABLE t_board (
    articleNO NUMBER(10) primary key,
    parentNO NUMBER(10) default 0,
    content VARCHAR2(4000),
    staring float,
    writeDate DATE default SYSDATE NOT NULL,
    id VARCHAR2(10),
    CONSTRAINT FK_ID FOREIGN KEY(id) REFERENCES t_member(id),
    booktitle VARCHAR2(500),
    tagname VARCHAR2(100)
);

insert into t_member
values('hong', '1212', '홍길동', 'hong@gmail.com', sysdate);

insert into t_member
values('lee', '1212', '이순신', 'lee@gmail.com', sysdate);

insert into t_member
values('kim', '1212', '김유신', 'kimg@gmail.com', sysdate);   

insert into t_member
values('park', '1212', '박찬욱', 'park@gmail.com', sysdate); 

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(1, 0, '노인과 바다', '좋은 책입니다', 2.5, sysdate, 'hong');

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(2, 0, '호두까기 인형', '아이들이 읽기 좋습니다', 3.5, sysdate, 'park');

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(3, 0, '아기판다 푸바오', '판다가 귀엽습니다', 4.0, sysdate, 'park');

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(4, 0, '도둑맞은 집중력', '도움이 되는 책입니다', 3.0, sysdate, 'lee');

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(5, 0, '별로인 책', '생각보다 별로입니다', 1.0, sysdate, 'kim');

commit;
select*from t_board;
select*from t_tag;