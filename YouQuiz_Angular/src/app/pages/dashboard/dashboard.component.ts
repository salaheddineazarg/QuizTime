import {Component, OnInit} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
   dropDown :boolean = true;
  buttonDisplay=localStorage.getItem('button') ? localStorage.getItem('button') : "main";
  questionModal=false;
  subjectModal=false;
  levelModal=false;
  quizModal=false;



  dropDownFunction(){
    this.dropDown = !this.dropDown;
  }

  showQuestionModal(){
    this.questionModal =! this.questionModal;
  }
  showSubjectModal(){
    this.subjectModal=!this.subjectModal;
  }

  showLevelModal(){
    this.levelModal=!this.levelModal
  }

  showQuizModal(){
   this.quizModal =!this.quizModal;
  }



  handleRouteChange(url: string) {

    if (url === '/dashboard/main'){
      this.buttonDisplay = 'main';
    }else if(url === '/dashboard/question'){
      this.buttonDisplay='question'
    }else if(url === '/dashboard/level') {
      this.buttonDisplay='level'
    }else if(url === '/dashboard/subject') {
      this.buttonDisplay='subject'
    } else if(url === '/dashboard/response') {
      this.buttonDisplay='response'
    }
    localStorage.setItem('button',this.buttonDisplay);
  }


  constructor(private router:Router) {
  }


  ngOnInit() {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.handleRouteChange(event.urlAfterRedirects);
      }
    });
  }
}
