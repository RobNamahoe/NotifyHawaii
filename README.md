# NotifyHawaii

Overview
--------
The goal of this application is to keep the user informed of specific events so that he can make better, more efficient use of his or her time.

View the [deployed application](http://www.notifyhawaii.com/) on Heroku.<br>
View this projects [GitHub Page](http://robnamahoe.github.io/NotifyHawaii/).

Documentation
-------------
View the [User Guide](https://github.com/RobNamahoe/NotifyHawaii/wiki/User-Guide).<br>
View the [Developers Guide](https://github.com/RobNamahoe/NotifyHawaii/wiki/Developer-Guide).

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

Mobile First
------------
We strived to build this application from the ground up from a 'mobile first' approach. All of the pages use modern techniques to provide a responsive design so the application is just as powerful on a phone as it is on a desktop computer. Here's what the app looks like in mobile view:

Choose from a variety of services.

![alt tag](https://raw.githubusercontent.com/RobNamahoe/NotifyHawaii/master/doc/images/services-mobile.png)

Subscribe to a service.

![alt tag](https://github.com/RobNamahoe/NotifyHawaii/blob/master/doc/images/news-mobile.png)

Access your account and update your contact info or current subscriptions.

![alt tag](https://github.com/RobNamahoe/NotifyHawaii/blob/master/doc/images/account-mobile.png)

