create table members (
mno number primary key,
email varchar2(100),
mname varchar2(100),
pwd varchar2(100),
cre_date date default sysdate,
mod_date date default sysdate
);

create SEQUENCE seq_members_mno;