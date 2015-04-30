drop table board;

select * from board;

create sequence board_seq start with 1 increment by 1 nocycle nocache;

select * from board order by board_num desc;

create table board(
	board_num number primary key,
	board_writer varchar2(30),
	board_sub varchar2(500),
	board_content varchar2(1000),
	board_date date default sysdate
);

