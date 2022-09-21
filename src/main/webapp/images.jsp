<%@ page import="java.util.List" %>
<%@ page import="com.voxeldev.webgalleryjsp.models.Image" %><%--
  Created by IntelliJ IDEA.
  User: nVoxel
  Date: 20.09.2022
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Web Gallery</title>
    <link href="/resource/style-images.css" rel="stylesheet">
    <link href="/resource/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="/resource/favicon.png">
</head>
<body class="outer">
<header>
    <h1>My Web Gallery</h1>
</header>

<br>

<div>
    <div class="gallery inner">
        <%
            List<Image> images = (List<Image>) request.getAttribute("images");
            for (Image image : images) {
        %>

        <img src="<%=image.getUrl()%>" alt="Just a random image"/>

        <%
            }
        %>
    </div>
</div>

<div class="buttons">
    <a href="images/add">
        <button class="btn btn-primary">Add Image</button>
    </a>
    <a href="images/delete" class="button-right">
        <button class="btn btn-danger">Delete Image</button>
    </a>
</div>

<br>

<footer>
    <h4>nVoxel, 2022</h4>
</footer>
</body>
</html>