create table member_files (
FNO NUMBER primary key,
MNO NUMBER ,  
email VARCHAR2(50) ,
ORI_FILE VARCHAR2(200) ,
REAL_FILE VARCHAR2(200),
FILE_PATH VARCHAR2(100),
FILE_SIZE NUMBER,
CRE_DATE DATE default sysdate
);

create SEQUENCE seq_member_files_fno;