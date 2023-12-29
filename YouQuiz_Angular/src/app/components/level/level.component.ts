import { Component, OnInit } from '@angular/core';
import {Store} from "@ngrx/store";
import {addLevel, loadLevels, removeLevel} from "../../state/level/level.actions";
import {levelModel} from "../../models/response/level.model";
import {selectLevel} from "../../state/level/level.selectors";
import {data} from "autoprefixer";


@Component({
  selector: 'app-level',
  templateUrl: './level.component.html',
  styleUrls: ['./level.component.css']
})
export class LevelComponent implements OnInit {

  Levels$!: levelModel[];

    level :levelModel= {
         name:'',
        maxPoints:0,
        minPoints:0,
    }




 constructor(private store:Store) {
      store.select(selectLevel).subscribe(
     data=>{
       this.Levels$ = data.levels

     }
   )
 }
  ngOnInit() {
      this.getAll()

  }

  getAll():void{
      this.store.dispatch(loadLevels({levels:this.Levels$}))

  }

  addLevel(){

   this.store.dispatch(addLevel({level:this.level}))
  }

    removeLevel(id: number | undefined){
        if (id !== undefined){
            this.store.dispatch(removeLevel({id}))
        }else{
            console.log("the id is undefined");
        }

  }



}
