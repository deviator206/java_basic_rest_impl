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

### 
creation of tables

// CUSTOMER INFO
create table EMP_CUSTOMER_TABLE (id int NOT NULL AUTO_INCREMENT, name varchar(20), address varchar(30), phone int,primary key (id));
alter table EMP_CUSTOMER_TABLE modify column phone varchar(15);
alter table EMP_CUSTOMER_TABLE modify column address varchar(50);
insert into EMP_CUSTOMER_TABLE (name, address,phone) values ('sachin','pune kp road','9765896417');

insert into EMP_CUSTOMER_TABLE (name, address,phone) values ('mohan','pune DP road','8865896417');
select * from EMP_CUSTOMER_TABLE;

select * from EMP_CUSTOMER_TABLE where name LIKE 'an%' OR name LIKE '%an' OR name LIKE '%n%';

// PRODUCT
create table EMP_PRODUCT_TABLE (id int NOT NULL AUTO_INCREMENT, brandName varchar(20), brandModel varchar(30), serialNumber varchar(20), primary key (id));
insert into EMP_PRODUCT_TABLE (brandName, brandModel,serialNumber) values ('CanonEOs450','s70000','1001505887832');
select * from EMP_PRODUCT_TABLE

............
REST implementation
GET : http://localhost:8080/vogellaRestImpl/rest/customer/serach-customer?text=a
POST : http://localhost:8080/vogellaRestImpl/rest/customer/create 
{"customerName":"tech bhai","customerAddress":"tech1 ka address nahi malum","customerPhone":"87654433212"}



