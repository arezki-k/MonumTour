package com.monumtour.Repository;

import com.monumtour.Model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, String> {

}
