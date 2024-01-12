import {QuizQuestionModel} from "./quizQuestion.model";
import {AssignQuizStudentsModel} from "./assignQuizStudents.model";
import {TeacherModel} from "./teacher.model";



export interface QuizModel {
  id?: number;
  title: string;
  passingScore: number;
  chances: number;
  duration: number;
  displayResult: boolean;
  moreInformations: string;
  quizQuestions?: QuizQuestionModel[];
  assignQuizStudents?: AssignQuizStudentsModel[];
  teacher?: TeacherModel;
  teacher_id:number;
}
