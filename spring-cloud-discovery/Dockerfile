FROM java:8

MAINTAINER nanasetakesi@yahoo.co.jp

ENV BASE_DIR=/usr/local/discovery

RUN mkdir -p ${BASE_DIR}{/lib}

ADD target/build/lib/* ${BASE_DIR}/lib/

ADD target/build/application.yml ${BASE_DIR}/

ADD target/build/bootstrap.yml ${BASE_DIR}/

ADD target/build/logback-spring.xml ${BASE_DIR}/

ADD target/build/spring-cloud-discovery.jar ${BASE_DIR}/

ADD target/build/spring-cloud-discovery.jar.original $BASE_DIR/

WORKDIR ${BASE_DIR}

CMD ["java", "-jar", "./spring-cloud-discovery.jar"]

EXPOSE 8080