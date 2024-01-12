import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {SubjectService} from "../../services/subject-service/subject-service";
import {exhaustMap, map, of, switchMap, tap} from "rxjs";
import {addSubject,removeSubject, subjectsLoaded} from "./subject-actions";
import {SubjectModel} from "../../models/subject.model";


@Injectable()
export  class SubjectEffects{

  constructor(private action$:Actions,private service:SubjectService) {

  }

  loadSubjects$ =createEffect(()=>
    this.action$.pipe(
      ofType(subjectsLoaded),
      exhaustMap(()=>{
        return this.service.getSubjects().pipe(
          map((subjects:SubjectModel[])=> subjectsLoaded({subjects}))
        )
      })
    )
  )

  addSubject$ = createEffect(()=>
    this.action$.pipe(
    ofType(addSubject),
      switchMap((action)=>{
        return this.service.addSubject(action.subject)
      })
      ),{dispatch:false}
    )

  removeSubject$  =createEffect(()=>
   this.action$.pipe(
     ofType(removeSubject),
     switchMap((action)=>{
       return this.service.deleteSubject(action.id);
     })
   ),{dispatch:false}
  )

}
