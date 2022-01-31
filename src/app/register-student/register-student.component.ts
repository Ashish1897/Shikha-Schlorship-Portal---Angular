import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.css']
})
export class RegisterStudentComponent implements OnInit {

  registerForm: FormGroup | any;
  numberRegEx = /\-?\d*\.?\d{1,2}/;
  
  student:Student= new Student();
  submitted=false;
  
  constructor(private sService:StudentService,private router:Router,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      fname: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      lname: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      gender: ['', [Validators.required]],
      aadharNumber: ['', [Validators.required,Validators.minLength(12), Validators.maxLength(12), Validators.pattern('^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$')]],
      email: ['', [Validators.required, Validators.email]],
      mobNo: ['', [Validators.required,Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      
      password: ['', [Validators.required, Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,12}$')]],
      dob: ['', [Validators.required]],
      
      fatherName: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]$')]],
      motherName: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]}$')]],
      
      street: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9 ]+$')]],
      city: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]],
      state: ['', [Validators.required]],
      pincode: ['', [Validators.required,Validators.pattern('^[0-9]{0,6}$')]],
      
      familyIncome: ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      incomeCertiNo: ['', [Validators.required]],
     
      category: ['', [Validators.required]], 
      domicileCertiNo: ['', [Validators.required]],
     
      highestQual: ['', [Validators.required]],
      collegeName: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]],
      rollNumber: ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      percentage: ['', [Validators.required,Validators.pattern('^[0-9]{2}$')]],
      year: ['', [Validators.required,Validators.pattern('^[0-9]{4}$')]],
     
      accNo: ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      bankName: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]],
      ifscCode: ['', [Validators.required, Validators.pattern('^[A-Z]{4}[0-9]{7}$')]],
      bankAddress: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
    })
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  save() {
    this.sService.newStudent(this.student).subscribe(data => console.log(data), error => console.log(error));
    console.log(this.student);
    this.student= new Student();
  }

  Student(): void {
    this.submitted = false;
    this.student = new Student();
  }

  onSubmit() {
    this.submitted = true;
    this.student = this.registerForm.value;
    // stop the process here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    this.save();    
  }

  goto(){
    this.router.navigate(['login']);
  }
 
}
