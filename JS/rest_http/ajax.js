function sendByGet() {
    let person = {
        surname: document.getElementById('getSurname').value,
        name: document.getElementById('getName').value,
        age: document.getElementById('getAge').value,
        address: document.getElementById('getAddress').value
    };
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/personGet?surname=" + person.surname
        + "&name=" + person.name + "&age=" + person.age + "&address=" + person.address);
    xhr.setRequestHeader("Content-type","application/json");
    xhr.send();
}

getAge.onblur = function () {
    if ((this.value <0) ||(this.value>100)){
        getAge.classList.add("errors");
        getAge.focus();
        getAge.value = "Enter your age from 0 to 100."
    }
}

function sendByPost() {
    let person = {
        surname: document.getElementById('postSurname').value,
        name: document.getElementById('postName').value,
        age: document.getElementById('postAge').value,
        address: document.getElementById('postAddress').value
    };
    var xhr = new XMLHttpRequest();
    xhr.open("POST","/personPost");
    xhr.setRequestHeader("Content-type","application/json");
    xhr.send(JSON.stringify(person))
}

postAge.onblur = function () {
    if ((this.value <0) ||(this.value>100)){
        postAge.classList.add("errors");
        postAge.focus();
        postAge.value = "Enter your age from 0 to 100."
    }
}
