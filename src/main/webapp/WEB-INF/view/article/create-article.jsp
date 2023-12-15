<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="echoes.space | Write article">
  <div class="pt-3 px-5 pb-5 border border-secondary rounded mx-auto article-create" style="margin-top: 8rem">
    <div class="text-center">
      <h1 id="write-article-page-title" class="text-white">Write new article</h1>
    </div>
    <c:if test="${message != null}">
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
          ${message}
      </div>
    </c:if>
    <form id="createArticleForm" class="form-horizontal w-100" action="<c:url value="/article/create"/>" enctype="application/x-www-form-urlencoded" accept-charset="UTF-8" method="POST">
      <div class="form-group">
        <label class="control-label text-white" for="title">Title</label>
        <div class="controls">
          <input id="title" name="title" class="form-control bg-dark text-white" type="text" value="">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label text-white" for="summary">Summary</label>
        <div class="controls">
          <textarea id="summary" name="summary" class="form-control bg-dark text-white"></textarea>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label text-white" for="articleBody">Body <span class="brand-logo">(in Markdown)</span></label>
        <div class="controls">
          <textarea id="articleBody" name="articleBody" class="form-control bg-dark text-white"></textarea>
        </div>
      </div>
      <div class="text-center">
        <button type="submit" class="btn btn-outline-info mt-3 w-25">Publish</button>
      </div>
    </form>
    <div class="text-center">
      <button id="preview-button" class="btn btn-outline-info mt-3 w-25">Preview</button>
    </div>
    <div style="display: none" id="preview-article">
      <div class="text-center">
        <h1 id="prepared-preview-title" class="text-white">
<%--            ${previewTitle}--%>
        </h1>
      </div>
      <div class="section text-white">
        <div id="prepared-preview-summary" class="article-summary">
<%--            ${previewSummary}--%>
        </div>
        <hr>
        <div class="article">
          <md-block class="md-display" id="prepared-preview-body">
<%--            ${previewArticleBody}--%>
          </md-block>
        </div>
        <div class="text-center">
          <button id="continue-editing-button" class="btn btn-outline-info mt-3 w-25">Continue editing</button>
        </div>
      </div>
    </div>
  </div>
  <script src="<c:url value="/js/prepare-article-for-preview.js"/>"></script>
</t:mainLayout>