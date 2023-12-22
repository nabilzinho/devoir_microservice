package com.nabil.microservice_commande.dao;
import com.nabil.microservice_commande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository est une annotation Spring pour indiquer que la classe est un bean,
//et que son rôle est de communiquer avec une source de données (en l'occurrence la base de données).
//@Repository est une spécialisation de @Component.
//Tout comme @Component, elle permet de déclarer auprès de Spring qu’une classe est un bean à exploiter.
@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer>{
}

