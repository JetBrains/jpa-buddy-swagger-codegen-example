CREATE TABLE pet
(
    id      BIGINT NOT NULL,
    user_id BIGINT,
    name    VARCHAR(255),
    CONSTRAINT pk_pet PRIMARY KEY (id)
);

CREATE TABLE "user"
(
    id          BIGINT NOT NULL,
    username    VARCHAR(255),
    first_name  VARCHAR(255),
    last_name   VARCHAR(255),
    email       VARCHAR(255),
    password    VARCHAR(255),
    phone       VARCHAR(255),
    user_status INTEGER,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE visit
(
    id                BIGINT NOT NULL,
    date              TIMESTAMP with time zone,
    veterinarian_name VARCHAR(255),
    clinic_name       VARCHAR(255),
    pet_id            BIGINT,
    CONSTRAINT pk_visit PRIMARY KEY (id)
);

ALTER TABLE pet
    ADD CONSTRAINT FK_PET_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (id);

ALTER TABLE visit
    ADD CONSTRAINT FK_VISIT_ON_PET FOREIGN KEY (pet_id) REFERENCES pet (id);
