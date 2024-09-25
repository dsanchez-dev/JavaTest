CREATE TABLE IF NOT EXISTS movies(
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL
    );

INSERT INTO movies (id, name, minutes, genre) VALUES (1, 'Dark Knight', 152, 'ACTION');
INSERT INTO movies (id, name, minutes, genre) VALUES (2, 'Memento', 113, 'THRILLER');
INSERT INTO movies (id, name, minutes, genre) VALUES (3, 'Matrix', 136, 'ACTION');
INSERT INTO movies (id, name, minutes, genre) VALUES (4, 'Super 8', 112, 'THRILLER');