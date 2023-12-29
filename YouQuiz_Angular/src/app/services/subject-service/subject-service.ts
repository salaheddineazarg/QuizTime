import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SubjectModel} from "../../models/response/subject.model";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  constructor(private  http : HttpClient) { }
  baseUrl:string = "http://localhost:8080/api";

  getSubjects(){

    return this.http.get<SubjectModel[]>(this.baseUrl+"/subject");
  }

  addSubject(subject:SubjectModel){
    return this.http.post<SubjectModel>(this.baseUrl,subject);
  }

  deleteSubject(id:number){
    return this.http.delete(this.baseUrl+`/${id}`);
  }
}
