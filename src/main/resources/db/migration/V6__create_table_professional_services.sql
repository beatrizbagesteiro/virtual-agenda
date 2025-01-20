CREATE TABLE professional_services(
    professional_id SERIAL,
    service_id SERIAL,
    PRIMARY KEY(professional_id,service_id),
    FOREIGN KEY(professional_id) REFERENCES application_user(id),
    FOREIGN KEY(service_id) REFERENCES service(id)
);