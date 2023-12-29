import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
   dropDown :boolean = true;
  buttonDisplay="main";
  questionModal=false;

  constructor(private router:Router) {
  }


  dropDownFunction(){
    this.dropDown = !this.dropDown;
  }

  showQuestionModal(){
    this.questionModal =! this.questionModal;
  }


  handleRouteChange(url: string) {
    console.log(url)
    if (url === '/dashboard/main'){
      this.buttonDisplay = 'main';
    }else if(url === '/dashboard/question'){
      this.buttonDisplay='question'
    }
  }


  ngOnInit() {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.handleRouteChange(event.urlAfterRedirects);
      }
    });
  }
}
