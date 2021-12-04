import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SurveyComponent } from './survey/survey.component';
import { AllSurveysComponent } from './all-surveys/all-surveys.component';
import { HttpClientModule } from '@angular/common/http';
import { CompletedsurveyComponent } from './completedsurvey/completedsurvey.component';

@NgModule({
  declarations: [
    AppComponent,
    SurveyComponent,
    AllSurveysComponent,
    CompletedsurveyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
