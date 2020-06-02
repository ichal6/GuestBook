<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="Model.Sign" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.ServiceSign" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Guestbook</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/guestbook.css">
    <script type="text/javascript" src="JS/dark-mode.js"></script>
  </head>
  <body>
    <h1>Guestbook:</h1>
    <button id="switch-dark-mode" onclick="switchDarkMode()">Toggle dark mode</button>
    <div class="sign-block">
      <%
        int styleChange = 1;
        List<Sign> allSigns = ServiceSign.getAllSigns();
        if(allSigns.size() == 0){
            %>
      <p>The book is empty</p>
      <%
        }
        for(Sign oneSign :allSigns){
            if(styleChange % 2 == 1){
      %>
      <div class="sign sign-even">
        <%
          }else{
        %>
      <div class="sign">
        <%
          }
        %>
        <div class="message"><%= oneSign.getMessage() %></div>
        <div class="info">
          <span>Name: </span>
          <span class="name-content"><%= oneSign.getName() %></span>
        </div>
        <div class="info">
          <span>Date: </span>
          <span class="date-content"><%= oneSign.getDate() %> <%=oneSign.getTime()%></span>
        </div>
      </div>
      <%
        styleChange++;
        }
      %>

    </div>
    <form id="sign-to-guestbook" action="Servlet" method="POST">
      <label>Message:</label>
      <textarea name="provide-message"></textarea>
      <label>Name:</label>
      <input name="provide-name" type="text">
      <button id="submit-btn">Submit</button>
    </form>

  </body>
</html>
