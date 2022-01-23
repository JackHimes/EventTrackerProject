import { Pipe, PipeTransform } from '@angular/core';
import { Player } from '../models/player';

@Pipe({
  name: 'playerTeam'
})
export class PlayerTeamPipe implements PipeTransform {

  transform(players: Player[], filterType: number): Player[] {
    const results: Player[] = [];


    players.forEach((player) => {
        if(player.team?.id === filterType){
          results.push(player);
        }

    
    });
    return results;

}

}
