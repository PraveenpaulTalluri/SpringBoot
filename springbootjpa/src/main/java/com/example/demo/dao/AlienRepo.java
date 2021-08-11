package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>
{
	List<Alien> findByTech(String tech);
	
	List<Alien> findByAidGreaterThan(int aid);
}
