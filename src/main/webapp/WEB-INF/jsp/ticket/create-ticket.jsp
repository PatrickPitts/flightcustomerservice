<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit a new Ticket</title>
</head>
<body>
<h2>Create a Ticket</h2>
<form method="post" action="/ticket/submit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="action" value="create">
    <label for="customerName">Your Name:</label><br/>
    <input type="text" name="customerName" id="customerName"/><br><br>
    <label for="subject">Subject:</label><br>
    <input type="text" name="subject" id="subject"/><br><br>
    <label for="body">Body:</label><br>
    <textarea name="body" id="body" rows="5" cols="30"></textarea><br><br>
    <label for="file1"><b>Attachments:</b></label><br>
    <input type="file" name="file1" id="file1"/><br><br>
    <input type="submit" value="Submit"/>
</form>
<a href="/ticket">Back to Main menu</a>
</body>
</html>
