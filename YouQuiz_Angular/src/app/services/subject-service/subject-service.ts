import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SubjectModel} from "../../models/subject.model";


@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  constructor(private  http : HttpClient) { }
  baseUrl:string = "http://localhost:8080/api/subject";

  getSubjects(){

    return this.http.get<SubjectModel[]>(this.baseUrl);
  }

  addSubject(subject:SubjectModel){
    return this.http.post<SubjectModel>(this.baseUrl,subject);
  }

  deleteSubject(id:number){
    return this.http.delete(this.baseUrl+`/${id}`);
  }
}
