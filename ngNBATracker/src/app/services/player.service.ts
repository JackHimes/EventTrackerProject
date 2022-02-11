import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Player } from '../models/player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  // private baseUrl = 'http://localhost:8083/';
  // private url = this.baseUrl + 'api/players';
  private url = environment.baseUrl + 'api/teams';


  constructor(
    private http: HttpClient,
  ) { }

  index(){
    return this.http.get<Player[]>(this.url)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
            () => new Error("inside player service index()")
            )
      })
    );
  }

  public create(player : Player): Observable<Player>{
    return this.http.post<Player>(this.url, player)
      .pipe(
        catchError((err : any) => {
          console.log(err);
          return throwError(
            () => new Error('Create(player) player method error')
          )
        })
      );
  }

  public destroy(id : number): Observable<void>{
    return this.http.delete<void>(this.url + "/" + id)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Destroy(id) player method error')
        )
      })
    );
  
}

public update(player : Player): Observable<Player>{
  return this.http.put<Player>(this.url + "/" +  player.id, player)
  .pipe(
    catchError((err : any) => {
      console.log(err);
      return throwError(
        () => new Error('Update(player) player method error: ' + err)
      )
    })
  );
}

}
