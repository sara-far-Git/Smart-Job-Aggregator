import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-jobs',
  standalone: true,   // ⭐ חשוב
  imports: [CommonModule, HttpClientModule], // ⭐ כאן מייבאים
  templateUrl: './jobs.component.html'
})
export class JobsComponent implements OnInit {

  jobs: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get<any[]>('http://localhost:8080/jobs/sorted')
      .subscribe(data => {
        this.jobs = data;
      });
  }
}
