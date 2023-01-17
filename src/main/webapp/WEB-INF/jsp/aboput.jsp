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

<section class="subhead">
    <h1>ABOUT US</h1>
    <h2>WE ARE AN ESPORTS AND GAMING ORGANISATION</h2>
    <p>As a leading metaverse and creator economy platform at the intersection of<br> gaming culture, Upthrust Esports was founded in April,2020. At Upthrust, we create<br> opportunities that empower creators, energize players, and entertain fans. With our enthusiastic<br> &vibrant team,
       we excel at making real & meaningful impact in the esports community.</p>
    
  </section>
  <section class="do">
    <h1>WHAT WE DO</h1>
    <div class="row">
      <div class="do-col">
        <h3>ONLINE GAMING EVENTS</h3>
        <p>Upthrust provides you with the most thrilling & exciting events of all time. We comply with audience demands and organize the best
           tournaments which enhance the gaming level to the new heights.</p>

      </div>
      <div class="do-col">
        <h3>PRODUCTION MANAGEMENT</h3>
        <p>We at Upthrust believe that the people behind the screens are the backbone of any event that goes towards success. Thus we work with the most energetic people around who impart an extra spark to the 
          work, providing you with the best production for any kind of event.</p>

      </div>
    </div>

  </section>
  <!-- 
    - #what we offer

  -->
  <section class="offer">
    <h1>WHAT WE OFFER</h1>
    <div class="row">
      <div class="do-col1">
        <h3>TALENT MANAGEMENT</h3>
        <p>Our team brings extensive experience in representing Esports talent including content creators, Esports athletes and personalities.Comprised of pro management skills, we are equipped to handle all of our clients’ needs. 
          We are pursuant to our commitment to provide a turnkey experience</p>

      </div>
      <div class="do-col1">
        <h3>BRAND ENGAGEMENT</h3>
        <p>Upthrust brings a wealth of experience in helping connect brands within the Esports industry. We focus on forging partnerships that share a strategic vision and are a proper fit for both the brand and Esports entity or personality.Impressions and related statistics are an important equation in the way we form our partnerships, but we believe 
          it is important to find a strategic partner for our sponsors.</p>

      </div>
      <div class="do-col1">
        <h3>PRODUCT MARKETING</h3>
        <p>In the field of product marketing, to enhance the product dealing, the requirement of the clientele is the primary priority at upthrust. Upthrust offers one of such product marketing services that prioritize on the satisfaction of the customers. Our team and executives give special importance in understanding the customer requirements so as to deliver 
          the high potential services demanded in the market to the clients.</p>

      </div>
    </div>

  </section>

  <jsp:include page="userfooter.jsp" />