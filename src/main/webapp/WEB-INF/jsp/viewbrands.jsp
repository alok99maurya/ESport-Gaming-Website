<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <jsp:include page="adminheader.jsp" />
        <div class="jumbotron-fluid text-center">
            <h1>Blog page</h1>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <table class="table">
                    <thead>
                        <tr>
                            <td>date</td>
                            <td>content</td>
                            <td>picture</td>
                            <td>action</td>
                        </tr>
                    </thead>
                    <tbody>
                <c:forEach var="img" items="${brands}">
                    <tr>
                        <td><h5>${img.name}</h5></td>
                        <td><h5>${img.url}</h5></td>
                        <td><img src="${img.img}" style="widht:200px; height:200px;" class="image"></td>
                        <td><a href="/admin/deletebrand/${img.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
                </table>
                        <c:if test="${pageno>0}">
                        <a href="/admin/allbrand/${pageno-1}" class="btn btn-info float-left">Previous</a>
                        </c:if>
                        <c:if test="${pageno<total-1}">
                        <a href="/admin/allbrand/${pageno+1}" class="btn btn-info float-left">next</a>
                        </c:if>
            </div>
            <div class="col-sm-6">
                <form action="addbrand" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                    <input type="text" name="name" class="form-control"/></div>
                    <div class="form-group">
                    <input type="text" name="url" class="form-control"/></div>
                    <div class="form-group">
                    <input type="file" name="img" class="form-control"/></div>
                    <input type="submit" value="Upload File" class="btn btn-success" />
                </form>
            </div>
        </div>
        <jsp:include page="adminfooter.jsp" />