

#cd producer && mvn clean package

#cd consumer && mvn clean package

#docker build -t srao/consumer -f Dockerfile.consumer .

#docker build -t srao/producer -f Dockerfile.producer .

#docker-compose up -d
# docker logs <<container_name>>
# docker-compose stop
#spring.rabbitmq.host=192.168.0.17
#spring.rabbitmq.port=5672
