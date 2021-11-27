import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-all-surveys',
  templateUrl: './all-surveys.component.html',
  styleUrls: ['./all-surveys.component.css']
})
export class AllSurveysComponent implements OnInit {

  constructor(private http: HttpClient) { }
  allSurveys = []

  ngOnInit(): void {
    this.getSurveyData()
  }

  getSurveyData() {
    let obs = this.http.get("http://3.19.123.200:30002/survey/all"); //TODO: Change ip!!!
    obs.subscribe((response) => this.formatData(response))
  }

  formatData(survey) {
    try {
      this.allSurveys = survey;
    } catch (error) {
      console.log(error)
    }
  }
}
