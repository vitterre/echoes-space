<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="echoes.space | Write article">
  <div class="pt-3 px-5 pb-5 border border-secondary rounded mx-auto podcast-create" style="margin-top: 8rem">
    <div class="text-center">
      <h1 id="update-page-page-title" class="text-white">Upload podcast</h1>
    </div>
    <c:if test="${message != null}">
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
          ${message}
      </div>
    </c:if>
    <form id="createPodcastForm" class="form-horizontal w-100" action="<c:url value="/podcast/create"/>" enctype="multipart/form-data" method="POST">
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
        <label class="control-label text-white" for="voices">Voices (use commas and spaces)</label>
        <div class="controls">
          <textarea id="voices" name="voices" class="form-control bg-dark text-white"></textarea>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label text-white" for="podcastFile">Select MP3 file</label>
        <div class="controls">
          <input type="file" id="podcastFile" name="podcastFile" class="form-control bg-dark text-white"/>
        </div>
      </div>
      <div class="text-center">
        <button type="submit" class="btn btn-outline-info mt-3 w-25">Publish</button>
      </div>
    </form>
  </div>
</t:mainLayout>