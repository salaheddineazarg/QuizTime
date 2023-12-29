import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent {

  @Input() label:string="";
  @Input() type:string="";
  @Input() placeHolder:string="";
  @Output() value  = new EventEmitter<any>();


  sendValue(value: any) {

    this.value.emit(value.value);
    console.log(value.value)
  }

}
