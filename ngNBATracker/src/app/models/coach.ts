import { Team } from "./team";

export class Coach {
    id: number | undefined;
    position: string | undefined;
    salary: number | undefined;
    team: Team | undefined;
    firstName: string | undefined;
    lastName: string | undefined;
    
    constructor(id?: number, position?: string, salary?: number, team?: Team, firstName?: string, lastName?: string){
        this.id = id;
        this.position = position;
        this.salary = salary;
        this.team = team;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
