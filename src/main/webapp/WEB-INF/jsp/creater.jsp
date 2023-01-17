<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <jsp:include page="createrheader.jsp" />
        <section class="section">
            <form action="/creater/message" method="post" class="footer-form" style="width:400px;height:200px;margin: 0 auto;">
            <input type="email" name="email_address" required placeholder="Your message" autocomplete="off"
              class="input-field">

            <button type="submit" class="btn" data-btn>Send Now</button>
          </form>
          </section>
        <jsp:include page="createrfooter.jsp" />