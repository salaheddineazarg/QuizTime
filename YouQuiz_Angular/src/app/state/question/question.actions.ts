import {createAction, props} from "@ngrx/store";
import {QuestionModel} from "../../models/question.model";
import {PaginationQuestionModel} from "../../models/pagination-question-model";






export const loadQuestions = createAction(
    '[Question Page] enter',
    props<{questions:QuestionModel[]}>()
)

export  const  addQuestion= createAction(
    '[Question Page] Add Question ' ,
    props<{question: QuestionModel}>()
);


export const removeQuestion=createAction(
    '[Question Page] Remove Question',
    props<{id:number}>()
)
