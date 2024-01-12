import {levelModel} from "./level.model";
import {SubjectModel} from "./subject.model";
import {MediaModel} from "./media.model";
import {QuestionType} from "../enum/question-type";

export interface QuestionModel {
  id?: number;
  text: string;
  questionType: QuestionType;
  numberAnswers: number;
  numberCorrectAnswers: number;
  numberFalseAnswers: number;
  points: number;
  level_id?:number;
  subject_id?:number;
  medias_ids?:number[];
  level?:levelModel;
  medias?: MediaModel[];
  subject?: SubjectModel;
}


