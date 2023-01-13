--**********************************
--Ajuste do NLS_CHARACTERSET
--**********************************
connect sys/oracle as sysdba;
shutdown;
startup restrict;
Alter database character set INTERNAL_USE WE8ISO8859P1;
shutdown immediate;
startup;
connect system/oracle

--**********************************
--Tuning OracleXE
--**********************************
alter system set filesystemio_options=directio scope=spfile;
alter system set disk_asynch_io=false scope=spfile;

--**********************************
--Esquema springbootfintechapi
--**********************************

create tablespace springbootfintechapi datafile '/u01/app/oracle/oradata/XE/springbootfintechapi01.dbf' size 100M online;
create tablespace idx_springbootfintechapi datafile '/u01/app/oracle/oradata/XE/idx_springbootfintechapi01.dbf' size 100M;
create user springbootfintechapi identified by springbootfintechapi default tablespace springbootfintechapi temporary tablespace temp;
grant resource to springbootfintechapi;
grant connect to springbootfintechapi;
grant create view to springbootfintechapi;
grant create procedure to springbootfintechapi;
grant create materialized view to springbootfintechapi;
alter user springbootfintechapi default role connect, resource;
exit;
