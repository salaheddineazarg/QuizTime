import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../../../services/question-service/question.service";
import {QuestionModel} from "../../../models/question.model";

@Component({
  selector: 'app-question-table',
  templateUrl: './question-table.component.html',
  styleUrls: ['./question-table.component.css']
})
export class QuestionTableComponent implements OnInit{
  questions:QuestionModel[]=[];
  constructor(private questionService:QuestionService) {
  }
  ngOnInit() {
    this.getQuestion()
  }

  getQuestion(){
   this.questionService.getQuestions().subscribe(
     (data)=>{
       this.questions = data;
       console.log(this.questions)
     },error => {
       console.error(error)
     }
   )
  }

}
