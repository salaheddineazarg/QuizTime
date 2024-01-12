import { createSelector } from "@ngrx/store";
import { AppState } from "../app.state";
import { MediaState } from "./media-reducer";

const mediaSelector: (state: AppState) => MediaState = (state) => state.medias

export const selectAllMedias = createSelector(
  mediaSelector,
  (state: MediaState) => state.medias
);
