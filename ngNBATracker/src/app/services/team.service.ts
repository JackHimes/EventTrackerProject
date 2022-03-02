import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Team } from '../models/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  // private baseUrl = 'http://localhost:8083/';
  // private url = this.baseUrl + 'api/teams';
  private url = environment.baseUrl + 'api/teams';

  constructor(
      private http: HttpClient,
  ) { }


  public index(){
    return this.http.get<Team[]>(this.url)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
            () => new Error("inside team service index()")
            )
      })
    );
  }

  public create(team : Team): Observable<Team>{
    return this.http.post<Team>(this.url, team)
      .pipe(
        catchError((err : any) => {
          console.log(err);
          return throwError(
            () => new Error('Create(team) team method error')
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
          () => new Error('Destroy(id) team method error')
        )
      })
    );
  
}

public update(team : Team): Observable<Team>{
  return this.http.put<Team>(this.url + "/" +  team.id, team)
  .pipe(
    catchError((err : any) => {
      console.log(err);
      return throwError(
        () => new Error('Update(team) team method error: ' + err)
      )
    })
  );
}


}
