import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MedicineComponent } from './medicine/medicine.component';
import { ViewmedicineComponent } from './viewmedicine/viewmedicine.component';
import { RouterModule,Routes } from '@angular/router';
import { AdminserviceService } from './adminservice.service';

const routes:Routes=[

  {
    path:"",redirectTo:"medicine",pathMatch:"full"
  },
  {
    path:"medicine",component:MedicineComponent
  },
  {
    path:"viewmedicine",component:ViewmedicineComponent
  }
  ]

@NgModule({
  declarations: [
    AppComponent,
    MedicineComponent,
    ViewmedicineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    [RouterModule.forRoot(routes)]
  ],
  providers: [AdminserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
