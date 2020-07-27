## Data Definition Language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `Accommodation`
(
    `accommodation_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`             TEXT                              NOT NULL COLLATE NOCASE,
    `start`            INTEGER                           NOT NULL,
    `end`              INTEGER                           NOT NULL,
    `longitude`        REAL,
    `latitude`         REAL
);
CREATE TABLE IF NOT EXISTS `General`
(
    `general_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `country`     TEXT                              NOT NULL COLLATE NOCASE,
    `wildlife`    TEXT                              NOT NULL COLLATE NOCASE,
    `packingList` TEXT                              NOT NULL COLLATE NOCASE,
    `advice`      TEXT                              NOT NULL COLLATE NOCASE
)
CREATE TABLE IF NOT EXISTS `Itinerary`
(
    `itinerary_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `parkName`      TEXT COLLATE NOCASE,
    `numberOfMiles` INTEGER,
    `start`         INTEGER                           NOT NULL,
    `end`           INTEGER                           NOT NULL,
    `location`      TEXT                              NOT NULL COLLATE NOCASE
);
CREATE TABLE IF NOT EXISTS `Poi`
(
    `poi_id`       INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `itinerary_id` INTEGER,
    `name`         TEXT                              NOT NULL COLLATE NOCASE,
    `longitude`    REAL,
    `latitude`     REAL,
    FOREIGN KEY (`itinerary_id`) REFERENCES `Itinerary` (`itinerary_id`) ON UPDATE NO ACTION ON DELETE SET NULL
);
```

[`ddl.sql`](sql/ddl.sql)








