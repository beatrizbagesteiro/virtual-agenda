package com.virtualagenda.virtual_agenda.service;

import com.virtualagenda.virtual_agenda.dto.WorkingDaysDTO;
import com.virtualagenda.virtual_agenda.entity.WorkingDays;
import com.virtualagenda.virtual_agenda.repository.WorkingDaysRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingDaysService {
    private final WorkingDaysRepository repository;
    public WorkingDaysService(WorkingDaysRepository repository){
        this.repository = repository;
    }

    public List<WorkingDays> getWorkingDays(){
        return repository.findAll();
    }

    public String registerWorkingDay(WorkingDaysDTO data){
        WorkingDays workingDay = new WorkingDays(data);
        repository.save(workingDay);
        return "Working day registered successfully";
    }

    public String updateWorkingDay(WorkingDaysDTO data){
        WorkingDays workingDay = repository.getReferenceById(data.id());
        workingDay.setDayOfWeek(data.dayOfWeek());
        workingDay.setOpeningHour(data.openingHour());
        workingDay.setClosingHour(data.closingHour());
        repository.save(workingDay);
        return "Working day updated successfully";
    }

    public String deleteWorkingDay(WorkingDaysDTO data){
        WorkingDays workingDay = repository.getReferenceById(data.id());
        repository.delete(workingDay);
        return "Working day deleted successfully";
    }

}
