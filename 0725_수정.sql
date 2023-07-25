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
values('hong', '1212', 'ȫ�浿', 'hong@gmail.com', sysdate);

insert into t_member
values('lee', '1212', '�̼���', 'lee@gmail.com', sysdate);

insert into t_member
values('kim', '1212', '������', 'kimg@gmail.com', sysdate);   

insert into t_member
values('park', '1212', '������', 'park@gmail.com', sysdate); 

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(1, 0, '���ΰ� �ٴ�', '���� å�Դϴ�', 2.5, sysdate, 'hong');

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(2, 0, 'ȣ�α�� ����', '���̵��� �б� �����ϴ�', 3.5, sysdate, 'park');

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(3, 0, '�Ʊ��Ǵ� Ǫ�ٿ�', '�Ǵٰ� �Ϳ����ϴ�', 4.0, sysdate, 'park');

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(4, 0, '���ϸ��� ���߷�', '������ �Ǵ� å�Դϴ�', 3.0, sysdate, 'lee');

insert into t_board(articleNO, parentNO, booktitle, content, staring,  writeDate, id)
values(5, 0, '������ å', '�������� �����Դϴ�', 1.0, sysdate, 'kim');

commit;
select*from t_board;
select*from t_tag;