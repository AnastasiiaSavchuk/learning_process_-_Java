# 1) Вивести всіх користувачів, у яких є акаунти посортовано за назвою акаунта
SELECT user.user_id, user.user_name, user.user_surname
FROM user INNER JOIN account
ON (user.user_id = account.account_id)
ORDER BY account.login;

# 2) Вивести всі повідомлення, текст яких починається на "La" і логін до акаунта "root"
SELECT * FROM messege INNER JOIN account
ON (messege.account_id = account.account_id)
WHERE messege.messege_name LIKE "La%" and account.login = "root";

# 3) Вивести всі фото у яких size меншe 4000
SELECT * FROM photo WHERE photo_size < 4000;

# 4) Вивести максимальний, мінімальний та середній розмір альбому, для акаунта з id = 4
SELECT min(album.album_size) AS min_size, max(album.album_size) AS max_size, avg(album.album_size)
FROM album LEFT JOIN account
ON (album.account_id = account.account_id)
WHERE account.account_id = 4;

# 5) Вивести та посортувати акаунти за логіном для користувачів, старших 30 років
SELECT account.account_id, account.login
FROM account INNER JOIN user
ON (account.account_id = user.user_id)
WHERE user.age > 30;

# 6) Вивести всі фото, які не належать до жодного альбому
SELECT photo.photo_id, photo.photo_name, photo.photo_size
FROM album_photo RIGHT JOIN photo ON (album_photo.photo_id = photo.photo_id)
WHERE album_photo.photo_id IS NULL;

# 7) Вивести всі юзера та його альбоми
SELECT user.user_id, user.user_name, user.user_surname, album.name, album.album_size
FROM user INNER JOIN account
ON (user.user_id = account.account_id)
INNER JOIN album
ON (account.account_id = album.account_id);

# 8) Вивести всі повідомлення для користувачів, посортувати за name.
SELECT user.user_id, user.user_name, user.user_surname, messege.messege_name
FROM user INNER JOIN account
ON (user.user_id = account.account_id)
INNER JOIN messege
ON (account.account_id = messege.account_id)
ORDER BY user.user_name;