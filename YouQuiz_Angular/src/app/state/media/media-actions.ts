import {createAction, props} from "@ngrx/store";
import {MediaModel} from "../../models/media.model";


export const loadMedias=createAction(
  '[Media Page] entry',
  props<{medias:MediaModel[]}>()

)

export const addMedia=createAction(
  '[Media Page] Add Media',
  props<{media:MediaModel}>()
)

export const removeMedia =createAction(
  '[Media Page] Remove Media',
  props<{id:number}>()
)
