import { Team } from "./team";

export class Player {
    id: number | undefined;
    firstName: string | undefined;
    lastName: string | undefined;
    number: number | undefined;
    height: number | undefined;
    weight: number | undefined;
    points: number | undefined;
    assists: number | undefined;
    rebounds: number | undefined;
    salary: number | undefined;
    team: Team | undefined;
    position: string | undefined;


    constructor(id?: number, firstName?: string, lastName?: string, number?: number, height?: number, weight?: number, points?: number, assists?: number, rebounds?: number, salary?: number, team?: Team, position?: string){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.height = height;
        this.weight = weight;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.salary = salary;
        this.team = team;
        this.position = position;
    } 

}
