import {LevelState} from "./level/level.reducer";
import {QuestionState} from "./question/question.reducer";
import {SubjectState} from "./subject/subject-reducer";
import {MediaState} from "./media/media-reducer";
import {QuizState} from "./quiz/quiz.reducer";


export interface AppState {
  levels:LevelState;
  questions:QuestionState;
  subjects:SubjectState;
  medias:MediaState;
  quizzes:QuizState;
}
