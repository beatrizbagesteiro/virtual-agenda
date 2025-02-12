package com.virtualagenda.virtual_agenda.service;

import com.virtualagenda.virtual_agenda.entity.*;
import com.virtualagenda.virtual_agenda.entity.EstablishmentService;
import com.virtualagenda.virtual_agenda.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class AppointmentService {
/*
    private final EstablishmentServiceRepository establishmentServiceRepository;
    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;
    private final WorkingDaysRepository workingDaysRepository;


    public AppointmentService(AppointmentRepository appointmentRepository, UserRepository userRepository, WorkingDaysRepository workingDaysRepository) {
        this.appointmentRepository = appointmentRepository;
        this.establishmentServiceRepository = establishmentServiceRepository;
        this.userRepository = userRepository;
        this.workingDaysRepository = workingDaysRepository;

    }


    public List<EstablishmentService> getServices(){
        return establishmentServiceRepository.findAll();
    }

    public List<User> getProfessionalsByService(EstablishmentService requiredEstablishmentService){
        return requiredEstablishmentService.getProfessionals();
    }
    
    public List<LocalTime> getAvailableTimeSlot(User requiredProfessional, LocalDate requiredDate, EstablishmentService requiredEstablishmentService){
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
            openingHour = openingHour.plusMinutes(requiredEstablishmentService.getDuration());
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

     */



}
