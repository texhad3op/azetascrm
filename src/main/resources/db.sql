CREATE SEQUENCE department_id_seq;
ALTER TABLE department_id_seq
  OWNER TO postgres;

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


  
  
insert into department (id,name,address,description)  values(1,'first','adr1', 'description1');
insert into department (id,name,address,description)  values(2,'second','adr2', 'description2');
insert into department (id,name,address,description)  values(3,'third','adr3', 'description3');

CREATE SEQUENCE worker_id_seq;
ALTER TABLE worker_id_seq
  OWNER TO postgres;
  
CREATE TABLE worker
(
  id bigint NOT NULL,
  firstname character varying(255),
  lastname character varying(255),
  phone character varying(255),
  email character varying(255),
  description text,
  department_id bigint NOT NULL,
  CONSTRAINT worker_pkey PRIMARY KEY (id),
  CONSTRAINT department_fk FOREIGN KEY (department_id)
      REFERENCES department (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE worker
  OWNER TO postgres; 