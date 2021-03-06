--------------------------------------------------------
--  File created - Tuesday-January-19-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SUBSTANCE
--------------------------------------------------------

  CREATE TABLE "BOOT_PROJECT_TEAM1"."SUBSTANCE" 
   (	"RECORD_ID" NUMBER, 
	"INGREDIENT_ID" VARCHAR2(30 CHAR), 
	"ACTIVE" VARCHAR2(3 CHAR), 
	"INGREDIENT_NAME" VARCHAR2(50 CHAR), 
	"REFERENCE_SUBSTANCE" NUMBER, 
	"LANGUAGE" VARCHAR2(20 CHAR), 
	"ACTIVE_INGREDIENT" NUMBER(1,0), 
	"ADJUVANT" NUMBER(1,0), 
	"MATERIAL" NUMBER(1,0), 
	"ALT_MATERIAL" NUMBER(1,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into BOOT_PROJECT_TEAM1.SUBSTANCE
SET DEFINE OFF;
Insert into BOOT_PROJECT_TEAM1.SUBSTANCE (RECORD_ID,INGREDIENT_ID,ACTIVE,INGREDIENT_NAME,REFERENCE_SUBSTANCE,LANGUAGE,ACTIVE_INGREDIENT,ADJUVANT,MATERIAL,ALT_MATERIAL) values (323,'SUB-201','Yes','sub-202',261,'English',1,1,1,1);
Insert into BOOT_PROJECT_TEAM1.SUBSTANCE (RECORD_ID,INGREDIENT_ID,ACTIVE,INGREDIENT_NAME,REFERENCE_SUBSTANCE,LANGUAGE,ACTIVE_INGREDIENT,ADJUVANT,MATERIAL,ALT_MATERIAL) values (261,'SUB-182','Yes','sub182',null,'English',1,1,0,0);
Insert into BOOT_PROJECT_TEAM1.SUBSTANCE (RECORD_ID,INGREDIENT_ID,ACTIVE,INGREDIENT_NAME,REFERENCE_SUBSTANCE,LANGUAGE,ACTIVE_INGREDIENT,ADJUVANT,MATERIAL,ALT_MATERIAL) values (263,'SUB-185','Yes','sub185',261,'English',0,1,0,1);
--------------------------------------------------------
--  DDL for Index SUBSTANCE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOT_PROJECT_TEAM1"."SUBSTANCE_PK" ON "BOOT_PROJECT_TEAM1"."SUBSTANCE" ("RECORD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SUBSTANCE_UK_INGREDIENT_NAME
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOT_PROJECT_TEAM1"."SUBSTANCE_UK_INGREDIENT_NAME" ON "BOOT_PROJECT_TEAM1"."SUBSTANCE" ("INGREDIENT_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SUBSTANCE_UK_INGREDIENT_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOOT_PROJECT_TEAM1"."SUBSTANCE_UK_INGREDIENT_ID" ON "BOOT_PROJECT_TEAM1"."SUBSTANCE" ("INGREDIENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SUBSTANCE
--------------------------------------------------------

  ALTER TABLE "BOOT_PROJECT_TEAM1"."SUBSTANCE" ADD CONSTRAINT "SUBSTANCE_PK_RECORD_ID" PRIMARY KEY ("RECORD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BOOT_PROJECT_TEAM1"."SUBSTANCE" ADD CONSTRAINT "SUBSTANCE_UK_INGREDIENT_ID" UNIQUE ("INGREDIENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BOOT_PROJECT_TEAM1"."SUBSTANCE" ADD CONSTRAINT "SUBSTANCE_UK_INGREDIENT_NAME" UNIQUE ("INGREDIENT_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BOOT_PROJECT_TEAM1"."SUBSTANCE" MODIFY ("RECORD_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table SUBSTANCE
--------------------------------------------------------

  ALTER TABLE "BOOT_PROJECT_TEAM1"."SUBSTANCE" ADD CONSTRAINT "SUBSTANCE_FK_REF_SUB" FOREIGN KEY ("REFERENCE_SUBSTANCE")
	  REFERENCES "BOOT_PROJECT_TEAM1"."SUBSTANCE" ("RECORD_ID") ENABLE;
