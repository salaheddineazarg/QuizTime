import {QuestionModel} from "./question.model";

export  interface levelModel {
  id:bigint,
  name:string,
  maxPoints:number,
  minPoints:number,
  questions:QuestionModel[] | null
}
