import {Component} from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {

  modal:boolean=true;



  modalFunction(){
    this.modal=!this.modal
  }
}
