<html>
  <head>
    <title>Gamics-Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    body,.jumbotron{
      background-color: aquamarine;
    }
    .abc{
        border: 2px solid black;
        padding: 20px;
        width: 250px;
        margin: 20px;
    }
    .image{
        width: 200px;
        height: 200px;
        max-width: 200px;
        background-blend-mode: lighten;
    }
  </style>
  </head>
  <body>
    <script>
      $(function(){
        $(".b1").click(function(){
          $.get("issue_status",{},function(output){
            $(".data").html(output);
          });
        });
        $(".b3").click(function(){
          $.get("lost_status",{},function(output){
            $(".data").html(output);
          });
        });
        $(".b2").click(function(){
          $.get("request_status",{},function(output){
            $(".data").html(output);
          });
        });
        $(".b4").click(function(){
          $.get("fine_status",{},function(output){
            $(".data").html(output);
          });
        });
      });
    </script>
  	<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">GAMICS-ADMIN</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/admin/home">Home</a></li>
      <li><a href="/admin/advertisment">Advertisment</a></li>
      <li><a href="/admin/blog">Blogs</a></li>
      <li><a href="/admin/event">Events</a></li>
      <li><a href="/admin/brand">Brands</a></li>
      <li><a href="/logout">Logout</a></li>
    </ul>
  </div>
</nav>