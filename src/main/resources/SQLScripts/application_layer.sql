REM INSERTING into APPLICATION_LAYER
ALTER SESSION SET CURRENT_SCHEMA = RISKOPERONS;
SET DEFINE OFF;
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('1','Windows Server 2008 Standard','JBoss 6.1.0','10.20.187.2','8090','C:\riskapp\jboss-6.1.0.PIdea','/SzroWeb/','riskOperon_Polaczone_Komercyjne',null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('2','RedHat 5.5','JBoss 4.0.5GA','172.30.170.212','8090','/jboss-4.0.5.GA','/SzroWeb/',null,'Maszyna wirtualna',null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('3','Red Hat Enterprise Linux Server release 5.5','JBoss 6.1.0','10.20.187.3','8180','/riskapp/jboss-6.1.0.PWarta','/SzroWeb/','riskOperon_Warta',null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('4','Windows XP Professional','WebSphere Server Application - V.7','GADB','9080',null,'/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('5','Windows Server 2008 Standard','WebSphere Server Application - V.7','10.20.187.2','9080',null,'/SzroWeb/','Analiza_v103_20070213_1130',null,'9060','/ibm/console/',null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('6',null,null,'GADB','9081',null,'/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('7','Windows XP Professional','JBoss 4.0.5GA','ZRODB','8080','C:\jboss_server1_8080','/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('8','Windows Server 2008 Standard','JBoss 4.0.5GA','10.20.187.2','8180','C:\riskapp\jboss-4.0.5.PGetin','/SzroWeb/','riskOperon_Polaczone_Komercyjne_getin',null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('9','Windows XP Professional','JBoss 4.0.5GA','GADB','18080','D:\jboss405GA.GetinProd','/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('10','Windows XP Professional','JBoss 4.0.5GA','GADB','8443','C:\port-8080','/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('11','Linux Ubuntu 2.6.38','Oracle Application Server 10.1.3.1','172.30.170.34','8888',null,'/SzroWeb/',null,'Maszyna wirtualna na ZRODB (BP_Mint_LXDE)',null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('12','Red Hat Enterprise Linux Server release 5.5','Oracle Application Server 10.1.3.1','10.20.187.3','8888',null,'/SzroWeb/','riskOperon_Polaczone_Komercyjne_pocztowy','URL konsoli: http://10.20.187.3:8888/em',null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('13',null,null,'172.30.170.38','17002',null,'/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('14','Red Hat Enterprise Linux Server release 5.5','Weblogic Server 10.3.2.0','10.20.187.3','7001',null,'/SzroWeb/','riskOperon_NBP_DEV',null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('15','Linux Ubuntu 2.6.38','WebLogic 10.3.2.0','172.30.170.38','7002',null,'/SzroWeb/',null,'Maszyna wirtualna na ZRODB (Mint_LXDE)',null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('16',null,null,'172.30.170.38','14002',null,'/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('17',null,null,'AZRODEV2','8080',null,'/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('18',null,null,'AZRODEV2','18080',null,'/SzroWeb/',null,null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('19','Windows Server 2008 Standard','JBoss 6.1.0','10.20.187.2','8280','C:\riskapp\jboss-6.1.0.Dkomerc','/SzroWeb/','riskOperon_Polaczone_Komercyjne',null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('20','Red Hat Enterprise Linux Server release 5.5','JBoss EAP 6.0.1 (JBoss 7.1.3)','10.20.187.3','8680','/riskapp/jboss-as-7.1.1.PSGB','/SzroWeb/','riskOperon_Polaczone_Komercyjne_Produkcja',null,'8643','/console/',null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('21','Windows Server 2003 Enterprise Edition SP2','Apache Tomcat/5.0.27','172.30.190.120','8080','C:\BusinessObjects\Tomcat','/businessobjects/enterprise115/adminlaunch/',null,'To środowisko zostało utworzone na potrzeby testowania przypadku niedziałania raportowania systemu AZRO w Business Objects w BPS',null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('22','Windows Server 2008 Standard','JBoss 4.0.5GA','10.20.187.2','8380','C:\riskapp\jboss-4.0.5.DKomercCele','/SzroWeb/','riskOperon_Polaczone_Komercyjne_Cele',null,null,null,null);
Insert into APPLICATION_LAYER (ID,OPERATING_SYSTEM,APPLICATION_SYSTEM,HOST,HTTP_PORT,PATH,APPLICATION_CONTEXT,SVN_BRANCH,INFORMATION,ADMIN_PORT,ADMIN_CONTEXT,HTTPS_PORT) values ('23','Windows Server 2008 Standard','JBoss 6.1.0','10.20.187.2','8480','C:\riskapp\jboss-6.1.0.PDNBNord','/SzroWeb/','riskOperon_Polaczone_Komercyjne_DnB_NORD',null,null,null,null);
