<jsp:useBean id="mathBean" scope="session" class="beans.MathBean" />

<%
/* Note: manually doing these parameters rather than using the jsp:setProperty
action because setProperty does not fire on an empty string (and I need to know
if user typed in space or nothing rather than a nuber) and also because the 
setProperty method will not work if user puts in a letter or something other than
the same type as the property, whereas in the conversion from String to that
property I can catch conversion exceptions and notify the user. 
Also, could use the setProperty="*" for difficulty since that is not free form 
input by user, however then we'd be doing two sets of the answer (one in the
setProperty), which is not very efficient, on top of the inefficiency of the
introspection setProperty requires already. 
In sum, doing it manually is more efficient (in terms of processing) & safer.*/

//input 
String difficulty = request.getParameter("difficulty");
String answer = request.getParameter("answer");

//process
if (difficulty != null) mathBean.setDifficulty(difficulty);
if (answer != null) mathBean.setAnswer(answer);

response.sendRedirect("index.jsp");
%>
