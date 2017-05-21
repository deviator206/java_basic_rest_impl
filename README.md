# java_basic_rest_impl
Basic REST implementation ready project with deploymentdescriptor &amp; pom.xml

###
after adding jersey-json & adding params in web.xml
recieved error - "java.lang.NoSuchMethodError: com.sun.jersey.core.reflection.ReflectionHelper.getContextClassLoaderPA()Ljava/security/PrivilegedAction"

> had used the version - 1.8 of jersery-json
but changed it to 
<dependency>
		<groupId>com.sun.jersey</groupId>
		<artifactId>jersey-json</artifactId>
		<version>1.19.3</version>
	</dependency>


###
All issue resolved 
working uRL
GET
http://localhost:8080/vogellaRestImpl/rest/hello/getstring
http://localhost:8080/vogellaRestImpl/rest/hello/getxml
http://localhost:8080/vogellaRestImpl/rest/hello/getjson
	
###
>support for json input added
http://localhost:8080/vogellaRestImpl/rest/hello/jsoninput
{"name":"Send Name"}
POST

###
crud operations

DB creation

create table validEmporiumUser (empId int NOT NULL AUTO_INCREMENT , empName varchar(20), empPassword varchar(20),empRole varchar(20), primary key (empId));

alter table validEmporiumUser1 modify column empId int NOT NULL AUTO_INCREMENT;

select * from validEmporiumUser;

insert into validEmporiumUser (empName, empPassword) values ('admin','admin','ADMIN')
insert into validEmporiumUser (empName, empPassword) values ('tech','tech','TECH')

select * from validEmporiumUser;


connecting to localhost:3306