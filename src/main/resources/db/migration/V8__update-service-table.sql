ALTER TABLE service RENAME TO establishment_service;

ALTER TABLE professional_services DROP CONSTRAINT professional_services_service_id_fkey;

ALTER TABLE professional_services
ADD CONSTRAINT professional_services_service_id_fkey
FOREIGN KEY (service_id)
REFERENCES establishment_service(id);
