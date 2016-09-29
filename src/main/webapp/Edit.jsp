<%-- 
    Document   : Edit
    Created on : Sep 28, 2016, 4:42:34 PM
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
        <title>Web Book App</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
            
        <link href="myCss.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <h1 class="text-center">Author List</h1>
                <div class="row">
                    <div class ="container">
                        <div id="cont">
                            <div class="col-md-4 col-md-offset-4" id="content">
                                <form id="update" name="update" method="POST" action="AuthorController1">
                                    <h3>Update Author by ID</h3>
                                    <p>This will return all records in Database - Including update.</p>
                                    <input type="text" name="authorId" value="${author.authorId}" placeholder="Record ID" readonly/>
                                    <input type="text" name="authorName" placeholder="Name"/>
                                    <br>
                                    <br>
                                    <input type="date" name="authorDate" value="${author.dateAdded}" placeholder="Date" readonly/>
                                    <br>
                                    <br>
                                    <input class="btn btn-info" type="submit" name="submit" value="Update">
                                    <input class="btn btn-info" type="submit" name="submit" value="Back to List">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <center><h1 style="color:red"> ${error} </h1></center>
                 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </body>
</html>