package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {
	
	@Autowired
	MedicineRepo repom;
	
	public Medicine insert(Medicine medicine) {
		return repom.save(medicine);
	}
	
	public List<Medicine> getmedicine(){
		return repom.findAll();
	}
	
	public Medicine getmedbyid(int id) {
		if(repom.findById(id).isPresent()) {
			return repom.findById(id).get();
		}
			else {
				return null;
			}
	}
	
	public List<Medicine> getbyname(String name){
		List<Medicine> med=repom.findbyname(name);
		if(med!=null)
			return med;
		else
			return null;
	}
	
	public List<Medicine> getbycategory(String category){
		
		List<Medicine> name=(List<Medicine>)repom.findbycategory(category);
		return name;
	}
	
	public List<Medicine> deletemedicine(int id){
		if(repom.findById(id)!=null) {
			repom.deleteById(id);
			return repom.findAll();
		}
		else {
			return null;
		}
	}
	
	public Medicine updatemedicine(int id, Medicine newMed) {
		if(repom.findById(id).isPresent()) {
			Medicine oldmed=repom.findById(id).get();
			
			oldmed.setName(newMed.getName());
			oldmed.setDescription(newMed.getDescription());
			oldmed.setCategory(newMed.getCategory());
			oldmed.setMfg_date(newMed.getMfg_date());
			oldmed.setPrice(newMed.getPrice());
			
			return repom.save(oldmed);
		}
		else {
			return null;
		}
	}
	
	public List<Medicine> getactivemedicine(){
		return repom.findbyactive(true);
	}
	
	public List<Medicine> getmedbyactivecategory(String category){
		return repom.findbyActiveCategory(true, category);
	}

}
