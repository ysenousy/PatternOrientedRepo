<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Content Input</title>
</head>
<body>
    <h1>Input Content</h1>
    <form action="ContentServlet" method="get">
        <label for="content">Content:</label>
        <br>
        <textarea name="content" id="content" rows="5" cols="50"></textarea>
        <br><br>
        <label for="contentType">Content Type:</label>
        <select name="contentType" id="contentType">
            <option value="article">Article</option>
            <option value="tutorial">Tutorial</option>
        </select>
        <br><br>
        <label for="format">Format:</label>
        <select name="format" id="format">
            <option value="html">HTML</option>
            <option value="json">JSON</option>
            <option value="xml">XML</option>
        </select>
        <br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>