import {Actions, createEffect, ofType} from "@ngrx/effects";
import {QuestionService} from "../../services/question-service/question.service";
import {addQuestion, loadQuestions, removeQuestion} from "./question.actions";
import {exhaustMap, map, switchMap, tap} from "rxjs";
import {QuestionModel} from "../../models/response/question.model";
import {Injectable} from "@angular/core";
import {PaginationQuestionModel} from "../../models/response/pagination-question-model";


@Injectable()
export class QuestionEffects {

      constructor(
          private action$:Actions,
          private questionService:QuestionService
      ) {
      }


       loadQuestions$ = createEffect( ()=>
       this.action$.pipe(
           ofType(loadQuestions),
           exhaustMap(()=> {
            return  this.questionService.getQuestions().pipe(
               map((pagination:PaginationQuestionModel)=> loadQuestions({pagination}))

             )
           })
       )
    );


    addQuestion$=createEffect(()=>
     this.action$.pipe(
         ofType(addQuestion),
         switchMap((action)=>{
             return this.questionService.addQuestion(action.question);
         }
         )
     ),{dispatch:false}

    );

    removeQuestion$ = createEffect(()=>
    this.action$.pipe(
        ofType(removeQuestion),
        switchMap((action)=>{
            return this.questionService.deleteQuestion(action.id);
        })
    ), {dispatch:false}

    )
}
