CREATE TABLE "ry0"."gen_table"
(
 "table_id" BIGINT IDENTITY(1,1) NOT NULL,
 "table_name" VARCHAR(200) DEFAULT ''
 NULL,
 "table_comment" VARCHAR(500) DEFAULT ''
 NULL,
 "sub_table_name" VARCHAR(64) NULL,
 "sub_table_fk_name" VARCHAR(64) NULL,
 "class_name" VARCHAR(100) DEFAULT ''
 NULL,
 "tpl_category" VARCHAR(200) DEFAULT 'crud'
 NULL,
 "package_name" VARCHAR(100) NULL,
 "module_name" VARCHAR(30) NULL,
 "business_name" VARCHAR(30) NULL,
 "function_name" VARCHAR(50) NULL,
 "function_author" VARCHAR(50) NULL,
 "gen_type" CHAR(1) DEFAULT '0'
 NULL,
 "gen_path" VARCHAR(200) DEFAULT '/'
 NULL,
 "options" VARCHAR(1000) NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) NULL
);
CREATE TABLE "ry0"."gen_table_column"
(
 "column_id" BIGINT IDENTITY(1,1) NOT NULL,
 "table_id" BIGINT NULL,
 "column_name" VARCHAR(200) NULL,
 "column_comment" VARCHAR(500) NULL,
 "column_type" VARCHAR(100) NULL,
 "java_type" VARCHAR(500) NULL,
 "java_field" VARCHAR(200) NULL,
 "is_pk" CHAR(1) NULL,
 "is_increment" CHAR(1) NULL,
 "is_required" CHAR(1) NULL,
 "is_insert" CHAR(1) NULL,
 "is_edit" CHAR(1) NULL,
 "is_list" CHAR(1) NULL,
 "is_query" CHAR(1) NULL,
 "query_type" VARCHAR(200) DEFAULT 'EQ'
 NULL,
 "html_type" VARCHAR(200) NULL,
 "dict_type" VARCHAR(200) DEFAULT ''
 NULL,
 "sort" INT NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL
);
CREATE TABLE "ry0"."qrtz_blob_triggers"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "trigger_name" VARCHAR(200) NOT NULL,
 "trigger_group" VARCHAR(200) NOT NULL,
 "blob_data" BLOB NULL
);
CREATE TABLE "ry0"."qrtz_calendars"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "calendar_name" VARCHAR(200) NOT NULL,
 "calendar" BLOB NOT NULL
);
CREATE TABLE "ry0"."qrtz_cron_triggers"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "trigger_name" VARCHAR(200) NOT NULL,
 "trigger_group" VARCHAR(200) NOT NULL,
 "cron_expression" VARCHAR(200) NOT NULL,
 "time_zone_id" VARCHAR(80) NULL
);
CREATE TABLE "ry0"."qrtz_fired_triggers"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "entry_id" VARCHAR(95) NOT NULL,
 "trigger_name" VARCHAR(200) NOT NULL,
 "trigger_group" VARCHAR(200) NOT NULL,
 "instance_name" VARCHAR(200) NOT NULL,
 "fired_time" BIGINT NOT NULL,
 "sched_time" BIGINT NOT NULL,
 "priority" INT NOT NULL,
 "state" VARCHAR(16) NOT NULL,
 "job_name" VARCHAR(200) NULL,
 "job_group" VARCHAR(200) NULL,
 "is_nonconcurrent" VARCHAR(1) NULL,
 "requests_recovery" VARCHAR(1) NULL
);
CREATE TABLE "ry0"."qrtz_job_details"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "job_name" VARCHAR(200) NOT NULL,
 "job_group" VARCHAR(200) NOT NULL,
 "description" VARCHAR(250) NULL,
 "job_class_name" VARCHAR(250) NOT NULL,
 "is_durable" VARCHAR(1) NOT NULL,
 "is_nonconcurrent" VARCHAR(1) NOT NULL,
 "is_update_data" VARCHAR(1) NOT NULL,
 "requests_recovery" VARCHAR(1) NOT NULL,
 "job_data" BLOB NULL
);
CREATE TABLE "ry0"."qrtz_locks"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "lock_name" VARCHAR(40) NOT NULL
);
CREATE TABLE "ry0"."qrtz_paused_trigger_grps"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "trigger_group" VARCHAR(200) NOT NULL
);
CREATE TABLE "ry0"."qrtz_scheduler_state"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "instance_name" VARCHAR(200) NOT NULL,
 "last_checkin_time" BIGINT NOT NULL,
 "checkin_interval" BIGINT NOT NULL
);
CREATE TABLE "ry0"."qrtz_simple_triggers"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "trigger_name" VARCHAR(200) NOT NULL,
 "trigger_group" VARCHAR(200) NOT NULL,
 "repeat_count" BIGINT NOT NULL,
 "repeat_interval" BIGINT NOT NULL,
 "times_triggered" BIGINT NOT NULL
);
CREATE TABLE "ry0"."qrtz_simprop_triggers"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "trigger_name" VARCHAR(200) NOT NULL,
 "trigger_group" VARCHAR(200) NOT NULL,
 "str_prop_1" VARCHAR(512) NULL,
 "str_prop_2" VARCHAR(512) NULL,
 "str_prop_3" VARCHAR(512) NULL,
 "int_prop_1" INT NULL,
 "int_prop_2" INT NULL,
 "long_prop_1" BIGINT NULL,
 "long_prop_2" BIGINT NULL,
 "dec_prop_1" DECIMAL(13,4) NULL,
 "dec_prop_2" DECIMAL(13,4) NULL,
 "bool_prop_1" VARCHAR(1) NULL,
 "bool_prop_2" VARCHAR(1) NULL
);
CREATE TABLE "ry0"."qrtz_triggers"
(
 "sched_name" VARCHAR(120) NOT NULL,
 "trigger_name" VARCHAR(200) NOT NULL,
 "trigger_group" VARCHAR(200) NOT NULL,
 "job_name" VARCHAR(200) NOT NULL,
 "job_group" VARCHAR(200) NOT NULL,
 "description" VARCHAR(250) NULL,
 "next_fire_time" BIGINT NULL,
 "prev_fire_time" BIGINT NULL,
 "priority" INT NULL,
 "trigger_state" VARCHAR(16) NOT NULL,
 "trigger_type" VARCHAR(8) NOT NULL,
 "start_time" BIGINT NOT NULL,
 "end_time" BIGINT NULL,
 "calendar_name" VARCHAR(200) NULL,
 "misfire_instr" SMALLINT NULL,
 "job_data" BLOB NULL
);
CREATE TABLE "ry0"."sys_config"
(
 "config_id" INT IDENTITY(1,1) NOT NULL,
 "config_name" VARCHAR(100) DEFAULT ''
 NULL,
 "config_key" VARCHAR(100) DEFAULT ''
 NULL,
 "config_value" VARCHAR(500) DEFAULT ''
 NULL,
 "config_type" CHAR(1) DEFAULT 'N'
 NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) NULL
);
CREATE TABLE "ry0"."sys_dept"
(
 "dept_id" BIGINT IDENTITY(1,1) NOT NULL,
 "parent_id" BIGINT DEFAULT 0
 NULL,
 "ancestors" VARCHAR(50) DEFAULT ''
 NULL,
 "dept_name" VARCHAR(30) DEFAULT ''
 NULL,
 "order_num" INT DEFAULT 0
 NULL,
 "leader" VARCHAR(20) NULL,
 "phone" VARCHAR(11) NULL,
 "email" VARCHAR(50) NULL,
 "status" CHAR(1) DEFAULT '0'
 NULL,
 "del_flag" CHAR(1) DEFAULT '0'
 NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL
);
CREATE TABLE "ry0"."sys_dict_data"
(
 "dict_code" BIGINT IDENTITY(1,1) NOT NULL,
 "dict_sort" INT DEFAULT 0
 NULL,
 "dict_label" VARCHAR(100) DEFAULT ''
 NULL,
 "dict_value" VARCHAR(100) DEFAULT ''
 NULL,
 "dict_type" VARCHAR(100) DEFAULT ''
 NULL,
 "css_class" VARCHAR(100) NULL,
 "list_class" VARCHAR(100) NULL,
 "is_default" CHAR(1) DEFAULT 'N'
 NULL,
 "status" CHAR(1) DEFAULT '0'
 NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) NULL
);
CREATE TABLE "ry0"."sys_dict_type"
(
 "dict_id" BIGINT IDENTITY(1,1) NOT NULL,
 "dict_name" VARCHAR(100) DEFAULT ''
 NULL,
 "dict_type" VARCHAR(100) DEFAULT ''
 NULL,
 "status" CHAR(1) DEFAULT '0'
 NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) NULL
);
CREATE TABLE "ry0"."sys_job"
(
 "job_id" BIGINT IDENTITY(1,1) NOT NULL,
 "job_name" VARCHAR(64) DEFAULT ''
 NOT NULL,
 "job_group" VARCHAR(64) DEFAULT 'DEFAULT'
 NOT NULL,
 "invoke_target" VARCHAR(500) NOT NULL,
 "cron_expression" VARCHAR(255) DEFAULT ''
 NULL,
 "misfire_policy" VARCHAR(20) DEFAULT '3'
 NULL,
 "concurrent" CHAR(1) DEFAULT '1'
 NULL,
 "status" CHAR(1) DEFAULT '0'
 NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) DEFAULT ''
 NULL
);
CREATE TABLE "ry0"."sys_job_log"
(
 "job_log_id" BIGINT IDENTITY(1,1) NOT NULL,
 "job_name" VARCHAR(64) NOT NULL,
 "job_group" VARCHAR(64) NOT NULL,
 "invoke_target" VARCHAR(500) NOT NULL,
 "job_message" VARCHAR(500) NULL,
 "status" CHAR(1) DEFAULT '0'
 NULL,
 "exception_info" VARCHAR(2000) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL
);
CREATE TABLE "ry0"."sys_logininfor"
(
 "info_id" BIGINT IDENTITY(1,1) NOT NULL,
 "login_name" VARCHAR(50) DEFAULT ''
 NULL,
 "ipaddr" VARCHAR(128) DEFAULT ''
 NULL,
 "login_location" VARCHAR(255) DEFAULT ''
 NULL,
 "browser" VARCHAR(50) DEFAULT ''
 NULL,
 "os" VARCHAR(50) DEFAULT ''
 NULL,
 "status" CHAR(1) DEFAULT '0'
 NULL,
 "msg" VARCHAR(255) DEFAULT ''
 NULL,
 "login_time" TIMESTAMP(0) NULL
);
CREATE TABLE "ry0"."sys_menu"
(
 "menu_id" BIGINT IDENTITY(1,1) NOT NULL,
 "menu_name" VARCHAR(50) NOT NULL,
 "parent_id" BIGINT DEFAULT 0
 NULL,
 "order_num" INT DEFAULT 0
 NULL,
 "url" VARCHAR(200) DEFAULT '#'
 NULL,
 "target" VARCHAR(20) DEFAULT ''
 NULL,
 "menu_type" CHAR(1) DEFAULT ''
 NULL,
 "visible" CHAR(1) DEFAULT '0'
 NULL,
 "is_refresh" CHAR(1) DEFAULT '1'
 NULL,
 "perms" VARCHAR(100) NULL,
 "icon" VARCHAR(100) DEFAULT '#'
 NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) DEFAULT ''
 NULL
);
CREATE TABLE "ry0"."sys_notice"
(
 "notice_id" INT IDENTITY(1,1) NOT NULL,
 "notice_title" VARCHAR(50) NOT NULL,
 "notice_type" CHAR(1) NOT NULL,
 "notice_content" BLOB NULL,
 "status" CHAR(1) DEFAULT '0'
 NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(255) NULL
);
CREATE TABLE "ry0"."sys_oper_log"
(
 "oper_id" BIGINT IDENTITY(1,1) NOT NULL,
 "title" VARCHAR(50) DEFAULT ''
 NULL,
 "business_type" INT DEFAULT 0
 NULL,
 "method" VARCHAR(100) DEFAULT ''
 NULL,
 "request_method" VARCHAR(10) DEFAULT ''
 NULL,
 "operator_type" INT DEFAULT 0
 NULL,
 "oper_name" VARCHAR(50) DEFAULT ''
 NULL,
 "dept_name" VARCHAR(50) DEFAULT ''
 NULL,
 "oper_url" VARCHAR(255) DEFAULT ''
 NULL,
 "oper_ip" VARCHAR(128) DEFAULT ''
 NULL,
 "oper_location" VARCHAR(255) DEFAULT ''
 NULL,
 "oper_param" VARCHAR(2000) DEFAULT ''
 NULL,
 "json_result" VARCHAR(2000) DEFAULT ''
 NULL,
 "status" INT DEFAULT 0
 NULL,
 "error_msg" VARCHAR(2000) DEFAULT ''
 NULL,
 "oper_time" TIMESTAMP(0) NULL,
 "cost_time" BIGINT DEFAULT 0
 NULL
);
CREATE TABLE "ry0"."sys_post"
(
 "post_id" BIGINT IDENTITY(1,1) NOT NULL,
 "post_code" VARCHAR(64) NOT NULL,
 "post_name" VARCHAR(50) NOT NULL,
 "post_sort" INT NOT NULL,
 "status" CHAR(1) NOT NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) NULL
);
CREATE TABLE "ry0"."sys_role"
(
 "role_id" BIGINT IDENTITY(1,1) NOT NULL,
 "role_name" VARCHAR(30) NOT NULL,
 "role_key" VARCHAR(100) NOT NULL,
 "role_sort" INT NOT NULL,
 "data_scope" CHAR(1) DEFAULT '1'
 NULL,
 "status" CHAR(1) NOT NULL,
 "del_flag" CHAR(1) DEFAULT '0'
 NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) NULL
);
CREATE TABLE "ry0"."sys_role_dept"
(
 "role_id" BIGINT NOT NULL,
 "dept_id" BIGINT NOT NULL
);
CREATE TABLE "ry0"."sys_role_menu"
(
 "role_id" BIGINT NOT NULL,
 "menu_id" BIGINT NOT NULL
);
CREATE TABLE "ry0"."sys_user"
(
 "user_id" BIGINT IDENTITY(1,1) NOT NULL,
 "dept_id" BIGINT NULL,
 "login_name" VARCHAR(30) NOT NULL,
 "user_name" VARCHAR(30) DEFAULT ''
 NULL,
 "user_type" VARCHAR(2) DEFAULT '00'
 NULL,
 "email" VARCHAR(50) DEFAULT ''
 NULL,
 "phonenumber" VARCHAR(11) DEFAULT ''
 NULL,
 "sex" CHAR(1) DEFAULT '0'
 NULL,
 "avatar" VARCHAR(100) DEFAULT ''
 NULL,
 "password" VARCHAR(50) DEFAULT ''
 NULL,
 "salt" VARCHAR(20) DEFAULT ''
 NULL,
 "status" CHAR(1) DEFAULT '0'
 NULL,
 "del_flag" CHAR(1) DEFAULT '0'
 NULL,
 "login_ip" VARCHAR(128) DEFAULT ''
 NULL,
 "login_date" TIMESTAMP(0) NULL,
 "pwd_update_date" TIMESTAMP(0) NULL,
 "create_by" VARCHAR(64) DEFAULT ''
 NULL,
 "create_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) DEFAULT ''
 NULL,
 "update_time" TIMESTAMP(0) NULL,
 "remark" VARCHAR(500) NULL
);
CREATE TABLE "ry0"."sys_user_online"
(
 "sessionId" VARCHAR(50) DEFAULT ''
 NOT NULL,
 "login_name" VARCHAR(50) DEFAULT ''
 NULL,
 "dept_name" VARCHAR(50) DEFAULT ''
 NULL,
 "ipaddr" VARCHAR(128) DEFAULT ''
 NULL,
 "login_location" VARCHAR(255) DEFAULT ''
 NULL,
 "browser" VARCHAR(50) DEFAULT ''
 NULL,
 "os" VARCHAR(50) DEFAULT ''
 NULL,
 "status" VARCHAR(10) DEFAULT ''
 NULL,
 "start_timestamp" TIMESTAMP(0) NULL,
 "last_access_time" TIMESTAMP(0) NULL,
 "expire_time" INT DEFAULT 0
 NULL
);
CREATE TABLE "ry0"."sys_user_post"
(
 "user_id" BIGINT NOT NULL,
 "post_id" BIGINT NOT NULL
);
CREATE TABLE "ry0"."sys_user_role"
(
 "user_id" BIGINT NOT NULL,
 "role_id" BIGINT NOT NULL
);
CREATE TABLE "ry0"."tq_aqi_station"
(
 "id" VARCHAR(64) NOT NULL,
 "timepoint" TIMESTAMP(0) NULL,
 "area" VARCHAR(64) NULL,
 "citycode" VARCHAR(64) NULL,
 "provinceid" VARCHAR(64) NULL,
 "provincename" VARCHAR(64) NULL,
 "positionname" VARCHAR(64) NULL,
 "stationcode" VARCHAR(64) NULL,
 "co" VARCHAR(64) NULL,
 "co_24h" VARCHAR(64) NULL,
 "latitude" VARCHAR(64) NULL,
 "longitude" VARCHAR(64) NULL,
 "measure" VARCHAR(255) NULL,
 "no2" VARCHAR(64) NULL,
 "no2_24h" VARCHAR(64) NULL,
 "o3" VARCHAR(64) NULL,
 "o3_24h" VARCHAR(64) NULL,
 "o3_8h" VARCHAR(64) NULL,
 "pm10" VARCHAR(64) NULL,
 "pm10_24h" VARCHAR(64) NULL,
 "pm2_5" VARCHAR(64) NULL,
 "pm2_5_24h" VARCHAR(64) NULL,
 "so2" VARCHAR(64) NULL,
 "so2_24h" VARCHAR(64) NULL,
 "aqi" VARCHAR(64) NULL,
 "colevel" VARCHAR(64) NULL,
 "no2level" VARCHAR(64) NULL,
 "o3level" VARCHAR(64) NULL,
 "pm10level" VARCHAR(64) NULL,
 "pm2_5level" VARCHAR(64) NULL,
 "so2level" VARCHAR(64) NULL,
 "primarypollutant" VARCHAR(64) NULL,
 "quality" VARCHAR(255) NULL,
 "unheathful" VARCHAR(255) NULL,
 "create_by" VARCHAR(255) NULL,
 "create_time" TIMESTAMP(0) NULL
);
CREATE TABLE "ry0"."tq_city"
(
 "id" VARCHAR(64) NOT NULL,
 "city_code" VARCHAR(64) NULL,
 "city_name" VARCHAR(64) NULL,
 "province_id" VARCHAR(64) NULL,
 "province_name" VARCHAR(64) NULL,
 "city_jc" VARCHAR(64) NULL,
 "create_time" TIMESTAMP(0) NULL,
 "create_by" VARCHAR(64) NULL,
 "update_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) NULL,
 "flag" VARCHAR(1) NULL
);
CREATE TABLE "ry0"."tq_city_aqi"
(
 "id" VARCHAR(64) NOT NULL,
 "timepoint" TIMESTAMP(0) NULL,
 "colevel" VARCHAR(64) NULL,
 "no2level" VARCHAR(64) NULL,
 "o3level" VARCHAR(64) NULL,
 "pm10level" VARCHAR(64) NULL,
 "pm2_5level" VARCHAR(64) NULL,
 "so2level" VARCHAR(64) NULL,
 "area" VARCHAR(64) NULL,
 "citycode" VARCHAR(64) NULL,
 "co" VARCHAR(64) NULL,
 "no2" VARCHAR(64) NULL,
 "o3" VARCHAR(64) NULL,
 "pm10" VARCHAR(64) NULL,
 "pm2_5" VARCHAR(64) NULL,
 "so2" VARCHAR(64) NULL,
 "aqi" VARCHAR(64) NULL,
 "primarypollutant" VARCHAR(64) NULL,
 "quality" VARCHAR(64) NULL,
 "measure" TEXT NULL,
 "Unheathful" TEXT NULL,
 "create_time" TIMESTAMP(0) NULL,
 "create_by" VARCHAR(64) NULL,
 "update_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) NULL,
 "flag" VARCHAR(1) NULL
);
CREATE TABLE "ry0"."tq_city_forecast"
(
 "id" VARCHAR(64) NOT NULL,
 "timepoint" TIMESTAMP(0) NULL,
 "citycode" VARCHAR(64) NULL,
 "cityname" VARCHAR(64) NULL,
 "forecastDate" TIMESTAMP(0) NULL,
 "day" VARCHAR(64) NULL,
 "aqi" VARCHAR(64) NULL,
 "quality" VARCHAR(64) NULL,
 "primarypollutant" VARCHAR(64) NULL,
 "create_by" VARCHAR(64) NULL,
 "create_time" TIMESTAMP(0) NULL
);
CREATE TABLE "ry0"."tq_province"
(
 "id" VARCHAR(64) NULL,
 "province_code" VARCHAR(64) NULL,
 "province_name" VARCHAR(64) NULL,
 "province_jc" VARCHAR(64) NULL,
 "create_time" TIMESTAMP(0) NULL,
 "create_by" VARCHAR(64) NULL,
 "update_time" TIMESTAMP(0) NULL,
 "update_by" VARCHAR(64) NULL,
 "flag" VARCHAR(1) NULL
);
ALTER TABLE "ry0"."gen_table" ADD CONSTRAINT  PRIMARY KEY("table_id") ;

