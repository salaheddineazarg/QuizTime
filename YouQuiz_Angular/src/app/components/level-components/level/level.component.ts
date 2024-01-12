import { Component, OnInit } from '@angular/core';
import {Store} from "@ngrx/store";
import {addLevel, loadLevels, removeLevel} from "../../../state/level/level.actions";
import {levelModel} from "../../../models/level.model";
import {selectAllLevels, selectLevel} from "../../../state/level/level.selectors";
import {data} from "autoprefixer";


@Component({
  selector: 'app-level',
  templateUrl: './level.component.html',
  styleUrls: ['./level.component.css']
})
export class LevelComponent implements OnInit {

  levels!: levelModel[];








  getAll():void{
      this.store.dispatch(loadLevels({levels:this.levels}))

  }

  addLevel(){

  // this.store.dispatch(addLevel({level:this.level}))
  }

    removeLevel(id: number | undefined){
        if (id !== undefined){
            this.store.dispatch(removeLevel({id}))
        }else{
            console.log("the id is undefined");
        }

  }


  constructor(private store:Store) {
    store.select(selectAllLevels).subscribe(
      levels=>{
        this.levels = levels

      }
    )
  }
  ngOnInit() {
    this.getAll()

  }



}
