CREATE TABLE member
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    create_date DATE         NOT NULL DEFAULT CURRENT_DATE
);
