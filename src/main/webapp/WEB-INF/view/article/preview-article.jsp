<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="echoes.space | Write article">
  <div class="pt-3 px-5 pb-5 mt-5 border border-secondary rounded mx-auto article-view">
    <div class="text-center">
      <h1 class="text-white">${previewTitle}</h1>
    </div>

    <div class="section text-white">
      <div class="article-summary">
        ${previewSummary}
      </div>
      <hr>
      <div class="article">
        <md-block>
          ${previewArticleBody}
        </md-block>
      </div>
      <div class="text-center">
        <button href="<c:url value="/article/publish"/>" class="btn btn-outline-info mt-3 w-25">Publish</button>
      </div>
    </div>
  </div>
</t:mainLayout>