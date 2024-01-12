import {createAction, props} from "@ngrx/store";
import {SubjectModel} from "../../models/subject.model";

export const subjectsLoaded = createAction(
  '[Subject Page] subject loaded successfully',
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
