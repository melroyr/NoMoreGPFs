import { Component, OnInit } from '@angular/core';
import { RemoteGreetingService, RemoteGreeting } from '../services/remotegreeting.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  remoteGreetings: RemoteGreeting[];

  constructor( private remoteGreetingService: RemoteGreetingService) { }

  ngOnInit() {

    this.remoteGreetingService.getRemoteGreeting().subscribe(
         response =>{this.remoteGreetings = response;}
        );

  }

}
