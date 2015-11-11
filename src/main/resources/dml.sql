INSERT INTO building ( nm ) VALUES ( '미래에셋 플레이스' );

INSERT INTO section (
building_seq,
floor,
sex,
nick_nm
) VALUES (
1,
'4층',
'M',
'남자화장실'
); 

INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt) VALUES ( 1, '입구방향칸', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt ) VALUES ( 1, '중간칸', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm ,modify_ymdt) VALUES ( 1, '안쪽칸', NOW() );