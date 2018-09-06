
-- auto-generated definition
CREATE TABLE stock_day
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  code        VARCHAR(8)     NOT NULL,
  name        VARCHAR(8)     NOT NULL,
  begin_pri   DECIMAL(8, 2)  NULL,
  max_pri     DECIMAL(8, 2)  NULL,
  min_pri     DECIMAL(8, 2)  NULL,
  pre_pri     DECIMAL(8, 2)  NULL,
  cur_pri     DECIMAL(8, 2)  NULL,
  deal_qty    BIGINT         NULL,
  deal_amt    DECIMAL(21, 2) NULL,
  rate        DECIMAL(5, 2)  NULL,
  rate_range  DECIMAL(5, 2)  NULL,
  in_out_rate DECIMAL(4, 2)  NULL,
  cur_date    DATE           NOT NULL,
  market_cap  DECIMAL(21, 2) NULL,
  famc        DECIMAL(21, 2) NULL,
  CONSTRAINT index_stock_day_code
  UNIQUE (code, cur_date)
)
  ENGINE = InnoDB;

CREATE INDEX index_code
  ON stock_day (code);

CREATE INDEX index_dealdate
  ON stock_day (cur_date);



CREATE TABLE deal_detail
(
  id_deal_detail INT AUTO_INCREMENT
    PRIMARY KEY,
  parent_id      INT            NOT NULL,
  deal_time      TIME           NOT NULL,
  price          DECIMAL(8, 2)  NULL,
  price_diff     DECIMAL(8, 2)  NULL,
  qty            INT            NULL,
  amt            DECIMAL(19, 2) NULL,
  sign           SMALLINT(6)    NULL
)
  ENGINE = InnoDB;

CREATE INDEX index_deal_detail
  ON deal_detail (parent_id);

create table rask_alyz
(
	id bigint auto_increment
		primary key,
	code varchar(8) null,
	name varchar(8) null,
	cur_pri decimal(8,2) null,
	avr_pri decimal(9,3) null,
	avr_pri_1 decimal(9,3) null,
	avr_pri_2 decimal(9,3) null,
	rate decimal(8,2) null,
	slope int null,
	slope1 int null,
	slope2 int null,
	deal_date date null,
	hold tinyint(1) null,
	reversal_rate varchar(80) null,
	remark varchar(300) null
)
;

create index inx_rask_alyz_code
	on rask_alyz (code)
;

create index inx_rask_alyz_day
	on rask_alyz (deal_date)
;

create table code_industry_rela
(
	code varchar(8) not null,
	industry varchar(8) not null,
	primary key (code, industry)
)
;

create table east_money_indestry
(
	code varchar(8) not null
		primary key,
	name varchar(8) not null
)
;

create table care_about
(
	code varchar(8) not null
		primary key,
	name varchar(8) not null
)
;

ALTER TABLE rask_alyz ADD high_risk_days int NULL;
ALTER TABLE rask_alyz ADD postive_days int NULL;
ALTER TABLE rask_alyz
  MODIFY COLUMN remark varchar(300) AFTER high_risk_days;


