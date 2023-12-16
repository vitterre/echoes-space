<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="echoes.space | Articles">
  <div class="pt-3 px-5 pb-5 mx-auto w-75" style="margin-top: 5rem">
    <h1 class="text-white text-center">Podcasts</h1>
    <a class="link-info" href="<c:url value="/podcast/create"/>">Upload your own</a>
    <div id="podcasts" class="mt-2">
<%--      <c:forEach items="${articles}" var="article">--%>
<%--        &lt;%&ndash;        <a href="<c:url value="/article/view?article-uuid=${article.getUuid()}"/>" style="text-decoration: none" class="article-item">&ndash;%&gt;--%>
<%--        <a href="<c:url value="/article/view?article-uuid=${article.getUuid()}"/>" class="card text-white bg-dark article-list-element article-item" id="article-list-element">--%>
<%--          <div id="article-img-grad" class="card-img-top" style="height: 10rem"></div>--%>
<%--          <div class="card-body">--%>
<%--            <h5 class="card-title">${article.getTitle()}</h5>--%>
<%--            <p class="card-text" style="color: #b6b6b6">${article.getSummary()}</p>--%>
<%--          </div>--%>
<%--        </a>--%>
<%--        &lt;%&ndash;        </a>&ndash;%&gt;--%>
<%--      </c:forEach>--%>

      <c:forEach items="${podcasts}" var="podcast">
        <div class="card border-dark bg-dark podcast-list-element" style="max-width: 100%">
          <div class="card-header" style="padding: 0">
            <div id="podcast-img-grad" class="card-img-top" style="height: 8rem"></div>
          </div>
          <div class="card-body text-white">
            <a href="<c:url value="/podcast/listen?podcast-uuid=${podcast.getUuid()}"/>" class="card-title"><h3>${podcast.getTitle()}</h3></a>
            <p class="card-text">${podcast.getSummary()}</p>
            <p>Voices: <span style="color: #b6b6b6;">${podcast.getVoices()}</span></p>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
  <script src="<c:url value="/js/podcast-image-grabber.js"/>"></script>
</t:mainLayout>