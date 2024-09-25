CREATE TABLE IF NOT EXISTS movies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    director VARCHAR(50) NOT NULL
);

INSERT INTO movies (id, name, minutes, genre, director) VALUES (1, 'Dark Knight', 152, 'ACTION', 'Christopher Nolan');
INSERT INTO movies (id, name, minutes, genre, director) VALUES (2, 'Memento', 113, 'THRILLER', 'Christopher Nolan');
INSERT INTO movies (id, name, minutes, genre, director) VALUES (3, 'Matrix', 136, 'ACTION', 'Lana Wachowski');
INSERT INTO movies (id, name, minutes, genre, director) VALUES (4, 'Super 8', 112, 'THRILLER', 'J.J. Abrams');
INSERT INTO movies (id, name, minutes, genre, director) VALUES (5, 'Inception', 148, 'ACTION', 'Christopher Nolan');