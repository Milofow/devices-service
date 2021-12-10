CREATE TABLE devices
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    name   VARCHAR(255)          NULL,
    status BIT(1)                NOT NULL,
    CONSTRAINT pk_devices PRIMARY KEY (id)
);

INSERT INTO devices (name, status) VALUES ("Lamp 1", false);
INSERT INTO devices (name, status) VALUES ("Lamp 2", false);
INSERT INTO devices (name, status) VALUES ("Lamp 3", true);