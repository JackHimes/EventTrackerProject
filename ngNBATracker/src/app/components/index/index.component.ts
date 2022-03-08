import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  images = ['../../assets/Dunking.jpg','../../assets/BasketballAndHoop.jpg', '../../assets/PlayersPlaying.jpg'];




}



