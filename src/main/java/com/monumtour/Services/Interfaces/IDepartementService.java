package com.monumtour.Services.Interfaces;

import com.monumtour.Model.Departement;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IDepartementService {
    Departement saveDepartement(Departement d);
    Departement updateDepartement(Departement d);
    void deleteDepartementById(String id);
    Departement getDepartement(String id);
    List<Departement> getAllDepartements();

}
