--Create stock table

CREATE TABLE stock 
(   product_id NUMBER(10) NOT NULL,
    product_name VARCHAR(50) NOT NULL,
    product_brand VARCHAR(50) NOT NULL,
    product_quantity NUMBER NOT NULL,
    product_price_per_unit NUMBER NOT NULL,
    supplier_name VARCHAR(50) NOT NULL,
    CONSTRAINT stock_pk PRIMARY KEY(product_id)
);

DROP table stock;

CREATE SEQUENCE stock_sequence START WITH 1;

DROP SEQUENCE stock_sequence;

DROP TRIGGER stock_on_insert;

CREATE OR REPLACE TRIGGER stock_on_insert
    BEFORE INSERT ON stock
    FOR EACH ROW
BEGIN
    SELECT stock_sequence.nextval
    INTO :new.product_id
    FROM dual;
END;







SELECT * FROM users;
CREATE TABLE users(
user_id NUMBER(10) NOT NULL,
user_name VARCHAR(50) NOT NULL,
user_password VARCHAR(50) NOT NULL,
CONSTRAINT user_pk PRIMARY KEY(user_id)
);


CREATE SEQUENCE users_sequence;

CREATE OR REPLACE TRIGGER users_on_insert
    BEFORE INSERT ON users
    FOR EACH ROW
BEGIN
    SELECT users_sequence.nextval
    INTO :new.user_id
    FROM dual;
END;

DESCRIBE stock;

DROP TABLE stock;

INSERT INTO users( user_name, user_password) VALUES ('user', 'user123');
SELECT * FROM users WHERE user_name = 'admin';

select * from stock;

