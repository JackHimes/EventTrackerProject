import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/models/player';
import { Team } from 'src/app/models/team';
import { PlayerService } from 'src/app/services/player.service';
import { TeamService } from 'src/app/services/team.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  teams: Team[] = [];
  selected: Team | null = null;
  newTeam: Team = new Team ();
  editTeam: Team | null = null;
  conferenceSplit: string = '';
  
  players: Player[] = [];
  teamAvgPPG: number = 0;

  constructor(
    private teamService: TeamService,
    private playerService: PlayerService,
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

    this.playerService.index().subscribe({

      next: (data1) => {
        this.players = data1;
      
      }, error: (err1) => {
        console.error("Observer got an error: " + err1)
      }
    });
  }

  displayTeam(team : Team){
    this.selected = team;
  }

  displayTable(){
    this.selected = null;
  }

  addTeam(team: Team): void{
    this.teamService.create(team).subscribe({
      next : (t) => {
        this.reload();
        this.newTeam = new Team();
      },
      error : (fail) => {
        console.error("FAILED TEAM POST, addTeam(team) in home.component.ts")
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

  updateTeam(team : Team){
    this.teamService.update(team).subscribe({
      
      next: (success) => {
        this.reload();
      },
      error: (fail) =>{
        console.log('FAILED TODO PUT')
      }
    });

    this.selected = null;

  }

  setEditTeam(){
    this.editTeam = null;
    this.editTeam = Object.assign({}, this.selected);
  }

  cancelEditTeam(){
    this.editTeam = null;
  }

findConferenceSplit(teams: Team[]){
  let westernCount = 0;
  let easternCount = 0;
    if (teams != null){
      for (const team of teams) {
        if(team.conference === 'Western'){
          westernCount++;
        }else if(team.conference === 'Eastern'){
          easternCount++;
        }
        
      }
    }
    this.conferenceSplit = "Western:" + westernCount + " | Eastern: " + easternCount;

}


  


}
