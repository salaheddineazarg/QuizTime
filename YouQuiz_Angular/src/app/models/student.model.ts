import {UserModel} from "./user.model";

export interface StudentModel extends UserModel{
   id?:number;
   registrationDate:Date
}
