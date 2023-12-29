import {createSelector, MemoizedSelector} from '@ngrx/store';
import {AppState} from "../app.state";
import {LevelState} from "./level.reducer";





export const selectLevel: (state: AppState) => LevelState = (state: AppState) => state.levels;

export const selectAllLevels = createSelector(
  selectLevel,
  (state: LevelState) => state.levels
);
