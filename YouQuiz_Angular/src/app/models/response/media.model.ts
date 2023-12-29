import {QuestionModel} from "./question.model";
import {MediaType} from "../../enum/media-type";

export interface MediaModel{
  id?: bigint;
  mediaType: MediaType;
  link: string;
  description: string;
  question?: QuestionModel;
}


