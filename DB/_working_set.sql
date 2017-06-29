SELECT * FROM `service_info_table`


SELECT * FROM SERVICE_INFO_TABLE;

UPDATE SERVICE_INFO_TABLE SET serviceStatus = 'C' WHERE serviceStatus='DTC'

SELECT * FROM SERVICE_INFO_TABLE WHERE service_order_number  = 'CE/2017-18/45 ';
productSN
service_order_number

SELECT * FROM SERVICE_INFO_TABLE WHERE  service_order_number = 'CE/2017-18/51' AND  id =  29

  SELECT * FROM SERVICE_INFO_TABLE WHERE  productName LIKE '%BamaneBrand%' AND serviceStatus='IN_PROGRESS'
SELECT * FROM S`sales_order_table``validemporiumuser`ERVICE_INFO_TABLE WHERE serviceStatus='IP'

SELECT * FROM EMP_CUSTOMER_TABLE WHERE  NAME LIKE '%as%'

SELECT * FROM EMP_CUSTOMER_TABLE;

SELECT * FROM SERVICE_INFO_TABLE WHERE  customerId LIKE '%5%'

SELECT * FROM EMP_CUSTOMER_TABLE WHERE NAME LIKE '%n%';
SELECT * FROM EMP_CUSTOMER_TABLE WHERE  phone LIKE '%9765899999%'
 UPDATE TABLE

ALTER TABLE SERVICE_INFO_TABLE DELETE COLUMN finalDeleted;
ALTER TABLE SERVICE_INFO_TABLE MODIFY COLUMN problemList VARCHAR(255);
ALTER TABLE SERVICE_INFO_TABLE MODIFY COLUMN accessoryList VARCHAR(255);

INSERT INTO SERVICE_INFO_TABLE (customerId, productName, productModel,productSN,accessoryList,problemList,shopUserComment,customerComment,serviceStatus,tentative_quoted_cost,tentative_service_completion_date,service_order_date,service_order_number,vatTinNumber,isCourier,courierName,courierPhone,courierDocumentNo,userId,advancedPayment) VALUES (25, 'NIKON', 'ssd20000', 'asdasasdads', 'Battery,Body Cap', 'Water Damage,Fungus in Binocular', 'asdasdddwqwwwwww', 'asddsa', 'IN_PROGRESS', '0', '2017-06-18 07:05:54', '2017-06-18 07:05:54' , 'CE/2017-18/40', '2763039355V', 0, '', '', '', '1', '0')


SELECT * FROM `service_info_table`

ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN technician_handle_status  VARCHAR(80) DEFAULT "NA"
ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN technician_handle_comment  VARCHAR(255) 
ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN technician_handle_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP 


ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN customer_approval_status  VARCHAR(80) DEFAULT "NA"
ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN customer_approval_comment  VARCHAR(255) 
ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN customer_approval_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP 


ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN  part_pending_status  VARCHAR(80) DEFAULT "NA"
ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN part_pending_comment  VARCHAR(255) 
ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN part_pending_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP 

ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN completed_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP 

ALTER TABLE SERVICE_INFO_TABLE ADD COLUMN tech_completed_comment  VARCHAR(255) 

SELECT * FROM SERVICE_INFO_TABLE WHERE servic`service_customer_table``service_info_table`eStatus = 'DTC' ORDER BY id ASC

``

``


WHERE  customerId  = 40

SELECT * FROM `emp_customer_table`

ALTER TABLE emp_customer_table ADD COLUMN alternate_number VARCHAR(90);
ALTER TABLE emp_customer_table ADD COLUMN email_id VARCHAR(90);

SELECT * FROM `validemporiumuser`

`userId`````
