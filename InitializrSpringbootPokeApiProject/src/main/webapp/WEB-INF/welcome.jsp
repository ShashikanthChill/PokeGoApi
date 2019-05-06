<%-- 
    Document   : welcome
    Created on : Apr 20, 2019, 4:40:22 PM
    Author     : The_Humble_Fool
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>PokéGo API</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <style>
            #raidbossTextarea {
                width: 100%;
                min-height: 21rem;
                font-family: "Lucida Console", Monaco, monospace;
                font-size: 0.8rem;
                line-height: 1.2;
            }

            #eggpoolTextarea {
                width: 100%;
                min-height: 9rem;
                font-family: "Lucida Console", Monaco, monospace;
                font-size: 0.8rem;
                line-height: 1.2;
            }

            #breakthroughTextarea {
                width: 100%;
                min-height: 9rem;
                font-family: "Lucida Console", Monaco, monospace;
                font-size: 0.8rem;
                line-height: 1.2;
            }

            #typeweatherTextarea {
                width: 100%;
                min-height: 6rem;
                font-family: "Lucida Console", Monaco, monospace;
                font-size: 0.8rem;
                line-height: 1.2;
            }

            #typeweatherSortedTextarea {
                width: 100%;
                min-height: 10rem;
                font-family: "Lucida Console", Monaco, monospace;
                font-size: 0.8rem;
                line-height: 1.2;
            }

            #typeeffectivenessTextarea {
                width: 100%;
                min-height: 25rem;
                font-family: "Lucida Console", Monaco, monospace;
                font-size: 0.8rem;
                line-height: 1.2;
            }
        </style>
    </head>

    <body class="bg-light">
        <!-- Navigation -->
        <nav class="navbar navbar-expand-md navbar-dark bg-danger static-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="https://fontmeme.com/permalink/190506/00b91748a537d9b0d99638efde289e03.png" alt="logo" border="0">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="admin/">Admin Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About Me</a>
                        </li>
                        <li class="nav-item">
                            <a data-toggle="collapse" href="#contact-div" role="button" aria-expanded="false" aria-controls="collapseExample" class="nav-link">Contact Us</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="collapse" id="contact-div">
            <div class="card card-body">
                Contact us at: <a href="mailto:chillappagarishashikanth@gmail.com">chillappagarishashikanth@gmail.com</a>
            </div>
        </div>

        <!-- jumbotron -->
        <div class="jumbotron jumbotron-fluid bg-dark text-light">
            <div class="container" style="margin-bottom: 25px">
                <center>
                    <h1><b>PokéGo API</b></h1>
                    <h2>The RESTful Pokémon GO In-game events info API</h2>
                </center>
            </div>
            <div class="container text-light" style="border-radius: 5px;border: 1px solid white;">
                <center>
                    <h5>Provides In-game events info like current raid bosses, egg hatches, research breakthrough encounters, e.t.c.</h5>
                    <p>Check out the <a href="#docs" class="badge badge-info">docs</a> below!</p>
                </center>
            </div>
        </div>

        <div class=" container alert alert-primary" role="alert">
            This is a <b>consumption-only</b> API — only the HTTP GET method is available on resources.
        </div>
        <div class=" container alert alert-info" role="alert">
            No authentication is required to access this API, and all resources are fully open and available. If you are going to be regularly using the API, we recommend caching data on your service when ever possible.
        </div>
        <div class=" container alert alert-warning" role="alert">
            The data provided by the API is collected from various publicly available data sources. We do not create this data, vouch for its accuracy, or guarantee that it is the most recent data available from the data providers. Due to the nature of game, events
            data tends to change regularly. The API data will be updated in accordance with changes in game at the earliest possible in this regards. We request you to update your caches when ever possible with updated data.
        </div>

        <!-- documentation -->
        <div id="docs" class="container-fluid" style="padding: 50px">
            <h1 class="display-4">Documentation</h1>
            <p class="text-muted">All REST end points start with url:
                <span class="text-dark">pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com<b
                        class="text-info ">/public-api/..</b></span></p>

            <!-- raid boss row -->
            <div class="row " style="margin: 10px 0px 5px 0px ">
                <div class="col-xl-12 ">
                    <div class="card ">
                        <div class="card-body ">
                            <h5 class="card-title ">Raid Boss Info</h5>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/raids</span> = This rest end point will provide list of all currently available raid bosses data. It returns a Json array containing Json objects, each representing details
                                of a Raid boss.
                            </p>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/raids/filter?${param_name}=${value}</span> = This rest end point will provide filtered list of currently available Raid bosses data. Filtering is done based on tier level
                                of raids or raid boss's name or names starting with. It returns a Json array containing Json object(s), each representing details of a raid boss.
                            </p>
                            <p class="card-text">Currently available parameters:</p>
                            <div class="row">
                                <div class="col-2">
                                    <ul class="list-group">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <span class="badge"><u>param</u></span>
                                            <span class="badge"><u>type</u></span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <b>boss</b>
                                            <span class="badge badge-primary badge-pill">String</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <b>tier</b>
                                            <span class="badge badge-primary badge-pill">Integer</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <br>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#raidbossmodal">
                                Details
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="raidbossmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            Sample data:
                                            <textarea class="card-text" name="" id="raidbossTextarea" readonly=true></textarea>
                                            <p>URL to get all raid bosses list =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/raids" target="_blank">".../public-api/raids"</a>
                                            </p>
                                            <p>URL to get all tier 4 raid bosses list =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/raids/filter?tier=4" target="_blank">".../public-api/raids/filter?tier=4"</a>
                                            </p>
                                            <p>URL to get raid boss details of 'Dragonite' =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/raids/filter?boss=Dragonite" target="_blank">".../public-api/raids/filter?boss=Dragonite"</a>
                                            </p>
                                            <p>URL to get raid bosses list whose name starts with 'a | A' =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/raids/filter?boss=a" target="_blank">".../public-api/raids/filter?boss=a"</a>
                                            </p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- egg pool row -->
            <div class="row " style="margin: 10px 0px 5px 0px ">
                <div class="col-xl-12 ">
                    <div class="card ">
                        <div class="card-body ">
                            <h5 class="card-title ">Egg Pool Info</h5>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/eggs</span> = This rest end point will provide list of all currently available egg pool data. It returns a Json array containing Json objects, each representing details of
                                a pokemon available through eggs.
                            </p>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/raids/${egg_distance}</span> = This rest end point will provide filtered list of currently available egg pool data. Filtering is done based on specified egg distance. It returns
                                a Json array containing Json object(s), each representing details of pokemons available through eggs.
                            </p>
                            <p class="card-text">Currently available egg pools:</p>
                            <div class="row">
                                <div class="col-1">
                                    <ul class="list-group">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <span class="badge"><u>egg distance</u></span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <span class="badge badge-primary badge-pill">2km</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <span class="badge badge-primary badge-pill">5km</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <span class="badge badge-primary badge-pill">7km</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <span class="badge badge-primary badge-pill">10km</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <br>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#eggpoolmodal">
                                Details
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="eggpoolmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            Sample data:
                                            <textarea class="card-text" name="" id="eggpoolTextarea" readonly=true></textarea>
                                            <p>URL to get all egg pools list =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/eggs" target="_blank">".../public-api/eggs"</a>
                                            </p>
                                            <p>URL to get 5km egg pool list =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/eggs/5" target="_blank">".../public-api/eggs/5"</a>
                                            </p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- research breakthrough encounters row -->
            <div class="row " style="margin: 10px 0px 5px 0px ">
                <div class="col-xl-12 ">
                    <div class="card ">
                        <div class="card-body ">
                            <h5 class="card-title ">Research Breakthrough Encounters Info</h5>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/breakthroughs</span> = This rest end point will provide list of all currently available research breakthrough pokemon encounters data. It returns a Json array containing Json
                                objects, each representing details of pokemons available through research breakthrough.
                            </p>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/breakthroughs/filter?${param_name}=${value}</span> = This rest end point will provide filtered list of all currently available research breakthrough pokemon encounters data.
                                Filtering is done based on pokemon's name or names starting with. It returns a Json array containing Json object(s), each representing details of pokemons available through research breakthrough.
                            </p>
                            <p class="card-text">Currently available parameters:</p>
                            <div class="row">
                                <div class="col-2">
                                    <ul class="list-group">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <span class="badge"><u>param</u></span>
                                            <span class="badge"><u>type</u></span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <b>pokemon</b>
                                            <span class="badge badge-primary badge-pill">String</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <br>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#breakthroughmodal">
                                Details
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="breakthroughmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            Sample data:
                                            <textarea class="card-text" name="" id="breakthroughTextarea" readonly=true></textarea>
                                            <p>URL to get all research breakthrough encounters list =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/breakthroughs" target="_blank">".../public-api/breakthroughs"</a>
                                            </p>
                                            <p>URL to get reasearch breakthrough encounter pokemon details whose name is 'Lugia' =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/breakthroughs/filter?pokemon=Lugia" target="_blank">".../public-api/breakthroughs/filter?pokemon=Lugia"</a>
                                            </p>
                                            <p>URL to get reasearch breakthrough encounter pokemon details whose name starts with 'a | A' =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/breakthroughs/filter?pokemon=a" target="_blank">".../public-api/breakthroughs/filter?pokemon=a"</a>
                                            </p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- type weather row -->
            <div class="row " style="margin: 10px 0px 5px 0px ">
                <div class="col-xl-12 ">
                    <div class="card ">
                        <div class="card-body ">
                            <h5 class="card-title ">Type-Weather Info</h5>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/types</span> = This rest end point will provide list of all currently available Pokemon types and their related weather data. It returns a Json array containing Json objects,
                                each representing details of Pokemon type and it's related weather.
                            </p>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/breakthroughs/types/sorted</span> = This rest end point will provide sorted list of all currently available Pokemon types and their related weather data. Sorting is done based
                                on weathers. It returns a Json array containing Json objects, each representing details of weather and corresponding pokemon types.
                            </p>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#typeweathermodal">
                                Details
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="typeweathermodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            Sample data:
                                            <textarea class="card-text" name="" id="typeweatherTextarea" readonly=true></textarea>
                                            <br> Sample data(sorted):
                                            <textarea class="card-text" name="" id="typeweatherSortedTextarea" readonly=true></textarea>
                                            <p>URL to get all available pokemons types and related weather details =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/types" target="_blank">".../public-api/types"</a>
                                            </p>
                                            <p>URL to get all available pokemons types and related weather details, sorted =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/types/sorted" target="_blank">".../public-api/types/sorted"</a>
                                            </p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- type effectiveness row -->
            <div class="row " style="margin: 10px 0px 5px 0px ">
                <div class="col-xl-12 ">
                    <div class="card ">
                        <div class="card-body ">
                            <h5 class="card-title ">Type-Effectiveness Info</h5>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/effectiveness</span> = This rest end point will provide list of all currently available Pokemon types and their effectiveness against other types data. It returns a Json array
                                containing Json objects, each representing details of Pokemon type and it's effectivness against other available pokemon types.
                            </p>
                            <p class="card-text ">
                                <span class="badge badge-secondary ">.../public-api/breakthroughs/effectiveness/{type}</span> = This rest end point will provide list filtered list of specified available Pokemon type and it's effectiveness against other types
                                data. It returns a Json array containing Json object, representing details of Pokemon type and it's effectivness against other available pokemon types.
                            </p>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#typeeffectivenessmodal">
                                Details
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="typeeffectivenessmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            Sample data:
                                            <textarea class="card-text" name="" id="typeeffectivenessTextarea" readonly=true></textarea>
                                            <p>URL to get all available pokemons types and effectiveness details =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/effectiveness" target="_blank">".../public-api/effectiveness"</a>
                                            </p>
                                            <p>URL to get 'Fire' type and effectiveness details =
                                                <a href="http://pokegoapi-env-1.t3efypvt5f.ap-south-1.elasticbeanstalk.com/public-api/effectiveness/Fire" target="_blank">".../public-api/effectiveness/fire"</a>
                                            </p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- footr -->
            <div class="container-fluid bg-secondary text-light" style="margin-top: 25px;padding: 10px 0px 10px 0px">
                <center>
                    <h4>More features coming soon to the API.</h4>
                    <div style="padding: 5px 0px 5px 0px">Icons made by <a href="https://www.freepik.com/?__hstc=57440181.389910b901d5629bbb8f0d0601001bc3.1556610230612.1556704541009.1557174460573.5&__hssc=57440181.1.1557174460573&__hsfp=47333315" title="Freepik" class="badge badge-light">Freepik</a>                    from
                        <a href="https://www.flaticon.com/" title="Flaticon" class="badge badge-light">www.flaticon.com</a> is licensed by <a class="badge badge-light" href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
                    <div style="padding: 5px 0px 5px 0px">
                        Logo font made by <a href="//fontmeme.com/" class="badge badge-light" title="Font Meme">Font
                            Meme.</a>
                    </div>
                    <br>
                    <p style="padding: 5px 0px 5px 0px" class="text-light">
                        Pokémon and Pokémon character names are trademarks of Nintendo.
                    </p>
                </center>
            </div>

    </body>
    <footer>
        <script src="/js/apidocsscripts.js"></script>
    </footer>
</html>