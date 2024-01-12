import {Component, EventEmitter, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Store} from "@ngrx/store";
import {QuizModel} from "../../../models/quiz.model";

@Component({
  selector: 'app-quiz-form',
  templateUrl: './quiz-form.component.html',
  styleUrls: ['./quiz-form.component.css']
})
export class QuizFormComponent {
  @Output() closeModal:EventEmitter<Function>=new EventEmitter<Function>()

      constructor(private store:Store) {
      }
  close(){
    this.closeModal.emit()
  }

  formQuiz=new FormGroup({
    title:new FormControl('',Validators.required),
    passingScore:new FormControl(0,Validators.required),
    changes:new FormControl(0,Validators.required),
    during:new FormControl(0,Validators.required),
    description:new FormControl('',Validators.required),
    displayResult:new FormControl(false)
  })


  addQuiz() {
  /*  const newQuiz:QuizModel ={
      title:this.formQuiz.value.title,
      passingScore:this.formQuiz.value.passingScore,
      chances:this.formQuiz.value.changes,

    }*/
  }
}
