import { createSelector} from '@ngrx/store';
import {QuestionState} from "./question.reducer";
import {AppState} from "../app.state";




export const selectQuestions: (state:AppState) => QuestionState = (state) => state.questions;

export const selectAllQuestions = createSelector(
  selectQuestions,
  (state: QuestionState) => state.questions
);
