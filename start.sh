#!/bin/sh

java -jar /usr/local/lib/ventas-app.jar --spring.datasource.url=$DB_URL --spring.datasource.username=$DB_USER \
--spring.datasource.password=$DB_PASSWD