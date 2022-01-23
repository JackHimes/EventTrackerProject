export class Team {
    id: number | undefined;
    name: string | undefined;
    logoUrl: string  | undefined;
    twitterUrl: string | undefined;
    city: string | undefined;
    venue: string | undefined;
    conference: string | undefined;

    constructor(id?: number, name?: string, logoUrl?: string, twitterUrl?: string, city?: string, venue?: string, conference?: string){
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
        this.twitterUrl = twitterUrl;
        this.city = city;
        this.venue = venue;
        this.conference = conference;
    }




    // id: number | undefined;
    // task: string | undefined;
    // description: string | undefined;
    // completed: boolean | undefined;
    // completeDate: string | undefined | null;

    // constructor(id?: number, task?: string, description?: string, completed?: boolean, completeDate?: string){
    //     this.id = id;
    //     this.task = task;
    //     this.description = description;
    //     this.completed = completed;
    //     this.completeDate = completeDate;
    // }
}
