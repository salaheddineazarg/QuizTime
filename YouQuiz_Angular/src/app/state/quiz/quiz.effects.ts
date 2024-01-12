import {Actions, createEffect, ofType} from "@ngrx/effects";
import {QuizService} from "../../services/quiz-servcie/quiz.service";
import {addQuiz, loadQuizzes, removeQuiz} from "./quiz.actions";
import {exhaustMap, map} from "rxjs";
import {QuizModel} from "../../models/quiz.model";
import {Injectable} from "@angular/core";



@Injectable()
export class QuizEffects {

  constructor(private action$: Actions, private service: QuizService) {
  }


  loadQuizzes$ = createEffect(() =>
    this.action$.pipe(
      ofType(loadQuizzes),
      exhaustMap(() =>
        this.service.getQuizzes().pipe(
          map((quizzes: QuizModel[]) => loadQuizzes({quizzes}))
        )
      )
    )
  )

  addQuiz$ = createEffect(() =>
    this.action$.pipe(
      ofType(addQuiz),
      exhaustMap((action) => {
        return this.service.saveQuiz(action.quiz)

      })
    ), {dispatch: false}
  )

  removeQuiz$=createEffect(()=>
  this.action$.pipe(
    ofType(removeQuiz),
    exhaustMap((action)=>{
      return this.service.deleteQuiz(action.id)
    })
  ),{dispatch:false}
  )


}
