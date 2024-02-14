package com.worker.worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worker.worker.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer>{

}
