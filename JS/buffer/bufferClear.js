function makeBuffer() {
    let text = '';

    function buffer(value) {
        if (arguments.length === 0) {
            return text;
        }
        text += value;
    }

    buffer.clear = function () {
        text = '';
    }
    return buffer;
}

let buffer = makeBuffer();
buffer('Тест');
buffer(' тебе не з`їсть');
alert(buffer());
buffer.clear();
alert(buffer());