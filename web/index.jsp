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
    <link rel="stylesheet" type="text/css" href="CSS/guestbook.css">
  </head>
  <body>
    <h1>Guestbook:</h1>
    <div class="sign-block">
      <div class="sign sign-even">
        <div class="message">
          This is the stupid content.
        </div>
        <div class="info">
          <span>Name: </span>
          <span class="name-content">
            Mr. Bond
          </span>
        </div>
        <div class="info">
          <span>Date: </span>
          <span class="date-content">
            28-05-2020
          </span>
        </div>
      </div>

      <div class="sign">
        <div class="message">
          HSomething stupid text.
        </div>
        <div class="info">
          <span>Name: </span>
          <span class="name-content">
            Mr. Łątka
          </span>
        </div>
        <div class="info">
          <span>Date: </span>
          <span class="date-content">
            31-05-2020
          </span>
        </div>
      </div>

      <div class="sign  sign-even">
        <div class="message">
          How how how!
        </div>
        <div class="info">
          <span>Name: </span>
          <span class="name-content">
            Mr. Smith
          </span>
        </div>
        <div class="info">
          <span>Date: </span>
          <span class="date-content">
            29-05-2020
          </span>
        </div>
      </div>
    </div>
    <form id="sign-to-guestbook">
      <label>Message:</label>
      <textarea id="provide-message">

      </textarea>
      <label>Name:</label>
      <input id="provide-name" type="text">
      <button id="submit-btn">Submit</button>
    </form>
  </body>
</html>
