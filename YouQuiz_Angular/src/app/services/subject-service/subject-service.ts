import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SubjectModel} from "../../models/subject.model";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  constructor(private  http : HttpClient) { }
  baseUrl:string = "http://localhost:8080/api";

  getSubjects() :Observable<SubjectModel[]>{

    return this.http.get<SubjectModel[]>(this.baseUrl+"/subject")
  }

}
