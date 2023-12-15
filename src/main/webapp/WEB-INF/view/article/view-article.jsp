<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="ES | ${viewingArticle.getTitle()} by ${viewingArticleAuthorName}">
  <div class="pt-3 px-5 pb-5 border border-secondary rounded mx-auto article-view" style="margin-top: 8rem">
    <div id="viewing-article">
      <h1 class="text-white">${viewingArticle.getTitle()}</h1>
    </div>
    <div style="color: cornflowerblue" class="viewing-article-data d-flex flex-col">
      <p>by ${viewingArticleAuthorName}</p>
      <svg style="width: 16px; margin-bottom: 1rem; margin-left: 1rem" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22ZM12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20ZM13 12H17V14H11V7H13V12Z" fill="rgba(255,255,255,1)"></path></svg>
      <p class="viewing-article-data" style="margin-left: 0.2rem">${viewingArticleDuration} minute(s)</p>
    </div>
    <div class="section text-white">
      <div class="article-summary">
        ${viewingArticle.getSummary()}
      </div>
      <hr>
      <div class="article">
        <md-block class="md-display">
          ${viewingArticle.getBody()}
        </md-block>
      </div>
    </div>
  </div>
</t:mainLayout>