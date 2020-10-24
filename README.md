
<h2> Local build run </h2>
<ol>
<li>gradle clean build</li>
<li>./build/scripts/standard-service</li>
<li> Swagger API Docs - http://localhost:1000/standing-service/api/swagger-ui.html</li>
</ol>

<h2> Docker Build & Run </h2>
<ol>
<li>docker build -t sanrocks123/standings-service .</li>
<li>docker run -p3000:1000 sanrocks123/standings-service </li>
<li>Swagger API Docs - http://localhost:3000/standing-service/api/swagger-ui.html</li>
</ol>

<p> Docker Hub repo - https://hub.docker.com/repository/docker/sanrocks123/standings-service</p>