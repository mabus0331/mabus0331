select * from coupon;

select coupon_seq.nextval from dual;

drop table coupon;

drop sequence coupon_seq;

create sequence coupon_seq start with 1 increment by 1 nocycle nocache;

create table coupon (
	cpNum varchar2(20) primary key,
	cpName varchar2(20),
	cpPer number
);

insert into coupon values ('135123512351235', '积老捻迄', '30');
insert into coupon values ('213512531235123', '积老捻迄', '30');
insert into coupon values ('123562346234623', '积老捻迄', '30');
insert into coupon values ('357635635634563', '积老捻迄', '30');