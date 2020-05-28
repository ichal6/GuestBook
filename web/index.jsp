<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 5/27/20
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Guestbook</title>
    <meta charset="UTF-8">
  </head>
  <body>
    <h1>Guestbook:</h1>
    <div class="sign-block">
      <div class="sign">
        <p class="message">
          This is the first stupid message in this page! Hurra!
        </p>
        <p class="name">
          Mr. Bond
        </p>
        <p class="date">
          28-05-2020
        </p>
      </div>
    </div>
    <form>
      <label>Message:</label>
      <textarea id="new-message-content">

      </textarea>
      <label>Name:</label>
      <input type="text">
      <button id="submit-btn">Submit</button>
    </form>
  </body>
</html>
