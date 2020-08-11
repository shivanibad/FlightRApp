package com.shivi.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivi.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
