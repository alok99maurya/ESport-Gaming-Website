<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <jsp:include page="adminheader.jsp" />
        <div class="jumbotron-fluid text-center">
            <h1>admin home page</h1>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <table class="table">
                    <thead>
                        <tr>
                            <td>name</td>
                            <td>id</td>
                            <td>team</td>
                            <td>action</td>
                        </tr>
                    </thead>
                    <tbody>
                <c:forEach var="img" items="${regusers}">
                    <tr>
                        <td><h5>${img.name}</h5></td>
                        <td><h5>${img.id}</h5></td>
                        <td>${img.team.name}</td>
                        <td><a href="/admin/deleteevent/${img.id}" class="btn btn-sm btn-danger">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
                </table>
                        <c:if test="${pageno>0}">
                        <a href="/admin/allevent/${-pageno}" class="btn btn-info float-left">Previous</a>
                        </c:if>
                        <c:if test="${pageno<total-1}">
                        <a href="/admin/allevent/${pageno+1}" class="btn btn-info float-left">next</a>
                        </c:if>
            </div>
        </div>
        <jsp:include page="adminfooter.jsp" />