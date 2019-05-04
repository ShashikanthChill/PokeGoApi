<%-- 
    Document   : welcome
    Created on : Apr 20, 2019, 4:40:22 PM
    Author     : The_Humble_Fool
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Research Encounters List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="/js/breakthroughencounterscripts.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/admin/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="raidbosslist">Raid Boss Page</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="eggpoollist">Egg Pool Page</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Research Tasks Page</a>
                    </li>
                </ul>
            </div>
            <div class="mx-auto order-0">
                <a class="navbar-brand mx-auto" href="#">Research Encounters Editor</a>
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
                        <a class="nav-link" href="/logout">Logout  <span class="badge badge-pill badge-light">${pageContext.request.remoteUser}</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container" style="margin-top: 75px;margin-bottom: 25px">
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#insertModal">+ New Encounter Entry</button>

            <!--insert modal-->
            <div class="modal fade" id="insertModal" role="dialog" tabindex="-1">
                <div class="modal-dialog" role="document">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <!--header-->
                        <div class="modal-header text-light bg-primary">
                            <h4 class="modal-title">Insert Encounter Info</h4>
                        </div>
                        <!--body-->
                        <div class="modal-body">
                            <form method="post" action="submitencounterinfo" onsubmit="return validateInsertForm()">
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Pokedex No:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="pokeDex" placeholder="Pokedex number" type="number" name="pokeDex">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Pokemon:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="pokemon" placeholder="Pokemon Name" type="text" name="pokemon">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Min CP:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="mincp" placeholder="Min CP" type="number" name="minCp">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Max CP:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="maxcp" placeholder="Max CP" type="number" name="maxCp">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Shiny Availability</label>
                                    <div class="col-sm-6">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="shinyavailable" name="shinyAvailable">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6">
                                        <button type="reset" class="btn btn-danger">Clear</button>
                                    </div>
                                    <div class="col-sm-6 ml auto">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

            <!--update modal-->
            <div class="modal fade" id="updateModal" role="dialog" tabindex="-1">
                <div class="modal-dialog" role="document">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <!--header-->
                        <div class="modal-header text-light bg-primary">
                            <center>
                                <h4 class="modal-title">Update Encounter Info</h4>
                            </center>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="updateencounterinfo" onsubmit="return validateUpdateForm()">
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Id:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="entry_id_u" placeholder="#" type="number" name="id" contenteditable="false">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Pokedex No:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="pokeDex_u" placeholder="Pokedex number" type="number" name="pokeDex">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Pokemon:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="pokemon_u" placeholder="Pokemon Name" type="text" name="pokemon">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Min CP:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="mincp_u" placeholder="Min CP" type="number" name="minCp">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Max CP:</label>
                                    <div class="col-sm-6">
                                        <input class="form-control" id="maxcp_u" placeholder="Max CP" type="number" name="maxCp">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Shiny Availability</label>
                                    <div class="col-sm-6">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="shinyavailable_u" name="shinyAvailable">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6">
                                        <button type="reset" class="btn btn-danger">Clear</button>
                                    </div>
                                    <div class="col-sm-6 ml auto">
                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="table-responsive">
                <table class="table table-sm table-bordered table-hover" id="table">
                    <thead class="thead-dark">
                        <tr align="center"  valign="middle">
                            <th>Id</th>
                            <th>Pokedex No.</th>
                            <th>Pokemon</th>
                            <th>Min Cp</th>
                            <th>Max Cp</th>
                            <th>Shiny Available</th>
                            <th>Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${entitymodels}" var="entitymodel">
                            <tr align="center" valign="middle">
                                <td class="table-primary">
                                    ${entitymodel.id}
                                </td>
                                <td class="table-info">
                                    ${entitymodel.pokeDex}
                                </td>
                                <td class="table-info">
                                    ${entitymodel.pokemon}
                                </td>
                                <td class="table-info">
                                    ${entitymodel.minCp}
                                </td>
                                <td class="table-info">
                                    ${entitymodel.maxCp}
                                </td>
                                <td class="table-info">
                                    ${entitymodel.shinyAvailable}
                                </td>
                                <td class="table-danger">
                                    <img id="btn_edit" src="/images/edit_24.png" alt="edit_btn" style="cursor: pointer" >
                                    |
                                    <img id="btn_del" src="/images/delete_24.png" alt="delete_btn" style="cursor: pointer">
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>

