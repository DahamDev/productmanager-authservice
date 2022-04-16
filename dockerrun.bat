 docker build -t auth-service:3 .
 docker run -d -p 8087:8087  --name auth-service auth-service:3