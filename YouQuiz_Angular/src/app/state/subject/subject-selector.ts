import {AppState} from "../app.state";
import {SubjectState} from "./subject-reducer";
import {createFeatureSelector, createSelector} from "@ngrx/store";
import {PaginationState} from "../question/question.reducer";
import {SubjectModel} from "../../models/response/subject.model";

const subjectState = createFeatureSelector<SubjectState>("subject");

const getSubjects = (state: SubjectState) => state.subjects;
export const selectAllSubjects = createSelector(
  subjectState,
  getSubjects
)
