console.log("----- 1 ------");
let user = {
    name: 'Пилип',
    surname: 'Шевченко'
};
console.log(user);

user.name = 'Сергій'
console.log(user);

delete user.name;
console.log(user);

console.log("----- 2 ------");
let salaries = {
    lead: 4458,
    senior: 3125,
    middle: 2569,
    junior: 1257
}
console.log(salaries);

function sumSalaries() {
    return salaries.lead + salaries.senior + salaries.middle + salaries.junior
};
console.log("All salaries = " + sumSalaries());

console.log("----- 3 ------");
arithmetic(10, 0);

function arithmetic(a, b) {
    console.log(a + " * " + b + " = ");
    console.log(a * b);
    console.log(a + " / " + b + " = ");
    try {
        console.log(a / b);
        if (b === 0) throw "cannot be divided by 0"
    } catch (e) {
        console.log("You enter 0, " + e)
    }
    console.log(a + " + " + b + " = ");
    console.log(a + b);
    console.log(a + " - " + b + " = ");
    console.log(a - b);
}
