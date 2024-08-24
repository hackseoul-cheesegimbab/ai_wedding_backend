CREATE TABLE seoul_gu
(
    district_id   INT AUTO_INCREMENT PRIMARY KEY,
    district_name VARCHAR(50) NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 서울시 구 이름들을 삽입하는 예제
INSERT INTO seoul_gu (district_name)
VALUES ('종로구'),
       ('중구'),
       ('용산구'),
       ('성동구'),
       ('광진구'),
       ('동대문구'),
       ('중랑구'),
       ('성북구'),
       ('강북구'),
       ('도봉구'),
       ('노원구'),
       ('은평구'),
       ('서대문구'),
       ('마포구'),
       ('양천구'),
       ('강서구'),
       ('구로구'),
       ('금천구'),
       ('영등포구'),
       ('동작구'),
       ('관악구'),
       ('서초구'),
       ('강남구'),
       ('송파구'),
       ('강동구');