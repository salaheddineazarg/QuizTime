import {Component, OnInit} from '@angular/core';
import {QuestionModel} from "../../../models/question.model";
import {select, Store} from "@ngrx/store";
import {PaginationQuestionModel} from "../../../models/pagination-question-model";
import {Observable} from "rxjs";
import {selectAllQuestions, selectQuestions} from "../../../state/question/question.selector";
import {data} from "autoprefixer";
import {loadQuestions, removeQuestion} from "../../../state/question/question.actions";


@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit{
  Questions$:QuestionModel[]=[];
  ResponseModal=false;




  getAll(){
    this.store.dispatch(loadQuestions({questions:this.Questions$}))
  }


  showModal(){
    this.ResponseModal=!this.ResponseModal;
  }

  delete(id:number){
    this.store.dispatch(removeQuestion({id}))
  }

  ngOnInit() {
    this.getAll()
  }
  constructor(private store:Store) {
    store.select(selectAllQuestions).subscribe(
      questions=>{
        console.log(questions)
        this.Questions$ = questions;
      }
    )
  }




}
