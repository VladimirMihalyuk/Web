<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Веб програмирование</title>
    <link href="styles.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<h1>Вывести список выигравших клиентов забега.</h1>

<div class="page-form">
    <form id="winners-in-race-form">
    </form>
</div>

<div class="page-table">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">ФИО</th>
            <th scope="col">Ставки</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="col">1</th>
            <th scope="col">Test</th>
            <th scope="col">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Сумма</th>
                        <th scope="col">Забег</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="col">1</th>
                        <th scope="col">12</th>
                        <th scope="col">1</th>
                    </tr>
                    </tbody>
                </table>

            </th>
        </tr>
        </tbody>
    </table>
</div>

<a href="home.jsp"> На главную</a>

<script src="script.js"></script>

</body>
</html>