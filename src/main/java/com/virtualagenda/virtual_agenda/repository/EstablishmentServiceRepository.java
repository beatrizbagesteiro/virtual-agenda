package com.virtualagenda.virtual_agenda.repository;

import com.virtualagenda.virtual_agenda.entity.EstablishmentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentServiceRepository extends JpaRepository<EstablishmentService, Long> {
}
