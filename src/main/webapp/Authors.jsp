<%-- 
    Document   : Authors
    Created on : Sep 28, 2016, 4:38:16 PM
    Author     : Gladwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Author Table</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <link href="myCss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row">
            <div class ="container">
                <div class="panel panel-default" style="background-color:lightblue">
                    <div class="panel-heading" style="background-color:lightblue">All Authors</div>
                    <div class="panel-body">
                        <p>Displays a List of Author objects collected from a database.</p>
                    </div>
                    <form method="POST" action="AuthorController?=addEditDelete">
                        <table class="table table-hover" width="600" border="1" cellspacing="2" cellpadding="5">
                            <tr>
                                <th  class=" ">Author ID</th>
                                <th  class=" ">Name</th>
                                <th  class=" ">Date Added</th>
                            </tr>
                            <c:forEach var="a" items="${authors}">
                                <tr>
                                    <td class="info"><input type="checkbox" name="authorId" value="${a.authorId}" />&nbsp;<input type="image" class="glyphicon glyphicon-pencil" name="authorId" value="${a.authorId}"></td>
                                    <td class="info">${a.authorName}</td>
                                    <td class="info"><fmt:formatDate pattern="MM/dd/yyyy" value="${a.dateAdded}"></fmt:formatDate></td>
                                </tr>
                            </c:forEach>
                        </table>
                        &nbsp;<input type="submit" value="Add" name="submit" class="btn btn-success" />&nbsp;
                        <input type="submit" value="Edit" name="submit" class="btn btn-warning" />&nbsp;
                        <input type="submit" value="Delete" name="submit" class="btn btn-danger"/>
                    </form>

                    <center>
                        <form id="back" name="back" method="POST" action="Home.jsp" style="padding:10px;">
                            <input class="btn btn-info" type="submit" name="submit" value="Take me Home">
                        </form>
                    </center>
                </div>
            </div>
        </div>
        <div 
        <div class="row">
            <div class ="container">
                <div id="cont">
                    <div class="col-md-4" id="content">
                        <form id="delete" name="delete" method="POST" action="AuthorController">
                            <h3>Delete Author by ID</h3>
                            <p>This will return the rest of the records in the database.</p>
                            <input type="text" name="authorId" placeholder="Record ID to Deleted">
                            <input class="btn btn-info" type="submit" name="submit" value="Delete">
                        </form>
                    </div>
                    <div class="col-md-4 col-md-offset-4" id="content">
                        <form id="create" name="create" method="POST" action="AuthorController">
                            <h3>Create a new Author</h3>
                            <p>This will return all records in the database, including new record added.</p>
                            <input type="text" name="authorName" placeholder="Record Name">
                            <input class="btn btn-info" type="submit" name="submit" value="Create">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class ="container">
                <div id="cont">
                    <div class="col-md-4" id="content">
                        <form id="update" name="update" method="POST" action="AuthorController">
                            <h3>Update Author by ID</h3>
                            <p>This will return all records in Database - Including update.</p>
                            <input type="text" name="authorId" placeholder="Record ID">
                            <input type="text" name="authorName" placeholder="Name">
                            <br>
                            <br>
                            <input type="date" name="authorDate" placeholder="Date">
                            <br>
                            <br>
                            <input class="btn btn-info" type="submit" name="submit" value="Update">
                        </form>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <footer class="footer">
                    <div class="container">
                        Created by Priya
                    </div>
                </footer>
            </div>
           
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
    </body>
</html>
