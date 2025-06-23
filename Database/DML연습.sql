/*
문제. 계좌 이체 처리하기

1. db_bank 데이터베이스와 은행, 고객, 계좌 테이블을 생성합니다.
  1) 관계 설정
    (1) 은행과 고객은 다대다 관계입니다.
    (2) 하나의 은행에는 여러 개의 계좌 정보가 존재합니다.
    (3) 하나의 고객은 여러 개의 계좌를 가질 수 있습니다.
  2) 칼럼 설정
    (1) 은행: 은행 아이디, 은행 이름
    (2) 고객: 고객 아이디, 고객 이름, 고객 연락처
    (3) 계좌: 계좌 아이디, 잔고 등
  3) 레코드 설정(행 설정)
    (1) 각 테이블에 최소 2개의 샘플 데이터를 입력합니다.
    (2) 100,000원 이상의 잔고를 가지도록 입력합니다.
    
2. 계좌 이체 트랜잭션을 처리합니다.
  1) 각 테이블에 최소 2개의 샘플 데이터를 입력합니다.
  2) 1번 고객이 2번 고객으로 100,000만원을 계좌 이체하는 트랜잭션을 작성하고 실행합니다.
  3) 쿼리문 실행 중 발생하는 오류는 없다고 가정하고 ROLLBACK 처리는 하지 않습니다.
*/

CREATE DATABASE IF NOT EXISTS db_bank;
USE db_bank;

CREATE TABLE IF NOT EXISTS tbl_bank(
  bank_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  bank_name VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS tbl_customer(
  customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  customer_name VARCHAR(50) NOT NULL,
  customer_number CHAR(11) NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS tbl_account(
  bank_id INT NULL,
  customer_id INT NULL,
  account_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  account_remaining INT NOT NULL DEFAULT 0,
  FOREIGN KEY(bank_id) REFERENCES tbl_bank(bank_id) ON DELETE SET NULL,
  FOREIGN KEY(customer_id) REFERENCES tbl_customer(customer_id) ON DELETE SET NULL,
  UNIQUE KEY(bank_id, customer_id)
) ENGINE=InnoDB;


INSERT INTO tbl_bank VALUES(NULL, "하나은행");
INSERT INTO tbl_bank VALUES(NULL, "국민은행");
INSERT INTO tbl_customer VALUES(NULL, "김철수", "01012345678");
INSERT INTO tbl_customer VALUES(NULL, "박은영", "01023456789");
INSERT INTO tbl_account VALUES(1, 1, NULL, 150000);
INSERT INTO tbl_account VALUES(2, 2, NULL, 250000);

UPDATE tbl_account SET account_remaining = account_remaining - 100000 WHERE customer_id = 1;
UPDATE tbl_account SET account_remaining = account_remaining + 100000 WHERE customer_id = 2;

DROP DATABASE db_bank;
DROP TABLE tbl_account;

COMMIT;
