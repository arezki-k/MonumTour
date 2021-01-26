package com.monumtour.Repository;

import com.monumtour.Model.Celebrite;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CelebriteRepository extends JpaRepository<Celebrite, Long> {


    List<Celebrite> findCelebriteByNom(String nom);




}
