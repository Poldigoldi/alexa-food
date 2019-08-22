# food Diary App for Amazon Alexa

This application provides the back end code for a Food Diary Alexa skill. 

INSTRUCTIONS TO RUN LOCALLY on MAC:


1. Download NGROK
        Sign up and download NGROK from here: 
        https://ngrok.com
        
2. Prepare Database: 
        Download and install MariaDB following these instructions: 
        https://mariadb.com/kb/en/library/installing-mariadb-on-macos-using-homebrew/
        
        Log into mysql through the terminal command "mysql -u root"
        
        Create user 'student' by running these mySQL commands: 
        
        CREATE USER 'student'@'localhost';
        CREATE DATABASE foodDiary;
        GRANT ALL ON foodDiary.* TO 'student'@'localhost';
        FLUSH PRIVILEGES;     
        
        Log out and back in through "mysql -u student" from the directory containing the 'create.sql' file.
        Type "USE foodDiary;"
        execute "\. create.sql"
        
        This should create the tables in the foodDiary database.
        
3. Start Tomcat server
        execute ./apache-tomcat-8.5.42/bin/startup.sh
        
4. Start NGROK
        execute the ngrok executable using this command ./ngrok http 8080
        Copy the 'forwarding' https URL.

5. Set Skill Endpoint
        In the Alexa Developer Console go to the foodDiary skill and set the endpoint to:
        https://NGROK_URL/helloworldservlet/main
        replace NGROK_URL with the one copied from the previous step. 

SETUP Complete


TESTING:

There are two ways of testing the skill. 

1. Developer Console
        Go the 'Test' tab in the Alexa Developer console and invoke the skill by saying "open food diary"
        
2. Alexa Device
        The skill is now available on any Alexa Device that is registered under the same developer account
        and can be invoked by saying "Alexa, open food diary".
        

Tip: The most reliable way of logging any food items is by saying "Log food", "Log drink" or "Log Meal".
     The skill will then talk you through populating the slot values. 
     
     
To visualise the database use basic mySQL commands to view the table contents such as: 
SELECT * FROM Foods;
SELECT * FROM Drinks;
SELECT * FROM Users;
SELECT * FROM IntakeEvents;



For a full analysis of the skill please see the "Computer Science Thesis" document



More info can be found in the notebook here: 
https://uob-my.sharepoint.com/:o:/r/personal/so18266_bristol_ac_uk/Documents/Project?d=w4475124d961048cbb726a0f7e11b59c4&csf=1&e=fBywjr


