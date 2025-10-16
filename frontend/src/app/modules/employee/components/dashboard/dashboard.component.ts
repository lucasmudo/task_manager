import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  listOfTasks:any = []

  constructor(private employeeService: EmployeeService,
    private snackbar:MatSnackBar
  ){
    this.getTasks();
  }

  getTasks(){
    this.employeeService.getEmployeeTasksById().subscribe((res)=>{
        console.log(res);
        this.listOfTasks = res;
    })
  }

  updateStatus(id: number, status:string){
    this.employeeService.updateStatus(id,status).subscribe((res)=>{
      if(res.id != null){
        this.snackbar.open("Task status updated successfully", "Close", {duration:5000});
        this.getTasks();
      }else{
        this.snackbar.open("Error while trying to update Task", "Close", {duration:5000});
      }
    });
  }
}
