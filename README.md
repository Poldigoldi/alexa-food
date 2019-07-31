# food Diary App for Amazon Alexa

This project involves a web server running locally hosting
an alexa skill as a web service. The skill enables logging 
food data using an Alexa supported device. 

The server is a Tomcat Server using Servlets for Alexa support.

More info can be found in the notebook here: 

https://uob-my.sharepoint.com/:o:/r/personal/so18266_bristol_ac_uk/Documents/Project?d=w4475124d961048cbb726a0f7e11b59c4&csf=1&e=fBywjr

Current endpoint of Server is running can be found at:
https://4dbeff9c.ngrok.io/helloworldservlet/main

The database used to store the meal data is mySQL with a structure of:

4 Tables:

Users
- userID

IntakeEvents
- id
- loggedBy
- mealType
- loggedAt

Foods
- eventID
- description
- amount

Drinks
- eventID
- description
- amount

Important Links:
https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-a-web-service.html
https://alexa-skills-kit-sdk-for-java.readthedocs.io/en/latest/Servlet-Support.html
