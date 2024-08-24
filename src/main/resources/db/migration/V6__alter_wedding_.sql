ALTER TABLE `member` ADD PRIMARY KEY (member_seq);           -- PRIMARY KEY 설정
ALTER TABLE `member` MODIFY COLUMN `member_seq` INT AUTO_INCREMENT;        -- Auto_increment 추가

ALTER TABLE `wedding_info` ADD PRIMARY KEY (seq);           -- PRIMARY KEY 설정
ALTER TABLE `wedding_info` MODIFY COLUMN `seq` INT AUTO_INCREMENT;        -- Auto_increment 추가

ALTER TABLE `ai_result` ADD PRIMARY KEY (seq);           -- PRIMARY KEY 설정
ALTER TABLE `ai_result` MODIFY COLUMN `seq` INT AUTO_INCREMENT;        -- Auto_increment 추가

ALTER TABLE `wedding_data` ADD PRIMARY KEY (seq);           -- PRIMARY KEY 설정
ALTER TABLE `wedding_data` MODIFY COLUMN `seq` INT AUTO_INCREMENT;        -- Auto_increment 추가
