import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { JobsComponent } from './jobs/jobs.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, JobsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'jobagent-ui';
}
