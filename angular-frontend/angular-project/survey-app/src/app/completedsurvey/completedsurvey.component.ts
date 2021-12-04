import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-completedsurvey',
  templateUrl: './completedsurvey.component.html',
  styleUrls: ['./completedsurvey.component.css']
})
export class CompletedsurveyComponent implements OnInit {
  survey = null
  isDataAvailable = false
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getStudentData()
  }

  getStudentData() {
    const queryString = window.location.search;

    const urlParams = new URLSearchParams(queryString);

    const id = urlParams.get('id')
    const url = "http://localhost:8080/survey-service/webresources/students/"
    let obs = this.http.get(url + id);
    obs.subscribe((response) => this.loadData(response))
  }

  loadData(studentData){
    this.survey = studentData
    console.log(this.survey)
    this.isDataAvailable = true
  }
}