ALTER TABLE "ry0"."gen_table_column" ADD CONSTRAINT  PRIMARY KEY("column_id") ;

ALTER TABLE "ry0"."qrtz_blob_triggers" ADD CONSTRAINT  PRIMARY KEY("sched_name","trigger_name","trigger_group") ;

ALTER TABLE "ry0"."qrtz_calendars" ADD CONSTRAINT  PRIMARY KEY("sched_name","calendar_name") ;

ALTER TABLE "ry0"."qrtz_cron_triggers" ADD CONSTRAINT  PRIMARY KEY("sched_name","trigger_name","trigger_group") ;

ALTER TABLE "ry0"."qrtz_fired_triggers" ADD CONSTRAINT  PRIMARY KEY("sched_name","entry_id") ;

ALTER TABLE "ry0"."qrtz_job_details" ADD CONSTRAINT  PRIMARY KEY("sched_name","job_name","job_group") ;

ALTER TABLE "ry0"."qrtz_locks" ADD CONSTRAINT  PRIMARY KEY("sched_name","lock_name") ;

ALTER TABLE "ry0"."qrtz_paused_trigger_grps" ADD CONSTRAINT  PRIMARY KEY("sched_name","trigger_group") ;

ALTER TABLE "ry0"."qrtz_scheduler_state" ADD CONSTRAINT  PRIMARY KEY("sched_name","instance_name") ;

