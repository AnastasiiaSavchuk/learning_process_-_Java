let registerStudentForm = document.querySelector("#registerStudentForm");

let registerStudentSuccess = document.querySelector("#registerStudentSuccess");
let registerStudentError = document.querySelector("#registerStudentError");

registerStudentForm.addEventListener("submit", function (event) {
    let firstNameUploadInput = document.querySelector("#firstName").value;
    let lastNameUploadInput = document.querySelector("#lastName").value;
    let ageUploadInput = document.querySelector("#age").value;
    let imageUploadInput = document.querySelector("#image").files;

    if (imageUploadInput.length === 0) {
        registerStudentError.innerHTML = "Please choose your portrait photo";
    }
    registerStudent(firstNameUploadInput, lastNameUploadInput, ageUploadInput, imageUploadInput[0]);
    event.preventDefault();
}, true);

function registerStudent(firstName, lastName, age, image) {
    let data = new FormData();
    data.append("firstName", firstName);
    data.append("lastName", lastName);
    data.append("age", age);
    data.append("image", image);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadStudent");

    xhr.onload = function () {
        console.log(xhr.responseText);
        let response = JSON.parse(xhr.responseText);
        if (xhr.status === 200) {
            registerStudentError.style.display = "none";
            let content = "<p> Student registered successfully.</p>"
                + "<p>See more information : "
                + "<a href='" + response.showStudentUri
                + "' target='_blank'>"
                + response.showStudentUri
                + "</a></p>";
            registerStudentSuccess.innerHTML = content;
        } else {
            registerStudentSuccess.style.display = "none";
            registerStudentError.innerHTML = (response && response.message)
                || "Some error occured";
        }
    };
    xhr.send(data)
}