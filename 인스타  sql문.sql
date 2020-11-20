select * from user;
select * from follow;
select * from image;
select * from tag;
select * from likes;
delete from likes;

select *
from user
where id=1;

select * from follow
where fromUserid = 1;

select 
u.id, 
u.name, 
(select true from follow where fromUserId = 2 and toUserId = u.id) as matpal
from follow f inner join user u
on f.toUserId = u.id
and f.fromUserId = 1;

select * from tag;
select * from image;

delete from image
where id <= 3;
delete from image;
commit;

select * from image
where userId = 1;

select * 
from follow
where fromUserId in(3, 4);

select toUserId 
from follow
where fromUserId = 1;

select *
from image 
where userId in (select toUserId from follow where fromUserId = 1);

select *
from image i
inner join follow f
on i.userId = f.toUserId
inner join user u
on i.userId = u.id
where f.fromUserId = 1;


insert into likes(userId, imageId)
VALUES(1,33);

select 
i.id, 
i.caption,  
(select count(*) from likes l where l.imageId = i.id) as 좋아요
from image i;


