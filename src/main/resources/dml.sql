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

INSERT INTO section (
building_seq,
floor,
sex,
nick_nm
) VALUES (
1,
'4층',
'F',
'여자화장실'
);

INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt) VALUES ( 2, '입구방향칸', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt ) VALUES ( 2, '중간칸(입구쪽)', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt ) VALUES ( 2, '중간칸(안쪽)', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm ,modify_ymdt) VALUES ( 2, '안쪽칸', NOW() );


INSERT INTO building ( nm ) VALUES ( '그린팩토리' );


INSERT INTO section (
building_seq,
floor,
sex,
nick_nm
) VALUES (
2,
'4층-cafeteria',
'M',
'남자화장실'
);

INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt) VALUES ( 3, '입구정면칸', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt ) VALUES ( 3, '중간칸(입구쪽)', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt ) VALUES ( 3, '중간칸(안쪽)', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm ,modify_ymdt) VALUES ( 3, '더팰리스', NOW() );


INSERT INTO section (
building_seq,
floor,
sex,
nick_nm
) VALUES (
2,
'4층-cafeteria',
'F',
'여자화장실'
);

INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt) VALUES ( 4, '입구정면칸', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt ) VALUES ( 4, '중간칸(입구쪽)', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm , modify_ymdt ) VALUES ( 4, '중간칸(안쪽)', NOW() );
INSERT INTO secret_room ( section_seq , nick_nm ,modify_ymdt) VALUES ( 4, '더팰리스', NOW() );