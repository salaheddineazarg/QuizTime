import {QuizModel} from "./quiz.model";
import {StudentModel} from "./student.model";
import {AnswerModel} from "./answer.model";

export interface AssignQuizStudentsModel{
  id?: number;
  chance: number;
  startDate: Date;
  endDate: Date;
  score?: number;
  result?: string;
  reason?: string;
  quiz?: QuizModel;
  student?: StudentModel;
  answers?:AnswerModel[];
  quiz_id?:number;
  student_id?:number;

}
