import {createSelector} from "@ngrx/store";
import {AppState} from "../app.state";
import {QuizState} from "./quiz.reducer";


const quizSelector:(state:AppState) => QuizState = state => state.quizzes


export const selectAllQuizzes=createSelector(
  quizSelector,
  (state: QuizState) => state.quizzes
)
