import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import {HttpClientModule} from '@angular/common/http'
import { TeamService } from './services/team.service';
import { FormsModule } from '@angular/forms';
import { PlayerService } from './services/player.service';
import { PlayerTeamPipe } from './pipes/player-team.pipe';
import { IndexComponent } from './components/index/index.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { NavigationComponent } from './components/navigation/navigation.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PlayerTeamPipe,
    IndexComponent,
    NotfoundComponent,
    NavigationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    
  ],
  providers: [
    TeamService,
    PlayerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
