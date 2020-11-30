function makeBuffer() {
    let text = '';
    return function (value) {
        if (arguments.length === 0) {
            return text;
        }
        text += value;
    };
}

let buffer1 = makeBuffer();
buffer1('JavaScript');
buffer1(' Вчити ');
buffer1('Потрібно');
alert(buffer1());

let buffer2 = makeBuffer();
buffer2(0);
buffer2(1);
buffer2(0);

alert(buffer2());