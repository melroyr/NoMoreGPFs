import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloCityComponent } from './hello-city/hello-city.component';
import { HelloLocalComponent } from './hello-local/hello-local.component';
import { HelloNationComponent } from './hello-nation/hello-nation.component';
import { HelloInternationComponent } from './hello-internation/hello-internation.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
import { HelloStateComponent } from './hello-state/hello-state.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloCityComponent,
    HelloLocalComponent,
    HelloNationComponent,
    HelloInternationComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    HelloStateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
