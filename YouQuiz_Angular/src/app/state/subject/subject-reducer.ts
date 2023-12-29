import {createReducer, on} from "@ngrx/store";
import {addSubject, loadSubjects, removeSubject, subjectsLoaded} from "./subject-actions";
import {SubjectModel} from "../../models/response/subject.model";


export interface SubjectState{
  subjects : SubjectModel[];
}

const initialState:SubjectState={
   subjects : []
}


export const subjectReducer = createReducer(
  initialState,
  on(subjectsLoaded,(state, {subjects})=> ({
    ...state,
    subjects : subjects
  })),
  on(addSubject,(state,{subject})=>({
    ...state,
    subjects:[...state.subjects,subject]
  })),
  on(removeSubject,(state,{id})=>({
    ...state,
    subjects:state.subjects.filter((subject)=>subject.id !== id)
  }))
)

