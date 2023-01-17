<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page import="java.util.*" %>
        <jsp:include page="userheader.jsp" />
        
        <!-- 
        - #BRAND
      -->




<div class="section-wrapper">
<section class="section latest-game" aria-label="latest game">
          <div class="container">

            <p class="section-subtitle">Latest Releases</p>

            <h2 class="h2 section-title">
              Create & <span class="span">Manage</span>
            </h2>

             <%
                      HashMap<Integer,Boolean> map=(HashMap<Integer,Boolean>)session.getAttribute("regevent");
                      pageContext.setAttribute("map", map);
                    %>
${msg}
        <section class="section latest-game" aria-label="latest game">
          <div class="container">

            <ul class="has-scrollbar">
            <c:forEach var="event" items="${events}">

              <li class="scrollbar-item">
                <div class="latest-game-card">

                  <figure class="card-banner img-holder">
                    <img src="${event.url}" width="400" height="470" loading="lazy"
                      alt="White Walker Daily" class="img-cover">
                  </figure>

                  <div class="card-content">

                    <a href="#" class="card-badge skewBg">${event.name}</a>

                    <h3 class="h3">
                      <a href="#" class="card-title">${event.name} <span class="span">${event.name}</span></a>
                    </h3>

                    <p class="card-price">
                      Entry Fee : <span class="span">${event.fees}</span>
                    </p>
                    <c:if test="${!map[event.id]}">
                    <c:if test="${event.date>crdate}">
					 <a href="/user/registerevent/${event.id}" class="btn" data-btn>Register</a>
					 </c:if>
					<c:if test="${event.date<crdate}">
					 <a href="#" class="btn" data-btn>Registeration closed</a>
					 </c:if>
           </c:if>
           <%
           session.invalidate();
           %>
           <c:if test="${map[event.id]}">
           <a href="#" class="btn" data-btn>Already registered</a>
           </c:if>
                  </div>

                </div>
              </li>


              
              
</c:forEach>

            </ul>

          </div>
        </section>
          </div>
        </section>
        </div>
        <jsp:include page="userfooter.jsp" />