echo "docker image download and run database"

docker run --name wedding-db \
  -e MYSQL_ROOT_PASSWORD=1234 \
  -e MYSQL_DATABASE=wedding \
  -e MYSQL_USER=wedding \
  -e MYSQL_PASSWORD=1234 \
  -p 3306:3306 \
  -d mariadb:10.11

#echo  "docker container start wedding-db "
#docker start wedding-db

#echo "docker container stop wedding-db "
#docker stop wedding-db