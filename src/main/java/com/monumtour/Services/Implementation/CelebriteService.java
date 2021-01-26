package com.monumtour.Services.Implementation;

import com.monumtour.Model.Celebrite;
import com.monumtour.Model.Monument;
import com.monumtour.Repository.CelebriteRepository;
import com.monumtour.Repository.MonumentRepository;
import com.monumtour.Services.Interfaces.ICelebriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CelebriteService implements ICelebriteService {

    @Autowired
    private CelebriteRepository celebriteRepository;
    @Autowired
    private MonumentRepository monumentRepository;
    @Override
    public List<Celebrite> findCelebriteByNom(String nom) {
        return celebriteRepository.findCelebriteByNom(nom);
    }

    @Override
    public Celebrite addCelebrite(Celebrite c) {
        celebriteRepository.save(c);
        return c;
    }

    @Override
    public Celebrite update(Celebrite c) {
        return null;
    }

    @Override
    public void deleteCelebrite(Long numCelebrite) {
        celebriteRepository.deleteById(numCelebrite);
    }

    @Override
    public Collection<Celebrite> getCelebriteParMonument(String codeMonument) {
        return monumentRepository.getOne(codeMonument).getCelebrites();
    }

    @Override
    public Collection<Celebrite> getAllCelebrites() {
        return celebriteRepository.findAll();
    }

    @Override
    public Page<Celebrite> getAllCelebritesParPage(int page, int size) {
        // TODO Auto-generated method stub
        return celebriteRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Celebrite getCelebriteParId(Long id) {
        return celebriteRepository.findById(id).get();
    }

    @Override
    public void addCelebriteToMonument(Long numCelebrite, String codeM) {
        Monument monument = monumentRepository.getOne(codeM);
        Celebrite celebrite = celebriteRepository.getOne(numCelebrite);
        celebrite.getMonuments().add(monument);
        monument.getCelebrites().add(celebrite);
    }
}
