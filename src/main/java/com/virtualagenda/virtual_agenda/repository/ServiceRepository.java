package com.virtualagenda.virtual_agenda.repository;

import com.virtualagenda.virtual_agenda.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
