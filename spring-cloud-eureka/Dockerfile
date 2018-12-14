FROM java:8

MAINTAINER nanasetakesi@yahoo.co.jp

RUN mkdir -p /usr/local/eureka{/lib}

ADD target/build/lib/* /usr/local/eureka/lib/

ADD target/build/application.yml /usr/local/eureka/

ADD target/build/bootstrap.yml /usr/local/eureka/

ADD target/build/logback-spring.xml /usr/local/eureka/

ADD target/build/spring-cloud-eureka.jar /usr/local/eureka/

ADD target/build/spring-cloud-eureka.jar.original /usr/local/eureka/

WORKDIR /usr/local/eureka

CMD ["java", "-jar", "./spring-cloud-eureka.jar"]

EXPOSE 8761