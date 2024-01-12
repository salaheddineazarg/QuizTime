import {QuizModel} from "./quiz.model";
import {UserModel} from "./user.model";


export interface TeacherModel extends UserModel{
     id?:number;
     speciality:string;
     quizz?:QuizModel[];
}
