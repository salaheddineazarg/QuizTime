import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./pages/dashboard/dashboard.component";
import { HomeComponent } from './pages/home/home.component';
import {PrincipalAreaComponent} from "./components/principal-area/principal-area.component";
import {LevelComponent} from "./components/level/level.component";


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'dashboard',component:DashboardComponent,
  children:[
    {path : 'main',component:PrincipalAreaComponent},
    {path:'items',component:LevelComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
