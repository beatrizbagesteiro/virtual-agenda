package com.virtualagenda.virtual_agenda.repository;

import com.virtualagenda.virtual_agenda.entity.User;
import com.virtualagenda.virtual_agenda.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUserType(UserType userType);

}
