import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Team } from 'src/app/models/team';
import { TeamService } from 'src/app/services/team.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  teams: Team[] = [];
  images = ['../../assets/Dunking.jpg','../../assets/BasketballAndHoop.jpg', '../../assets/PlayersPlaying.jpg'];
  westernTeam: Team[] = [];
  easternTeam: Team[] = [];


  constructor(
    private teamService: TeamService,
  ) { }

  ngOnInit(): void {
    this.reload();
  }

  reload(){
    this.teamService.index().subscribe({

      next: (data) => {
        this.teams = data;
        this.findConferenceSplit(data);
        
      
      }, error: (err) => {
        console.error("Observer got an error: " + err)
      }
    });
  }

  deleteTeam(id : number){
    this.teamService.destroy(id).subscribe({

      next: (success) => {
        this.reload();
      },
      error: (fail) =>{
        console.error("FAILED TODO DELETE");
        console.error(fail);
      }
    });
  }

  findConferenceSplit(teams: Team[]){
      if (teams != null){
        for (const team of teams) {
          if(team.conference === 'Western'){
            this.westernTeam.push(team);
          }else if(team.conference === 'Eastern'){
            this.easternTeam.push(team);
          }
          
        }
      }
  
  }





}



