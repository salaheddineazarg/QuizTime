import {Component, EventEmitter, Output} from '@angular/core';
import {Store} from "@ngrx/store";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {levelModel} from "../../../models/level.model";
import {addLevel} from "../../../state/level/level.actions";

@Component({
  selector: 'app-level-form',
  templateUrl: './level-form.component.html',
  styleUrls: ['./level-form.component.css']
})
export class LevelFormComponent  {

  @Output() closeModal:EventEmitter<Function> = new EventEmitter<Function>()


  formLevel=new FormGroup({
    name:new FormControl('',Validators.required),
    maxPoints:new FormControl(0,Validators.required),
    minPoints: new FormControl(0,Validators.required)
  })

  saveLevel(){
   const newLevel:levelModel = {
     name:this.formLevel.value.name,
     maxPoints:this.formLevel.value.maxPoints,
     minPoints:this.formLevel.value.minPoints
   }
   this.store.dispatch(addLevel({level:newLevel}))
   this.close()
  }

   close(){
    this.closeModal.emit()
   }

  constructor(private store:Store) {
  }

}
