import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable, catchError, delay, map, throwError } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JsonApiService {

  headers = new HttpHeaders()
                            .append('Content-Type', 'application/json; charset=utf-8')
                            .append('Access-Control-Allow-Origin', ' *')
                            .append('Access-Control-Allow-Methods', ' GET, POST, PATCH, PUT, DELETE, OPTIONS')
                            .append("Access-Control-Allow-Headers", "Authorization, X-PINGOTHER, X-Auth-Token', Origin, X-Requested-With, Content-Type, Accept, X-Custom-header")
                            .append('tokenJWT', '123X-Auth-Token');

  private http = inject(HttpClient)

  public addHeader(headerName: string, headerValue: string) {
    this.headers.delete(headerName);
    this.headers.append(headerName, headerValue);
  }

  public fetchFromServiceWithGet(url: string): Observable<any> {
    return this.http.get(environment.API_URL_SERVICES + url, 
                        { headers : this.headers,observe: "response" }).pipe(
      delay(1000),
      map((res) => this.extractData( res )),
      catchError(this.handleError), );
  }

  public fetchFromServiceWithPost(url: string, postData: any): Observable<any> {
    this.headers = new HttpHeaders();
    this.headers.append('Content-Type', 'application/json');

    return this.http.post(environment.API_URL_SERVICES + url, postData,
                         { headers : this.headers,observe: "response" }).pipe(
      delay(100),
      map((res) => this.extractData( res )),
      catchError(this.handleError),
       );    
  }

  public fetchFromServiceWithPut(url: string, postData: any): Observable<any> {
    this.headers = new HttpHeaders();
    this.headers.append('Content-Type', 'application/json');
    return this.http.put(environment.API_URL_SERVICES + url, postData, 
                          { headers : this.headers,observe: "response" }).pipe(
      delay(100),
      map((res) => this.extractData( res )),
      catchError(this.handleError),
       );    
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof HttpErrorResponse) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }
  
  private extractData(res: any) {
    // Processando os headers para incluir ou trocar o token de autorizacao
    console.log('res');
    console.log(res);
    console.log(res.headers);
    if (res.headers) {
      console.log('headers: ' + res.headers);
      if (res.headers.has('tokenJWT')) {
        console.log('this.tokenJWT: ' + res.headers.has('tokenJWT'));
        this.addHeader('tokenJWT', res.headers.get('tokenJWT'));
      } else {
        console.log('console.log(this.tokenJWT): False')
      }
    }

    if (res.body) {
      const body = res.body;
      if (body) {
        return body.data || body
      } else {
        return {}
      }
    } else {
      return {};
    }
  }

}
