import {MediaModel} from "../../models/media.model";
import {createReducer, on} from "@ngrx/store";
import {addMedia, loadMedias, removeMedia} from "./media-actions";


export interface MediaState{
  medias:MediaModel[];
}


const initialState : MediaState = {
  medias:[]
}


export const mediaReducer = createReducer(
  initialState,
  on(loadMedias,(state,{medias})=>({
    ...state,
    medias:medias
  })),
  on(addMedia,(state,{media})=>({
    ...state,
    media:[...state.medias,media]
  })),
  on(removeMedia,(state,{id})=>({
    ...state,
    medias:state.medias.filter((media)=>media.id != id)
  }))
)
