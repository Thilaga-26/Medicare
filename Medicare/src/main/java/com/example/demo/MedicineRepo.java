package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicineRepo extends JpaRepository<Medicine, Integer> {
	
	@Query(value="select * from Medicine m where m.category=?",nativeQuery = true)
	public List<Medicine> findbycategory(String category);
	
	@Query(value="select * from Medicine m where m.name=?",nativeQuery = true)
	public List<Medicine> findbyname(String name);
	
	@Query(value="select * from Medicine m where active=true?",nativeQuery = true)
	public List<Medicine> findbyactive(boolean active);
	
	@Query(value="select * from Medicine m where active=?1 and category=?2",nativeQuery = true)
	public List<Medicine> findbyActiveCategory(boolean active,String category);

}
