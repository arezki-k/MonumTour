package com.monumtour.Services.Interfaces;

import com.monumtour.Model.Celebrite;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ICelebriteService {

    //Crud operation
    //GET
    //by nom
    public List<Celebrite> findCelebriteByNom(String nom);
    //Celebrite par monument
    public Collection<Celebrite> getCelebriteParMonument(String codeMonument);
    //ALL
    public Collection<Celebrite> getAllCelebrites();

    //ADD
    public Celebrite addCelebrite(Celebrite c);
    //Ajouter Celebrite a un monument
    public void addCelebriteToMonument(Long numCelebrite, String codeM);

    //UPDATE
    Celebrite update(Celebrite c);

    //delete
    public void deleteCelebrite(Long numCelebrite);

    //PerPAge
    Page<Celebrite> getAllCelebritesParPage(int page, int size);


    Celebrite getCelebriteParId(Long id);
}
