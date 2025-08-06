SELECT * FROM db_puppit.point_charge;
DROP TABLE trade_payment;
DROP TABLE point_charge;
DROP TABLE wishlist;

CREATE TABLE `trade_payment` (
	`payment_id`	INT	NOT NULL PRIMARY KEY,
	`buyer_id`	    INT	NOT NULL,
	`amount`	    INT	NOT NULL,
	`created_at`	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`status`	    VARCHAR(250)	
);

CREATE TABLE `point_charge` (
	`charge_id`	                INT	NOT NULL PRIMARY KEY,
	`user_id`	                INT	NOT NULL,
	`point_charge_amount`	    INT	NOT NULL,
	`point_charge_imp_uid`	    VARCHAR(250) NOT NULL,
	`point_charge_order_number`	VARCHAR(250) NOT NULL,
	`point_charge_charged_at`	TIMESTAMP DEFAULT CURRENT_TIMESTAMP	NOT NULL,
	 FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE `wishlist` (
	`wishlist_id`	INT	NOT NULL PRIMARY KEY,
	`product_id`	INT	NOT NULL,
	`user_id`	    INT	NOT NULL,
     FOREIGN KEY (user_id) REFERENCES user(user_id),
     FOREIGN KEY (product_id) REFERENCES product(product_id)
);

commit;