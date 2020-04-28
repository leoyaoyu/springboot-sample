FROM {image_with_jdk8}
LABEL maintainer='leoyaoyu@sina.com.cn'
COPY ssl-certficate/mvss.crt self-springboot-user-service-1.0-SNAPSHOT-boot.jar /home/
RUN chmod 777 /var/log
ENV JAVA_HOME "/opt/jdk1.8.0_92"
ENV JRE_HOME "${JAVA_HOME}/jre"
ENV CLASSPATH ".:${JAVdockerA_HOME}/lib:${JRE_HOME}/lib"
ENV PATH "${JAVA_HOME}/bin:$PATH"
ENV _JAVA_OPTIONS "-Xms256m -Xmx512m -Xmn128m"
RUN sh -c '/bin/echo -e "changeit\nY\n" | keytool -import -alias devCert -file /home/mvss.crt -keystore $JAVA_HOME/jre/lib/security/cacerts'
USER root
WORKDIR /home
EXPOSE 8080
CMD java \
    -Dspring.profiles.active='dev' \
    -jar self-springboot-user-service-1.0-SNAPSHOT-boot.jar