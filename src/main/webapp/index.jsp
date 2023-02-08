<%@ page session="true" import="java.util.*" %>  

<jsp:useBean id="mathBean" scope="session" class="beans.MathBean" >
<% mathBean.init(); %>
</jsp:useBean>

<% 
int score = mathBean.getScore();
String question = mathBean.getQuestion();
String status = mathBean.getStatus();
int difficulty = mathBean.getDifficulty();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Math Practice</title>
</head>
<body>
<form method="get" action="controller.jsp" name="">
<table border=1>
<tr>
<td align="center" bgcolor="yellow">Solve for x</td>
<td bgcolor="yellow" align="right">Score:</td>
<td align="center"><%=score%></td>
</tr>
<tr>
<td colspan=3 align="center" bgcolor="cyan"><%=question%></td>
</tr>
<tr>
<td colspan=2 bgcolor="orange">Type in your answer here:</td>
<td><input name=answer size=3></td>
</tr>
<tr>
<td colspan=3><%=status%></td>
</tr>
</table>
</form>

<form method="get" action="controller.jsp" name="radios">
<table>
<tr><td><input type="radio" value="0" name="difficulty" onClick="submit()">Easy</td></tr>
<tr><td><input type="radio" value="1" name="difficulty" onClick="submit()">Hard</td></tr>
<tr><td><input type="radio" value="2" name="difficulty" onClick="submit()">Mixed</td></tr>
</table>
</form>

<script>
document.forms[1].difficulty[<%=difficulty%>].checked="true";
document.forms[0].answer.focus();
</script>

</body>
</html>
