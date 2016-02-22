CREATE TABLE department
(
  id bigint NOT NULL,
  name character varying(255),
  address character varying(255),
  description character varying(255),
  CONSTRAINT department_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE department
  OWNER TO postgres;

CREATE SEQUENCE department_id_seq;
ALTER TABLE department_id_seq
  OWNER TO postgres;
  
  
insert into department (id,name,address,description)  values(1,'first','adr1', 'description1');
insert into department (id,name,address,description)  values(2,'second','adr2', 'description2');
insert into department (id,name,address,description)  values(3,'third','adr3', 'description3');