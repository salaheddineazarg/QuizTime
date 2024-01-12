import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./pages/dashboard/dashboard.component";
import { HomeComponent } from './pages/home/home.component';
import {LevelComponent} from "./components/level-components/level/level.component";
import {QuestionComponent} from "./components/question-components/question/question.component";
import {SubjectComponent} from "./components/subject-component/subject/subject.component";
import {ResponseComponent} from "./components/response-components/response/response.component";
import {QuizComponent} from "./components/quiz-components/quiz/quiz.component";



const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'dashboard',component:DashboardComponent,
  children:[
    {path :'main',component:QuizComponent},
    {path:'level',component:LevelComponent},
    {path:'question',component:QuestionComponent},
    {path:'subject',component:SubjectComponent},
    {path:'response',component:ResponseComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
