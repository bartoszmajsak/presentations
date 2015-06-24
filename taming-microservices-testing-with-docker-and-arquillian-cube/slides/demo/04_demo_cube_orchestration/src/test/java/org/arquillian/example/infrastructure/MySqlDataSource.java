package org.arquillian.example.infrastructure;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@DataSourceDefinition(
    name = "java:/mysql_ds",
    className = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
    url = "jdbc:mysql://mysql:3306/ape",
    user = "ape",
    password = "letmein")
@Singleton
@Startup
public class MySqlDataSource {
}
