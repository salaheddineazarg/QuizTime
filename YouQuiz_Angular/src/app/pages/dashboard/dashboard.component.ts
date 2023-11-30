import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
   showArea :boolean = true;

  constructor() {
  }

  ngOnInit() {
  }

  ShowAreafun(){
    this.showArea = !this.showArea;
  }

}
