import { QuestionModel } from "../../models/response/question.model";
import { createReducer, on } from "@ngrx/store";
import { addQuestion, loadQuestions, removeQuestion } from "./question.actions";
import { PaginationQuestionModel } from "../../models/response/pagination-question-model";

export interface QuestionState {
  questions: QuestionModel[];
}

export interface PaginationState {
  pagination: PaginationQuestionModel | null;
}

export const initialQuestionState: QuestionState = {
  questions: [],
};

export const initialPaginationState: PaginationState = {
  pagination: null,
};

export const questionReducer = createReducer(
  initialQuestionState,
  on(addQuestion, (state, { question }) => ({
    ...state,
    questions: [...state.questions, question],
  })),
  on(removeQuestion, (state, { id }) => ({
    ...state,
    questions: state.questions.filter((question) => question.id !== id),
  })),
);

export const paginationReducer=createReducer(
  initialPaginationState,
  on(loadQuestions, (state, { pagination }) => ({
    ...state,
    pagination: pagination,
  }))
)