ALTER TABLE "ry0"."qrtz_simple_triggers" ADD CONSTRAINT  PRIMARY KEY("sched_name","trigger_name","trigger_group") ;

ALTER TABLE "ry0"."qrtz_simprop_triggers" ADD CONSTRAINT  PRIMARY KEY("sched_name","trigger_name","trigger_group") ;

ALTER TABLE "ry0"."qrtz_triggers" ADD CONSTRAINT  PRIMARY KEY("sched_name","trigger_name","trigger_group") ;

ALTER TABLE "ry0"."sys_config" ADD CONSTRAINT  PRIMARY KEY("config_id") ;

ALTER TABLE "ry0"."sys_dept" ADD CONSTRAINT  PRIMARY KEY("dept_id") ;

ALTER TABLE "ry0"."sys_dict_data" ADD CONSTRAINT  PRIMARY KEY("dict_code") ;

ALTER TABLE "ry0"."sys_dict_type" ADD CONSTRAINT  PRIMARY KEY("dict_id") ;

ALTER TABLE "ry0"."sys_job" ADD CONSTRAINT  PRIMARY KEY("job_id","job_name","job_group") ;

ALTER TABLE "ry0"."sys_job_log" ADD CONSTRAINT  PRIMARY KEY("job_log_id") ;

