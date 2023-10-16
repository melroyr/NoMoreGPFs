import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HelloCityComponent } from './hello-city/hello-city.component';
import { HelloLocalComponent } from './hello-local/hello-local.component';
import { HelloStateComponent } from './hello-state/hello-state.component';
import { HelloNationComponent } from './hello-nation/hello-nation.component';
import { HelloInternationComponent } from './hello-internation/hello-internation.component';


const routes: Routes = [
  { path:'hellocity', component: HelloCityComponent},
  { path:'hellolocal', component: HelloLocalComponent},
  { path:'hellostate', component: HelloStateComponent},
  { path:'hellonation', component: HelloNationComponent},
  { path:'hellointernation', component: HelloInternationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
