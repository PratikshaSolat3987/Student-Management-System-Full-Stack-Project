import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { StudentService } from '../../services/student.service';
import { Student } from '../../models/student';


@Component({
  selector: 'app-student-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './student-form.component.html',
  styleUrl: './student-form.component.css'
})
export class StudentFormComponent implements OnInit{
  studentForm: FormGroup;
  isEditMode = false;
  studentId?: number;

  constructor(
    private fb: FormBuilder,
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.studentForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: [''],
      enrollmentDate: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const id = params.get('id');
      if (id) {
        this.isEditMode = true;
        this.studentId = +id;
        this.studentService.getStudentById(this.studentId).subscribe((student) => {
          this.studentForm.patchValue({
            ...student,
            enrollmentDate: student.enrollmentDate.split('T')[0] // Format for input type="date"
          });
        });
      }
    });
  }

  onSubmit(): void {
    if (this.studentForm.valid) {
      const student: Student = this.studentForm.value;
      if (this.isEditMode && this.studentId) {
        this.studentService.updateStudent(this.studentId, student).subscribe(() => {
          this.router.navigate(['/']);
        });
      } else {
        this.studentService.registerStudent(student).subscribe(() => {
          this.router.navigate(['/']);
        });
      }
    }
  }

}