ALTER TABLE "ry0"."sys_logininfor" ADD CONSTRAINT  PRIMARY KEY("info_id") ;

ALTER TABLE "ry0"."sys_menu" ADD CONSTRAINT  PRIMARY KEY("menu_id") ;

ALTER TABLE "ry0"."sys_notice" ADD CONSTRAINT  PRIMARY KEY("notice_id") ;

ALTER TABLE "ry0"."sys_oper_log" ADD CONSTRAINT  PRIMARY KEY("oper_id") ;

ALTER TABLE "ry0"."sys_post" ADD CONSTRAINT  PRIMARY KEY("post_id") ;

ALTER TABLE "ry0"."sys_role" ADD CONSTRAINT  PRIMARY KEY("role_id") ;

ALTER TABLE "ry0"."sys_role_dept" ADD CONSTRAINT  PRIMARY KEY("role_id","dept_id") ;

ALTER TABLE "ry0"."sys_role_menu" ADD CONSTRAINT  PRIMARY KEY("role_id","menu_id") ;

ALTER TABLE "ry0"."sys_user" ADD CONSTRAINT  PRIMARY KEY("user_id") ;

ALTER TABLE "ry0"."sys_user_online" ADD CONSTRAINT  PRIMARY KEY("sessionId") ;

ALTER TABLE "ry0"."sys_user_post" ADD CONSTRAINT  PRIMARY KEY("user_id","post_id") ;

ALTER TABLE "ry0"."sys_user_role" ADD CONSTRAINT  PRIMARY KEY("user_id","role_id") ;

ALTER TABLE "ry0"."tq_aqi_station" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "ry0"."qrtz_blob_triggers" ADD CONSTRAINT "qrtz_blob_triggers_ibfk_1" FOREIGN KEY("sched_name","trigger_name","trigger_group") REFERENCES "ry0"."qrtz_triggers"("sched_name","trigger_name","trigger_group") with index ;

ALTER TABLE "ry0"."qrtz_cron_triggers" ADD CONSTRAINT "qrtz_cron_triggers_ibfk_1" FOREIGN KEY("sched_name","trigger_name","trigger_group") REFERENCES "ry0"."qrtz_triggers"("sched_name","trigger_name","trigger_group") with index ;

ALTER TABLE "ry0"."qrtz_simple_triggers" ADD CONSTRAINT "qrtz_simple_triggers_ibfk_1" FOREIGN KEY("sched_name","trigger_name","trigger_group") REFERENCES "ry0"."qrtz_triggers"("sched_name","trigger_name","trigger_group") with index ;

ALTER TABLE "ry0"."qrtz_simprop_triggers" ADD CONSTRAINT "qrtz_simprop_triggers_ibfk_1" FOREIGN KEY("sched_name","trigger_name","trigger_group") REFERENCES "ry0"."qrtz_triggers"("sched_name","trigger_name","trigger_group") with index ;

ALTER TABLE "ry0"."qrtz_triggers" ADD CONSTRAINT "qrtz_triggers_ibfk_1" FOREIGN KEY("sched_name","job_name","job_group") REFERENCES "ry0"."qrtz_job_details"("sched_name","job_name","job_group") with index ;

CREATE INDEX "sched_name"
ON "ry0"."qrtz_triggers"("sched_name","job_name","job_group");

CREATE INDEX "idx_sys_logininfor_lt"
ON "ry0"."sys_logininfor"("login_time");

CREATE INDEX "idx_sys_logininfor_s"
ON "ry0"."sys_logininfor"("status");

CREATE INDEX "idx_sys_oper_log_bt"
ON "ry0"."sys_oper_log"("business_type");

CREATE INDEX "idx_sys_oper_log_ot"
ON "ry0"."sys_oper_log"("oper_time");

CREATE INDEX "idx_sys_oper_log_s"
ON "ry0"."sys_oper_log"("status");

ALTER TABLE "ry0"."sys_dict_type" ADD CONSTRAINT "dict_type" UNIQUE("dict_type") ;

COMMENT ON TABLE "ry0"."gen_table" IS '代码生成业务表';

COMMENT ON COLUMN "ry0"."gen_table"."table_id" IS '编号';

COMMENT ON COLUMN "ry0"."gen_table"."table_name" IS '表名称';

COMMENT ON COLUMN "ry0"."gen_table"."table_comment" IS '表描述';

COMMENT ON COLUMN "ry0"."gen_table"."sub_table_name" IS '关联子表的表名';

COMMENT ON COLUMN "ry0"."gen_table"."sub_table_fk_name" IS '子表关联的外键名';

COMMENT ON COLUMN "ry0"."gen_table"."class_name" IS '实体类名称';

COMMENT ON COLUMN "ry0"."gen_table"."tpl_category" IS '使用的模板（crud单表操作 tree树表操作 sub主子表操作）';

COMMENT ON COLUMN "ry0"."gen_table"."package_name" IS '生成包路径';

COMMENT ON COLUMN "ry0"."gen_table"."module_name" IS '生成模块名';

COMMENT ON COLUMN "ry0"."gen_table"."business_name" IS '生成业务名';

COMMENT ON COLUMN "ry0"."gen_table"."function_name" IS '生成功能名';

COMMENT ON COLUMN "ry0"."gen_table"."function_author" IS '生成功能作者';

COMMENT ON COLUMN "ry0"."gen_table"."gen_type" IS '生成代码方式（0zip压缩包 1自定义路径）';

COMMENT ON COLUMN "ry0"."gen_table"."gen_path" IS '生成路径（不填默认项目路径）';

COMMENT ON COLUMN "ry0"."gen_table"."options" IS '其它生成选项';

COMMENT ON COLUMN "ry0"."gen_table"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."gen_table"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."gen_table"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."gen_table"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."gen_table"."remark" IS '备注';

