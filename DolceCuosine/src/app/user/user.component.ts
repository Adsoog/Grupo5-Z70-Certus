import { Component } from '@angular/core';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  data: any[] = [];

  constructor(private apiService: ApiService) {
    
  }

  ngOnInit():void{
    this.llenarData();
  }

  llenarData(){
    this.apiService.getDataUser().subscribe( data => {
      this.data = data;
      console.log(this.data);
    })
  }
}
