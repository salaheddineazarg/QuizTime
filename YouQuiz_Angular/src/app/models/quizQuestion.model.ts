import {QuizModel} from "./quiz.model";
import {QuestionModel} from "./question.model";


export interface QuizQuestionModel{

  id?:number;
  temporize:number;
  quiz?:QuizModel;
  question?:QuestionModel;
  quiz_id?:number;
  question_id?:number;
}
