CREATE TABLE 'crypto-automation'.'report_histories' (
    'id' int not null,
    'market' varchar(45) not null,
    'price' varchar(45) not null,
    'reported_at' DATETIME not null,
    PRIMARY KEY('id'));

ALTER TABLE `crypto-automation`.`report_histories`
    CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ;