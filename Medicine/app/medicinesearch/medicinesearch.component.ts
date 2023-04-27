import { Component, OnInit } from '@angular/core';
import { MedicineserviceService } from '../medicineservice.service';
@Component({
  selector: 'app-medicinesearch',
  templateUrl: './medicinesearch.component.html',
  styleUrls: ['./medicinesearch.component.css']
})
export class MedicinesearchComponent implements OnInit {

  name:any;
  category:any;
  medicines:any;
  message:any;

  constructor(private service:MedicineserviceService){}

  public findbyname(){
    let response=this.service.getbyname(this.name);
    response.subscribe((data:any)=>this.medicines=data);
  }

  public findbycategory(){
    let response=this.service.getbycategory(this.category);
    response.subscribe((data:any)=>this.medicines=data); 
  }

  ngOnInit(): void {
    let response=this.service.getmedicines();
    response.subscribe((data:any)=>this.medicines=data);
  }


}
