# mathQuiz
Small Java program to practice solving simple equations. There are two variations, a Java desktop application written in 1999 and a web application using JSP written shortly thereafter. The two variations are separate and not dependent on one another; they're both in the same repository only because they share history and functionality.

## Purpose
I wrote this for one of my daughters so she could practice solving simple equations in one or two unknowns for Algebra. At the time I wrote it the only practice equations I could find for her were on paper or otherwise "static", which over time made them difficult to practice on without inadvertently memorizing at least some of the answers. There was also always the need to find new material, more equations. To solve those problems this program generates random variables for each equation so there is an endless supply of new ones to practice on.

## Requirements

For the web application you'll need:
* Java 5 or greater
* Maven 2 or greater 
* Tomcat 7 or greater

For the desktop application:
* Java 5 SE (JDK 1.5) or later

## Usage

For either version you can choose "Easy" (1 unknown) or "Hard" (2 unknowns). Each right answer adds 1 to score, whereas each wrong answer subtracts 1 from score. There is no persistance of score or user session, so no requirement to log in.
 

