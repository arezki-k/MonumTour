package com.monumtour.Repository;

import com.monumtour.Model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, String> {


}
