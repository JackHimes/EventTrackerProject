import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/models/team';
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
        // AYY ADD CONFERENCE SPLIT METHOD CALL HERE, PLEASE DONT FORGET
      
      }, error: (err) => {
        console.error("Observer got an error: " + err)
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
  


}
