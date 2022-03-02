import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Coach } from '../models/coach';

@Injectable({
  providedIn: 'root'
})
export class CoachService {
private url = environment.baseUrl + 'api/coaches';

  constructor(
    private http: HttpClient
  ) { }


  public index(){
    return this.http.get<Coach[]>(this.url)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () => new Error("Error in coach service index()")
        )
      })
    );
  }

  public create(coach: Coach): Observable<Coach>{
    return this.http.post<Coach>(this.url, coach)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () => new Error("Create(coach) method error")
        )
      }) 
    );
  }

  public destroy(id: number): Observable<void>{
    return this.http.delete<void>(this.url + "/" + id)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () => new Error("Delete(coach) method error")
        )
      })
    );
  }

  public update(coach: Coach): Observable<Coach>{
    return this.http.put<Coach>(this.url + "/" + coach.id, coach)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () => new Error("Update(coach) method error")
        )
      })
    );
  }


}
