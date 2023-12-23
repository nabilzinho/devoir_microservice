package com.nabil.microservice_commande.web.controller;

import com.nabil.microservice_commande.configurations.ApplicationPropertiesConfiguration;
import com.nabil.microservice_commande.dao.CommandeDao;
import com.nabil.microservice_commande.model.Commande;
import com.nabil.microservice_commande.web.exceptions.CommandeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController implements HealthIndicator {
    @Autowired
    CommandeDao commandedao;
    @Autowired
    ApplicationPropertiesConfiguration appProperties;
    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/Produits")
    public List<Commande> listeDesProduits() throws CommandeNotFoundException {
        System.out.println(" ********* CommandeController listeDesProduits() ");
        List<Commande> Commandes = commandedao.findAll();
        if (Commandes.isEmpty())
            throw new CommandeNotFoundException("Aucun produit n'est disponible à la vente");
        LocalDate tenDaysAgo = LocalDate.now().minusDays(appProperties.getCommandes_last());

        // Retrieve commands from the last 10 days
        List<Commande> commandesLast10Days = commandedao.findByDateAfter(tenDaysAgo);

        return commandesLast10Days;


    }

    // Supprimer un produit par son id
    @DeleteMapping(value = "/Produits/{id}")
    public void supprimerProduit(@PathVariable int id) throws CommandeNotFoundException {
        System.out.println(" ********* CommandeController supprimerProduit(@PathVariable int id) ");
        Optional<Commande> commande = commandedao.findById(id);
        if (!commande.isPresent())
            throw new CommandeNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

        commandedao.deleteById(id);
    }
    // Récuperer un produit par son id
    @GetMapping(value = "/Produits/{id}")
    public Optional<Commande> recupererUnProduit(@PathVariable int id) throws CommandeNotFoundException {
        System.out.println(" ********* CommandeController recupererUnProduit(@PathVariable int id) ");
        Optional<Commande> Commande = commandedao.findById(id);
        if (!Commande.isPresent())
            throw new CommandeNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");
        return Commande;
    }
    @Override
    public Health health() {
        System.out.println("****** Actuator : CommandeController health() ");
        List<Commande> Commandes = commandedao.findAll();
        if (Commandes.isEmpty()) {
            return Health.down().build();
        }
        return Health.up().build();
    }
}