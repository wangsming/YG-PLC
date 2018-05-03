package com.ming.plc.repository;

import com.ming.plc.entity.PlasticPipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlasticpipeI extends JpaRepository<PlasticPipe, Long>, JpaSpecificationExecutor<PlasticPipe> {


}
