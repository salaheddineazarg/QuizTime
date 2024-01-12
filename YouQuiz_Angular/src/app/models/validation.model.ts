import {ResponseModel} from "./response.model";
import {QuestionModel} from "./question.model";

export interface ValidationModel{
  id?: bigint;
  response: ResponseModel;
  question: QuestionModel;
  points: number;
}
