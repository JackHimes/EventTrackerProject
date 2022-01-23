import { Player } from "./player";

export class Team {
    id: number | undefined;
    name: string | undefined;
    logoUrl: string  | undefined;
    twitterUrl: string | undefined;
    city: string | undefined;
    venue: string | undefined;
    conference: string | undefined;
    roster: Player[] | undefined;

    constructor(id?: number, name?: string, logoUrl?: string, twitterUrl?: string, city?: string, venue?: string, conference?: string, roster?: Player[]){
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
        this.twitterUrl = twitterUrl;
        this.city = city;
        this.venue = venue;
        this.conference = conference;
        this.roster = roster;
    }


}
