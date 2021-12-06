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
    // console.log(processedlike)

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
		// "date": values.surveydate
    
    }
    let obs = this.http.post("http://localhost:8080/survey-service/webresources/students", body)

    obs.subscribe((response) => {
      console.log(response)
	  let mean = response["dataBean"]["mean"]
	  let standardDev = response["dataBean"]["standardDev"]
    //   alert("Thanks " + values.fname + ", your survey has been received")
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
    
  }

  // $(function() {
	// 	$("reset").click(function() {
	// 		$("#form")[0].reset()
	// 	});

		
		// $('#error').dialog({
    //         modal: true,
    //         autoOpen: false,
    //         width: 'auto',
    //         closeOnEscape: true,
    //         show: {
    //             effect: "blind",
    //             // duration: 1000,
    //         },
    //         buttons: [{
    //             text: "Close",
    //             click: function() {
    //                 $(this).dialog("close");
    //             }
    //         }],
    //         title: "Validation Failed"
    //     });
		
		
		// Submit button click handler
	// 	$("#form")
	// 			.submit(
	// 					function(event) {
	// 						var errorMessage = "";

	// 						var count = 0;
	// 						if ($("#studentid").val() == ' '
	// 							|| $("#studentid").val().match(
	// 									/^[A-Za-z0-9_@]{3,8}$/) == null) {
	// 						errorMessage += "<li>The studentId should be 3 to 8 characters long and contain only numeric,alphabets,underscore and @.</li>";
	// 						count++;
	// 					}
	// 						var username = $("#username").val();
	// 						// Name validation
	// 						const alphabeticRegex = /^[A-Za-z]+$/;
	// 						if (username == ' '
	// 								|| username.match(alphabeticRegex) == null) {
	// 							errorMessage += "<li>The Name text box should contain only Alphabets.</li>";
	// 							count++;
	// 						}
	// 						// Address validation
	// 						if ($("#address").val() == ' '
	// 								|| $("#address").val().match(
	// 										/^[ A-Za-z0-9]+$/) == null) {
	// 							errorMessage += "<li>The address box should contain only numeric,alphabets or alphanumeric.</li>";
	// 							count++;
	// 						}
	// 						// At least 2 checkboxes must be seleted
	// 						if ($('input:checkbox').filter(':checked').length < 2) {
	// 							errorMessage += "<li>Make sure at least two checkboxes are checked.</li>";
	// 							count++;
	// 						}
	// 						// Radio button must be selected
	// 						if ($("input[type = 'radio']:checked").length == 0) {
	// 							errorMessage += "<li>Make sure at least one button is selected.</li>";
	// 							count++;
	// 						}
	// 						// Email validation
	// 						if (($("#email").val() == ' ' || $("#email")
	// 								.val()
	// 								.match(
	// 										/^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/) == null)) {
	// 							errorMessage += "<li>Invalid email.</li>";
	// 							count++;
	// 						}
	// 						if(isDataValid()){
	// 							errorMessage += "<li>Enter at least 10 numbers between 1 and 100 in data field separated by comma.</li>";
	// 						}
	// 						// Show modal dialog if validation fails.
	// 						if (count > 0) {
	// 							$("#error").html(errorMessage);
	// 							$('#error').dialog('open');
	// 							event.preventDefault();
	// 						}
							
	// 					});
	// });

}
