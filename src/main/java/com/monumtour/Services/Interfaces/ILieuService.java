package com.monumtour.Services.Interfaces;

import com.monumtour.Model.Lieu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ILieuService {


    Lieu updateLieu(Lieu l);
    Lieu saveLieu(Lieu l);
    void deleteLieuById(String id);
    Lieu getLieu(String id);
    List<Lieu> getAllLieux();
    List<Lieu> findByCodeInsee(String CodeInsee);
}
