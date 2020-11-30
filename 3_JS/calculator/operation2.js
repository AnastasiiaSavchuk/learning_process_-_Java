let operationButtons = document.getElementsByClassName('operation-button');

let input1 = document.getElementById('number1');
let input2 = document.getElementById('number2');

for (let i = 0; i < operationButtons.length; i++) {
    operationButtons[i].addEventListener('click', onOperationButtonClick);
}

function onOperationButtonClick(eventObject) {
    let clickedElement = eventObject.currentTarget;
    let operation = clickedElement.innerHTML;
    makeOperation(operation);
}

function makeOperation(operationCode) {
    let number1 = Number(input1.value);
    let number2 = Number(input2.value);
    let result;

    if (operationCode === '+') {
        result = number1 + number2;
    } else if (operationCode === '-') {
        result = number1 - number2;
    } else if (operationCode === '*') {
        result = number1 * number2;
    } else if (operationCode === '/') {
        result = number1 / number2;
    }
    document.getElementById("result-number").innerHTML = result;

    let calculate = {
        number1: number1,
        operationCode: operationCode,
        number2: number2,
        result: result
    };

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/calculatePost");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(calculate));
}