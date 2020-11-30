let menu = document.getElementById('menuId');
let title = menu.querySelector('.title');

title.onclick = function () {
    menu.classList.toggle('open');
};