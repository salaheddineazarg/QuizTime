import {QuestionModel} from "./question.model";

export interface SubjectModel {
  id: bigint;
  title: string;
  parent: SubjectModel | null;
  childs: SubjectModel[];
  questions: QuestionModel[];
}
