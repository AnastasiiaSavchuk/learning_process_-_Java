console.log("----- 1 -----");
let log = prompt("Who's there?")
switch (log) {
    case 'cancel':
        console.log('Canceled.');
        break;
    case 'other' :
        console.log('I do not know you.');
        break;
    case 'admin':
        let pass = prompt("Password?")
        if (pass === 'cancel') {
            console.log('Canceled.')
        } else if (pass === 'other') {
            console.log('Wrong password.')
        } else if (pass === 'themaster') {
            console.log('Welcome!')
        }
        break;
}