import {QuestionModel} from "./question.model";

export interface SubjectModel {
  id?: number;
  title: string;
  parent?: SubjectModel;
  childs?: SubjectModel[];
  questions?: QuestionModel[];
  parent_id?:number;
}
