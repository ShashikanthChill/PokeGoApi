<%-- 
    Document   : adminpage
    Created on : Apr 30, 2019, 12:57:01 AM
    Author     : The_Humble_Fool
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/styles.css">
        <style>
            .go:hover {
                transform: scale(1.5); /* (120% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-light bg-light">
            <div class="mx-auto order-0">
                <a class="navbar-brand mx-auto" href="#">PokeGoApi Admin</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/">API Docs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout <span class="badge badge-pill badge-secondary">${pageContext.request.remoteUser}</span></a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container" style="margin-top: 75px">
            <div class="row justify-content-between">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="/images/Egg-edited.png" alt="Card image cap">
                    <div class="card-body">
                        <center>
                            <h5 class="card-title">Egg Pool Info</h5>
                            <p>Add/Delete/Update Egg pool data.</p>
                            <a href="eggpoollist" class="btn btn-primary go">Go</a>
                        </center>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <br>
                    <img class="card-img-top" src="/images/raid-att.png" alt="Card image cap">
                    <div class="card-body">
                        <center>
                            <h5 class="card-title">Raid Boss Info</h5>
                            <p>Add/Delete/Update Raid boss data.</p>
                            <a href="raidbosslist" class="btn btn-primary go">Go</a>
                        </center>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="/images/binoculars.svg" alt="Card image cap" height="260" width="260">
                    <div class="card-body">
                        <center>
                            <h5 class="card-title">Research Encounters Info</h5>
                            <p>Add/Delete/Update Field Research data.</p>
                            <a href="encounterslist" class="btn btn-primary go">Go</a>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
