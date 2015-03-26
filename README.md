# NotifyHawaii

Overview
--------
The goal of this application is to keep the user informed of specific events so that he can make better, more efficient use of his time.

Approach
--------
Registered users will be able to select from a predetermined set of services. Each service will allow for notifications to be sent to the user via email or text message when specific events are triggered (such as a new blog entry or a specific bus running ahead of/behind schedule). The triggering events will be monitored through the use of a variety of services including Google Maps, TheBus Web Services API, and Jaunt Web Scraping and Automation tool.

This application will be built using HTML, CSS, Twitter Bootstrap and the Play Web Application Framework. The backend database will be implemented using PostgreSQL and the entire application will be deployed to Heroku. 

Deliverable 1
-------------
Decide on wording and images to be used on the home page and in the description of services on each Service page.
Bare-bones in-memory database initialized with valid information so notification system can be tested.
Functional automated sending of email and text messages.
Functional 'News Services' component: Harvesting of news headlines through the use of the Jaunt Web-Scraper API.

Deliverable 2
-------------
Persistent data storage with PostgreSQL backend database.
Functional 'Commute Services' component: Estimating commute time given a specified route using Google Maps and monitoring specific bus schedules using TheBus Web Services API will be implemented.

Deliverable 3
-------------
Functional 'Blog & Posts Services' component: Able to identify and report new posts on Wordpress, Craigslist.
Implement Authentication and Authorization.
Deploy application to Heroku.

Mockup
------
The application homepage will introduce the user to the application and summarize the service. Users must log in or sign up for an account.
![alt tag](https://raw.githubusercontent.com/RobNamahoe/NotifyHawaii/master/mockup/readme/home.png)
After the user logs in, they are taken to the Services page where we present services by category.
![alt tag](https://raw.githubusercontent.com/RobNamahoe/NotifyHawaii/master/mockup/readme/Services.png)
Users can choose to receive daily notifications about their favorite news paper...
![alt tag](https://raw.githubusercontent.com/RobNamahoe/NotifyHawaii/master/mockup/readme/news.png)
their commute home...
![alt tag](https://raw.githubusercontent.com/RobNamahoe/NotifyHawaii/master/mockup/readme/maps.png)
or their favorite blogs.
![alt tag](https://raw.githubusercontent.com/RobNamahoe/NotifyHawaii/master/mockup/readme/blogs.png)
Users can edit their contact information and modify and/or delete their current subscriptions from their account page.
![alt tag](https://raw.githubusercontent.com/RobNamahoe/NotifyHawaii/master/mockup/readme/account.png)
