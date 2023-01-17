<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page import="java.util.*" %>
    <c:if test="${user.role=='ROLE_USER'}">
        <jsp:include page="userheader.jsp" />
        </c:if>
        <c:if test="${user.role=='ROLE_CREATER'}">
        <jsp:include page="createrheader.jsp" />
        </c:if>
        <c:if test="${user.role=='ROLE_SPONSOR'}">
        <jsp:include page="createrheader.jsp" />
        </c:if>
        <!-- 
        - #BRAND
      -->







<section class="section blog" id="blog" aria-label="blog">
        <div class="container">

          <h2 class="h2 section-title">
            Latest News & <span class="span">Articles</span>
          </h2>

          <p class="section-text">
            Compete With 100 Players On A Remote Island For Winner Takes Showdown Known Issue Where Certain Skin
            Strategic
          </p>

          <ul class="has-scrollbar">
    <c:forEach var="event" items="${events}">
            <li class="scrollbar-item">
              <div class="blog-card">

                <figure class="card-banner img-holder" style="--width: 400; --height: 290;">
                  <img src="${event.url}" width="400" height="290" loading="lazy"
                    alt="Shooter Action Video" class="img-cover">
                </figure>

                <div class="card-content">

                  <ul class="card-meta-list">

                    <li class="card-meta-item">
                      <ion-icon name="person-outline"></ion-icon>

                      <a href="#" class="item-text">Admin</a>
                    </li>

                    <li class="card-meta-item">
                      <ion-icon name="calendar-outline"></ion-icon>

                      <time datetime="2022-09-19" class="item-text">${event.date}</time>
                    </li>

                  </ul>

                  <h3>
                    <a href="#" class="card-title">Blog ${event.id}</a>
                  </h3>

                  <p class="card-text">
                    ${event.content}
                  </p>

                  <a href="#" class="card-link">
                    <span class="span">Read More</span>

                    <ion-icon name="caret-forward"></ion-icon>
                  </a>

                </div>

              </div>
            </li>

        </c:forEach>

            </ul>

          </div>
        </section>
          </div>
        </section>
        <c:if test="${m>0}">
        <a href="/news/${m-1}" class="btn" style="float:left;">previous</a>
        </c:if>
        <c:if test="${m<total}">
        <a href="/news/${m+1}" class="btn" style="float:right;">next</a>
        </c:if>
        </div>
        <jsp:include page="userfooter.jsp" />