# GymApp

![Java CI with Maven](https://github.com/seredenkodenis/GymApp/workflows/Java%20CI%20with%20Maven/badge.svg)

GymApp is a project that implements a simple communication of clients with the management of the gym. We can help small gyms to start their own coll website and use payment system!
The main objective of this project is to:
- Enable clients to control their training progress
- Buy online subscriptions
- Have 24/7 contact with the administration
- notify of the end of the subscription


# New Features!

  - Add photo to your profile
  - Admin can write blogs


You can also:
  - contact the administration
  - control your weight with our diary
  - set up a training schedule
  - pay for an online membership


This is only a small part of what we have done, we plan to further develop the project and add new features!

### Tech

GymApp uses a number of open source projects to work properly:

* [Ace Editor] - awesome web-based text editor
* [markdown-it] - Markdown parser done right. Fast and easy to extend.
* [Twitter Bootstrap] - great UI boilerplate for modern web apps
* [jQuery] - duh


### Installation

GymApp requires [Java](https://www.java.com/ru/) v8+ to run and MAVEN.

Install the dependencies and devDependencies and start the server.

```sh
$ cd gym
$ mvn spring-boot:run
```

For production environments...

```sh
$ mvn clean package spring-boot:repackage
$ java -jar target/gym-0.0.1-SNAPSHOT-spring-boot.jar
```


### Todos

 - Write tests
 - Add deleteUser in admin panel
 - page with extras

License
----

MIT




[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
