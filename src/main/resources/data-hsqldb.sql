-- Bcrypt(admin) $2a$10$iphtk.Sqrovu.3sP15m5yeumJ./bNAzA100Ph1rfFltxb1v5UTmYK
INSERT INTO user (user_name, password, email) VALUES ('admin', '$2a$10$iphtk.Sqrovu.3sP15m5yeumJ./bNAzA100Ph1rfFltxb1v5UTmYK', 'admin@mail.com');
-- Bcrypt(user) $2a$10$zai14OCTfDP3UgSjr46X0eSK43wF0utyPvqbd0etcHj8bBEuBzQWa
INSERT INTO user (user_name, password, email) VALUES ('user', '$2a$10$zai14OCTfDP3UgSjr46X0eSK43wF0utyPvqbd0etcHj8bBEuBzQWa', 'user@mail.com');
INSERT INTO role (role_name) VALUES ('admin');
INSERT INTO role (role_name) VALUES ('USER');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