COMMENT ON TABLE "ry0"."gen_table_column" IS '代码生成业务表字段';

COMMENT ON COLUMN "ry0"."gen_table_column"."column_id" IS '编号';

COMMENT ON COLUMN "ry0"."gen_table_column"."table_id" IS '归属表编号';

COMMENT ON COLUMN "ry0"."gen_table_column"."column_name" IS '列名称';

COMMENT ON COLUMN "ry0"."gen_table_column"."column_comment" IS '列描述';

COMMENT ON COLUMN "ry0"."gen_table_column"."column_type" IS '列类型';

COMMENT ON COLUMN "ry0"."gen_table_column"."java_type" IS 'JAVA类型';

COMMENT ON COLUMN "ry0"."gen_table_column"."java_field" IS 'JAVA字段名';

COMMENT ON COLUMN "ry0"."gen_table_column"."is_pk" IS '是否主键（1是）';

COMMENT ON COLUMN "ry0"."gen_table_column"."is_increment" IS '是否自增（1是）';

COMMENT ON COLUMN "ry0"."gen_table_column"."is_required" IS '是否必填（1是）';

COMMENT ON COLUMN "ry0"."gen_table_column"."is_insert" IS '是否为插入字段（1是）';

COMMENT ON COLUMN "ry0"."gen_table_column"."is_edit" IS '是否编辑字段（1是）';

COMMENT ON COLUMN "ry0"."gen_table_column"."is_list" IS '是否列表字段（1是）';

COMMENT ON COLUMN "ry0"."gen_table_column"."is_query" IS '是否查询字段（1是）';

COMMENT ON COLUMN "ry0"."gen_table_column"."query_type" IS '查询方式（等于、不等于、大于、小于、范围）';

COMMENT ON COLUMN "ry0"."gen_table_column"."html_type" IS '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）';

COMMENT ON COLUMN "ry0"."gen_table_column"."dict_type" IS '字典类型';

COMMENT ON COLUMN "ry0"."gen_table_column"."sort" IS '排序';

COMMENT ON COLUMN "ry0"."gen_table_column"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."gen_table_column"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."gen_table_column"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."gen_table_column"."update_time" IS '更新时间';

COMMENT ON TABLE "ry0"."qrtz_blob_triggers" IS 'Blob类型的触发器表';

COMMENT ON COLUMN "ry0"."qrtz_blob_triggers"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_blob_triggers"."trigger_name" IS 'qrtz_triggers表trigger_name的外键';

COMMENT ON COLUMN "ry0"."qrtz_blob_triggers"."trigger_group" IS 'qrtz_triggers表trigger_group的外键';

COMMENT ON COLUMN "ry0"."qrtz_blob_triggers"."blob_data" IS '存放持久化Trigger对象';

COMMENT ON TABLE "ry0"."qrtz_calendars" IS '日历信息表';

COMMENT ON COLUMN "ry0"."qrtz_calendars"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_calendars"."calendar_name" IS '日历名称';

COMMENT ON COLUMN "ry0"."qrtz_calendars"."calendar" IS '存放持久化calendar对象';

COMMENT ON TABLE "ry0"."qrtz_cron_triggers" IS 'Cron类型的触发器表';

COMMENT ON COLUMN "ry0"."qrtz_cron_triggers"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_cron_triggers"."trigger_name" IS 'qrtz_triggers表trigger_name的外键';

COMMENT ON COLUMN "ry0"."qrtz_cron_triggers"."trigger_group" IS 'qrtz_triggers表trigger_group的外键';

COMMENT ON COLUMN "ry0"."qrtz_cron_triggers"."cron_expression" IS 'cron表达式';

COMMENT ON COLUMN "ry0"."qrtz_cron_triggers"."time_zone_id" IS '时区';

COMMENT ON TABLE "ry0"."qrtz_fired_triggers" IS '已触发的触发器表';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."entry_id" IS '调度器实例id';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."trigger_name" IS 'qrtz_triggers表trigger_name的外键';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."trigger_group" IS 'qrtz_triggers表trigger_group的外键';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."instance_name" IS '调度器实例名';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."fired_time" IS '触发的时间';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."sched_time" IS '定时器制定的时间';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."priority" IS '优先级';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."state" IS '状态';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."job_name" IS '任务名称';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."job_group" IS '任务组名';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."is_nonconcurrent" IS '是否并发';

COMMENT ON COLUMN "ry0"."qrtz_fired_triggers"."requests_recovery" IS '是否接受恢复执行';

COMMENT ON TABLE "ry0"."qrtz_job_details" IS '任务详细信息表';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."job_name" IS '任务名称';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."job_group" IS '任务组名';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."description" IS '相关介绍';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."job_class_name" IS '执行任务类名称';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."is_durable" IS '是否持久化';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."is_nonconcurrent" IS '是否并发';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."is_update_data" IS '是否更新数据';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."requests_recovery" IS '是否接受恢复执行';

COMMENT ON COLUMN "ry0"."qrtz_job_details"."job_data" IS '存放持久化job对象';

COMMENT ON TABLE "ry0"."qrtz_locks" IS '存储的悲观锁信息表';

COMMENT ON COLUMN "ry0"."qrtz_locks"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_locks"."lock_name" IS '悲观锁名称';

COMMENT ON TABLE "ry0"."qrtz_paused_trigger_grps" IS '暂停的触发器表';

COMMENT ON COLUMN "ry0"."qrtz_paused_trigger_grps"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_paused_trigger_grps"."trigger_group" IS 'qrtz_triggers表trigger_group的外键';

COMMENT ON TABLE "ry0"."qrtz_scheduler_state" IS '调度器状态表';

COMMENT ON COLUMN "ry0"."qrtz_scheduler_state"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_scheduler_state"."instance_name" IS '实例名称';

COMMENT ON COLUMN "ry0"."qrtz_scheduler_state"."last_checkin_time" IS '上次检查时间';

COMMENT ON COLUMN "ry0"."qrtz_scheduler_state"."checkin_interval" IS '检查间隔时间';

COMMENT ON TABLE "ry0"."qrtz_simple_triggers" IS '简单触发器的信息表';

COMMENT ON COLUMN "ry0"."qrtz_simple_triggers"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_simple_triggers"."trigger_name" IS 'qrtz_triggers表trigger_name的外键';

COMMENT ON COLUMN "ry0"."qrtz_simple_triggers"."trigger_group" IS 'qrtz_triggers表trigger_group的外键';

COMMENT ON COLUMN "ry0"."qrtz_simple_triggers"."repeat_count" IS '重复的次数统计';

COMMENT ON COLUMN "ry0"."qrtz_simple_triggers"."repeat_interval" IS '重复的间隔时间';

COMMENT ON COLUMN "ry0"."qrtz_simple_triggers"."times_triggered" IS '已经触发的次数';

COMMENT ON TABLE "ry0"."qrtz_simprop_triggers" IS '同步机制的行锁表';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."trigger_name" IS 'qrtz_triggers表trigger_name的外键';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."trigger_group" IS 'qrtz_triggers表trigger_group的外键';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."str_prop_1" IS 'String类型的trigger的第一个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."str_prop_2" IS 'String类型的trigger的第二个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."str_prop_3" IS 'String类型的trigger的第三个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."int_prop_1" IS 'int类型的trigger的第一个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."int_prop_2" IS 'int类型的trigger的第二个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."long_prop_1" IS 'long类型的trigger的第一个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."long_prop_2" IS 'long类型的trigger的第二个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."dec_prop_1" IS 'decimal类型的trigger的第一个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."dec_prop_2" IS 'decimal类型的trigger的第二个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."bool_prop_1" IS 'Boolean类型的trigger的第一个参数';

