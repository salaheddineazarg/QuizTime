import {createAction, props} from "@ngrx/store";
import {SubjectModel} from "../../models/response/subject.model";


export const loadSubjects = createAction(
  '[Subject Page] enter'
)

export const subjectsLoaded = createAction(
  '[Subject Api] subject loaded successfully',
  props<{subjects: SubjectModel[]}>()
)

export const addSubject=createAction(
  '[Subject Page] Add subject',
  props<{subject:SubjectModel}>()
)

export const removeSubject=createAction(
  '[Subject Page] Remove subject',
  props<{id:number}>()
)
