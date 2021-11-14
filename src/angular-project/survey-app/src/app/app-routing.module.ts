import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllSurveysComponent } from './all-surveys/all-surveys.component';
import { SurveyComponent } from './survey/survey.component';

const routes: Routes = [
  { path: 'survey', component: SurveyComponent},
  { path: 'all', component: AllSurveysComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
