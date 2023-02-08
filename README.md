# mathQuiz
Small Java web application using JSP to practice solving simple equations. 

![screenshot](docs/assets/images/runAsWebApp.png?raw=true)

## Purpose
I wrote this for one of my daughters so she could practice solving simple equations in one or two unknowns for Algebra. At the time I wrote it the only practice equations I could find for her were on paper or otherwise "static", which over time made them difficult to practice on without inadvertently memorizing at least some of the answers. There was also always the need to find new material, more equations. To solve those problems this program generates random variables for each equation so there is an endless supply of new ones to practice on.

## Requirements

To compile and run the web application you'll need:
* Java 5 or greater
* Maven 2 or greater 
* Tomcat 7 or greater

## Usage

For equations you can choose "Easy" (1 unknown) or "Hard" (2 unknowns). Regardless of how hard it is each right answer adds 1 to score, whereas each wrong answer subtracts 1 from score. There is no persistance of score or user session, so no requirement to log in.


 