COMMENT ON COLUMN "ry0"."qrtz_simprop_triggers"."bool_prop_2" IS 'Boolean类型的trigger的第二个参数';

COMMENT ON TABLE "ry0"."qrtz_triggers" IS '触发器详细信息表';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."sched_name" IS '调度名称';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."trigger_name" IS '触发器的名字';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."trigger_group" IS '触发器所属组的名字';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."job_name" IS 'qrtz_job_details表job_name的外键';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."job_group" IS 'qrtz_job_details表job_group的外键';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."description" IS '相关介绍';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."next_fire_time" IS '上一次触发时间（毫秒）';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."prev_fire_time" IS '下一次触发时间（默认为-1表示不触发）';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."priority" IS '优先级';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."trigger_state" IS '触发器状态';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."trigger_type" IS '触发器的类型';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."start_time" IS '开始时间';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."end_time" IS '结束时间';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."calendar_name" IS '日程表名称';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."misfire_instr" IS '补偿执行的策略';

COMMENT ON COLUMN "ry0"."qrtz_triggers"."job_data" IS '存放持久化job对象';

COMMENT ON TABLE "ry0"."sys_config" IS '参数配置表';

COMMENT ON COLUMN "ry0"."sys_config"."config_id" IS '参数主键';

COMMENT ON COLUMN "ry0"."sys_config"."config_name" IS '参数名称';

COMMENT ON COLUMN "ry0"."sys_config"."config_key" IS '参数键名';

COMMENT ON COLUMN "ry0"."sys_config"."config_value" IS '参数键值';

COMMENT ON COLUMN "ry0"."sys_config"."config_type" IS '系统内置（Y是 N否）';

COMMENT ON COLUMN "ry0"."sys_config"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_config"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_config"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_config"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_config"."remark" IS '备注';

COMMENT ON TABLE "ry0"."sys_dept" IS '部门表';

COMMENT ON COLUMN "ry0"."sys_dept"."dept_id" IS '部门id';

COMMENT ON COLUMN "ry0"."sys_dept"."parent_id" IS '父部门id';

COMMENT ON COLUMN "ry0"."sys_dept"."ancestors" IS '祖级列表';

COMMENT ON COLUMN "ry0"."sys_dept"."dept_name" IS '部门名称';

COMMENT ON COLUMN "ry0"."sys_dept"."order_num" IS '显示顺序';

COMMENT ON COLUMN "ry0"."sys_dept"."leader" IS '负责人';

COMMENT ON COLUMN "ry0"."sys_dept"."phone" IS '联系电话';

COMMENT ON COLUMN "ry0"."sys_dept"."email" IS '邮箱';

COMMENT ON COLUMN "ry0"."sys_dept"."status" IS '部门状态（0正常 1停用）';

COMMENT ON COLUMN "ry0"."sys_dept"."del_flag" IS '删除标志（0代表存在 2代表删除）';

COMMENT ON COLUMN "ry0"."sys_dept"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_dept"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_dept"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_dept"."update_time" IS '更新时间';

COMMENT ON TABLE "ry0"."sys_dict_data" IS '字典数据表';

COMMENT ON COLUMN "ry0"."sys_dict_data"."dict_code" IS '字典编码';

COMMENT ON COLUMN "ry0"."sys_dict_data"."dict_sort" IS '字典排序';

COMMENT ON COLUMN "ry0"."sys_dict_data"."dict_label" IS '字典标签';

COMMENT ON COLUMN "ry0"."sys_dict_data"."dict_value" IS '字典键值';

COMMENT ON COLUMN "ry0"."sys_dict_data"."dict_type" IS '字典类型';

COMMENT ON COLUMN "ry0"."sys_dict_data"."css_class" IS '样式属性（其他样式扩展）';

COMMENT ON COLUMN "ry0"."sys_dict_data"."list_class" IS '表格回显样式';

COMMENT ON COLUMN "ry0"."sys_dict_data"."is_default" IS '是否默认（Y是 N否）';

COMMENT ON COLUMN "ry0"."sys_dict_data"."status" IS '状态（0正常 1停用）';

COMMENT ON COLUMN "ry0"."sys_dict_data"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_dict_data"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_dict_data"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_dict_data"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_dict_data"."remark" IS '备注';

COMMENT ON TABLE "ry0"."sys_dict_type" IS '字典类型表';

COMMENT ON COLUMN "ry0"."sys_dict_type"."dict_id" IS '字典主键';

COMMENT ON COLUMN "ry0"."sys_dict_type"."dict_name" IS '字典名称';

COMMENT ON COLUMN "ry0"."sys_dict_type"."dict_type" IS '字典类型';

COMMENT ON COLUMN "ry0"."sys_dict_type"."status" IS '状态（0正常 1停用）';

COMMENT ON COLUMN "ry0"."sys_dict_type"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_dict_type"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_dict_type"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_dict_type"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_dict_type"."remark" IS '备注';

COMMENT ON TABLE "ry0"."sys_job" IS '定时任务调度表';

COMMENT ON COLUMN "ry0"."sys_job"."job_id" IS '任务ID';

COMMENT ON COLUMN "ry0"."sys_job"."job_name" IS '任务名称';

COMMENT ON COLUMN "ry0"."sys_job"."job_group" IS '任务组名';

COMMENT ON COLUMN "ry0"."sys_job"."invoke_target" IS '调用目标字符串';

COMMENT ON COLUMN "ry0"."sys_job"."cron_expression" IS 'cron执行表达式';

COMMENT ON COLUMN "ry0"."sys_job"."misfire_policy" IS '计划执行错误策略（1立即执行 2执行一次 3放弃执行）';

COMMENT ON COLUMN "ry0"."sys_job"."concurrent" IS '是否并发执行（0允许 1禁止）';

COMMENT ON COLUMN "ry0"."sys_job"."status" IS '状态（0正常 1暂停）';

COMMENT ON COLUMN "ry0"."sys_job"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_job"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_job"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_job"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_job"."remark" IS '备注信息';

COMMENT ON TABLE "ry0"."sys_job_log" IS '定时任务调度日志表';

COMMENT ON COLUMN "ry0"."sys_job_log"."job_log_id" IS '任务日志ID';

COMMENT ON COLUMN "ry0"."sys_job_log"."job_name" IS '任务名称';

COMMENT ON COLUMN "ry0"."sys_job_log"."job_group" IS '任务组名';

COMMENT ON COLUMN "ry0"."sys_job_log"."invoke_target" IS '调用目标字符串';

COMMENT ON COLUMN "ry0"."sys_job_log"."job_message" IS '日志信息';

COMMENT ON COLUMN "ry0"."sys_job_log"."status" IS '执行状态（0正常 1失败）';

COMMENT ON COLUMN "ry0"."sys_job_log"."exception_info" IS '异常信息';

COMMENT ON COLUMN "ry0"."sys_job_log"."create_time" IS '创建时间';

COMMENT ON TABLE "ry0"."sys_logininfor" IS '系统访问记录';

COMMENT ON COLUMN "ry0"."sys_logininfor"."info_id" IS '访问ID';

COMMENT ON COLUMN "ry0"."sys_logininfor"."login_name" IS '登录账号';

COMMENT ON COLUMN "ry0"."sys_logininfor"."ipaddr" IS '登录IP地址';

COMMENT ON COLUMN "ry0"."sys_logininfor"."login_location" IS '登录地点';

COMMENT ON COLUMN "ry0"."sys_logininfor"."browser" IS '浏览器类型';

