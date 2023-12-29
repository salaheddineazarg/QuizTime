import {QuestionModel} from "./question.model";

export interface SubjectModel {
  id?: number;
  title: string;
  parent?: SubjectModel | null;
  childs: SubjectModel[];
  questions?: QuestionModel[];
}
