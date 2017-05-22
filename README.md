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


// Creation of Product REST

// PRODUCT
create table EMP_PRODUCT_TABLE (id int NOT NULL AUTO_INCREMENT, brandName varchar(20), brandModel varchar(30), serialNumber varchar(20), primary key (id));
insert into EMP_PRODUCT_TABLE (brandName, brandModel,serialNumber,price) values ('NIKON','ssd20000','1001505887832',12899);

alter table EMP_PRODUCT_TABLE add column price int(30);

alter table EMP_PRODUCT_TABLE add column tax_type varchar(30);
select * from EMP_PRODUCT_TABLE


create implementation 
POST
URL : http://localhost:8080/vogellaRestImpl/rest/product/create
Content-Type: application/json

payload :
{"productList" : [
  
  			{"isNew":true,"brandName":"Canon-1","brandModel":"s7001","serialNumber":"X99999","price":9999,"taxType":"6"},
{"isNew":true,"brandName":"Canon-2","brandModel":"s7002","serialNumber":"X99990","price":29999,"taxType":"13.5"},
  {"isNew":true,"brandName":"Canon-3","brandModel":"s7003","serialNumber":"X99989","price":19999,"taxType":"0"}
]}

OUTPUT
{
"status": true,
"counterValue": 3
}


//search product
http://localhost:8080/vogellaRestImpl/rest/product/search-product?text=nik&type=NAME
{
  "status": true,
  "singleProductModelList": [
    {
      "id": 4,
      "name": "Canon-1",
      "model": "s7001",
      "sn": "X99999",
      "price": 9999,
      "taxType": "6"
    },
    {
      "id": 5,
      "name": "Canon-2",
      "model": "s7002",
      "sn": "X99990",
      "price": 29999,
      "taxType": "13.5"
    },
    {
      "id": 6,
      "name": "Canon-3",
      "model": "s7003",
      "sn": "X99989",
      "price": 19999,
      "taxType": "0"
    }
  ]
}



type=NAME
type=MODEL
type=SN

