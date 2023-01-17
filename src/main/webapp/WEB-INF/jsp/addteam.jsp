<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>GAMICS - Sign up / Login Form</title>
  
  <link rel="stylesheet" href="/assets/css/style.css">

  <link rel="stylesheet" href="/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body>
<body>
${msg}
<header class="header active" data-header>
    <div class="container">

      <a href="/user/home" class="logo">
        <img src="/assets/images/icon.png" width="110" height="53" alt="unigine home">
      </a>

      <nav class="navbar" data-navbar>
        <ul class="navbar-list">

          <li class="navbar-item">
            <a href="/user/home" class="navbar-link" data-nav-link>home</a>
          </li>

          <li class="navbar-item">
            <a href="/tournament" class="navbar-link" data-nav-link>tournament</a>
          </li>

          <li class="navbar-item">
            <a href="/news" class="navbar-link" data-nav-link>news</a>
          </li>

          <li class="navbar-item">
            <a href="/contact" class="navbar-link" data-nav-link>contact</a>
          </li>
          <li class="navbar-item">
            <a href="/user/team" class="navbar-link" data-nav-link>Team</a>
          </li>
          <li class="navbar-item">
            <a href="/logout" class="navbar-link" data-nav-link>logout</a>
          </li>
        </ul>
      </nav>
<c:if test="${user.id>0}">
      <a href="#" class="btn" data-btn>Welcome ${user.name}</a>
</c:if>
<c:if test="${user==null}">
      <a href="/join" class="btn" data-btn>join our team</a>
</c:if>
      <button class="nav-toggle-btn" aria-label="toggle menu" data-nav-toggler>
        <span class="line line-1"></span>
        <span class="line line-2"></span>
        <span class="line line-3"></span>
      </button>

    </div>
  </header>
	<div class="main">  	
		<input type="checkbox" id="chk" aria-hidden="true">

			<div class="signup">
				<form:form method="post" action="/register" name="RegForm">
					<label for="chk" aria-hidden="true">members</label>

                    <c:forEach var="mem" items="${member}">
					<input type="text" name="name" placeholder="${mem.name}" readonly>
                    </c:forEach>
				</form:form>
			</div>

			<div class="login">
				<form action="/user/savemem" method="post">
					<label for="chk" aria-hidden="true">Add</label>
					<input type="email" name="email" placeholder="Email" required="">
					<c:if test="${team==null}"><input type="text" name="teamname" placeholder="Team name" required=""></c:if>
					<input type="submit" value="LOGIN" class="button">
				</form>
			</div>
	</div>
<!-- partial -->
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<script src="/assets/js/script.js"></script>
</body>
</html>
