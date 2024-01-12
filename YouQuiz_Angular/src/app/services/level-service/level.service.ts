import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {levelModel} from "../../models/level.model";

@Injectable({
  providedIn: 'root'
})
export class LevelService {

  constructor(private http: HttpClient) {}
  baseUrl:string = "http://localhost:8080/api/level";
  getLevels() : Observable<levelModel[]>{

    return  this.http.get<levelModel[]>(this.baseUrl);
  }

  addLevel(level:levelModel){

    return this.http.post<levelModel>(this.baseUrl,level);
  }

  removeLevel(id:number){

    return this.http.delete<string>(this.baseUrl+`/${id}`);
  }

}
