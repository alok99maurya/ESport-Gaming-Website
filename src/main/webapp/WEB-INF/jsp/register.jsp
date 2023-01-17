<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <jsp:include page="userheader.jsp" />
    ${msg}

      <!-- 
        - #LATEST GAME
      -->
      <section class="section latest-game" aria-label="latest game">
        <div class="container">

          <ul class="has-scrollbar">

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
                    Entry Fee : <span class="span">${event.fees>0?evetn.fees:"free"}</span>
                  </p>
                  <div class="container" style="margin-top: 20px;margin-bottom: 2px;">
                    <h4 style="margin-top: 20px;margin-bottom: 20px;">Select members to rewgister(only ${event.teamsize} members)</h4>
                    <form method="post" action="/user/reg/${event.id}"class="footer-form">
                      <select name="members" id="countries" multiple>
                        <c:forEach items="${members}" var="member">
                          <option value="${member.id}">${member.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="register" class="btn" style="margin-top: 20px;margin-bottom: 2px;">
                    </form>
                  </div>
                </div>
                
              </div>
            </li>
          </ul>
          <script>
          new MultiSelectTag('countries', {
            rounded: true,    // default true
            shadow: true      // default false
        })
</script>
        </div>
      </section>
    <jsp:include page="userfooter.jsp" />