import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { FormsModule, FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';


@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit {

  email = '';
  password = '';
  invalidLogin = false;
  errorMessage = 'Invalid Credentials';
  successMessage: string='';
  loginSuccess = false;

  constructor(private router:Router, private loginService:LoginService) { }

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required])
  })

  ngOnInit(): void {
  }

  checkLogin() {
    let student={
      "email":this.email,
      "password":this.password
    }
    this.loginService.login(student).subscribe((response) => {
      console.log(response);
      if(response =="true")
      {
        sessionStorage.setItem('email', this.email)
        this.invalidLogin = false;
        this.loginSuccess = true;
        this.successMessage = 'Login Successful.';
        this.router.navigate(['/student_dashboard'])
      }
      else{
        this.invalidLogin = true;
        this.errorMessage = 'Invalid Credentials';
        this.loginSuccess = false;
      }
    });
    this.loginSuccess = false;
   
  }

  list(){
    this.router.navigate(['register']);
  }
}
