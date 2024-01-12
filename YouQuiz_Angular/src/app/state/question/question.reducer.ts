import { QuestionModel } from "../../models/question.model";
import { createReducer, on } from "@ngrx/store";
import { addQuestion, loadQuestions, removeQuestion } from "./question.actions";


export interface QuestionState {
  questions: QuestionModel[];
}


export const initialQuestionState: QuestionState = {
  questions: [],
};


export const questionReducer = createReducer(
  initialQuestionState,
  on(loadQuestions, (state, { questions }) => ({
    ...state,
    questions: questions,
  })),
  on(addQuestion, (state, { question }) => ({
    ...state,
    questions: [...state.questions,question],
  })),
  on(removeQuestion, (state, { id }) => ({
    ...state,
    questions: state.questions.filter((question) => question.id !== id),
  })),
);

