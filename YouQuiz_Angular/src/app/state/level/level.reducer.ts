import {levelModel} from "../../models/response/level.model";
import {createReducer, on} from "@ngrx/store";
import {addLevel, loadLevels, removeLevel} from "./level.actions";


export interface LevelState{
  levels: levelModel[];
}

export const initialState : LevelState = {
     levels:[]
}

export const levelReducer= createReducer(
  initialState,
  on(addLevel,(state,{level})=>({
    ...state,
    levels:[...state.levels,level]
  })),
  on(removeLevel,(state,{id})=>({
    ...state,
      levels:state.levels.filter((level)=>level.id !== id)
  })),
 on(loadLevels,(state,{levels})=>({
   ...state,
   levels:levels,
 })),



)
