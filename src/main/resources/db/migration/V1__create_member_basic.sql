CREATE TABLE `member`
(
    `member_seq` BIGINT       NOT NULL COMMENT '회원번호',
    `member_id`  VARCHAR(50)  NOT NULL COMMENT '아이디',
    `member_pw`  VARCHAR(100) NOT NULL COMMENT '비밀번호',
    `recordtime` DATETIME     NOT NULL DEFAULT NOW() COMMENT '저장시간'
);


CREATE TABLE `wedding_info`
(
    `seq`            Bigint      NOT NULL COMMENT '기본키',
    `member_seq`     BIGINT      NOT NULL COMMENT '회원번호',
    `region`         VARCHAR(10) NOT NULL COMMENT '지역',
    `budget`         BIGINT      NOT NULL COMMENT '결혼식의 예산',
    `hall`           BOOLEAN     NULL COMMENT '웨딩홀 선택 여부',
    `studio`         BOOLEAN     NULL COMMENT '스튜디오 선택 여부',
    `dress`          BOOLEAN     NULL COMMENT '드레스 선택 여부',
    `make_up`        BOOLEAN     NULL COMMENT '메이크업 선택 여부',
    `gitf`           BOOLEAN     NULL COMMENT '예물 선택 여부',
    `dowry`          BOOLEAN     NULL COMMENT '혼수 선택여부',
    `parent_make_up` BOOLEAN     NULL COMMENT '혼주메이크업',
    `parent_dress`   BOOLEAN     NULL COMMENT '혼주 드레스'
);


CREATE TABLE `ai_log`
(
    `request_time`  DATETIME NOT NULL DEFAULT NOW() COMMENT 'AI호출한 시간',
    `reqeust_data`  TEXT     NOT NULL COMMENT '요청데이터',
    `response_data` TEXT     NOT NULL COMMENT '응답데이터'
);


CREATE TABLE `ai_result`
(
    `seq`                Bigint   NOT NULL COMMENT '기본키',
    `wedding_key`        Bigint   NULL COMMENT '웨딩홀 키',
    `studio_key`         BIGINT   NULL COMMENT '스튜디오키',
    `dress_key`          BIGINT   NULL COMMENT '드레스키',
    `make_up_key`        BIGINT   NULL COMMENT '메이크업 키',
    `gift_key`           BIGINT   NULL COMMENT '예물키',
    `dowry_key`          BIGINT   NULL COMMENT '혼수 키',
    `parent_make_up_key` BIGINT   NULL COMMENT '혼주 메이크업 키',
    `parent_dress_key`   BIGINT   NULL COMMENT '혼주 드레스 키',
    `recordtime`         DATETIME NOT NULL DEFAULT NOW() COMMENT '저장시간'
);


CREATE TABLE `wedding_data`
(
    `seq`          BIGINT       NOT NULL COMMENT '기본키',
    `wedding_flag` VARCHAR(2)   NOT NULL COMMENT '업체의 플래그',
    `name`         varchar(50)  NULL COMMENT '업체명',
    `city`         VARCHAR(10)  NULL COMMENT '시명칭',
    `district`     VARCHAR(10)  NULL COMMENT '구명칭',
    `adress`       VARCHAR(200) NULL COMMENT '주소',
    `phone`        VARCHAR(20)  NULL COMMENT '전화번호',
    `price`        VARCHAR(50)  NULL COMMENT '비용',
    `discription`  TEXT         NULL COMMENT '설명'
);
