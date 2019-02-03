# public_chat_backend
Written in Java Spring and Hibernate Backend for a simple public chat based on actual  users location

# docker for the database
docker volume create pgdata <br>
docker run -p 5432:5432 --rm --name some-postgres -v pgdata:/var/lib/postgresql/data -d postgres:10.3

# URL 
http://localhost:8080/swagger-ui.html
