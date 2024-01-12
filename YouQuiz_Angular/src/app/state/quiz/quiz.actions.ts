import {createAction, props} from "@ngrx/store";
import {QuizModel} from "../../models/quiz.model";


 export const loadQuizzes = createAction(
  '[Quiz Page]',
   props<{quizzes:QuizModel[]}>()
)

export const addQuiz=createAction(
  '[Quiz Page] Add quiz',
  props<{quiz:QuizModel}>()
)


export const removeQuiz=createAction(
  '[Quiz Page] Remove quiz',
  props<{id:number}>()
)
