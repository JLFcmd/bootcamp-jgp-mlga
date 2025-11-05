# Tabla ya hecha 

| Id | Make/Model          | # Wheels | # Doors | Type        |
|----|---------------------|-----------|----------|-------------|
| 1  | Ford Focus          | 4         | 4        | Sedan       |
| 2  | Tesla Roadster      | 4         | 2        | Sports      |
| 3  | Kawakasi Ninja      | 2         | 0        | Motorcycle  |
| 4  | McLaren Formula 1   | 4         | 0        | Race        |
| 5  | Tesla S             | 4         | 4        | Sedan       |



# Solucion a ejercicio 1:

SELECT title FROM movies;
SELECT director FROM movies;

SELECT title, director FROM movies;

SELECT title, year FROM movies;
SELECT * FROM movies;

# Solucion a ejercicio 2:


SELECT * FROM movies
WHERE id = 6;


SELECT * FROM movies
WHERE year BETWEEN 2000 AND 2010
ORDER BY year ASC;


SELECT * FROM movies
WHERE year NOT BETWEEN 2000 AND 2010
ORDER BY year ASC;


SELECT title, year
FROM movies
ORDER BY year ASC
LIMIT 5;

# Solucion a ejercicio 3:


SELECT * FROM movies
WHERE title LIKE 'Toy Story%';


SELECT * FROM movies
WHERE director = 'John Lasseter';


SELECT title, director
FROM movies
WHERE director <> 'John Lasseter';


SELECT * FROM movies
WHERE title LIKE 'WALL-%';


# Solucion a ejercicio 4:


SELECT DISTINCT director
FROM movies
ORDER BY director ASC;


SELECT *
FROM movies
ORDER BY year DESC
LIMIT 4;

SELECT *
FROM movies
ORDER BY title ASC
LIMIT 5;


SELECT *
FROM movies
ORDER BY title ASC
LIMIT 5 OFFSET 5;


