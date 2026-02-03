import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { JobsComponent } from './jobs/jobs.component';
import { ResumeUploadComponent } from './resume-upload/resume-upload.component';

@Component({
  selector: 'app-root',
  imports: [ JobsComponent, ResumeUploadComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'jobagent-ui';
}
