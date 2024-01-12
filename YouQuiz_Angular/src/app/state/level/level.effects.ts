import {Injectable} from "@angular/core";
import {Store} from "@ngrx/store";
import {AppState} from "../app.state";
import {LevelService} from "../../services/level-service/level.service";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {addLevel, loadLevels, removeLevel} from "./level.actions";
import {exhaustMap,map, switchMap} from "rxjs";
import {levelModel} from "../../models/level.model";


@Injectable()
export class LevelEffects {
  constructor(
    private actions$:Actions,
    private levelService:LevelService
  ) {}


   loadLevels$ = createEffect(()=>
   this.actions$.pipe(
     ofType(loadLevels),
     exhaustMap(()=>
     this.levelService.getLevels().pipe(
       map((levels:levelModel[])=> loadLevels({levels})),

     ))));


    addLevel$ = createEffect(() =>
        this.actions$.pipe(
            ofType(addLevel),
            switchMap((action) => {
                    return this.levelService.addLevel(action.level);
                }
            )
        ),{dispatch :false}
    );

    removeLevel$ = createEffect(() =>
            this.actions$.pipe(
                ofType(removeLevel),
                switchMap((action) =>
                    this.levelService.removeLevel(action.id)
                )
            ),
        { dispatch: false } // Set dispatch to false if you don't want to dispatch any action
    );

}
