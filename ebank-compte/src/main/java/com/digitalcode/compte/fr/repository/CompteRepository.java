package com.digitalcode.compte.fr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalcode.compte.fr.entity.jpa.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

}
