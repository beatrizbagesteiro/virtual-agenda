package com.virtualagenda.virtual_agenda.repository;

import com.virtualagenda.virtual_agenda.entity.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment,Long> {


}
