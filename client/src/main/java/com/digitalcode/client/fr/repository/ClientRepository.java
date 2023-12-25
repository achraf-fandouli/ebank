package com.digitalcode.client.fr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalcode.client.fr.entity.jpa.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
