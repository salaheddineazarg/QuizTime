import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {MediaService} from "../../services/media-service/media.service";
import {addMedia, loadMedias, removeMedia} from "./media-actions";
import {exhaustMap, map, switchMap, tap} from "rxjs";
import {MediaModel} from "../../models/media.model";


@Injectable()
export class MediaEffects {



  loadMedias$ = createEffect(() =>
    this.action$.pipe(
      ofType(loadMedias),
      exhaustMap(() =>{
      return  this.service.getMedias().pipe(
          map((medias: MediaModel[])=>loadMedias({medias}))
        )
        }
      )
    )
  );


  addMedia$=createEffect(
    ()=>
  this.action$.pipe(
    ofType(addMedia),
    switchMap(
      (action)=>{
     return  this.service.addMedia(action.media)
    })
  ),{dispatch:false}
  );

  removeMedia$=createEffect(
    ()=>
      this.action$.pipe(
        ofType(removeMedia),
        switchMap(
          (action)=>{
            return  this.service.deleteMedia(action.id)
          })
      ),{dispatch:false}
  )



  constructor(private action$:Actions,private service:MediaService) {
  }


}



