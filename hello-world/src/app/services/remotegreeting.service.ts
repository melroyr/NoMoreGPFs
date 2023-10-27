import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class RemoteGreeting{
  constructor(
    public generalGreeting:string,
    //public name:string,
    //public designation:string,
    //public salary:string,
  ) {}

}

@Injectable({
  providedIn: 'root'
})
export class RemoteGreetingService {

  constructor(private httpClient:HttpClient) { }

  getRemoteGreeting()
    {
      console.log("test call");
      return this.httpClient.get<RemoteGreeting[]>('http://localhost:8080/greeting');
    }
}
