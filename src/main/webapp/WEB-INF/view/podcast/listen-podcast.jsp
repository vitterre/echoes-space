<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="ES | ${listeningPodcast.getTitle()}">
  <div class="pt-3 px-5 pb-5 border border-secondary rounded mx-auto article-view" style="margin-top: 8rem">
    <h1 class="text-white">${listeningPodcast.getTitle()}</h1>
    <p class="text-white">Published: ${listeningPodcast.getUploadDate()}</p>
    <audio controls style="width: 70%" preload="metadata" id="podcastAudio">
      <source src="<c:url value="/podcast/get-audio?podcast-uuid=${listeningPodcast.getUuid()}"/>" type="audio/mp3"/>
    </audio>
    <p class="text-white">${listeningPodcast.getSummary()}</p>
    <h3 class="text-white">Voices of the podcast:</h3>
    <ul class="text-white">
      <c:forEach items="${podcastVoices}" var="voice">
        <li>${voice}</li>
      </c:forEach>
    </ul>
  </div>
</t:mainLayout>