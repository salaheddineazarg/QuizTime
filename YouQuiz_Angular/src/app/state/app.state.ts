import {LevelState} from "./level/level.reducer";
import {PaginationState, QuestionState} from "./question/question.reducer";
import {PaginationQuestionModel} from "../models/response/pagination-question-model";
import {SubjectState} from "./subject/subject-reducer";


export interface AppState {
  levels:LevelState;
  questions:QuestionState;
  pagination:PaginationState;
  subjects:SubjectState;
}
