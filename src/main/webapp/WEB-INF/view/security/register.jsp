<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="echoes.space | Register">

  <div class="pt-3 px-5 pb-5 mt-2 w-min-content border border-secondary rounded">
    <div class="text-center">
      <h1 class="text-white">Register</h1>
    </div>
    <c:if test="${message != null}">
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
          ${message}
      </div>
    </c:if>
    <form id="registerForm" class="form-horizontal" action="<c:url value="/register"/>" method="POST">
      <div class="form-group">
        <label class="control-label text-white" for="firstName">First name</label>
        <div class="controls">
          <input id="firstName" name="firstName" class="form-control bg-dark text-white" type="text" value=""/>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label text-white" for="lastName">Last name</label>
        <div class="controls">
          <input id="lastName" name="lastName" class="form-control bg-dark text-white" type="text" value=""/>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label text-white" for="emailAddress">E-mail</label>
        <div class="controls">
          <input id="emailAddress" name="emailAddress" class="form-control bg-dark text-white" type="text" value=""/>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label text-white mt-2" for="password">Password</label>
        <div class="controls">
          <input id="password" name="password" class="form-control bg-dark text-white" type="password" value=""/>
        </div>
      </div>
      <div class="text-center">
        <button type="submit" class="btn btn-outline-info mt-3 w-50">Register</button>
      </div>
      <div class="text-center mt-2">
        <a class="link-info" href="<c:url value="/sign-in"/>">Already have an account? Sign in</a>
      </div>
    </form>
  </div>
</t:mainLayout>