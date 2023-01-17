<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- 
    - primary meta tags
  -->
  <title>Unigine - Epic Games Made For True Gamers!</title>
  <meta name="title" content="ESN Media - Epic Games Made For True Gamers!">
  <meta name="description" content="this website is made by vaibhav mishra">

  <!-- 
    - favicon
  -->
  <link rel="shortcut icon" href="/assets/images/icon.png">

  <!-- 
    - google font link
  -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link
    href="https://fonts.googleapis.com/css2?family=Oxanium:wght@400;500;600;700&family=Work+Sans:wght@600&display=swap"
    rel="stylesheet">

  <!-- 
    - custom css link
  -->
  <link rel="stylesheet" href="/assets/css/style.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">
  <script src="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/js/multi-select-tag.js"></script>>
  <!-- 
    - preload images
  -->
  <link rel="preload" as="image" href="/assets/images/hero-banner.png">
  <link rel="preload" as="image" href="/assets/images/hero-banner-bg.png">
</head>

<body id="top">

  <!-- 
    - #HEADER
  -->

  <header class="header active" data-header>
    <div class="container">

      <a href="/user/home" class="logo">
        <img src="/assets/images/icon.png" width="110" height="53" alt="unigine home">
      </a>

      <nav class="navbar" data-navbar>
        <ul class="navbar-list">

          <li class="navbar-item">
            <a href="/creater/home" class="navbar-link" data-nav-link>home</a>
          </li>

          <li class="navbar-item">
            <a href="/news" class="navbar-link" data-nav-link>news</a>
          </li>

          <li class="navbar-item">
            <a href="/contact" class="navbar-link" data-nav-link>contact</a>
          </li>
          <li class="navbar-item">
            <a href="/about" class="navbar-link" data-nav-link>About</a>
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
  <section class="section brand" aria-label="brand">
        <div class="container">
          <h1 class="sponsors skewBg">
            OUR SPONSORS
          </h1>

          <ul class="has-scrollbar">
            <c:forEach var="brand" items="${brands}">
            <li class="brand-item">
              <a href="https://${brand.url}"><img src="${brand.img}" loading="lazy" alt="brand logo" class="brand-logo"></a>
            </li>
            </c:forEach>
          </ul>

        </div>
      </section>