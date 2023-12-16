<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position: fixed; width: 100%; z-index: 1100">
    <div class="container-fluid">
        <a class="navbar-brand ms-5" href="#">
            <h1>echoes.<span class="brand-logo">space</span></h1>
        </a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/sign-in"/>">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/article/list"/>">Articles</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/podcast/list"/>">Podcasts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/about"/>">About</a>
                </li>
            </ul>
        </div>
    </div>
</nav>