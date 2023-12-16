<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="echoes.space | About">
  <div class="pt-3 px-5 pb-5 mx-auto text-white" style="margin-top: 8rem; width: 60%">
    <div class="about-img" id="about-img"></div>
    <h1>About</h1>
    <p>
      echoes.<span class="brand-logo">space</span> is website for creative people.
      You can browse articles and podcasts on topics such as music, cinema, literature
      and even game design. If you are into anything from this, welcome!
    </p>
  </div>
  <script src="<c:url value="/js/about-image-grabber.js"/>"></script>
</t:mainLayout>