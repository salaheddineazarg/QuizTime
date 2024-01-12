import {QuizModel} from "../../models/quiz.model";
import {createReducer, on} from "@ngrx/store";
import {addQuiz, loadQuizzes, removeQuiz} from "./quiz.actions";


export interface QuizState{
  quizzes:QuizModel[]
}

const initialState:QuizState = {
  quizzes:[]
}


export const QuizReducer= createReducer(
  initialState,
  on(loadQuizzes,(state,{quizzes})=>({
   ...state,
   quizzes:quizzes
  })),
  on(addQuiz,(state,{quiz})=>({
    ...state,
    quizzes:[...state.quizzes,quiz]
  })),
  on(removeQuiz,(state,{id})=>({
    ...state,
    quizzes:state.quizzes.filter((quiz)=>quiz.id !== id)
  }))

)
