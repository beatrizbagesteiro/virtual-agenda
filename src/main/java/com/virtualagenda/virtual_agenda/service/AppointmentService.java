package com.virtualagenda.virtual_agenda.service;

import com.virtualagenda.virtual_agenda.entity.*;
import com.virtualagenda.virtual_agenda.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class AppointmentService {

    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;
    private final WorkingDaysRepository workingDaysRepository;
    private final EstablishmentRepository establishmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, ServiceRepository serviceRepository, UserRepository userRepository, WorkingDaysRepository workingDaysRepository, EstablishmentRepository establishmentRepository) {
        this.appointmentRepository = appointmentRepository;
        this.serviceRepository = serviceRepository;
        this.userRepository = userRepository;
        this.workingDaysRepository = workingDaysRepository;
        this.establishmentRepository = establishmentRepository;
    }

    public List<com.virtualagenda.virtual_agenda.entity.Service> getServices(){
        return serviceRepository.findAll();
    }

    public List<User> getProfessionalsByService(com.virtualagenda.virtual_agenda.entity.Service requiredService){
        return requiredService.getProfessionals();
    }
    
    public List<LocalTime> getAvailableTimeSlot(User requiredProfessional, LocalDate requiredDate, com.virtualagenda.virtual_agenda.entity.Service requiredService){
        List<LocalTime> timeBlocks = new ArrayList<>();

        Long establishmentId = requiredProfessional.getEstablishment().getId();

        LocalTime openingHour = workingDaysRepository.findById(establishmentId)
                .map(WorkingDays::getOpeningHour)
                .orElseThrow(() -> new IllegalArgumentException("Establishment not found"));

        LocalTime closingHour = workingDaysRepository.findById(establishmentId)
                .map(WorkingDays::getClosingHour)
                .orElseThrow(() -> new IllegalArgumentException("Establishment not found"));

        while(!openingHour.isAfter(closingHour)){
            timeBlocks.add(openingHour);
            openingHour = openingHour.plusMinutes(requiredService.getDuration());
        }


        List<Appointment> professionalAppointments = requiredProfessional.getProfessionalAppointments();
        if(!professionalAppointments.isEmpty()){
            List<LocalTime> unavailableTimeSlot = new ArrayList<>();
            for(Appointment a: professionalAppointments){
                if(a.getDate() == requiredDate) {
                    unavailableTimeSlot.add(a.getTime());
                }
            }


            for (int i = timeBlocks.size() - 1; i >= 0; i--) {
                if (unavailableTimeSlot.contains(timeBlocks.get(i))) {
                    timeBlocks.remove(i);
                }
            }
        }

        return  timeBlocks;
    }

}
