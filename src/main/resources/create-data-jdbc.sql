CREATE TABLE public.professores
(
   id bigserial NOT NULL, 
   codigo character varying(256) NOT NULL, 
   nome character varying(32) NOT NULL, 
   email character varying(32) NOT NULL,
   fone character varying(15) NOT NULL,
   PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;