CREATE TABLE delivery
(
    id         int          NOT NULL AUTO_INCREMENT,
    user_id int  NOT NULL,
    number_protocol  varchar(70)  NOT NULL,
    farmacy_origin_id  int          ,
    farmacy_destiny_id  int          ,
    status   varchar(100) NOT NULL,
    received_by   varchar(100) NOT NULL,
    date_delivered    date,
    CONSTRAINT delivery_pkey PRIMARY KEY (id),
    CONSTRAINT delivery_userid_fkey FOREIGN KEY (user_id) REFERENCES user_account(id),
    CONSTRAINT delivery_farmacyorigin_fkey FOREIGN KEY (farmacy_origin_id) REFERENCES farmacy(id),
    CONSTRAINT delivery_farmacydestiny_fkey FOREIGN KEY (farmacy_destiny_id) REFERENCES farmacy(id),

);

CREATE TABLE farmacy
(
    id int NOT NULL AUTO_INCREMENT,
    farmacyName varchar(100) NOT NULL,
    farmacyCityName varchar(50),
    description varchar(255),
    CONSTRAINT farmacy_pkey PRIMARY KEY (id)
);