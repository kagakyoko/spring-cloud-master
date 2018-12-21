FROM java:8

MAINTAINER nanasetakesi@yahoo.co.jp

ENV BASE_DIR=/usr/local/eureka

RUN mkdir -p ${BASE_DIR}{/lib}

COPY bin/startup.sh /usr/local/bin/

ADD target/build/lib/* ${BASE_DIR}/lib/

ADD target/build/application.yml ${BASE_DIR}/

ADD target/build/bootstrap.yml ${BASE_DIR}/

ADD target/build/logback-spring.xml ${BASE_DIR}/

ADD target/build/spring-cloud-eureka.jar ${BASE_DIR}/

ADD target/build/spring-cloud-eureka.jar.original ${BASE_DIR}/

WORKDIR ${BASE_DIR}

CMD ["java", "-jar", "./spring-cloud-eureka.jar"]

EXPOSE 8761