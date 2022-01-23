import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import {HttpClientModule} from '@angular/common/http'
import { TeamService } from './services/team.service';
import { FormsModule } from '@angular/forms';
import { PlayerService } from './services/player.service';
import { PlayerTeamPipe } from './pipes/player-team.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PlayerTeamPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    
  ],
  providers: [
    TeamService,
    PlayerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
