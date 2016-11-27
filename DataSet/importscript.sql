SELECT count(*) FROM mealpaldb.restaurants;
SHOW VARIABLES LIKE "secure_file_priv";
truncate mealpaldb.restaurants;
LOAD DATA INFILE 'C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\Boston_Hotels.csv'  
INTO TABLE mealpaldb.restaurants 
FIELDS TERMINATED BY ','  
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
 IGNORE 1 LINES; 

