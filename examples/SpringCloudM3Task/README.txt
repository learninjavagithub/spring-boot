Note: The project fails with the below error, if the project is not build properly. 
Maven -> Update Project

AnnotationConfigApplicationContext@512535ff has been closed already

@Bean in the Controller for the bean that runs the task is very important.

The application starts does the task of printing the parameters and stops. This is very useful to do tasks that does 
one single thing at one time. This is similar to a task in a batch


Derby DB:
Derby db is not supported by spring cloud : see public enum DatabaseType {

	HSQL("HSQL Database Engine"),
	H2("H2"),
	ORACLE("Oracle"),
	MYSQL("MySQL"),
	POSTGRES("PostgreSQL"),
	SQLSERVER("Microsoft SQL Server"),
	DB2("DB2"),
	DB2VSE("DB2VSE"),
	DB2ZOS("DB2ZOS"),
	DB2AS400("DB2AS400");

Settings :	

spring.datasource.url=jdbc:derby://localhost:1527/tasklog;create=true
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=org.apache.derby.jdbc.ClientDriver

Using H2:

1. Start h2.bat
2. Add Driver dependency. Driver name can be found in web console login
3. Enter any pwd for the first time to login( used sa)
4. Start the client
5. Each batch run stats are stored to tables in DB same as spring batch

RebbitMQ:
start it if not already started using: 
C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.2\sbin>rabbitmq-server.bat

Enable Management Plugin(for management console):
C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.2\sbin>rabbitmq-plugins enable rabbitmq_management

C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.2\sbin>rabbitmqctl stop

C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.2\sbin>rabbitmq-server -detached


Access using the browser : http://localhost:15672/





	
