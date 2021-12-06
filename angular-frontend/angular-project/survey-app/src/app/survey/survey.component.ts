import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {
  like = [
    { name: "students", selected: false },
    { name: "location", selected: false },
    { name: "campus", selected: false },
    { name: "atmosphere", selected: false },
    { name: "dormrooms", selected: false },
    { name: "sports", selected: false }
  ]

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  submitSurvey(values) {

    var processedlike = this.like
      .filter(opt => opt.selected)
      .map(opt => opt.name);

    var body = {
        "address": values.address,
        "campuslikes": processedlike.join(),
        "city": values.city,
        "email": values.email,
        "interested": values.interested,
        "states": values.state,
        "studentId": values.studentid,
        "telephone": values.telephone,
        "url": values.url,
        "userName": values.username,
        "zip": values.zip,
		"data": values.data,
    
    }
    let obs = this.http.post("http://localhost:8080/survey-service/webresources/students", body)

    obs.subscribe((response) => {
      console.log(response)
	  let mean = response["dataBean"]["mean"]
	  let standardDev = response["dataBean"]["standardDev"]
	   window.location.href = `http://localhost:4200/all?mean=${mean}&standardDev=${standardDev}`;
    }, 
	(error) => {
		console.log('oops', console.log(error.status))
		if(error.status==409){
		alert("Student already exists. \nPlease enter different Student Id");
		}
	}
	)
	
  }

  clearSurvey() {
	window.location.reload();
  }


}
