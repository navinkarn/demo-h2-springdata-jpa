DROP TABLE IF EXISTS BOOK_TBL;

CREATE TABLE BOOK_TBL (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          name VARCHAR(250) NOT NULL,
                          publication VARCHAR(250) NOT NULL

);

INSERT INTO BOOK_TBL (name, publication) VALUES
('Clean Code', 'Pearson'),
('Modern Java Recipe', 'OREILLY'),
('Top Java', 'Pearson'),
('C Programming', 'OREILLY'),
('Object Oriented Programming', 'Pearson'),
('Data Structure', 'OREILLY'),
('Operating System', 'Pearson'),
('Computer Network', 'OREILLY'),
('DBMS', 'Pearson'),
('DBMS', 'OREILLY'),
('Algorithm', 'Pearson'),
('System Analysis', 'OREILLY'),
('Javascript', 'Pearson'),
('C#', 'OREILLY'),
('.net', 'Pearson'),
('CSS', 'OREILLY'),
('jsp', 'Pearson'),
('Artificial Intelligence', 'OREILLY'),
('Rest Services', 'Pearson'),
('System Design', 'OREILLY'),
('Spring Boot', 'Pearson'),
('Angular', 'OREILLY'),
('Machine Learning', 'Pearson'),
('Computer Architecture', 'OREILLY');
