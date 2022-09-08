package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer>{

	List<Farmer> farmerList = new ArrayList<Farmer>();

}
