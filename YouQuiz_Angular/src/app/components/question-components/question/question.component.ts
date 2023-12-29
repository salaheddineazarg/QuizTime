import {Component, OnInit} from '@angular/core';
import {QuestionModel} from "../../../models/response/question.model";
import {select, Store} from "@ngrx/store";
import {PaginationQuestionModel} from "../../../models/response/pagination-question-model";
import {Observable} from "rxjs";
import {selectAllQuestions, selectQuestions} from "../../../state/question/question.selector";
import {data} from "autoprefixer";
import {loadQuestions} from "../../../state/question/question.actions";


@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit{
  pagination$!:PaginationQuestionModel;
  Questions$:QuestionModel[]=[];

  constructor(private store:Store) {
    store.select(selectQuestions).subscribe(
      data=>{
        console.log(data.pagination)
        this.Questions$ = data.pagination.content
      }
    )
  }



  getAll(){
    this.store.dispatch(loadQuestions({pagination:this.pagination$}))
  }


  ngOnInit() {
    this.getAll()
  }

}
