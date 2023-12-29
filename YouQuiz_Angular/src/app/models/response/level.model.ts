import {QuestionModel} from "./question.model";

export  interface levelModel {
  id?:number,
  name:string,
  maxPoints:number,
  minPoints:number,
  questions?:QuestionModel[] | null
}
