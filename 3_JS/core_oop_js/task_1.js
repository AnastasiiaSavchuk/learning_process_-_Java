// 1. Сума всіх чисел які ввів користувач
console.log("----- 1 ------");
let number = prompt("Enter your number : ");
let sum = 0;
for (let i = 0; i <= number; i++) {
    sum += i;
}
console.log(sum);

// 2. Визначити чи число додатнє,від'ємне або 0
console.log("----- 2 ------");
let int = prompt("Enter your number : ");
if (int > 0) {
    console.log('Your number is positive : ' + int)
} else if (int == 0) {
    console.log('Your number is zero : ' + int)
} else if (int < 0) {
    console.log('Your number is negative : ' + int)
}

console.log("----- 3 ------");
// 3. Розв'язати рівняння 8*9
let multiply = prompt("Solve the equation 8*9 = ");
while (multiply !== 72) {
    prompt("Solve the equation 8*9 = ");
}

console.log("----- 4 ------");
// 4. введення пароля
let password = prompt("Enter your password : ");
switch (password) {
    case "pass123":
        console.log("Your password is correct.")
        break;
    case "admin":
        console.log("You are logged in as an administrator.");
        break;
    default:
        console.log("The password is incorrect.");
}

console.log("----- 5 ------");
// 5. Ряд фібоначі
let n0 = 1, n1 = 1, n2;
console.log("Послідовність Фібоначі : " + n0 + " " + n1 + " ");
for (let i = 0; i < 10; i++) {
    n2 = n0 + n1;
    console.log(+n2 + " ");
    n0 = n1;
    n1 = n2;
}