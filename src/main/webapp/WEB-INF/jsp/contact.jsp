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
        <section class="contact">
        <div class="content">
            <h2>Contact Us</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat non consequuntur, voluptatem minima et magnam similiq</p>
        
        </div>
        <div class="container2">
            <div class="containerInfo">
                <div class="box">
                    <div class="icon"><i class="fa fa-map-marker"></i></div>
                    <div class="text">
                        <h3>Address</h3>
                        <p>22/13c Pitamber Nagar <br>Teliyargang Prayagraj<br> Uttar Pradesh pin-224508</p>
                    </div>
                </div>
                <div class="box">
                    <div class="icon"><i class="fa fa-phone" aria-hidden="true"></i></div>
                    <div class="text">
                        <h3>Phone</h3>
                        <p>+918115955921</p>
                    </div>
                </div>
                <div class="box">
                    <div class="icon"><i class="fa fa-envelope-o" aria-hidden="true"></i></div>
                    <div class="text">
                        <h3>Email</h3>
                        <p>mauryaalok@gmail.com</p>
                    </div>
                </div>
            </div>
            <div class="contactForm2">
                <form action="/message" method="post" class="footer-form" style="width:400px;height:200px;margin: 0 auto;">
            <input type="message" name="message" required placeholder="Your message" autocomplete="off"
              class="input-field">

            <button type="submit" class="btn" data-btn>Send Now</button>
          </form>
            </div>
        </div>

    </section>
        <jsp:include page="userfooter.jsp" />