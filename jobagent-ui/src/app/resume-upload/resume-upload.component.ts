import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-resume-upload',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './resume-upload.component.html'
})
export class ResumeUploadComponent {

  selectedFile!: File;
  resumeId: number | null = null;
  message = '';

  constructor(private http: HttpClient) {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  upload() {

    if (!this.selectedFile) {
      alert('בחרי קובץ קודם');
      return;
    }

    const formData = new FormData();
    formData.append('file', this.selectedFile);

    this.http.post<any>('http://localhost:8080/resume/upload', formData)
      .subscribe(res => {
        this.resumeId = res.id;
        this.message = "Resume uploaded successfully (ID: " + res.id + ")";
      });
  }
}
