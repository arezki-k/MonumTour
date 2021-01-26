package com.monumtour.Services.Implementation;

import com.monumtour.Model.Monument;
import com.monumtour.Repository.MonumentRepository;
import com.monumtour.Services.Interfaces.IMonumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MonumentService implements IMonumentService {

    @Autowired
    private MonumentRepository monumentRepository;

    @Override
    public Monument saveMonument(Monument m) {
        return monumentRepository.save(m);
    }

    @Override
    public Monument updateMonument(Monument m) {
        return monumentRepository.save(m);
    }

    @Override
    public void deleteMonumentById(String id) {
        monumentRepository.deleteById(id);
    }

    @Override
    public Monument getMonument(String id) {
        return monumentRepository.findById(id).get();
    }

    @Override
    public List<Monument> getAllMonuments() {
        return monumentRepository.findAll();
    }
}
