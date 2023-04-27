import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MedicineserviceService {

  constructor(private http:HttpClient) { }
  public getmedicines(){
    return this.http.get("http://localhost:8092/api/medicine/getall");
  }

  public getbyname(name:any){
    return this.http.get("http://localhost:8092/api/medicine/getbyname"+name);
  }

  public getbycategory(category:any){
    return this.http.get("http://localhost:8092/api/medicine/getbycategory/"+category);
  }

  public doinsertuser(user:any){
    return this.http.post("http://localhost:8092/user/insert",user,{responseType:'text' as 'json'}); 
  }

  public getuserbyname(username:any){
    return this.http.get("http://localhost:8092/user/view/"+username);
  }
}


