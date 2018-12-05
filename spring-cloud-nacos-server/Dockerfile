FROM java:8

ENV BASE_DIR /usr/local/nacos

RUN mkdir -p {$BASE_DIR/{bin,conf,target}}

ADD nacos/bin/* $BASE_DIR/bin/

ADD nacos/conf/* $BASE_DIR/conf/

ADD nacos/target/nacos-server.jar $BASE_DIR/target/

RUN chmod 755 $BASE_DIR/bin/*

CMD sh $BASE_DIR/bin/startup.sh -m standalone

EXPOSE 8848
