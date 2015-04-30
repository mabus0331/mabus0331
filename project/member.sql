select * from member;

select member_seq.nextval from dual;

drop table member;

drop sequence member_seq;

create sequence member_seq start with 1 increment by 1 nocycle nocache;

create table member (	
	id varchar2(10) primary key,
	pass varchar2(20),
	name varchar2(20),
	zip1 varchar2(10),
	zip2 varchar2(10),
	addr1 varchar2(100),
	addr2 varchar2(100),	
	phone varchar2(100),
	email varchar2(20),
	gen varchar2(10),
	birthday varchar2(20),
	joinDate date default sysdate,
	msNum number default 4 not null,
	foreign key(msNum) references memship(msNum),
	cpNum varchar2(20) default null,	
	foreign key(cpNum) references coupon(cpNum)
);

insert into member (id, pass, name, zip1, zip2, addr1, addr2, phone, email, gen, birthday) 
	values ('master', 'master', '홍길동','232','777', '서울시 강남구','중앙', '77-777-7777', 
	'master@ju.com', '남자', '2015-4-24');
	
	
	