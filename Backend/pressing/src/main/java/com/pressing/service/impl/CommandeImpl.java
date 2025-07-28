package com.pressing.service.impl;

import com.pressing.dao.CommandeDao;
import com.pressing.enums.StatutCommande;
import com.pressing.models.CommandeEntity;
import com.pressing.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeImpl implements CommandeService {

    private final CommandeDao commandeRepository;

    @Autowired
    public CommandeImpl(CommandeDao commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public CommandeEntity saveCommande(CommandeEntity commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<CommandeEntity> getAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<CommandeEntity> getArticleById(Integer id) {
        return commandeRepository.findById(id);
    }

    @Override
    public void deleteCommande(Integer id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public double calculerTotal(Integer idCommande) {
        Optional<CommandeEntity> optional = commandeRepository.findById(idCommande);
        if (optional.isPresent()) {
            CommandeEntity commande = optional.get();
            double total = commande.getLigneArticleList().stream()
                    .mapToDouble(l -> l.getQuantite() * l.getPrixUnitaire())
                    .sum();
            commande.setTotal(total);
            commandeRepository.save(commande);
            return total;
        }
        throw new RuntimeException("Commande introuvable");
    }
    @Override
    public void changerStatut(Integer idCommande, StatutCommande nouveauStatut) {
        Optional<CommandeEntity> optional = commandeRepository.findById(idCommande);
        if (optional.isPresent()) {
            CommandeEntity commande = optional.get();
            commande.setStatut(nouveauStatut);
            commandeRepository.save(commande);
        } else {
            throw new RuntimeException("Commande introuvable");
        }
    }
}
