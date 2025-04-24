import { Routes } from '@angular/router';
import { StudentListComponent } from './components/student-list/student-list.component';
import { StudentFormComponent } from './components/student-form/student-form.component';
import { StudentDetailComponent } from './components/student-detail/student-detail.component';

export const routes: Routes = [
  { path: '', component: StudentListComponent },
  { path: 'create', component: StudentFormComponent },
  { path: 'edit/:id', component: StudentFormComponent },
  { path: 'details/:id', component: StudentDetailComponent },
  { path: '**', redirectTo: '' }
];