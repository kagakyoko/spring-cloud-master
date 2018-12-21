FROM java:8

MAINTAINER nanasetakesi@yahoo.co.jp

ENV BASE_DIR=/usr/local/mdc

RUN mkdir -p ${BASE_DIR}{/lib,/mapper}

ADD target/build/lib/* ${BASE_DIR}/lib/

ADD target/build/mapper/* ${BASE_DIR}/mapper/

ADD target/build/application.yml ${BASE_DIR}/

ADD target/build/logback-spring.xml ${BASE_DIR}/

ADD target/build/provider-cloud-mdc.jar ${BASE_DIR}/

ADD target/build/provider-cloud-mdc.jar.original $BASE_DIR/

WORKDIR ${BASE_DIR}

CMD ["java", "-jar", "./provider-cloud-mdc.jar"]

EXPOSE 8080