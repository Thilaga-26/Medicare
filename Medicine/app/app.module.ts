import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { MedicinesearchComponent } from './medicinesearch/medicinesearch.component';
import { BookComponent } from './book/book.component';
import { PayComponent } from './pay/pay.component';
import { RouterModule, Routes,ROUTES } from '@angular/router';
import { MedicineserviceService } from './medicineservice.service';

const routes:Routes=[
  {
    path:"app",component:AppComponent
  },
  {
    path:"home",component:HomeComponent
  },
  {
    path:"medicinesearch",component:MedicinesearchComponent
  },
  {
    path:"book",component:BookComponent
  },
  {
    path:"pay",component:PayComponent
  },
  ]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MedicinesearchComponent,
    BookComponent,
    PayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    [RouterModule.forRoot(routes)]
  ],
  providers: [MedicineserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
