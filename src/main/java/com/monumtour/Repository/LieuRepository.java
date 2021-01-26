package com.monumtour.Repository;

import com.monumtour.Model.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LieuRepository extends JpaRepository<Lieu,String> {

    List<Lieu> findByCodeInsee(String CodeInsee);
}
