import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { JsonApiService } from '../shared/json-api.service';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class GlobalStateService {
  
headers = new HttpHeaders()
                          .append('Content-Type', 'application/json; charset=utf-8')
                          .append('Access-Control-Allow-Origin', ' *')
                          .append('Access-Control-Allow-Methods', ' GET, POST, PATCH, PUT, DELETE, OPTIONS')
                          .append('Access-Control-Allw-Headers', ' Origin, Content-Type, X-Auth-Token')
                          .append('TokenJWT', '123X-Auth-Token');

private apiService = inject(JsonApiService)
  
token$ = new Observable<any>(); 
token3$ = new Observable<string[]>(); 
sendPost(url: string, postData: any)
{
  this.token$ = this.apiService.fetchFromServiceWithPost(url, postData);
  return this.token$;
}

sendPut(url: string, postData: any)
{
  this.token$ = this.apiService.fetchFromServiceWithPut(url, postData);
  return this.token$;
}

getParticipanteById(url: string)
{
  this.token$ = this.apiService.fetchFromServiceWithGet(url);
  return this.token$;  
}

getListarNomes(url: string)
{
  this.token3$ = this.apiService.fetchFromServiceWithGet(url);
  return this.token3$;  
}

excluirLista(url: string, postData: any) {
  this.token$ = this.apiService.fetchFromServiceWithPost(url, postData);
  return this.token$; 
}
  
}

