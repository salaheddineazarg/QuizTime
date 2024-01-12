import {Injectable, NgModule} from "@angular/core";
import {StoreModule} from "@ngrx/store";
import {levelReducer} from "./level/level.reducer";
import {questionReducer} from "./question/question.reducer";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {EffectsModule} from "@ngrx/effects";
import {LevelEffects} from "./level/level.effects";
import {QuestionEffects} from "./question/question.effects";
import {subjectReducer} from "./subject/subject-reducer";
import {SubjectEffects} from "./subject/subject-effects";
import {MediaEffects} from "./media/media-effects";
import {mediaReducer} from "./media/media-reducer";
import {QuizReducer} from "./quiz/quiz.reducer";
import {QuizEffects} from "./quiz/quiz.effects";

@NgModule({
  imports: [
    StoreModule.forRoot({
      levels: levelReducer,
      questions: questionReducer,
      subjects: subjectReducer,
      medias:mediaReducer,
      quizzes:QuizReducer
    }),
    StoreDevtoolsModule.instrument({
      maxAge: 25
    }),
    EffectsModule.forRoot([LevelEffects,
      QuestionEffects,
      SubjectEffects,
      MediaEffects,
       QuizEffects]),
  ],
  providers: [],
  bootstrap: []
})

export class StateModule {}
