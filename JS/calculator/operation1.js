let input1 = document.getElementById('number1');
let input2 = document.getElementById('number2');

function plus() {

    let number1 = Number(input1.value);
    let number2 = Number(input2.value);
    let result = number1 + number2;

    let calculatePlus = {
        number1: number1,
        operationCode: "+",
        number2: number2,
        result: result
    };
    document.getElementById("out").innerHTML = result;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/calculatePost");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(calculatePlus));
}

function minus() {

    let number1 = Number(input1.value);
    let number2 = Number(input2.value);
    let result = number1 - number2;

    let calculateMinus = {
        number1: number1,
        operationCode: "-",
        number2: number2,
        result: result
    };
    document.getElementById("out").innerHTML = result;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/calculatePost");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(calculateMinus));
}

function multiplies() {

    let number1 = Number(input1.value);
    let number2 = Number(input2.value);
    let result = number1 * number2;

    let calculateMultiply = {
        number1: number1,
        operationCode: "*",
        number2: number2,
        result: result
    };

    document.getElementById("out").innerHTML = result;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/calculatePost");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(calculateMultiply));
}

function divides() {

    let number1 = Number(input1.value);
    let number2 = Number(input2.value);
    let result = number1 + number2;

    let calculateDivide = {
        number1: number1,
        operationCode: "/",
        number2: number2,
        result: result
    };

    document.getElementById("out").innerHTML = result;

    try {
        calculateDivide.number1 / calculateDivide.number2;
        if (calculateDivide.number2 === 0) throw "Cannot be divided by 0"
    } catch (e) {
        alert(e)
    }

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/calculatePost");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(calculateDivide));
}