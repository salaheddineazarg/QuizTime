import {Component, EventEmitter,OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {QuestionType} from "../../../enum/question-type";
import {Store} from "@ngrx/store";
import {addQuestion} from "../../../state/question/question.actions";
import {SubjectModel} from "../../../models/subject.model";
import {subjectsLoaded} from "../../../state/subject/subject-actions";
import {selectAllSubject} from "../../../state/subject/subject-selector";
import {levelModel} from "../../../models/level.model";
import {loadLevels} from "../../../state/level/level.actions";
import {selectAllLevels} from "../../../state/level/level.selectors";
import {QuestionModel} from "../../../models/question.model";
import {MediaModel} from "../../../models/media.model";


@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit{
  @Output() closeModal:EventEmitter<Function>=new EventEmitter<Function>()
  subjects!: SubjectModel[];
  levels!:levelModel[];
  medias!:MediaModel[];



  getMedias(medias:MediaModel[]){
    this.medias = medias;
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
      subject:new FormControl(0,Validators.required),
      level:new FormControl(0,Validators.required),
      points:new FormControl(0,Validators.required),
    })


    saveQuestion(){
    const newQuestion:QuestionModel = {
      text:this.formQuestion.value.text,
      questionType:this.formQuestion.value.type as QuestionType,
      numberAnswers:this.formQuestion.value.numberAnswers,
      numberCorrectAnswers:this.formQuestion.value.correctAnswers,
      numberFalseAnswers:this.formQuestion.value.incorrectAnswers,
      subject_id:this.formQuestion.value.subject,
      level_id:this.formQuestion.value.level,
      points:this.formQuestion.value.points,
      medias:this.medias
    }
    this.store.dispatch(addQuestion({question:newQuestion}));
     this.getFunction()
    }




  constructor(private store:Store) {
    store.dispatch(subjectsLoaded({subjects:this.subjects}));
    store.dispatch(loadLevels({levels:this.levels}))
  }
   ngOnInit() {
     this.store.select(selectAllSubject).subscribe(
       subjects => {
       this.subjects = subjects
       }
     );

     this.store.select(selectAllLevels).subscribe(
       levels =>{
         this.levels = levels
       }
     )

   }
}
