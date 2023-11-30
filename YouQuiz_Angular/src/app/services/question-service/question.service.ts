import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {QuestionModel} from "../../models/question.model";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  baseUrl:string="http://localhost:8080/api"
  constructor(private http :HttpClient) { }

  getQuestions():Observable<QuestionModel[]> {

    return this.http.get<QuestionModel[]>(this.baseUrl+"/question").pipe(
      map((question : QuestionModel[])=>{

        return question.splice(0,3);
      })
    );
}

  getAllQuestions():Observable<QuestionModel[]>{

    return this.http.get<QuestionModel[]>(this.baseUrl+"/question");
  }

}
