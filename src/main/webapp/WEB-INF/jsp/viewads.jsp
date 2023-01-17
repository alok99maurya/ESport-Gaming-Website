<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <jsp:include page="adminheader.jsp" />
        <div class="jumbotron-fluid text-center">
            <h1>Advertisment page</h1>
            ${msg}
        </div>
        <div class="row">
            <div class="col-sm-6">
                <table class="table">
                    <thead>
                        <tr>
                            <td>picture</td>
                            <td>email</td>
                            <td>id</td>
                            <td>action</td>
                        </tr>
                    </thead>
                    <tbody>
                <c:forEach var="img" items="${ads}">
                    <tr>
                        <td><img src="${img.url}" style="widht:200px; height:200px;" class="image"></td>
                        <td><h5>Email:${img.email}</h5></td>
                        <td><h5>id:${img.id}</h5></td>
                        <td><a href="/admin/${img.status}/${img.id}" class="btn btn-danger float-left btn-sm">${img.status=="ACTIVE"?"DEACTIVATE":"ACIVATE"}</a><a href="/admin/delete/${img.id}" class="btn btn-sm btn-danger">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
                </table>
                        <c:if test="${pageno>0}">
                        <a href="/admin/all/${-pageno}" class="btn btn-info float-left">Previous</a>
                        </c:if>
                        <c:if test="${pageno<total-1}">
                        <a href="/admin/all/${pageno+1}" class="btn btn-info float-left">next</a>
                        </c:if>
            </div>
            <div class="col-sm-6">
                <form action="saveads" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                    <input type="text" name="email" class="form-control"/></div>
                    <div class="form-group">
                    <input type="file" name="file" class="form-control"/></div>
                    <div class="form-group">
                    <input type="text" name="url" class="form-control"/></div>
                    
                    <input type="submit" value="Upload File" class="btn btn-success" />
                </form>
            </div>
        </div>
        <jsp:include page="adminfooter.jsp" />