<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>${listeningPodcast.getTitle()}</h1>

  <audio controls style="width: 70%" preload="metadata" id="podcastAudio">
    <source src="<c:url value="/podcast/get-audio?podcast-uuid=${listeningPodcast.getUuid()}"/>" type="audio/mp3"/>
  </audio>
</body>
</html>
