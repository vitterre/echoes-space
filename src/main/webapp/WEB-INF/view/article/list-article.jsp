<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="echoes.space | Articles">
  <div class="pt-3 px-5 pb-5 mx-auto w-75" style="margin-top: 5rem">
    <h1 class="text-white text-center">Articles</h1>
    <div id="articles">
      <c:forEach items="${articles}" var="article">
<%--        <a href="<c:url value="/article/view?article-uuid=${article.getUuid()}"/>" style="text-decoration: none" class="article-item">--%>
          <a href="<c:url value="/article/view?article-uuid=${article.getUuid()}"/>" class="card text-white bg-dark article-list-element article-item" id="article-list-element">
            <div id="article-img-grad" class="card-img-top" style="height: 10rem"></div>
            <div class="card-body">
              <h5 class="card-title">${article.getTitle()}</h5>
              <p class="card-text" style="color: #b6b6b6">${article.getSummary()}</p>
            </div>
          </a>
<%--        </a>--%>
      </c:forEach>
    </div>
  </div>
  <script src="<c:url value="/js/article-image-grabber.js"/>"></script>
</t:mainLayout>