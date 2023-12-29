import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {QuestionModel} from "../../models/response/question.model";
import {PaginationQuestionModel} from "../../models/response/pagination-question-model";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  baseUrl:string="http://localhost:8080/api/question"
  page:number = 0;
  constructor(private http :HttpClient) { }


  getQuestions(){

    return  this.http.get<PaginationQuestionModel>(this.baseUrl+`?size=5&page=${this.page}`);

  }


  addQuestion(question:QuestionModel){

  return   this.http.post<QuestionModel>(this.baseUrl,question);
  }

  deleteQuestion(id:number){

    return this.http.delete<string>(this.baseUrl+`/${id}`);
  }

}
