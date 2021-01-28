package com.monumtour.Services.Interfaces;

import com.monumtour.Model.Monument;

import java.util.List;

public interface IMonumentService {


    Monument saveMonument(Monument m);
    Monument updateMonument(Monument m);
    void deleteMonumentById(String id);
    Monument getMonument(String id);
    List<Monument> getAllMonuments();
    float distance(String codeM1, String codeM2);
}