COMMENT ON COLUMN "ry0"."sys_logininfor"."os" IS '操作系统';

COMMENT ON COLUMN "ry0"."sys_logininfor"."status" IS '登录状态（0成功 1失败）';

COMMENT ON COLUMN "ry0"."sys_logininfor"."msg" IS '提示消息';

COMMENT ON COLUMN "ry0"."sys_logininfor"."login_time" IS '访问时间';

COMMENT ON TABLE "ry0"."sys_menu" IS '菜单权限表';

COMMENT ON COLUMN "ry0"."sys_menu"."menu_id" IS '菜单ID';

COMMENT ON COLUMN "ry0"."sys_menu"."menu_name" IS '菜单名称';

COMMENT ON COLUMN "ry0"."sys_menu"."parent_id" IS '父菜单ID';

COMMENT ON COLUMN "ry0"."sys_menu"."order_num" IS '显示顺序';

COMMENT ON COLUMN "ry0"."sys_menu"."url" IS '请求地址';

COMMENT ON COLUMN "ry0"."sys_menu"."target" IS '打开方式（menuItem页签 menuBlank新窗口）';

COMMENT ON COLUMN "ry0"."sys_menu"."menu_type" IS '菜单类型（M目录 C菜单 F按钮）';

COMMENT ON COLUMN "ry0"."sys_menu"."visible" IS '菜单状态（0显示 1隐藏）';

COMMENT ON COLUMN "ry0"."sys_menu"."is_refresh" IS '是否刷新（0刷新 1不刷新）';

COMMENT ON COLUMN "ry0"."sys_menu"."perms" IS '权限标识';

COMMENT ON COLUMN "ry0"."sys_menu"."icon" IS '菜单图标';

COMMENT ON COLUMN "ry0"."sys_menu"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_menu"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_menu"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_menu"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_menu"."remark" IS '备注';

COMMENT ON TABLE "ry0"."sys_notice" IS '通知公告表';

COMMENT ON COLUMN "ry0"."sys_notice"."notice_id" IS '公告ID';

COMMENT ON COLUMN "ry0"."sys_notice"."notice_title" IS '公告标题';

COMMENT ON COLUMN "ry0"."sys_notice"."notice_type" IS '公告类型（1通知 2公告）';

COMMENT ON COLUMN "ry0"."sys_notice"."notice_content" IS '公告内容';

COMMENT ON COLUMN "ry0"."sys_notice"."status" IS '公告状态（0正常 1关闭）';

COMMENT ON COLUMN "ry0"."sys_notice"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_notice"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_notice"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_notice"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_notice"."remark" IS '备注';

COMMENT ON TABLE "ry0"."sys_oper_log" IS '操作日志记录';

COMMENT ON COLUMN "ry0"."sys_oper_log"."oper_id" IS '日志主键';

COMMENT ON COLUMN "ry0"."sys_oper_log"."title" IS '模块标题';

COMMENT ON COLUMN "ry0"."sys_oper_log"."business_type" IS '业务类型（0其它 1新增 2修改 3删除）';

COMMENT ON COLUMN "ry0"."sys_oper_log"."method" IS '方法名称';

COMMENT ON COLUMN "ry0"."sys_oper_log"."request_method" IS '请求方式';

COMMENT ON COLUMN "ry0"."sys_oper_log"."operator_type" IS '操作类别（0其它 1后台用户 2手机端用户）';

COMMENT ON COLUMN "ry0"."sys_oper_log"."oper_name" IS '操作人员';

COMMENT ON COLUMN "ry0"."sys_oper_log"."dept_name" IS '部门名称';

COMMENT ON COLUMN "ry0"."sys_oper_log"."oper_url" IS '请求URL';

COMMENT ON COLUMN "ry0"."sys_oper_log"."oper_ip" IS '主机地址';

COMMENT ON COLUMN "ry0"."sys_oper_log"."oper_location" IS '操作地点';

COMMENT ON COLUMN "ry0"."sys_oper_log"."oper_param" IS '请求参数';

COMMENT ON COLUMN "ry0"."sys_oper_log"."json_result" IS '返回参数';

COMMENT ON COLUMN "ry0"."sys_oper_log"."status" IS '操作状态（0正常 1异常）';

COMMENT ON COLUMN "ry0"."sys_oper_log"."error_msg" IS '错误消息';

COMMENT ON COLUMN "ry0"."sys_oper_log"."oper_time" IS '操作时间';

COMMENT ON COLUMN "ry0"."sys_oper_log"."cost_time" IS '消耗时间';

COMMENT ON TABLE "ry0"."sys_post" IS '岗位信息表';

COMMENT ON COLUMN "ry0"."sys_post"."post_id" IS '岗位ID';

COMMENT ON COLUMN "ry0"."sys_post"."post_code" IS '岗位编码';

COMMENT ON COLUMN "ry0"."sys_post"."post_name" IS '岗位名称';

COMMENT ON COLUMN "ry0"."sys_post"."post_sort" IS '显示顺序';

COMMENT ON COLUMN "ry0"."sys_post"."status" IS '状态（0正常 1停用）';

COMMENT ON COLUMN "ry0"."sys_post"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_post"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_post"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_post"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_post"."remark" IS '备注';

COMMENT ON TABLE "ry0"."sys_role" IS '角色信息表';

COMMENT ON COLUMN "ry0"."sys_role"."role_id" IS '角色ID';

COMMENT ON COLUMN "ry0"."sys_role"."role_name" IS '角色名称';

COMMENT ON COLUMN "ry0"."sys_role"."role_key" IS '角色权限字符串';

COMMENT ON COLUMN "ry0"."sys_role"."role_sort" IS '显示顺序';

COMMENT ON COLUMN "ry0"."sys_role"."data_scope" IS '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）';

COMMENT ON COLUMN "ry0"."sys_role"."status" IS '角色状态（0正常 1停用）';

COMMENT ON COLUMN "ry0"."sys_role"."del_flag" IS '删除标志（0代表存在 2代表删除）';

COMMENT ON COLUMN "ry0"."sys_role"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_role"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_role"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_role"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_role"."remark" IS '备注';

COMMENT ON TABLE "ry0"."sys_role_dept" IS '角色和部门关联表';

COMMENT ON COLUMN "ry0"."sys_role_dept"."role_id" IS '角色ID';

COMMENT ON COLUMN "ry0"."sys_role_dept"."dept_id" IS '部门ID';

COMMENT ON TABLE "ry0"."sys_role_menu" IS '角色和菜单关联表';

COMMENT ON COLUMN "ry0"."sys_role_menu"."role_id" IS '角色ID';

COMMENT ON COLUMN "ry0"."sys_role_menu"."menu_id" IS '菜单ID';

COMMENT ON TABLE "ry0"."sys_user" IS '用户信息表';

COMMENT ON COLUMN "ry0"."sys_user"."user_id" IS '用户ID';

COMMENT ON COLUMN "ry0"."sys_user"."dept_id" IS '部门ID';

COMMENT ON COLUMN "ry0"."sys_user"."login_name" IS '登录账号';

COMMENT ON COLUMN "ry0"."sys_user"."user_name" IS '用户昵称';

COMMENT ON COLUMN "ry0"."sys_user"."user_type" IS '用户类型（00系统用户 01注册用户）';

COMMENT ON COLUMN "ry0"."sys_user"."email" IS '用户邮箱';

COMMENT ON COLUMN "ry0"."sys_user"."phonenumber" IS '手机号码';

COMMENT ON COLUMN "ry0"."sys_user"."sex" IS '用户性别（0男 1女 2未知）';

