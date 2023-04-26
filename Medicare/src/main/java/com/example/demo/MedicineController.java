package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin(origins = "*")
public class MedicineController {

	@Autowired
	MedicineService servicem;
	
	@PostMapping("/insert")
	public ResponseEntity<Medicine> insert(@RequestBody Medicine medicine){
		Medicine m=servicem.insert(medicine);
		if(m!=null) {
			return new ResponseEntity<Medicine>(m,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Medicine>(m,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getall")
	public List<Medicine> getall(){
		List<Medicine> med=servicem.getmedicine();
		if(med!=null) {
			return med;
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Medicine> getbyid(@PathVariable int id){
		Medicine m=servicem.getmedbyid(id);
		if(m!=null) {
			return new ResponseEntity<Medicine>(m,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Medicine>(m,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getbycategory/{category}")
	public List<Medicine> getbycategory(@PathVariable String category){
		List<Medicine> m=servicem.getbycategory(category);
		if(m!=null) {
			return m;
		}
		else {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getbyname/{name}")
	public List<Medicine> getbyname(@PathVariable String name){
		List<Medicine> med=servicem.getbyname(name);
		if(med!=null) {
			return med;
		}
		else {
			return (List<Medicine>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Medicine>> delete(@PathVariable int id){
		List<Medicine> med=servicem.deletemedicine(id);
		if(med!=null) {
			return ResponseEntity.ok(servicem.getmedicine()); 
		}
		else {
			return ResponseEntity.ok(servicem.deletemedicine(id));
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Medicine med){
		Medicine oldmed= servicem.updatemedicine(id,med);
		if(oldmed!=null) {
			return new ResponseEntity<Object>(oldmed,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(oldmed,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/active")
	public List<Medicine> getactiveMed(){
		return servicem.getactivemedicine();
	}
	
	@GetMapping("/category/active/{category}")
	public List<Medicine> getmedbyactivecategory(@PathVariable String category){
		return servicem.getmedbyactivecategory(category);
	}
	
	}