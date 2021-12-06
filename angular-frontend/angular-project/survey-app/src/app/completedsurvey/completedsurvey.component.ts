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

  like = [
    { name: "students", selected: false },
    { name: "location", selected: false },
    { name: "campus", selected: false },
    { name: "atmosphere", selected: false },
    { name: "dormrooms", selected: false },
    { name: "sports", selected: false }
  ]
  ngOnInit(): void {
    this.getStudentData()
  }

  getStudentData() {
    const queryString = window.location.search;

    const urlParams = new URLSearchParams(queryString);

    const id = urlParams.get('id')
    const url = "http://localhost:8080/survey-service/webresources/students/"
    let obs = this.http.get(url + id);
    obs.subscribe((response) => this.loadData(response),
    (error) => {
      console.log('oops', console.log(error.status))
      if(error.status==404){
      alert("Student data does not exists");
      }
    })
  }

  loadData(studentData){
    let likeArray = studentData.campuslikes.split(',')

    this.like.forEach(individualLike => {
      if(likeArray.includes(individualLike.name)){
        individualLike.selected = true
      }
    });


    this.survey = studentData
    console.log(this.survey)
    this.isDataAvailable = true
  }
  return(){
    window.history.back();
  }
}
