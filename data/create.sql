
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

