import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-validation',
  templateUrl: './validation.component.html',
  styleUrls: ['./validation.component.css']
})
export class ValidationComponent {
@Output() closeModal:EventEmitter<Function>=new EventEmitter<Function>()


  close(){
  this.closeModal.emit();
  }
}
