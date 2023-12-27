CREATE SEQUENCE IF NOT EXISTS nomination_steps_id_sequence as integer START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS nomination_steps
(
    id            INT4 DEFAULT nextval('nomination_steps_id_sequence') PRIMARY KEY,
    code          INT4 UNIQUE                               NOT NULL,
    name_bn       VARCHAR(255)                              NOT NULL,
    name_en       VARCHAR(255)                              NOT NULL,
    is_active     boolean      DEFAULT TRUE                 NOT NULL,
    created_by                      VARCHAR(255)                                NOT NULL,
    updated_by                      VARCHAR(255)                                NOT NULL,
    created_at                      TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP(6)   NOT NULL,
    updated_at                      TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP(6)   NOT NULL

);