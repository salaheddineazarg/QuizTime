import {Component, EventEmitter, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Store} from "@ngrx/store";
import {QuizModel} from "../../../models/quiz.model";
import {addQuiz} from "../../../state/quiz/quiz.actions";

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
    chances:new FormControl(0,Validators.required),
    during:new FormControl(0,Validators.required),
    description:new FormControl('',Validators.required),
    displayResult:new FormControl(false)
  })


  addQuiz() {
    const newQuiz:QuizModel ={
      title:this.formQuiz.value.title,
      passingScore:this.formQuiz.value.passingScore,
      chances:this.formQuiz.value.chances,
      during:this.formQuiz.value.during,
      moreInformations:this.formQuiz.value.description,
      displayResult:this.formQuiz.value.displayResult,
      teacher_id:1
          }
          this.store.dispatch(addQuiz({quiz:newQuiz}))
    this.close()
  }
}
