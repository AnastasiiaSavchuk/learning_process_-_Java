<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Worker By Id</title>

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

    <link rel="stylesheet" href="css/workerForms.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <h1 style="margin: 10px">About worker : </h1>


    <div class='card border-success mb-3' style="width: 100%;border-color: #004c40;margin: 0 auto;">
        <div class='card-header'>
            <h3 class='card-title'>Worker name : ${worker.fullName}</h3>
        </div>
        <div class='card-body text-success'>
            <h4 class="card-title">Work in the project company. Lalalalalalalalalalalalalala. </h4>
            <h4 style="color: #00796b;font-size: 14px;font-weight:bold;">Title : ${worker.title}</h4>
            <h4 style="color: #00796b;font-size: 14px;font-weight:bold;">Salary : ${worker.salary}</h4>
            <button style="background-color: #004c40;border:none;color: #ffffff;font-size: 12px;font-weight:bold;border-radius: 5px;margin-top: 10px;" data-toggle="modal" data-target="#addWorkerModal"
                    type="button" id="add" worker_id="${worker.id}">Add to TeamLead</button>
            <button style="background-color: #004c40;border:none;border-radius: 5px;margin-top: 10px;" data-toggle="modal" data-target="#updateWorkertModal"
                    type="button" id="update" worker_id = "${worker.id}">
                <a href="${pageContext.request.contextPath}/workerUpdate.jsp" style="color: #ffffff;font-size: 12px;font-weight:bold;text-decoration: none;">Update</a></button>
            <button style="background-color: #004c40;border:none;color: #ffffff;font-size: 12px;font-weight:bold;border-radius: 5px;margin-top: 10px;" data-toggle="modal" data-target="#deleteWorkerModal"
                    onclick='deleteWorkerFromDB(worker_id="${worker.id}")'>Delete</button>
        </div>
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

<script src="js/workerAdd.js"></script>
<script src="js/workerUpdate.js"></script>
<script src="js/workerDelete.js"></script>
</body>
</html>