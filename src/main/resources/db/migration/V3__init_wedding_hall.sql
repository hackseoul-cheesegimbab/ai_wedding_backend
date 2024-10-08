CREATE TABLE iwedding_wedding_hall
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '웨딩홀 레코드의 기본 키',
    enterprise_code    VARCHAR(255) NOT NULL COMMENT '웨딩홀과 연관된 기업 코드',
    thumbnail          VARCHAR(255)          COMMENT '웨딩홀 썸네일 이미지 URL',
    weddinghall_code   VARCHAR(255) NOT NULL COMMENT '웨딩홀의 고유 코드',
    name               VARCHAR(255) NOT NULL COMMENT '웨딩홀 이름',
    local              VARCHAR(50)           COMMENT '웨딩홀의 위치 또는 층',
    style              VARCHAR(100)          COMMENT '웨딩홀 스타일 (예: 하우스, 호텔)',
    shape              VARCHAR(100)          COMMENT '웨딩홀의 진행 형태 (예: 동시, 분리)',
    time               VARCHAR(50)           COMMENT '웨딩홀에서의 행사 시간',
    min_person         INT                   COMMENT '최소 참석 인원',
    seat_person        INT                   COMMENT '웨딩홀의 좌석 수',
    max_person         INT                   COMMENT '최대 수용 인원',
    food               VARCHAR(50)           COMMENT '제공 음식 종류 (예: 양식, 뷔페)',
    min_food_fee       DECIMAL(10, 2)        COMMENT '1인당 최소 음식 비용',
    max_food_fee       DECIMAL(10, 2)        COMMENT '1인당 최대 음식 비용',
    flower             VARCHAR(50)           COMMENT '꽃 종류 (예: 생화)',
    min_artificial_fee DECIMAL(10, 2)        COMMENT '인공 꽃 최소 비용',
    max_artificial_fee DECIMAL(10, 2)        COMMENT '인공 꽃 최대 비용',
    min_real_fee       DECIMAL(10, 2)        COMMENT '실제 꽃 최소 비용',
    max_real_fee       DECIMAL(10, 2)        COMMENT '실제 꽃 최대 비용',
    min_external_fee   DECIMAL(10, 2)        COMMENT '최소 외부 비용',
    max_external_fee   DECIMAL(10, 2)        COMMENT '최대 외부 비용',
    use_status         VARCHAR(10)           COMMENT '웨딩홀 사용 가능 여부',
    min_use_fee        DECIMAL(10, 2)        COMMENT '웨딩홀 최소 사용 비용',
    max_use_fee        DECIMAL(10, 2)        COMMENT '웨딩홀 최대 사용 비용',
    directing          VARCHAR(10)           COMMENT '연출 가능 여부',
    min_direct_fee     DECIMAL(10, 2)        COMMENT '최소 연출 비용',
    max_direct_fee     DECIMAL(10, 2)        COMMENT '최대 연출 비용',
    drink              VARCHAR(50)           COMMENT '음료 제공 방식 (예: 인당, 당일소모량)',
    drink_fee          DECIMAL(10, 2)        COMMENT '음료 비용'
) COMMENT='웨딩홀 상세 정보를 저장하는 테이블';