COMMENT ON COLUMN "ry0"."sys_user"."avatar" IS '头像路径';

COMMENT ON COLUMN "ry0"."sys_user"."password" IS '密码';

COMMENT ON COLUMN "ry0"."sys_user"."salt" IS '盐加密';

COMMENT ON COLUMN "ry0"."sys_user"."status" IS '帐号状态（0正常 1停用）';

COMMENT ON COLUMN "ry0"."sys_user"."del_flag" IS '删除标志（0代表存在 2代表删除）';

COMMENT ON COLUMN "ry0"."sys_user"."login_ip" IS '最后登录IP';

COMMENT ON COLUMN "ry0"."sys_user"."login_date" IS '最后登录时间';

COMMENT ON COLUMN "ry0"."sys_user"."pwd_update_date" IS '密码最后更新时间';

COMMENT ON COLUMN "ry0"."sys_user"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."sys_user"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."sys_user"."update_by" IS '更新者';

COMMENT ON COLUMN "ry0"."sys_user"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."sys_user"."remark" IS '备注';

COMMENT ON TABLE "ry0"."sys_user_online" IS '在线用户记录';

COMMENT ON COLUMN "ry0"."sys_user_online"."sessionId" IS '用户会话id';

COMMENT ON COLUMN "ry0"."sys_user_online"."login_name" IS '登录账号';

COMMENT ON COLUMN "ry0"."sys_user_online"."dept_name" IS '部门名称';

COMMENT ON COLUMN "ry0"."sys_user_online"."ipaddr" IS '登录IP地址';

COMMENT ON COLUMN "ry0"."sys_user_online"."login_location" IS '登录地点';

COMMENT ON COLUMN "ry0"."sys_user_online"."browser" IS '浏览器类型';

COMMENT ON COLUMN "ry0"."sys_user_online"."os" IS '操作系统';

COMMENT ON COLUMN "ry0"."sys_user_online"."status" IS '在线状态on_line在线off_line离线';

COMMENT ON COLUMN "ry0"."sys_user_online"."start_timestamp" IS 'session创建时间';

COMMENT ON COLUMN "ry0"."sys_user_online"."last_access_time" IS 'session最后访问时间';

COMMENT ON COLUMN "ry0"."sys_user_online"."expire_time" IS '超时时间，单位为分钟';

COMMENT ON TABLE "ry0"."sys_user_post" IS '用户与岗位关联表';

COMMENT ON COLUMN "ry0"."sys_user_post"."user_id" IS '用户ID';

COMMENT ON COLUMN "ry0"."sys_user_post"."post_id" IS '岗位ID';

COMMENT ON TABLE "ry0"."sys_user_role" IS '用户和角色关联表';

COMMENT ON COLUMN "ry0"."sys_user_role"."user_id" IS '用户ID';

COMMENT ON COLUMN "ry0"."sys_user_role"."role_id" IS '角色ID';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."id" IS '表id';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."timepoint" IS '时间点';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."area" IS '城市';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."citycode" IS '城市编码';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."provinceid" IS '省编码';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."provincename" IS '省名称';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."positionname" IS '监测点名';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."stationcode" IS '监测点编码';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."co" IS 'co';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."co_24h" IS '24小时co';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."latitude" IS '纬度';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."longitude" IS '经度';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."measure" IS '建议';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."no2" IS 'no2';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."no2_24h" IS '24小时no2';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."o3" IS 'o3';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."o3_24h" IS '24小时o3';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."o3_8h" IS '8小时o3';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."pm10" IS 'pm10';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."pm10_24h" IS '24小时pm10';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."pm2_5" IS 'pm2.5';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."pm2_5_24h" IS '24小时pm2.5';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."so2" IS 'so2';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."so2_24h" IS '24小时so2';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."aqi" IS 'aqi';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."colevel" IS 'co等级';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."no2level" IS 'no2等级';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."o3level" IS 'o3等级';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."pm10level" IS 'pm10等级';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."pm2_5level" IS 'pm2.5等级';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."so2level" IS 'so2等级';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."primarypollutant" IS '主要污染物';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."quality" IS '空气质量';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."unheathful" IS '健康影响';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."create_by" IS '创建者';

COMMENT ON COLUMN "ry0"."tq_aqi_station"."create_time" IS '创建时间';

COMMENT ON TABLE "ry0"."tq_city" IS '城市';

COMMENT ON COLUMN "ry0"."tq_city"."id" IS '城市ID';

COMMENT ON COLUMN "ry0"."tq_city"."city_code" IS '城市编码';

COMMENT ON COLUMN "ry0"."tq_city"."city_name" IS '城市名称';

COMMENT ON COLUMN "ry0"."tq_city"."province_id" IS '所属省编码';

COMMENT ON COLUMN "ry0"."tq_city"."province_name" IS '所属省名称';

COMMENT ON COLUMN "ry0"."tq_city"."city_jc" IS '城市拼音';

COMMENT ON COLUMN "ry0"."tq_city"."create_time" IS '创建人';

COMMENT ON COLUMN "ry0"."tq_city"."create_by" IS '创建时间';

COMMENT ON COLUMN "ry0"."tq_city"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."tq_city"."update_by" IS '更新人';

COMMENT ON COLUMN "ry0"."tq_city"."flag" IS '有效标志';

COMMENT ON TABLE "ry0"."tq_city_aqi" IS '城市AQI';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."id" IS '表ID';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."timepoint" IS '时间点';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."colevel" IS 'CO等级';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."no2level" IS 'NO2等级';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."o3level" IS 'O3等级';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."pm10level" IS 'PM10等级';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."pm2_5level" IS 'PM2.5等级';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."so2level" IS 'SO2等级';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."area" IS '区域';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."citycode" IS '城市代码';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."co" IS 'CO';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."no2" IS 'NO2';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."o3" IS 'O3';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."pm10" IS 'PM10';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."pm2_5" IS 'PM2.5';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."so2" IS 'SO2';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."aqi" IS 'AQI';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."primarypollutant" IS '主要污染物';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."quality" IS '空气质量';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."measure" IS '建议';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."Unheathful" IS '健康影响';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."create_by" IS '创建人';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."update_by" IS '更新人';

COMMENT ON COLUMN "ry0"."tq_city_aqi"."flag" IS '有效标志';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."id" IS '编号';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."timepoint" IS '时间点';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."citycode" IS '城市编码';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."cityname" IS '城市名称';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."forecastDate" IS '预测日期';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."day" IS '距离现在时间';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."aqi" IS 'AQI';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."quality" IS '空气质量';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."primarypollutant" IS '首要污染物';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."create_by" IS '创建人';

COMMENT ON COLUMN "ry0"."tq_city_forecast"."create_time" IS '创建时间';

COMMENT ON TABLE "ry0"."tq_province" IS '省份';

COMMENT ON COLUMN "ry0"."tq_province"."id" IS '省ID';

COMMENT ON COLUMN "ry0"."tq_province"."province_code" IS '省编码';

COMMENT ON COLUMN "ry0"."tq_province"."province_name" IS '省名称';

COMMENT ON COLUMN "ry0"."tq_province"."province_jc" IS '省拼音';

COMMENT ON COLUMN "ry0"."tq_province"."create_time" IS '创建时间';

COMMENT ON COLUMN "ry0"."tq_province"."create_by" IS '创建人';

COMMENT ON COLUMN "ry0"."tq_province"."update_time" IS '更新时间';

COMMENT ON COLUMN "ry0"."tq_province"."update_by" IS '更新人';

COMMENT ON COLUMN "ry0"."tq_province"."flag" IS '有效标志';

