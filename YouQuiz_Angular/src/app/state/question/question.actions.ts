import {createAction, props} from "@ngrx/store";
import {QuestionModel} from "../../models/response/question.model";
import {PaginationQuestionModel} from "../../models/response/pagination-question-model";





export const loadQuestions = createAction(
    '[Question Page] enter',
    props<{pagination:PaginationQuestionModel}>()
)

export  const  addQuestion= createAction(
    '[Question Page] Add Question ' ,
    props<{question: QuestionModel}>()
);


export const removeQuestion=createAction(
    '[Question Page] Remove Question',
    props<{id:number}>()
)
