// #1
let products = ['Orange', 'Banana', 'lemon', 'Watermelon', 'Cherry'];
console.log(products.length);
console.log(products[4]);

// #2
let styles = ['jazz', 'blues'];
styles.push('Rock-n-Roll');
console.log(styles);
styles.splice(1, 1, 'classic');
console.log(styles);
console.log(styles.shift());
styles.unshift('Rep', 'Reggi');
console.log(styles);

// #3
let arr = ['java', 'html', 'css', 'javaScript'];

function find(arr, value) {
    for (let i = 0; i < arr.length; i++) {
        let flag = -1;
        if (arr[i] === value) {
            flag = value;
        }
        return flag;
    }
}

console.log(find(arr, "java"));

// #4
let array = [5, -8, 9, 7, 99, 45, -1, 28, -3];
console.log(array);
let newArray = array.filter(function filterRange(a, b) {
    return a >= -1 && b <= 50;
})
console.log(newArray);

// #5
let str = "my-short-string";

function toUpperCase(str) {
    let arrStr = str.split('-');
    for (let i = 0; i < arrStr.length; i++) {
        arrStr[i] = arrStr[i].substring(0, 1).toUpperCase() + arrStr[i].substring(1);
    }
    return arrStr.join('')
}

console.log(toUpperCase(str));

