var express = require("express");
var bodyParser = require("body-parser");

var server = express();

server.use(express.static(__dirname));
server.use(bodyParser.urlencoded({
    extended: true
}));
server.use(bodyParser.json());

server.get("/", function (request, response) {
    console.log('Start page requested');
});

server.get("/personGet", function (request, response) {
    var object = request.query;
    console.log(object.surname += '.validatedByGet');
    console.log(object.name += '.validatedByGet');
    console.log(object.age += '.validatedByGet');
    console.log(object.address += '.validatedByGet');
    response.send('You are using GET method :' + JSON.stringify(object));
});

server.post("/personPost", function (request, response) {
    var object = request.body;
    console.log(object.name += '.validatedByPOST');
    console.log(object.surname += '.validatedByPOST');
    console.log(object.age += '.validatedByPOST');
    console.log(object.address += '.validatedByPOST');
    response.send('You are using POST method : ' + JSON.stringify(object));
});

server.listen(3000);