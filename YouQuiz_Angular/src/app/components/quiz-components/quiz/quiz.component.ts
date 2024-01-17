import {Component, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import {loadQuizzes} from "../../../state/quiz/quiz.actions";
import {QuizModel} from "../../../models/quiz.model";
import {selectAllQuizzes} from "../../../state/quiz/quiz.selector";

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit{
  colors: string[] = [];
  quizzes?:QuizModel[];

  constructor(private store:Store) {
    store.dispatch(loadQuizzes({quizzes:this.quizzes}))
  }


   ngOnInit() {
    this.generateRandomColor()
    this.store.select(selectAllQuizzes).subscribe(
      quizzes => {
        this.quizzes =quizzes
      }
    )
   }




  generateRandomColor() {
    const letters = '0123456789ABCDEF';
    for (let j = 0; j < 5; j++) {
      let color = '#';
      for (let i = 0; i < 3; i++) {
        const darkValue = Math.floor(Math.random() * 8); // Use 16 as it's hex
        color += letters[darkValue];
      }
      this.colors.push(color);
    }
  }


  isDateComparison(dateString: string, comparisonOperator: string): boolean {
    const competitionDate = new Date(dateString).getDate();
    console.log(competitionDate)
    const currentDate = new Date().getDate();

    if (comparisonOperator === '<') {
      return competitionDate < currentDate;
    } else if (comparisonOperator === '>') {
      return competitionDate> currentDate;
    } else if (comparisonOperator === '=') {
      return competitionDate === currentDate;
    }

    return false;
  }





}
