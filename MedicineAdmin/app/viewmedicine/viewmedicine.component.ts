import { Component,OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-viewmedicine',
  templateUrl: './viewmedicine.component.html',
  styleUrls: ['./viewmedicine.component.css']
})
export class ViewmedicineComponent implements OnInit {

  medicines:any;
  constructor(private service:AdminserviceService){}

  public deletemedicine(id:number){
    let response=this.service.deletemedicine(id);
    response.subscribe((data:any)=>this.medicines=data);
    alert("deleted "+this.medicines.name+" successfully");
  }

  ngOnInit(): void {
    let response=this.service.getmedicines();
    response.subscribe((data:any)=>this.medicines=data);
  }

}
