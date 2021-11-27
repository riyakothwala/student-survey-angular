# 642 HW3 Andrea Howes, Riya Modi, Cici Well

#Database Setup
First, install SQL Developer GUI using this link: https://www.oracle.com/tools/downloads/sqldev-downloads.html
Then, connect to GMU VPN and use the instructions located here: https://labs.vse.gmu.edu/index.php/Services/Oracle
to find your gmu oracle password and connect to your GMU oracle database.

Once connected, create a table named "students" in sqldeveloper,the DDL is below.
DDL for the students table is:  CREATE TABLE STUDENTS(
                                StudentId varchar(12),
                                UserName varchar(255),
                                Address varchar(255),
                                City varchar(25),
                                States varchar(25),
                                PRIMARY KEY (StudentId)
                                );
Note: Rightnow, I have just added the 5 columns but will add the remaining columns later.
now, you are all set with the database.

Second, In project's StudentDao file add your gmu oracle credentials in username and pwd variable to connect to the database make sure you are in the GMU VPN.

                              
