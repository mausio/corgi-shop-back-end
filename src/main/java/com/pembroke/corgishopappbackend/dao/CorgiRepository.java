package com.pembroke.corgishopappbackend.dao;

import com.pembroke.corgishopappbackend.entity.Corgi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorgiRepository extends JpaRepository<Corgi, Integer> {

    Corgi findCorgiByUuid(String uuid);

}