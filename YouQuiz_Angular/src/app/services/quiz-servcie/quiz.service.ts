import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {QuizModel} from "../../models/quiz.model";

@Injectable({
  providedIn: 'root'
})
export class QuizService {
 baseUrl="http://localhost:8080/api/quiz"
  constructor(private http:HttpClient) { }


  getQuizzes(){
  return  this.http.get<QuizModel[]>(this.baseUrl);
  }
  saveQuiz(quiz:QuizModel){
   return this.http.post<QuizModel>(this.baseUrl,quiz);
  }
  deleteQuiz(id:number){
   return this.http.delete(this.baseUrl+`/${id}`);
  }
}
