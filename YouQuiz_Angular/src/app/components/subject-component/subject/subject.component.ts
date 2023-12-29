import {Component, OnInit} from '@angular/core';
import {SubjectService} from "../../../services/subject-service/subject-service";
import {Observable} from "rxjs";
import {SubjectModel} from "../../../models/response/subject.model";

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.css']
})
export class SubjectComponent implements OnInit{
  dataSubjects:SubjectModel[]=[];
  showInfosSubject:boolean[]= [];
  constructor(private subjectService:SubjectService) {}
  ngOnInit() {
  this.getSubjects();
   this.showInfosSubject = Array(this.dataSubjects.length).fill(false);
  }

  private getSubjects(): void {
    this.subjectService.getSubjects().subscribe(
      (data: SubjectModel[]) => {
        this.dataSubjects = data;
        console.log(data)
      },
      (error) => {
        console.error(error);
      }
    );
  }

  showInfosSubjectFunction(index: number) {
    this.showInfosSubject[index] = !this.showInfosSubject[index];
  }
}
