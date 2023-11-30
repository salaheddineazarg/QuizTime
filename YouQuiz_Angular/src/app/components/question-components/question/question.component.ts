import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../../../services/question-service/question.service";
import {QuestionModel} from "../../../models/question.model";

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit{
  showInfos:boolean[] = [];

   questions:QuestionModel[]=[];
  constructor(private questionService : QuestionService) {
    this.showInfos = Array(this.questions.length).fill(false);
  }

  ngOnInit() {
    this.getAllQuestion();
  }

  getAllQuestion(){
    this.questionService.getQuestions().subscribe(
      (data)=>{
        this.questions = data;
        console.log(data)
      },error => {
        console.error(error)
      }
    )

  }

  showInfosFunction(index: number) {
    this.showInfos[index] = !this.showInfos[index];
  }
}
