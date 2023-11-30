<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<nav class="navbar navbar-default">--%>
<%--    <div class="container-fluid">--%>
<%--        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
<%--            <ul class="nav navbar-nav">--%>
<%--                <li><a href="<c:url value="/"/>">Home</a></li>--%>
<%--                <c:if test="${user != null}">--%>
<%--                    <c:if test="${user.getRole() == 'admin'}">--%>
<%--                        <li><a href="<c:url value="/"/>">New Book</a></li>--%>
<%--                    </c:if>--%>
<%--                    <li><a class="nav-link disabled">${user.getUsername()}</a></li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${user == null}">--%>
<%--                    <li><a href="<c:url value="/sign-in"/>">Sign in</a></li>--%>
<%--                </c:if>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand ms-5" href="#"> <!-- Добавлен класс ms-3 для отступа слева -->
            <h1>echoes.<span class="brand-logo">space</span></h1>
        </a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5"> <!-- Добавлен класс me-3 для отступа справа -->
                <li class="nav-item">
                    <a class="nav-link" href="#">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Articles</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Podcasts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
            </ul>
        </div>
    </div>
</nav>