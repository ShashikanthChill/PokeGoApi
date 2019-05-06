/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var raidboss_sample_data = [{
        "Poke Index": 386,
        "Raid Boss": "Deoxys (Defense Forme)",
        "Type": [
            "Psychic",
        ],
        "Boosted Weather": [
            "Windy"
        ],
        "Generation": 3,
        "Tier": "EX",
        "Boss Cp": 33018,
        "Min Cp(Non-Boosted)": 1228,
        "Max Cp(Non-Boosted)": 1299,
        "Min Cp(Boosted)": 1535,
        "Max Cp(Boosted)": 1624,
        "Recommended Group Size": 6,
        "Catch Rate": 6.0,
        "Shiny Availability": false
    }]

var eggpool_sample_data = [{
        "Egg Distance": 2,
        "Pokemon": "Pichu",
        "Min Cp": 240,
        "Max Cp": 270,
        "Shiny Availability": true
    }]

var breakthrough_sample_data = [{
        "Pokemon": "Lugia",
        "Min Cp": 1521,
        "Max Cp": 1587,
        "Shiny Availability": true,
        "Poke Index": 249
    }]

var typeweather_sample_data = [{
        "Pokemon Type": "Water",
        "Boosted Weather": "Rain"
    }]

var typeweather_sample_data_sorted = [{
        "Weather": "Windy",
        "Boosted Types": [
            "Flying",
            "Psychic",
            "Dragon"
        ]
    }]

var typeeffectiveness_sample_data = [{
        "Type": "Electric",
        "Super Effective": [
            "Water",
            "Flying"
        ],
        "Nomal Effective": [
            "Normal",
            "Fire",
            "Ice",
            "Fighting",
            "Poison",
            "Psychic",
            "Bug",
            "Rock",
            "Ghost",
            "Dark",
            "Steel"
        ],
        "Not Very Effective": [
            "Electric",
            "Grass",
            "Dragon"
        ],
        "Zero Effective": [
            "Ground"
        ]
    }]

var textedRaidbossJson = JSON.stringify(raidboss_sample_data, undefined, 4);
var textedEggpoolJson = JSON.stringify(eggpool_sample_data, undefined, 4);
var textedBreakthroughJson = JSON.stringify(breakthrough_sample_data, undefined, 4);
var textedTypeweatherJson = JSON.stringify(typeweather_sample_data, undefined, 4);
var textedTypeweatherSortedJson = JSON.stringify(typeweather_sample_data_sorted, undefined, 4);
var textedTypeeffectivenessJson = JSON.stringify(typeeffectiveness_sample_data, undefined, 4);

console.log("setting text")
$('#raidbossTextarea').text(textedRaidbossJson);
$('#eggpoolTextarea').text(textedEggpoolJson);
$('#breakthroughTextarea').text(textedBreakthroughJson);
$('#typeweatherTextarea').text(textedTypeweatherJson);
$('#typeweatherSortedTextarea').text(textedTypeweatherSortedJson);
$('#typeeffectivenessTextarea').text(textedTypeeffectivenessJson);