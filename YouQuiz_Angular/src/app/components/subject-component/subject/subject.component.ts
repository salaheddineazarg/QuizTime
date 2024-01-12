import {Component, OnInit} from '@angular/core';
import {SubjectService} from "../../../services/subject-service/subject-service";
import {Observable} from "rxjs";
import {SubjectModel} from "../../../models/subject.model";
import {Store} from "@ngrx/store";
import {removeSubject, subjectsLoaded} from "../../../state/subject/subject-actions";
import {selectAllSubject} from "../../../state/subject/subject-selector";

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.css']
})
export class SubjectComponent implements OnInit{
  subjects!:SubjectModel[];
  showInfosSubject:boolean[]= [];

  delete(id:number){
    this.store.dispatch(removeSubject({id}))
  }


  constructor(private store:Store) {
    store.dispatch(subjectsLoaded({subjects:this.subjects}))
  }
  ngOnInit() {
  this.store.select(selectAllSubject).subscribe(
    subjects =>{
      this.subjects =subjects;
    }
  )
  }
}


