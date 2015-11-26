select b.seq, b.nm, s.floor, s.sex, s.nick_nm from building b, section s 
where b.seq = s.building_seq
;

select b.seq, b.nm, s.floor, s.sex, s.nick_nm, sr.seq, sr.nick_nm 
from building b, section s, secret_room sr
where b.seq = s.building_seq
and s.seq = sr.section_seq
and sr.use_yn = 'Y'
;

select b.seq, b.nm, s.floor, s.sex, s.nick_nm, sr.seq, sr.nick_nm 
, ifnull( (select 'OCCUPIED' from secret_room_use i where i.secret_room_seq = sr.seq and i.start_reg_ymdt is not null and i.end_reg_ymdt is null) ,'EMPTY') as 'NOW-EMPTY'
, (select max(start_reg_ymdt) from secret_room_use i where i.secret_room_seq = sr.seq and i.start_reg_ymdt is not null and i.end_reg_ymdt is null) as 'LAST-START'
, (select max(end_reg_ymdt) from secret_room_use i where i.secret_room_seq = sr.seq and i.start_reg_ymdt is not null and i.end_reg_ymdt is not null) as 'LAST-END'
from building b, section s, secret_room sr
where b.seq = s.building_seq
and s.seq = sr.section_seq
and b.seq = 1
and s.floor = 4
and s.sex = 'M'
and sr.use_yn = 'Y'
;
