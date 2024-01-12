import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Store} from "@ngrx/store";
import {SubjectModel} from "../../../models/subject.model";
import {addSubject, removeSubject, subjectsLoaded} from "../../../state/subject/subject-actions";
import {selectAllSubject} from "../../../state/subject/subject-selector";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-subject-form',
  templateUrl: './subject-form.component.html',
  styleUrls: ['./subject-form.component.css']
})
export class SubjectFormComponent implements OnInit{

  @Output() closeModal:EventEmitter<Function> = new EventEmitter<Function>()
  subjects!:SubjectModel[];






  formSubject= new FormGroup({
    title:new FormControl('',Validators.required),
    parent:new FormControl(0,Validators.required)
  })


  saveSubject(){
    let newSubject!:SubjectModel;
    if(this.formSubject.value.parent == 0){
       newSubject={
        title:this.formSubject.value.title,

      }
    }else {
       newSubject={
        title:this.formSubject.value.title,
        parent_id:this.formSubject.value.parent
      }
    }
  this.store.dispatch(addSubject({subject:newSubject}))

    this.clodeModal();
  }

  clodeModal(){
    this.closeModal.emit()
  }



  constructor(private store:Store) {
    store.dispatch(subjectsLoaded({subjects:this.subjects}))
  }




  ngOnInit() {
    this.store.select(selectAllSubject).subscribe(
      subjects => {
        this.subjects = subjects;
      }
    )
  }
}
