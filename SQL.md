# SQL

---

### 1. Create a database

```sql
CREATE DATABASE database_name;
```

### 2. Delete a database

```sql
DROP DATABASE database_name;
```

### 3. Use a database + create a table

```sql
USE database_name;
CREATE TABLE table_name (
    column_name INT
)
```

### 4. Alter a table + add column

```sql
ALTER TABLE table_name
ADD another_column VARCHAR(255)
```

### 5. Alter a table + add column

```sql
ALTER TABLE table_name
ADD another_column VARCHAR(255)
```

### 6. Create a table with `NOT NULL` keyword

```sql
CREATE TABLE bands (
    name VARCHAR(255) NOT NULL
)
```

### 7. Create a table with `PRIMARY KEY` + `AUTO INCREMENT` keyword

```sql
CREATE TABLE bands (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)
```

### 8. Create a table with `PRIMARY KEY` + `FOREIGN KEY` keyword

```sql
CREATE TABLE bands (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)
CREATE TABLE albums (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    release_year INT,
    band_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (band_id) REFERENCES bands(id)
)
```

### 9. Insert a record to table

```sql
INSERT INTO bands (name)
VALUES ('Iron Man');

INSERT INTO bands (name)
VALUES ('Batman'), ('Spiderman'), ('Captain America');

INSERT INTO albums (name, release_year, band_id)
VALUES ('Album 1', 1985, 1),
       ('Album 2', 1984, 2),
       ('Album 3', 2018, 3),
```

### 10. Query

1. SELECT keyword

```sql
SELECT * FROM bands;
```

2. LIMIT keyword

```sql
SELECT * FROM bands
LIMIT 10;
```

3. AS keyword

```sql
SELECT id AS 'ID', name AS 'Band Name' FROM bands;
```

4. ORDER BY keyword

```sql
SELECT * FROM bands
ORDER BY name;

SELECT * FROM bands
ORDER BY name ASC;

SELECT * FROM bands
ORDER BY name DESC;
```

5. DISTINCT keyword

```sql
SELECT DISTINCT name FROM albums;
```

6. UPDATE keyword

```sql
UPDATE albums
SET release_year = 1982
WHERE id = 1;
```

7. Operator

```sql
SELECT * FROM albums;
WHERE release_year < 2000;

SELECT * FROM albums;
WHERE name LIKE '%er%' OR band_id = 2;

SELECT * FROM albums;
WHERE release_year = 1984 OR band_id = 1;

SELECT * FROM albums;
WHERE release_year BETWEEN 2000 AND 2018;

SELECT * FROM albums;
WHERE release_year IS NULL;
```

8. DELETE keyword

```sql
DELETE FROM albums WHERE id = 5;
```
