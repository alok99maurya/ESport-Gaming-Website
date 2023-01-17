<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <jsp:include page="adminheader.jsp" />
        <div class="jumbotron-fluid text-center">
            <h1>Advertisment page</h1>
        </div>
        <div class="row">
         ${pageno}<br>${total}
            <div class="col-sm-6">
                <table class="table">
                    <thead>
                        <tr>
                            <td>picture</td>
                            <td>name</td>
                            <td>id</td>
                            <td>Time</td>
                            
                            <td>action</td>
                        </tr>
                    </thead>
                    <tbody>
                <c:forEach var="img" items="${events}">
                    <tr>
                        <td><img src="${img.url}" style="widht:200px; height:200px;" class="image"></td>
                        <td><h5>${img.name}</h5></td>
                        <td><h5>${img.id}</h5></td>
                        <td>${img.date}</td>
                        <td><a href="/admin/deleteevent/${img.id}" class="btn btn-sm btn-danger">Delete</a>
                        <a href="/admin/viewevent/${img.id}" class="btn btn-sm btn-danger">view</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
                </table>
                        <c:if test="${pageno>=0}">
                        <a href="/admin/allevent/${-pageno}" class="btn btn-info float-left">Previous</a>
                        </c:if>
                        <c:if test="${pageno<total}">
                        <a href="/admin/allevent/${pageno+1}" class="btn btn-info float-right">next</a>
                        </c:if>
            </div>
            <div class="col-sm-6">
                <form action="addevent" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                    <input type="text" name="name" class="form-control"/></div>
                    <div class="form-group">
                        <input type="text" name="teamsize" class="form-control"/></div>
                    <div class="form-group">
                        <input type="text" name="totalteams" class="form-control"/></div>
                    <div class="form-group">
                        <input type="date" name="date" class="form-control"/></div>
                    <div class="form-group">
                        <input type="text" name="hrs" class="form-control"/></div>
                    <div class="form-group">
                        <input type="text" name="minutes" class="form-control"/></div>
                    <div class="form-group">
                    <input type="file" name="img" class="form-control"/></div>
                    <input type="submit" value="Upload File" class="btn btn-success" />
                </form>
            </div>
        </div>
        <jsp:include page="adminfooter.jsp" />