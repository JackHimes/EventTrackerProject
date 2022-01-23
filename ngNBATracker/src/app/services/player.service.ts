import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private baseUrl = 'http://localhost:8083/';
  private url = this.baseUrl + 'api/players';

  constructor(
    private http: HttpClient,
  ) { }
}
