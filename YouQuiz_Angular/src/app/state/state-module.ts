import {Injectable, NgModule} from "@angular/core";
import {StoreModule} from "@ngrx/store";
import {levelReducer} from "./level/level.reducer";
import {paginationReducer, questionReducer} from "./question/question.reducer";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {EffectsModule} from "@ngrx/effects";
import {LevelEffects} from "./level/level.effects";
import {QuestionEffects} from "./question/question.effects";
import {subjectReducer} from "./subject/subject-reducer";
import {SubjectEffects} from "./subject/subject-effects";

@NgModule({
  imports: [
    StoreModule.forRoot({
      levels: levelReducer,
      question: questionReducer,
      pagination: paginationReducer,
      subject: subjectReducer
    }),
    StoreDevtoolsModule.instrument({
      maxAge: 25
    }),
    EffectsModule.forRoot([LevelEffects,QuestionEffects,SubjectEffects]),
  ],
  providers: [],
  bootstrap: []
})

export class StateModule {}
