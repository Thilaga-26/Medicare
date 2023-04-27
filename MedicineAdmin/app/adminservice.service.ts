import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  constructor(private http:HttpClient) { }

  public doinsert(medicine:any){
    return this.http.post("http://localhost:8092/api/medicine/insert",medicine,{responseType:'text' as 'json'});
  }

  public getuser(){
    return this.http.get("http://localhost:8092/user/viewall")
  }

  public deleteuser(userid:any){
    return this.http.delete("http://localhost:8092/user/delete/"+userid)
  }

  public getmedicines(){
    return this.http.get("http://localhost:8092/api/medicine/getall");
  }

  public deletemedicine(id:any){
    return this.http.delete("http://localhost:8092/medicine/delete/"+id);
  }

  public getadminbyname(name:any){
    return this.http.get("http://localhost:8092/admin/viewadmin/"+name)
  }

}
