#Setting the working directory to my local system
setwd("G:/Semester IV/SmartPhones/Smartphones-Based-Web-Development-Project/DataSet")
# INSTALL THE PACKAGE FIRST TIME
#install.packages("sqldf")
library("sqldf")
#Identified the fastest way to read the file
#Fread is a function in data.table package which can be used to read a file
# very fast.
## CAN ALSO USE read.csv and read.table in case you want it

## JUST NEED TO INSTALL IT THE FIRST TIME
#install.packages("data.table")
#install.packages("plr")
library(data.table)
library(plyr)
library(dplyr)