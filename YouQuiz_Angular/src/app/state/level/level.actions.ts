import {createAction, props} from "@ngrx/store";
import {levelModel} from "../../models/response/level.model";


export  const  addLevel= createAction(
  '[Level Page]',
  props<{level: levelModel}>()
);

export const removeLevel =createAction(
  '[Level Page] Remove',
  props<{id:number}>()
  );

export const loadLevels = createAction(
    '[Level Page] Load Pages',
    props<{ levels:levelModel[] }>()
);
