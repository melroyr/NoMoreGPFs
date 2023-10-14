import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloCityComponent } from './hello-city/hello-city.component';
import { HelloLocalComponent } from './hello-local/hello-local.component';
import { HelloNationComponent } from './hello-nation/hello-nation.component';
import { HelloInternationComponent } from './hello-internation/hello-internation.component';
import { AppHeaderComponent } from './app-header/app-header.component';
import { AppFooterComponent } from './app-footer/app-footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloCityComponent,
    HelloLocalComponent,
    HelloNationComponent,
    HelloInternationComponent,
    AppHeaderComponent,
    AppFooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
