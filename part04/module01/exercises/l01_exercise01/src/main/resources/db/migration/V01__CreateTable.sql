-- write sql to create member table
CREATE TABLE member (
	id INT auto_increment,
	name varchar(100) NULL,
	CONSTRAINT NewTable_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
