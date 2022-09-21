<%@ page import="java.util.List" %>
<%@ page import="com.voxeldev.webgalleryjsp.models.Image" %><%--
  Created by IntelliJ IDEA.
  User: nVoxel
  Date: 21.09.2022
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Image</title>
    <link href="/resource/bootstrap.min.css" rel="stylesheet">
    <link href="/resource/style-delete-image.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="/resource/favicon.png">
</head>
<body>
<%
    List<Image> images = (List<Image>) request.getAttribute("images");
    for (Image image : images) {
%>

<div class="gallery inner">
    <img src="<%=image.getUrl()%>" alt="Image should be here"/>
    <form method="post" action="/images/delete" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="imageUrl" value="<%=image.getUrl()%>">
        <input class="btn btn-primary" type="submit" value="Delete">
    </form>
</div>

<%
    }
%>
</body>
</html>