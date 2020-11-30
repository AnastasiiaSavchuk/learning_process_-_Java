var express = require("express");
var bodyParser = require("body-parser");

var server = express();
var jsonParser = bodyParser.json();

server.use(express.static(__dirname));
server.use(jsonParser)

server.get("/start", function (request, response) {
    console.log("Start page requested.");
    response.send("<h1>Welcome to calculate!</h1>")
});

server.post("/calculatePost", function (request, response) {
    let object = request.body;
    console.log(object);
    response.send("You are using calculate : " + JSON.stringify(object))
});

server.listen(3000);