package com.virtualagenda.virtual_agenda.repository;

import com.virtualagenda.virtual_agenda.entity.User;
import com.virtualagenda.virtual_agenda.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> getUsersByUserType(UserType userType);
}
