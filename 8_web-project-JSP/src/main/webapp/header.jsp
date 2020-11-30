<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/header.css">

<header id="header">
    <div class="container">
        <div id="logo" class="pull-left">
            <h1 class="scrollto">Project Company</h1>
        </div>

        <nav id="nav-menu-container">
            <ul class="nav-menu">
                <li class="menu-active"><a href="${pageContext.request.contextPath}/cabinet.jsp">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/project.jsp">Projects</a></li>
                <li><a href="${pageContext.request.contextPath}/worker.jsp">Workers</a></li>
                <li>
                    <button id="logout" class="mobile-nav-active" type="button">Log Out</button>
                </li>
            </ul>
        </nav>
    </div>
</header>

<script src="js/logout.js"></script>
<script src="js/header.js"></script>