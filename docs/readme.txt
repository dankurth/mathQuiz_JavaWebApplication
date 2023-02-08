
# to compile and run as web application
cd mathQuiz/web
mvn clean
mvn package
# move mathQuiz.war to Java enabled web server, e.g:
sudo cp target/mathQuiz.war /var/lib/tomcat9/webapps
# use browser to view on web server at <server>/mathQuiz

