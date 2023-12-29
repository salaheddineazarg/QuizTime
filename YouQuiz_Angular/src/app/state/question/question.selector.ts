import { createSelector} from '@ngrx/store';
import {PaginationState} from "./question.reducer";
import {AppState} from "../app.state";




export const selectQuestions: (state:AppState) => PaginationState = (state) => state.pagination;

export const selectAllQuestions = createSelector(
  selectQuestions,
  (state: PaginationState) => state.pagination
);
