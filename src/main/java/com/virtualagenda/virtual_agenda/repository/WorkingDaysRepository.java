package com.virtualagenda.virtual_agenda.repository;

import com.virtualagenda.virtual_agenda.entity.WorkingDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingDaysRepository extends JpaRepository<WorkingDays, Long> {
}
