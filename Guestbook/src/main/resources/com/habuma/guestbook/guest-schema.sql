CREATE TABLE Guest (
	id IDENTITY,
	NAME VARCHAR NOT NULL,
	email VARCHAR NOT NULL,
	dateOfVisit TIMESTAMP NOT NULL
);

INSERT INTO Guest (NAME, email, dateOfVisit) VALUES ('Craig', 'craig@habuma.com', CURRENT_TIMESTAMP());