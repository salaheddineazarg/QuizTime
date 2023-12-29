import {NgModule} from "@angular/core";
import {TableComponentComponent} from "./table-component/table-component.component";
import {CommonModule} from "@angular/common";
import { FormComponent } from './form/form.component';
import { InputComponent } from './input/input.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ButtonComponent } from './button/button.component';
import { SelectComponent } from './select/select.component';

@NgModule({
  declarations:[
    TableComponentComponent,
    FormComponent,
    InputComponent,
    ButtonComponent,
    SelectComponent
  ],
    imports: [CommonModule,
        FormsModule, ReactiveFormsModule],
    exports: [
        TableComponentComponent,
        FormComponent,
        InputComponent,
        ButtonComponent,
        SelectComponent
    ]
})

export class SharedModule{}
