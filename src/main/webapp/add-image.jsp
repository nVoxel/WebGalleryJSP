<%--
  Created by IntelliJ IDEA.
  User: nVoxel
  Date: 20.09.2022
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Images</title>
    <link href="/resource/bootstrap.min.css" rel="stylesheet">
    <link href="/resource/style-add-image.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="/resource/favicon.png">
</head>
<body>
<header>
    <h1>My Web Gallery</h1>
</header>

<form method="post" action="/images/add" enctype="application/x-www-form-urlencoded">
    <div class="form-group">
        <label for="imgurl">Enter Image URL to submit</label>
        <input type="url" class="form-control url-form" name="imageUrl" id="imgurl" placeholder="Image URL">
    </div>
    <div>
        <input class="btn btn-primary" type="submit" value="Submit">
    </div>
</form>

<footer>
    <h4>nVoxel, 2022</h4>
</footer>
</body>
</html>