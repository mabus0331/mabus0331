select * from memship;

select memship_seq.nextval from dual;

drop table memship;

drop sequence memship_seq;

create sequence memship_seq start with 1 increment by 1 nocycle nocache;

create table memship (
	msNum number primary key,
	disc number,
	grade varchar2(20)
);

insert into memship values ('1', 20, 'VIP');
insert into memship values ('2', 15, 'Gold');
insert into memship values ('3', 10, 'Silver');
insert into memship values ('4', 0, 'Creem');

