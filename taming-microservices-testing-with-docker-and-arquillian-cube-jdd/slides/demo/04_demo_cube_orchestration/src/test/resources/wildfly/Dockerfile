from jboss/wildfly:9.0.0.Final
COPY module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
COPY mysql-connector-java-5.1.35.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/
RUN /opt/jboss/wildfly/bin/add-user.sh -up mgmt-users.properties admin Admin#70365 --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]