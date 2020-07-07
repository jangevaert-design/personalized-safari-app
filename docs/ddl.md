## Data Definition Language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `Accommodation`
(
    `accommodation_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Accommodation_name` ON `Accommodation` (`name`);

CREATE TABLE IF NOT EXISTS `General`
(
    `general_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
/*    `name`      TEXT                              NOT NULL COLLATE NOCASE */
);

/* CREATE UNIQUE INDEX IF NOT EXISTS `index_General` ON `General` (`name`); */ 

CREATE TABLE IF NOT EXISTS `Itinerary`
(
    `itinerary_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `park_name`      TEXT                              NOT NULL COLLATE NOCASE
);


CREATE TABLE IF NOT EXISTS `Poi`
(
    `poi_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `itinerary_id` INTEGER,
    `text`      TEXT                              NOT NULL COLLATE NOCASE,
    FOREIGN KEY (`itinerary_id`) REFERENCES `Itinerary` (`itinerary_id`) ON UPDATE NO ACTION ON DELETE SET NULL
);

CREATE INDEX IF NOT EXISTS `index_Poi_itinerary_id` ON `Poi` (`itinerary_id`);
```

[`ddl.sql`](sql/ddl.sql)








