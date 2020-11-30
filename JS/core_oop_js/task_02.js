// #1
console.log("----- 1 ------");
let numbers = [15, -10, 0, 5, -7, 6, 7, 59, 547, -65, 9, 17, 13, -14, 17, 19, 244, -985, 37, -67]

numbers.sort(function (a, b) {
    return a - b;
});
console.log(numbers);

numbers.sort(function (a, b) {
    return b - a;
});
console.log(numbers);

// #2
console.log("----- 2 ------");
let evenNumbers = numbers.filter(function (element) {
    return element % 2 === 0;
})
console.log(evenNumbers);
let notEvenNumbers = numbers.filter(function (element) {
    return element % 2 !== 0;
})
console.log(notEvenNumbers);

// #3
console.log("----- 3 ------");
let student = [
    {age: 22, groupName: "java"},
    {age: 36, groupName: "js"},
    {age: 48, groupName: "testing"},
    {age: 16, groupName: "java"},
    {age: 34, groupName: "js"},
    {age: 27, groupName: "rubi"},
    {age: 26, groupName: "c++"},
    {age: 21, groupName: "java"},
    {age: 25, groupName: "c++"},
    {age: 36, groupName: "rubi"}];

function groupArray(student) {
    return student.map(function (element) {
        return element.groupName;
    });
}

console.log(groupArray(student))

function addAge(student) {
    return student.reduce(function (sum, element) {
        return sum + element.age;
    }, 0);
}

console.log(addAge(student))

function checkAge(student) {
    let ifAdult = 'You have adult'
    for (let i = 0; i < student.length; i++) {
        if (student.age > 18) {
            ifAdult = 'Your have not adult'
        }
    }
    return ifAdult;
}

console.log(checkAge(student))



