import {ValidationModel} from "./validation.model";
import {AssignQuizStudentsModel} from "./assignQuizStudents.model";


export interface AnswerModel{
   id?:number;
   totalScore:number;
   validation?:ValidationModel;
   assignQuizStudents?:AssignQuizStudentsModel;
   validation_id:number;
   assignQuizStudents_id:number;
}
