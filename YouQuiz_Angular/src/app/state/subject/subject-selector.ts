import {AppState} from "../app.state";
import {SubjectState} from "./subject-reducer";
import {createSelector} from "@ngrx/store";



const subjectSelector:(state:AppState) => SubjectState = (state)=>state.subjects

export const selectAllSubject =createSelector(
  subjectSelector,
  (state:SubjectState) => state.subjects
)
