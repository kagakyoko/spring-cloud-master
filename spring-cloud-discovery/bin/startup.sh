#!/bin/bash

error_exit()
{
 echo "ERROR:$1 !!"
 exit 1
}

[ ! -e "$JAVA_HOME/bin/java" ] && error_exit "Please set the JAVA_HOME variable in your environment, We need java(x64)!
jdk8 or later is better!"


[ ! -e "$BASE_DIR" ]  && error_exit "找不到该执行路径!"

CMD="$JAVA_HOME/bin/java -jar $BASE_DIR/spring-cloud-eureka.jar"