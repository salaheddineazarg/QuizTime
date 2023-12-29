import {QuestionType} from "../../enum/question-type";
import {levelModel} from "../response/level.model";
import {MediaModel} from "../response/media.model";
import {SubjectModel} from "../response/subject.model";

export interface QuestionRequestModel {
  text: string;
  questionType: QuestionType;
  numberAnswers: number;
  numberCorrectAnswers: number;
  numberFalseAnswers: number;
  points: number;
  level_id:levelModel;
  medias: MediaModel[];
  subject_id: SubjectModel;

}
