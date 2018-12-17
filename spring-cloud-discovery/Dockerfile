FROM java:8

MAINTAINER nanasetakesi@yahoo.co.jp

RUN mkdir -p /usr/local/discovery{/lib}

ADD target/build/lib/* /usr/local/discovery/lib/

ADD target/build/application.yml /usr/local/discovery/

ADD target/build/bootstrap.yml /usr/local/discovery/

ADD target/build/logback-spring.xml /usr/local/discovery/

ADD target/build/spring-cloud-discovery.jar /usr/local/discovery/

ADD target/build/spring-cloud-discovery.jar.original /usr/local/discovery/

WORKDIR /usr/local/discovery

CMD ["java", "-jar", "./spring-cloud-discovery.jar"]

EXPOSE 8080