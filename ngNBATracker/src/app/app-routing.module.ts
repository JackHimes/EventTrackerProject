import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { IndexComponent } from './components/index/index.component';
import { NotfoundComponent } from './components/notfound/notfound.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'index', component: IndexComponent},
  {path: '**', component: NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
