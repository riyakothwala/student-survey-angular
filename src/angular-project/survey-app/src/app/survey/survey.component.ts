import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders, HttpClientModule } from '@angular/common/http';

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

    console.log(values)

    var processedlike = this.like
      .filter(opt => opt.selected)
      .map(opt => opt.name);
    console.log(processedlike)

    var body = {
      firstName: values.fname,
      lastName: values.lname,
      phoneNumber: values.number,
      emailAddress: values.email,
      street: values.streetaddress,
      city: values.city,
      zip: values.zip,
      state: values.state,
      custom_field_1: processedlike.toString(),
      custom_field_2: values.interest,
      custom_field_3: values.options,
      date: values.surveydate
    }

    console.log(body)
    let obs = this.http.post("http://3.19.123.200:30002/survey/submit", body)

    obs.subscribe((response) => {
      console.log(response)
      alert("Thanks " + values.fname + ", your survey has been received")
    })
  }

  clearSurvey() {

  }
}
