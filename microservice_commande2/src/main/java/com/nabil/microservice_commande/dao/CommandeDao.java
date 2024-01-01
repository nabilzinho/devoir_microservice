package com.nabil.microservice_commande.dao;
import com.nabil.microservice_commande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//@Repository est une annotation Spring pour indiquer que la classe est un bean,
//et que son rôle est de communiquer avec une source de données (en l'occurrence la base de données).
//@Repository est une spécialisation de @Component.
//Tout comme @Component, elle permet de déclarer auprès de Spring qu’une classe est un bean à exploiter.
@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer>{
    @Query("SELECT c FROM Commande c WHERE c.date >= :date")
    List<Commande> findByDateAfter(LocalDate date);

}

