<html>
<head>
    <title>App-store</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="register-form">
            <h2>Registered Project</h2>
            <hr>
            <div class="input-group mb-3"><input class="form-control name" type="text" placeholder="Project name"/></div>
            <div class="input-group mb-3"><input class="form-control budget" type="text" placeholder="Budget"/></div>
            <div class="input-group mb-3"><input class="form-control email" type="email" placeholder="Email address"/></div>
            <div class="input-group mb-3"><input class="form-control password" type="password" placeholder="Password"/></div>
            <div class="input-group mb-3"><input class="form-control confirmPassword" type="password" placeholder="Confirm password"/></div>
            <div class="text-center"><button id="register" class="btn btn-customized">create</button></div>
            <div class="text-center"><p class="message">Already registered? <a href="#">Sign In</a></p></div>
        </form>
        <form class="login-form">
            <h2>Login Project</h2>
            <hr>
            <div class="input-group mb-3">
                <div class="input-group-prepend"><span class="input-group-text" id="email-label"><i class="fa fa-user-circle" aria-hidden="true"></i></span></div>
                <input class="form-control email" type="email" placeholder="Email address"></div>
            <div class="input-group mb-3">
                <div class="input-group-prepend"><span class="input-group-text" id="password-label"><i class="fa fa-key" aria-hidden="true"></i></span></div>
                <input class="form-control password" type="password" placeholder="Password"></div>
            <div class="text-center"><button id="login" type="submit" class="btn btn-customized">Login Account</button></div>
            <div class="text-center"><p class="message">Not registered? <a href="#">Create new project</a></p></div>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script src="js/main.js"></script>
</body>
</html>