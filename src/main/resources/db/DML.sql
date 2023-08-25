-- Category data initial
INSERT INTO category(name) VALUES('Level 1');
INSERT INTO category(name) VALUES('Level 2');
INSERT INTO category(name) VALUES('Level 3');

-- Contact data initial
INSERT INTO contact(name, relationship_value, address, email, phone)
VALUES('Ariel', 1, 'CBD, Auckland, NZ', 'ariel@gmail.com', '021 4567 8901');

INSERT INTO contact(name, relationship_value, address, email, phone)
VALUES('Bruce', 2, 'North Shore, Auckland, NZ', 'bruce@gmail.com', '022 4567 8902');

INSERT INTO contact(name, relationship_value, address, email, phone)
VALUES('Cindy', 3, 'Central, Auckland, NZ', 'cindy@gmail.com', '023 4567 8903');

INSERT INTO contact(name, relationship_value, address, email, phone)
VALUES('David', 4, 'East, Auckland, NZ', 'david@gmail.com', '024 4567 8904');

INSERT INTO contact(name, relationship_value, address, email, phone)
VALUES('Ethan', 5, 'West, Auckland, NZ', 'ethan@gmail.com', '025 4567 8905');

-- Student data initial
INSERT INTO student(name, student_number, birth_date, gender_value, starting_date, leaving_date, address)
VALUES('Bruce', '007', '1982-09-22', 2, NOW(), NULL, 'North Shore, Auckland, NZ');
