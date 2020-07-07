CREATE TABLE IF NOT EXISTS `General`
(
    `general_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Source_name` ON `Source` (`name`);

CREATE TABLE IF NOT EXISTS `Itinerary`
(
    `itinerary_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `poi_id` INTEGER,
    `text`      TEXT                              NOT NULL COLLATE NOCASE,
    FOREIGN KEY (`poi_id`) REFERENCES `Poi` (`poi_id`) ON UPDATE NO ACTION ON DELETE SET NULL
);

CREATE INDEX IF NOT EXISTS `index_Quote_source_id` ON `Quote` (`source_id`);

//[ddl.md](docs/sql/ddl.sql)