import {Component, EventEmitter,OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {QuestionModel} from "../../../models/response/question.model";
import {QuestionType} from "../../../enum/question-type";
import {Store} from "@ngrx/store";
import {addQuestion} from "../../../state/question/question.actions";
import {SubjectModel} from "../../../models/response/subject.model";
import {selectAllSubjects} from "../../../state/subject/subject-selector";
import {loadSubjects} from "../../../state/subject/subject-actions";


@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit{
  @Output() closeModal:EventEmitter<Function>=new EventEmitter<Function>()
  subjects?: SubjectModel[];



    constructor(private store:Store) {
      this.store.dispatch(loadSubjects());
    }

    getFunction(){
    this.closeModal.emit();
    }

    formQuestion = new FormGroup({
      text:new FormControl('',Validators.required),
      type: new FormControl('',Validators.required),
      numberAnswers:new FormControl(0,Validators.required),
      correctAnswers:new FormControl(0,Validators.required),
      incorrectAnswers:new FormControl(0,Validators.required),
      points:new FormControl(0,Validators.required)
    })


    saveQuestion(){
    const newQuestion:QuestionModel = {
      text:this.formQuestion.value.text,
      questionType:this.formQuestion.value.type as QuestionType,
      numberAnswers:this.formQuestion.value.numberAnswers,
      numberCorrectAnswers:this.formQuestion.value.correctAnswers,
      numberFalseAnswers:this.formQuestion.value.incorrectAnswers,
      points:this.formQuestion.value.points
    }
      console.log(newQuestion)
    this.store.dispatch(addQuestion({question:newQuestion}));
     this.getFunction()
    }

   ngOnInit() {
     console.log(this.store.select(selectAllSubjects));
     this.store.select(selectAllSubjects);
     console.log(this.subjects);
   }
}
