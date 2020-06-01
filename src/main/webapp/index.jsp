<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 5/27/20
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="Controller.ServletGuestBook"%>
<%@ page import="Model.Sign" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Guestbook</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/guestbook.css">
  </head>
  <body>
    <h1>Guestbook:</h1>
    <div class="sign-block">
      <%
        int styleChange = 1;
        List<Sign> allSigns = ServletGuestBook.getAllSigns();
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
          <span class="date-content"><%= oneSign.getDate() %></span>
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
