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
        <title>RaidBoss List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="/js/raidbossscripts.js"/>
        <script>
        </script>
    </head>
    <body>

        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/admin/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="eggpoollist">Egg Pool Page</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="encounterslist">Research Encounters Page</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Research Tasks Page</a>
                    </li>
                </ul>
            </div>
            <div class="mx-auto order-0">
                <a class="navbar-brand mx-auto" href="#">Raid Boss Editor</a>
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
                        <a class="nav-link" href="/logout">Logout <span class="badge badge-pill badge-light">${pageContext.request.remoteUser}</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid" style="margin: 75px 50px 25px 50px">
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#insertModal">+ New Raid Boss Entry</button>

            <!--insert modal-->
            <div class="modal fade" id="insertModal" role="dialog" tabindex="-1">
                <div class="modal-dialog modal-lg" role="document" style="width: 700px">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <!--header-->
                        <div class="modal-header text-light bg-primary">
                            <h4 class="modal-title">Insert Raid Boss Info</h4>
                        </div>
                        <!--body-->
                        <div class="modal-body">
                            <form method="post" action="submitraidbossinfo" onsubmit="return validateInsertForm()">
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Tier:</label>
                                    <div class="col-sm-8">
                                        <select class="form-control custom-select" id="tier" name="tier">
                                            <option class="text-white bg-warning">
                                                Pick a Tier
                                            </option>
                                            <option value="1">
                                                1
                                            </option>
                                            <option value="2">
                                                2
                                            </option>
                                            <option value="3">
                                                3
                                            </option>
                                            <option value="4">
                                                4
                                            </option>
                                            <option value="5">
                                                5
                                            </option>
                                            <option value="6">
                                                EX
                                            </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Pokedex No:</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="pokeDex" placeholder="Pokedex number" type="number" name="pokeDex">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Gen:</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="gen" placeholder="Pokemon Gen" type="number" name="gen">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Raid Boss:</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="raidBoss" placeholder="Pokemon Name" type="text" name="raidBoss">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Raid Boss CP:</label>
                                    <div class="col-sm-8">
                                        <input class="form-control" id="raidBossCp" placeholder="Raid Boss CP" type="number" name="raidBossCp">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Pokemon Type1:</label>
                                    <div class="col-sm-4">
                                        <select class="form-control custom-select" id="type1" name="type1">
                                            <option class="text-white bg-warning">
                                                Pick a type
                                            </option>
                                            <option value="Normal">
                                                Normal
                                            </option>
                                            <option value="Fighting">
                                                Fighting
                                            </option>
                                            <option value="Flying">
                                                Flying
                                            </option>
                                            <option value="Poison">
                                                Poison
                                            </option>
                                            <option value="Ground">
                                                Ground
                                            </option>
                                            <option value="Rock">
                                                Rock
                                            </option>
                                            <option value="Bug">
                                                Bug
                                            </option>
                                            <option value="Ghost">
                                                Ghost
                                            </option>
                                            <option value="Steel">
                                                Steel
                                            </option>
                                            <option value="Fire">
                                                Fire
                                            </option>
                                            <option value="Water">
                                                Water
                                            </option>
                                            <option value="Grass">
                                                Grass
                                            </option>
                                            <option value="Electric">
                                                Electric
                                            </option>
                                            <option value="Psychic">
                                                Psychic
                                            </option>
                                            <option value="Ice">
                                                Ice
                                            </option>
                                            <option value="Dragon">
                                                Dragon
                                            </option>
                                            <option value="Fairy">
                                                Fairy
                                            </option>
                                            <option value="Dark">
                                                Dark
                                            </option>
                                        </select>
                                    </div>
                                    <label class="col-sm-2 col-form-label">Pokemon Type2:</label>
                                    <div class="col-sm-4">
                                        <select class="form-control custom-select" id="type2" name="type2">
                                            <option class="text-white bg-warning">
                                                Pick a type
                                            </option>
                                            <option value="Normal">
                                                Normal
                                            </option>
                                            <option value="Fighting">
                                                Fighting
                                            </option>
                                            <option value="Flying">
                                                Flying
                                            </option>
                                            <option value="Poison">
                                                Poison
                                            </option>
                                            <option value="Ground">
                                                Ground
                                            </option>
                                            <option value="Rock">
                                                Rock
                                            </option>
                                            <option value="Bug">
                                                Bug
                                            </option>
                                            <option value="Ghost">
                                                Ghost
                                            </option>
                                            <option value="Steel">
                                                Steel
                                            </option>
                                            <option value="Fire">
                                                Fire
                                            </option>
                                            <option value="Water">
                                                Water
                                            </option>
                                            <option value="Grass">
                                                Grass
                                            </option>
                                            <option value="Electric">
                                                Electric
                                            </option>
                                            <option value="Psychic">
                                                Psychic
                                            </option>
                                            <option value="Ice">
                                                Ice
                                            </option>
                                            <option value="Dragon">
                                                Dragon
                                            </option>
                                            <option value="Fairy">
                                                Fairy
                                            </option>
                                            <option value="Dark">
                                                Dark
                                            </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Min CP(Non-boosted):</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="minCpNonBoosted" placeholder="Min CP" type="number" name="minCpNonBoosted">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Max CP(Non-boosted):</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="maxCpNonBoosted" placeholder="Max CP" type="number" name="maxCpNonBoosted">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Min CP(boosted):</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="minCpBoosted" placeholder="Min CP" type="number" name="minCpBoosted">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Max CP(boosted):</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="maxCpBoosted" placeholder="Max CP" type="number" name="maxCpBoosted">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Recommended Group Size:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="groupSizeDifficulty" placeholder="Group Size" type="number" name="groupSizeDifficulty">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Catch Rate:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="catchRate" placeholder="Catch Rate" type="number" step="0.1" name="catchRate">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Shiny Availability</label>
                                    <div class="col-sm-4">
                                        <div class="form-check">
                                            <input class="form-check-input" id="shinyavailable" placeholder="Shiny Availability" type="checkbox" name="shinyAvailable">
                                        </div>
                                    </div>
                                    <!--</div>-->
                                    <!--<div class="form-group row">-->
                                    <div class="col-sm-3">
                                        <button type="reset" class="btn btn-danger">Clear</button>
                                    </div>
                                    <div class="col-sm-3 ml auto">
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
                <div class="modal-dialog modal-lg" role="document" style="width: 700px">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <!--header-->
                        <div class="modal-header text-light bg-primary">
                            <h4 class="modal-title">Update Raid Boss Info</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="updateraidbossinfo" onsubmit="return validateUpdateForm()">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Id:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="entry_id_u" placeholder="#" type="number" name="id" contenteditable="false">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Tier:</label>
                                    <div class="col-sm-4">
                                        <select class="form-control custom-select" id="tier_u" name="tier">
                                            <option class="text-white bg-warning">
                                                Pick a Tier
                                            </option>
                                            <option value="1">
                                                1
                                            </option>
                                            <option value="2">
                                                2
                                            </option>
                                            <option value="3">
                                                3
                                            </option>
                                            <option value="4">
                                                4
                                            </option>
                                            <option value="5">
                                                5
                                            </option>
                                            <option value="6">
                                                EX
                                            </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Pokedex No:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="pokeDex_u" placeholder="Pokedex number" type="number" name="pokeDex">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Gen:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="gen_u" placeholder="Pokemon Gen" type="number" name="gen">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Raid Boss:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="raidBoss_u" placeholder="Pokemon Name" type="text" name="raidBoss">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Raid Boss CP:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="raidBossCp_u" placeholder="Raid Boss CP" type="number" name="raidBossCp">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Pokemon Type1:</label>
                                    <div class="col-sm-4">
                                        <select class="form-control custom-select" id="type1_u" name="type1">
                                            <option class="text-white bg-warning">
                                                Pick a type
                                            </option>
                                            <option value="Normal">
                                                Normal
                                            </option>
                                            <option value="Fighting">
                                                Fighting
                                            </option>
                                            <option value="Flying">
                                                Flying
                                            </option>
                                            <option value="Poison">
                                                Poison
                                            </option>
                                            <option value="Ground">
                                                Ground
                                            </option>
                                            <option value="Rock">
                                                Rock
                                            </option>
                                            <option value="Bug">
                                                Bug
                                            </option>
                                            <option value="Ghost">
                                                Ghost
                                            </option>
                                            <option value="Steel">
                                                Steel
                                            </option>
                                            <option value="Fire">
                                                Fire
                                            </option>
                                            <option value="Water">
                                                Water
                                            </option>
                                            <option value="Grass">
                                                Grass
                                            </option>
                                            <option value="Electric">
                                                Electric
                                            </option>
                                            <option value="Psychic">
                                                Psychic
                                            </option>
                                            <option value="Ice">
                                                Ice
                                            </option>
                                            <option value="Dragon">
                                                Dragon
                                            </option>
                                            <option value="Fairy">
                                                Fairy
                                            </option>
                                            <option value="Dark">
                                                Dark
                                            </option>
                                        </select>
                                    </div>
                                    <label class="col-sm-2 col-form-label">Pokemon Type2:</label>
                                    <div class="col-sm-4">
                                        <select class="form-control custom-select" id="type2_u" name="type2">
                                            <option class="text-white bg-warning">
                                                Pick a type
                                            </option>
                                            <option value="Normal">
                                                Normal
                                            </option>
                                            <option value="Fighting">
                                                Fighting
                                            </option>
                                            <option value="Flying">
                                                Flying
                                            </option>
                                            <option value="Poison">
                                                Poison
                                            </option>
                                            <option value="Ground">
                                                Ground
                                            </option>
                                            <option value="Rock">
                                                Rock
                                            </option>
                                            <option value="Bug">
                                                Bug
                                            </option>
                                            <option value="Ghost">
                                                Ghost
                                            </option>
                                            <option value="Steel">
                                                Steel
                                            </option>
                                            <option value="Fire">
                                                Fire
                                            </option>
                                            <option value="Water">
                                                Water
                                            </option>
                                            <option value="Grass">
                                                Grass
                                            </option>
                                            <option value="Electric">
                                                Electric
                                            </option>
                                            <option value="Psychic">
                                                Psychic
                                            </option>
                                            <option value="Ice">
                                                Ice
                                            </option>
                                            <option value="Dragon">
                                                Dragon
                                            </option>
                                            <option value="Fairy">
                                                Fairy
                                            </option>
                                            <option value="Dark">
                                                Dark
                                            </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Min CP(Non-boosted):</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="minCpNonBoosted_u" placeholder="Min CP" type="number" name="minCpNonBoosted">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Max CP(Non-boosted):</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="maxCpNonBoosted_u" placeholder="Max CP" type="number" name="maxCpNonBoosted">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Min CP(boosted):</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="minCpBoosted_u" placeholder="Min CP" type="number" name="minCpBoosted">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Max CP(boosted):</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="maxCpBoosted_u" placeholder="Max CP" type="number" name="maxCpBoosted">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Recommended Group Size:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="groupSizeDifficulty_u" placeholder="Group Size" type="number" name="groupSizeDifficulty">
                                    </div>
                                    <label class="col-sm-2 col-form-label">Catch Rate:</label>
                                    <div class="col-sm-4">
                                        <input class="form-control" id="catchRate_u" placeholder="Catch Rate" type="number" step="0.1" name="catchRate">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Shiny Availability</label>
                                    <div class="col-sm-2">
                                        <div class="form-check">
                                            <input class="form-check-input" id="shinyavailable_u" placeholder="Shiny Availability" type="checkbox" name="shinyAvailable">
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="reset" class="btn btn-danger">Clear</button>
                                    </div>
                                    <div class="col-sm-4 ml auto">
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

        <div style="margin-left: 50px;margin-right: 50px">
            <div class="table-responsive">
                <table class="table table-sm table-bordered table-hover" id="table">
                    <thead class="thead-dark">
                        <tr align="center"  valign="middle">
                            <th>Id</th>
                            <th>Pokedex No.</th>
                            <th>RaidBoss</th>
                            <th>Type1</th>
                            <th>Type2</th>
                            <th>Tier</th>
                            <th>Gen</th>
                            <th>RaidBoss Cp</th>
                            <th>Min Cp(Non-Boosted)</th>
                            <th>Max Cp(Non-Boosted)</th>
                            <th>Min Cp(Boosted)</th>
                            <th>Max Cp(Boosted)</th>
                            <th>Group Size Difficulty</th>
                            <th>Catch Rate</th>
                            <th>Shiny Available</th>
                            <th>Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${entitymodels}" var="entitymodel">
                            <tr align="center"  valign="middle">
                                <td class="table-primary">
                                    ${entitymodel.id} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.pokeDex} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.raidBoss} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.type1} 
                                </td>
                                <c:choose>
                                    <c:when test="${entitymodel.type2 == null}">
                                        <td class="table-danger">
                                            ${entitymodel.type2}
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="table-info">
                                            ${entitymodel.type2} 
                                        </td>
                                    </c:otherwise>
                                </c:choose>
                                <td class="table-info">
                                    ${entitymodel.tier} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.gen} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.raidBossCp} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.minCpNonBoosted} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.maxCpNonBoosted} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.minCpBoosted} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.maxCpBoosted} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.groupSizeDifficulty} 
                                </td>
                                <td class="table-info">
                                    ${entitymodel.catchRate} 
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
    </body>
</html>

