import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { NavBarComponent } from './includes/nav-bar/nav-bar.component';
import { HomeComponent } from './pages/home/home.component';
import { HomeSvgComponent } from './icons/home-svg/home-svg.component';
import { ItemsSvgComponent } from './icons/items-svg/items-svg.component';
import { PersonSvgComponent } from './icons/person-svg/person-svg.component';
import { LevelComponent } from './components/level/level.component';
import { PrincipalAreaComponent } from './components/principal-area/principal-area.component';
import { ItemsAreaComponent } from './components/items-area/items-area.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from "@angular/common/http";
import { SubjectComponent } from './components/subject/subject.component';
import { QuestionComponent } from './components/question-components/question/question.component';
import { QuestionTableComponent } from './components/question-components/question-table/question-table.component';
import { SharedModule } from "./shared/shared.module";
import { QuestionFormComponent } from './components/question-components/question-form/question-form.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    NavBarComponent,
    HomeComponent,
    HomeSvgComponent,
    ItemsSvgComponent,
    PersonSvgComponent,
    LevelComponent,
    PrincipalAreaComponent,
    ItemsAreaComponent,
    SubjectComponent,
    QuestionComponent,
    QuestionTableComponent,
    QuestionFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
