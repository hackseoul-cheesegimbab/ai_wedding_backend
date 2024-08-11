CREATE TABLE friend
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '친구 아이디',
    type               VARCHAR(255) COMMENT '주변 타입 (friend, cousin, coworker)',
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) COMMENT='친구 정보 테이블';

CREATE TABLE me
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '나의 아이디',
    name               VARCHAR(255) COMMENT '나의 이름',
    age                INT COMMENT '나의 나이',
    sex                VARCHAR(50) COMMENT '나의 성별',
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) COMMENT='나의 정보 테이블';

CREATE TABLE result_plan
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '플랜 아이디',
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) COMMENT='AI 플랜 결과 테이블';

CREATE TABLE review
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '후기 아이디',
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) COMMENT='플랜 사용 후기 테이블';

CREATE TABLE wedding_map
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '장소 아이디',
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) COMMENT='결혼식 장소 테이블';

CREATE TABLE wish_info
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '플랜 아이디',
    type               VARCHAR(255) COMMENT '플랜 타입',
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) COMMENT='플랜 정보 테이블';
