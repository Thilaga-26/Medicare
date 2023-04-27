import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { Medicine } from '../medicine';

@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css']
})
export class MedicineComponent implements OnInit {

  medicine:Medicine=new Medicine();
  constructor(private service:AdminserviceService){}
  message:any
  ngOnInit(): void {
    
  }

  public insertnow(){
    let response=this.service.doinsert(this.medicine);
    response.subscribe((data:any)=>this.message=data);
    alert("inserted successfully "+this.medicine.name);
  }

}
